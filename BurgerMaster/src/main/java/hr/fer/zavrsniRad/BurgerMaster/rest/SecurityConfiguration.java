package hr.fer.zavrsniRad.BurgerMaster.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	/** Authentication entry point. */
//	@Autowired
//	private AuthenticationEntryPoint entryPoint;
	

	@Autowired
	private CustomAuthenticationFailureHandler failureHandler;

	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();
		http.cors();
		http.headers().frameOptions().disable();
		http.formLogin().failureHandler(failureHandler).successHandler(successHandler);
    }

}
