package uptodatemaintainers.Maintenancetool.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        if (!(credentials instanceof String)) {
            return null;
        }

        String password = credentials.toString();
        // TODO change from hard code to access users in db

        if (name.equals("bill") && password.equals("hello")) {
            List<GrantedAuthority> grants = new ArrayList<>();
            grants.add(new SimpleGrantedAuthority("King"));
            Authentication newAuth = new UsernamePasswordAuthenticationToken(name, password, grants);
            return newAuth;
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}