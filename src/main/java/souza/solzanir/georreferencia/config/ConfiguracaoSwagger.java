package souza.solzanir.georreferencia.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class ConfiguracaoSwagger {

    private static final String AUTHORIZATION = "Authorization";
    private static final String HEADER = "header";

    @Value("${spring.api.swagger-enable}")
    private boolean swaggerEnable;

    @Value("${info.modulo}")
    private String moduleName;

    @Value("${info.version}")
    private String moduleVersion;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .enable(swaggerEnable)
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Módulo de Cadastro de Endereço",
                "Projeto de exemplo de comunicação com Geocoding API do Google",
                moduleVersion,
                "",
                null,
                "",
                "",
                new ArrayList<>());
    }

    private ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION, AUTHORIZATION, HEADER);
    }

    private SecurityContext securityContext() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();

        SecurityReference securityReference = SecurityReference.builder().reference(AUTHORIZATION)
                .scopes(authScopes).build();

        return SecurityContext.builder().securityReferences(
                Arrays.asList(securityReference)
        ).build();
    }
}