package hr.fer.zavrsniRad.BurgerMaster.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Class which presents custom authentication success handler. This class
 * specifies how will security handle successful authentication requests.
 * 
 * @author Jelena Šarić
 * 
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * Defines action which will be executed on successful authentication. In this
	 * case, <i>HTTP</i> response is set to <code>OK</code>.
	 * 
	 * @param request
	 *            authentication request
	 * @param response
	 *            authentication response
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response,
										Authentication authentication)

			throws IOException, ServletException {

		response.setStatus(HttpStatus.OK.value());
	}
}
