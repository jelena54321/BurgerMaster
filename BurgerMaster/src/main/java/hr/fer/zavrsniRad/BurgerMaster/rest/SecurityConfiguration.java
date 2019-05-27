package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.Properties;

import org.apache.catalina.authenticator.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final String REALM = "MY_REALM";
	
	 @Autowired
	 UserDetailsService userDetailsService;

	/** Authentication entry point. */
	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	@Autowired
	private CustomAuthenticationFailureHandler failureHandler;

	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

        String hash = passwordEncoder().encode("password");

        auth.inMemoryAuthentication().withUser("ivek").password(hash).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();
		http.cors();
		http.headers().frameOptions().disable();
		http.formLogin().failureHandler(failureHandler).successHandler(successHandler);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
