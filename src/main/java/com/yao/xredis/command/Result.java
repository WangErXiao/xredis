package com.yao.xredis.command;

/**
 * Created by yao on 15/8/27.
 */
public class Result {

    private int length;

    private Object object;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
