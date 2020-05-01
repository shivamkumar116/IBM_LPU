package in.ibm.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-B")
public interface EmployeeClient {

	@RequestMapping("/api/employee/hi")
	public String callHi(@RequestParam String name);
}
