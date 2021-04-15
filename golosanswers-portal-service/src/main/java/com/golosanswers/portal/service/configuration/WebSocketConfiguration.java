package com.golosanswers.portal.service.configuration;

import com.golosanswers.portal.service.WebSocketNavigation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Value("${spring.security.origins.allow}")
	private String allowedOrigins;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint(WebSocketNavigation.WS_ROOT).setAllowedOrigins(allowedOrigins).withSockJS();
	}
}
