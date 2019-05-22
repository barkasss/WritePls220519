package com.brks.writepls;

import java.util.HashMap;
import java.util.Map;

public class User {
    String list = " ";
    int namePosition = 1;
    int remPosition = 1;

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("namePosition",namePosition);
        result.put("remPosition",remPosition);


        return result;
    }

}
