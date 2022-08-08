package home.bruce.WebSocketSTOMPTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
//@EnableScheduling
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 註冊兩個 STOMP 節點，並指定 SockJS 協議
        // WebSocket 客戶端必需用這裡的設定才能使用 WebSocket
        registry.addEndpoint("/xxx", "/ooo");//.withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 設定消息代理前綴，必需和 @Controller 裡的 @SendTo 前綴一樣
        // 會將消息放到這裡設定的路徑前綴裡，有訂閱的會去裡面拿資料
        registry.enableSimpleBroker("/abc", "/def");
//        registry.setApplicationDestinationPrefixes("/pre");
    }
}
