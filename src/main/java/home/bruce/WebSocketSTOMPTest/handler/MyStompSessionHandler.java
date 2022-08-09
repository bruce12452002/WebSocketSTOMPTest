package home.bruce.WebSocketSTOMPTest.handler;

import home.bruce.WebSocketSTOMPTest.entity.S2CMsg;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MyStompSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("bruce.handleFrame");
        // super.handleFrame(headers, payload);
        System.out.println(((S2CMsg) payload).getResMsg());
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("連線成功後自動調用 afterConnected");
        StompSession.Subscription subscribe = session.subscribe("/broker1/hahaha", this); // 和 @SendTo 一樣
        StompSession.Receiptable send = session.send("/kkk/mmm", "{\"name\":\"monkey\"}");
        System.out.println("sessionId=" + session.getSessionId());
        super.afterConnected(session, connectedHeaders);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        System.out.println("bruce.handleTransportError");
        super.handleTransportError(session, exception);
    }

    public MyStompSessionHandler() {
        super();
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        System.out.println("afterConnected() 後會調用 getPayloadType");
//        return super.getPayloadType(headers);
        return S2CMsg.class; // 回傳 afterConnected 方法裡 send 路徑的 return 物件
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.out.println("連線有成功，但出例外會調用 handleException");
        System.out.println(exception.getMessage());
        super.handleException(session, command, headers, payload, exception);
    }
}
