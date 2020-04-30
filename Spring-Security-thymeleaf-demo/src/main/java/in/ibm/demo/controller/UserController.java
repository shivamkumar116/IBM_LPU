package in.ibm.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ibm.demo.dao.EmployeeDAO;
import in.ibm.demo.model.Employee;
import in.ibm.demo.model.MyUser;

@Controller
public class UserController {

	
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@RequestMapping("/index")
	public String index() {

		return "Index";
	}



	
	@RequestMapping("/register")
	public String getForm(Model model) {
		model.addAttribute("user", new MyUser());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(MyUser user) {
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRoles().toUpperCase()));
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		User myUser = new User(user.getUserName(),encodedPassword,authorities);
		jdbcUserDetailsManager.createUser(myUser);
		 return "Success";
	}
	
	@GetMapping("/saveEmployee")
	public String save(Model model) {
		model.addAttribute("employee",new Employee());
		return "employeeForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(Employee employee) {
		employeeDao.save(employee);
		return "Success";
	}
}
