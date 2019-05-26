package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Class which presents concrete implementation of <code>AuthenticationFailureHandler</code>
 * interface.
 * 
 * @author Jelena Šarić
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/**
	 * Defines action which will be executed if authorization was unsuccessful.
	 * In this case <i>response</i> status is set to <code>UNAUTHORIZED</code>.
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
										HttpServletResponse response, 
										AuthenticationException exception)
			
												throws IOException, ServletException {
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}

}
