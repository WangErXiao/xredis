package com.yao.xredis.bio;

import com.yao.xredis.command.Command;
import com.yao.xredis.exception.XredisConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by yao on 15/8/27.
 */
public class Connection {

    private String host="localhost";

    private int port=6379;

    private int connectionTimeout=200000;

    private int soTimeout = 200000;

    private Socket socket;

    private boolean isConnect=false;

    private OutputStream outputStream;

    private InputStream inputStream;

    public Connection(String host, int port,int connectionTimeout) {
        this.host = host;
        this.port = port;
        this.connectionTimeout=connectionTimeout;
    }
    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public Connection(String host) {
        this.host = host;
    }

    public Connection(){}


    public void connect() {
        synchronized (this) {
            if (!isConnect()) {
                try {
                    socket = new Socket();
                    socket.setReuseAddress(true);
                    socket.setKeepAlive(true); // Will monitor the TCP connection is
                    socket.setTcpNoDelay(true); // Socket buffer Whetherclosed, to
                    // ensure timely delivery of data
                    socket.setSoLinger(true, 0); // Control calls close () method,

                    socket.connect(new InetSocketAddress(host, port), connectionTimeout);
                    socket.setSoTimeout(soTimeout);
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                    isConnect = true;
                } catch (IOException ex) {
                    throw new XredisConnectionException(ex);
                }
            }
        }
    }


    protected Object sendCommand(Command cmd, String ... args) throws IOException {
        connect();
        cmd.setConnection(this);
        return cmd.send();
    }



    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setIsConnect(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
