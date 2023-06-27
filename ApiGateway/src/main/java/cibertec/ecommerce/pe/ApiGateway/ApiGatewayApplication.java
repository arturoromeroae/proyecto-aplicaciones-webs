package cibertec.ecommerce.pe.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hoteles", r -> r.path("/hoteles/**", "/api/rooms/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://ApiHoteles"))
                .route("reservas", r -> r.path("/reservas/**")
                .filters(f -> f.stripPrefix(1))
                .uri("lb://ApiReservas"))
                .build();
    }

    

}
