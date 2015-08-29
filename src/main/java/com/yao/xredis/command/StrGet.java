package com.yao.xredis.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yao on 15/8/27.
 */
public class StrGet extends Command {

    private String key;

    public StrGet(String key) {
        setType(ComandEnum.STR);
        setName("get");
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Result send(String ... args) throws IOException {
        getConnection().connect();
        String cmd=getName()+" "+key+"\r\n";
        getConnection().getOutputStream().write(cmd.getBytes());
        getConnection().getOutputStream().flush();
        byte []rels=new byte[1024*10];
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(getConnection().getInputStream()));
        StringBuffer sb=new StringBuffer();
        Result result=new Result();
        String xx=null;
        int count=0;
        xx=bufferedReader.readLine();
        if(xx!=null){
            result.setLength(Integer.parseInt(xx.substring(1)));
        }
        xx=bufferedReader.readLine();
        if(xx!=null){
            result.setObject(xx);
        }
        return result;
    }
}
