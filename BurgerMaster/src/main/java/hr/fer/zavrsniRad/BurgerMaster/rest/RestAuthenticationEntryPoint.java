package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Class which presents concrete implementation of 
 * <code>AuthenticationEntryPoint</code> interface.
 * 
 * @author Jelena Šarić
 */
@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Commences authentication process.
	 */
	@Override
	public void commence(final HttpServletRequest request, 
						 final HttpServletResponse response, 
						 final AuthenticationException exception)
			
								 throws IOException, ServletException {
		
		response.sendError(
				HttpServletResponse.SC_UNAUTHORIZED, 
				"Unauthorized entry"
		);
		
	}

}
