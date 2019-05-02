package com.brks.writepls;

import java.util.HashMap;
import java.util.Map;

public class ShoppingElement {
    private int status;
    private String toBuy;
    private String key;

    public ShoppingElement() {
    }

    public ShoppingElement(int status, String toBuy, String key) {
        this.status = status;
        this.toBuy = toBuy;
        this.key = key;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToBuy() {
        return toBuy;
    }

    public void setToBuy(String toBuy) {
        this.toBuy = toBuy;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("toBuy",toBuy);
        result.put("key",key);


        return result;
    }


}
