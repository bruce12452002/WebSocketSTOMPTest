package home.bruce.WebSocketSTOMPTest.entity;

import java.io.Serializable;

public class C2SMsg implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public C2SMsg(String name) {
        this.name = name;
    }

    public C2SMsg() {
    }


}
