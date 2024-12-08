package org.example.spring0.chat;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // access link would be : ('http://localhost:8080/ws');
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // this is the web broker endpoint that manages how message are delivered
        registry.enableSimpleBroker("/chatroom", "/user");

        // it is a prefix used by the client to send message to the server
        registry.setApplicationDestinationPrefixes("/app");

        // for private user
        registry.setUserDestinationPrefix("/user");
    }

////    @Override
////    public void registerStompEndpoints(StompEndpointRegistry registry) {
////        registry.addEndpoint("/ws")
////                .setAllowedOriginPatterns("*")
////                .withSockJS();
////    }
////
////    @Override
////    public void configureMessageBroker(MessageBrokerRegistry registry) {
////        registry.setApplicationDestinationPrefixes("/app");
////        registry.enableSimpleBroker("/chatroom", "/chat");
////        registry.setUserDestinationPrefix("/user");
////    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws")
//                .setAllowedOriginPatterns("*")
//                .withSockJS();
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        System.out.println("corsFilter");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true); // Update here
//        config.addAllowedOriginPattern("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter();
//    }
}
