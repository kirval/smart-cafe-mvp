package sc.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sc.configuration.security.userDetails.CustomUserDetailsService;

import static org.springframework.security.config.BeanIds.AUTHENTICATION_MANAGER;
import static sc.adapter.web.session.SessionConstants.SESSION_ENDPOINT;
import static sc.adapter.web.user.UserConstants.USER_ENDPOINT;
import static sc.configuration.swagger.SwaggerConstants.SWAGGER_ENDPOINTS_SECURITY_WHITELIST;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        prePostEnabled = true
)
@RequiredArgsConstructor
@Profile("dev")
public class SecurityDevConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;


    //todo add 401, 403 config
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .csrf()
                .disable() //todo configure csrf
            .authorizeRequests()
                .antMatchers(HttpMethod.POST,
                        USER_ENDPOINT,
                        SESSION_ENDPOINT)
                    .anonymous()
                .antMatchers(SWAGGER_ENDPOINTS_SECURITY_WHITELIST)
                    .permitAll()
                .anyRequest()
                    .authenticated();
        //@formatter:on
    }

    @Override
    @Bean(AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
