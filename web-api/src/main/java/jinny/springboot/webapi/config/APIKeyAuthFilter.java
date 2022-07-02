package jinny.springboot.webapi.config;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String principalRequestsHeader;

    public APIKeyAuthFilter (String principalRequestsHeader) {
        this.principalRequestsHeader = principalRequestsHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal (HttpServletRequest request) {
        return request.getHeader(principalRequestsHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials (HttpServletRequest request) {
        return "N/A";
    }
}
