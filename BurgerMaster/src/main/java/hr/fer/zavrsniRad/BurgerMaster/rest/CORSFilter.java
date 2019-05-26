package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Class which presents <i>CORS</i> filter.
 * 
 * @author Jelena Šarić
 */
public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response, 
									FilterChain filterChain)
			
											throws ServletException, IOException {
		
		response.setHeader(
				"Access-Control-Allow-Origin", 
				"*"
		);
		response.setHeader(
				"Access-Control-Allow-Methods", 
				"GET, POST"
		);
		response.setHeader(
				"Access-Control-Max-Age", 
				"3600"
		);
		response.setHeader(
				"Access-Control-Allow-Headers", 
				"X-PINGOTHER,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"
		);
		response.addHeader(
				"Access-Control-Expose-Headers", 
				"xsrf-token"
		);
		
        if ("OPTIONS".equals(request.getMethod())) {
        	response.setStatus(HttpServletResponse.SC_OK);
        } else { 
        	filterChain.doFilter(request, response);
        }

	}

}
