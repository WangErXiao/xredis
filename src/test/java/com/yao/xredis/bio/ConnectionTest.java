package com.yao.xredis.bio;

import com.yao.xredis.command.Command;
import com.yao.xredis.command.Result;
import com.yao.xredis.command.StrGet;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by yao on 15/8/27.
 */
public class ConnectionTest extends TestCase {

    @Test
    public void testSendCommand() throws Exception {

            Connection connection=new Connection();
            Command command=new StrGet("yao");
            command.setConnection(connection);

            Result result=command.send();
            System.out.println(result.getLength());
            System.out.println(result.getObject());
    }
}