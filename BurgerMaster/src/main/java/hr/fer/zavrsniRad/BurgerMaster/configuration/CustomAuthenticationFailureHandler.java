package hr.fer.zavrsniRad.BurgerMaster.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Class which presents custom authentication failure handler. This class
 * specifies how will security handle unsuccessful authentication requests.
 * 
 * @author Jelena Šarić
 * 
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/**
	 * Defines action which will be executed on unsuccessful authentication. In this
	 * case, <i>HTTP</i> response is set to <code>UNAUTHORIZED</code>.
	 * 
	 * @param request
	 *            authentication request
	 * @param response
	 *            authentication response
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
										HttpServletResponse response,
										AuthenticationException exception)

			throws IOException, ServletException {

		response.setStatus(HttpStatus.UNAUTHORIZED.value());
	}

}
