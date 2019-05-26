package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Class which presents concrete implementation of 
 * <code>AuthenticationSuccessHandler</code> method.
 * 
 * @author Jelena Šarić
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * Defines action which will be executed if authorization was successful.
	 * In this case <i>response</i> status is set to <code>OK</code>.
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response, 
										Authentication authentication)
			
												throws IOException, ServletException {
		
		response.setStatus(HttpStatus.OK.value());
	}

}
