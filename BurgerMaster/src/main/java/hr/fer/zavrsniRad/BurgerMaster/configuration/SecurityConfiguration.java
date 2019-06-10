package hr.fer.zavrsniRad.BurgerMaster.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Class which presents security configuration for application.
 * 
 * @author Jelena Šarić
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/** Failure handler. */
	@Autowired
	private CustomAuthenticationFailureHandler failureHandler;

	/** Success handler. */
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	/**
	 * Configures security specifications. 
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.formLogin().failureHandler(failureHandler)
						.successHandler(successHandler);
    }

}
