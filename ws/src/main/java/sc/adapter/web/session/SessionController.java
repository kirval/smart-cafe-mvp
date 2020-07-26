package sc.adapter.web.session;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
import static sc.adapter.web.session.SessionConstants.SESSION_ENDPOINT;

@RestController
@RequestMapping(SESSION_ENDPOINT)
@RequiredArgsConstructor
public class SessionController {

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public void authenticateUser(@Valid @RequestBody SessionDtoIn credentials, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        HttpSession session = request.getSession();
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
    }

}
