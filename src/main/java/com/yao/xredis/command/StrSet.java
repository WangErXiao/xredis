package com.yao.xredis.command;

/**
 * Created by yao on 15/8/27.
 */
public class StrSet extends Command {

    public StrSet() {
        setType(ComandEnum.STR);
    }

    @Override
    public Result send(String ... args) {
        return null;
    }
}
