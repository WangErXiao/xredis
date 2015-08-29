package com.yao.xredis.exception;

import java.io.IOException;

/**
 * Created by yao on 15/8/27.
 */
public class XredisConnectionException extends RuntimeException {
    public XredisConnectionException(IOException ex) {
        super(ex);
    }
}
