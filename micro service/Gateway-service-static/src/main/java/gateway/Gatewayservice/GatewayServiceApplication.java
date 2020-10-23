package gateway.Gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
	@Bean
	RouteLocator gatewayRoutesStatic(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r->r
						.path("/publicCountries/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host","restcountries-v1.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key", "fe5e774996msh4eb6e863d457420p1d2ffbjsnee0617ac5078")
								.rewritePath("/publicCountries/(?<segment>.*)","/${segment}")
								.hystrix(h->h.setName("rest-countries")
										.setFallbackUri("forward:/defaultCountries"))
						)
						.uri("https://restcountries-v1.p.rapidapi.com")
						.id("countries")
				)

				.route(r->r
						.path("/muslimsalat/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host","muslimsalat.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key", "fe5e774996msh4eb6e863d457420p1d2ffbjsnee0617ac5078")
								.rewritePath("/muslimsalat/(?<segment>.*)","/${segment}")
								.hystrix(h->h.setName("muslimsalat")
										.setFallbackUri("forward:/defaultSalat"))
						)
						.uri("https://muslimsalat.p.rapidapi.com")
						.id("muslimsalat")
				)
				.build();
	}

}
