package home.bruce.WebSocketSTOMPTest.controller;

import home.bruce.WebSocketSTOMPTest.entity.C2SMsg;
import home.bruce.WebSocketSTOMPTest.entity.S2CMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MessageMapping("/kkk")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * @MessageMapping 是給 webSocket 用戶端使用的路徑
     * @SendTo 回傳的結果會廣播播到 /abc/hahaha，客戶端有訂閱就會收到
     */
    @SubscribeMapping("/mmm")
    @SendTo("/abc/hahaha")
    public S2CMsg executeS2C(C2SMsg msg) {
        System.out.println("server: into executeS2C method");
        return new S2CMsg("Hi! I'm " + msg.getName());
    }
}
