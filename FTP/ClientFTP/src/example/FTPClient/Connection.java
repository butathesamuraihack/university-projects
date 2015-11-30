package example.FTPClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    private Socket s;
    private ServerSocket ss;
    private Socket sR;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private InputStream is;
    private OutputStream os;

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public Socket getsR() {
        return sR;
    }

    public void setsR(Socket sR) {
        this.sR = sR;
    }
}
