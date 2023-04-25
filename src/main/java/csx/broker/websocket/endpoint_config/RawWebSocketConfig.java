//package csx.broker.websocket.endpoint_config;
//
//import csx.broker.websocket.etc.IpHandshakeInterceptor;
//import csx.broker.websocket.etc.RawSocketHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket
//@RequiredArgsConstructor
//public class RawWebSocketConfig implements WebSocketConfigurer {
//    final RawSocketHandler rawSocketHandler;
//    final IpHandshakeInterceptor ipHandshakeInterceptor;
//
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry
//                .addHandler(rawSocketHandler, "/me_websockets")
//                .addInterceptors(ipHandshakeInterceptor)
//                .setAllowedOrigins("*");
//    }
//
//}
