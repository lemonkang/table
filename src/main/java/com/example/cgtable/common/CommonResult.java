package com.example.cgtable.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class CommonResult {
    private Integer code;
    private Boolean success;
    private HashMap<String,Object> data=null;
    private String message=null;
    public static  CommonResult success(){
        CommonResult resultCommon = new CommonResult();
        resultCommon.setCode(2000);
        resultCommon.setSuccess(true);
        return  resultCommon;
    }
    public static  CommonResult fail(){
        CommonResult resultCommon = new CommonResult();
        resultCommon.setCode(2001);
        resultCommon.setSuccess(false);
        return  resultCommon;
    }
    public CommonResult data(String key,Object data){
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, data);
        this.setData(map);
        return this;
    }
    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }
}
