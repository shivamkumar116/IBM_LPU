package in.ibm.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// In memory authentication

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("test").password("test123").roles("ADMIN"));
	}

	/*
	 * @Autowired private DataSource dataSource;
	 * 
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(
	 * passwordEncoder()); }
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/postaccounts").hasRole("ADMIN").antMatchers("/accountDemo").hasRole("ADMIN").and().formLogin();
	}

	/*
	 * @Bean public JdbcUserDetailsManager jdbcUserDetailsManager() { return new
	 * JdbcUserDetailsManager(dataSource); }
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
}
