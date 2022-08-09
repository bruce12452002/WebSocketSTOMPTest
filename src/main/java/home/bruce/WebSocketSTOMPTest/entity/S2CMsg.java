package home.bruce.WebSocketSTOMPTest.entity;

import java.io.Serializable;

public class S2CMsg implements Serializable {
    private String resMsg;

    public S2CMsg() {
    }

    public S2CMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
