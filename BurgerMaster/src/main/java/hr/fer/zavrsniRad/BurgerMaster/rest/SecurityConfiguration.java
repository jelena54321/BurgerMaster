package hr.fer.zavrsniRad.BurgerMaster.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/** Authentication entry point. */
	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	/** Success handler. */
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	/** Failure handler. */
	@Autowired
	private AuthenticationFailureHandler failureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();
		http.cors();
		http.headers().frameOptions().disable();
		http.formLogin().failureHandler(failureHandler)
						.successHandler(successHandler);
	}
}
