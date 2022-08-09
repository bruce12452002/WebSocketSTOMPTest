package home.bruce.WebSocketSTOMPTest;

import home.bruce.WebSocketSTOMPTest.handler.MyStompSessionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@SpringBootTest
class WebSocketStompTestApplicationTests {
    @Autowired
    private MyStompSessionHandler myStompSessionHandler;

    @Test
    void testConnect() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        /**
         * 如果出現 The HTTP response from the server [400] did not permit the HTTP upgrade to WebSocket
         * 將 withSockJS() 註解，但前端就不能用了
         */
        stompClient.connect("ws://127.0.0.1:8080/endpoint1", myStompSessionHandler);

        while (true) {
        } // 不加無限迴圈的話，程式會立即停止
    }

}
