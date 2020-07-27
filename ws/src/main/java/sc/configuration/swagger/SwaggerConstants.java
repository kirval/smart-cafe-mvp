package sc.configuration.swagger;

public class SwaggerConstants {

    public static final String[] SWAGGER_ENDPOINTS_SECURITY_WHITELIST = {
            "/**swagger**/**",
            "/**springfox**/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

}
