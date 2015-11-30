package example.FTPClient;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Console extends Connection{

    private int count;
    private String fClient;
    private String cmd;
    private String fileString;
    private String ipMachine;
    private File fFile;
    private InetAddress ipServer;


    public void putCommand(){
        String response;

        try {
            this.getOos().writeObject(this.getFileString());
            this.setsR(new Socket(this.getIpMachine(), 10000));
            this.setfFile(new File(this.getfClient() + this.getFileString()));
            if (!this.getfFile().exists()){
                System.out.println("File doesn't exists.");
                response = "don't";
            }else {
                response = "do";
                byte[] bytes = new byte[1024];
                this.setIs(new FileInputStream(this.getfFile()));
                this.setOs(this.getsR().getOutputStream());
                while ((count = this.getIs().read(bytes))>0){
                    this.getOs().write(bytes, 0, count);
                }
                System.out.println(this.getFileString() + " was uploaded in Server");
                this.getIs().close();
                this.getOs().close();
            }
            this.getOos().writeObject(response);
            this.getsR().close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCommand() throws IOException, ClassNotFoundException {

        String response;
        try {

            this.getOos().writeObject(this.getIpServer());
            this.getOos().writeObject(this.getFileString());
            this.setSs(new ServerSocket(10000));
            this.setsR(this.getSs().accept());
            response = (String)this.getOis().readObject();
            if ("do".equals(response)){
                this.setIs(this.getsR().getInputStream());
                this.setOs(new FileOutputStream(this.getfClient() + this.getFileString()));
                byte[] bytesSend = new byte[1024];
                while ((count = this.getIs().read(bytesSend))> 0){
                    this.getOs().write(bytesSend,0,count);
                }
                System.out.println("File " + this.getFileString() + " was downloaded from Server");
                this.getOs().close();
                this.getIs().close();
            }else {
                System.out.println("File doesn't exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (this.getSs() != null) this.getSs().close();
        }
    }

    public void deleteCommand() throws ClassNotFoundException {

        try {
            this.getOos().writeObject(this.getFileString());
            String response = (String)this.getOis().readObject();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listCommand() throws ClassNotFoundException {

        try {
            String[] files = (String[])this.getOis().readObject();
            if (files.length != 0){
                String folder = (String)this.getOis().readObject();
                System.out.print("\n");
                for (String list : files) {
                    System.out.println(folder + list);
                }
                System.out.print("\n");
            }else {
                String response = (String)this.getOis().readObject();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void helpCommand() throws IOException, ClassNotFoundException {
        String[] help;
        help = (String[])this.getOis().readObject();
        for (String show : help){
            System.out.println(show);
        }
    }

    public String getfClient() {
        return fClient;
    }

    public void setfClient(String fClient) {
        this.fClient = fClient;
    }

    public String getFileString() {
        return fileString;
    }

    public void setFileString(String fileString) {
        this.fileString = fileString;
    }

    public File getfFile() {
        return fFile;
    }

    public void setfFile(File fFile) {
        this.fFile = fFile;
    }

    public InetAddress getIpServer() {
        return ipServer;
    }

    public void setIpServer(InetAddress ipServer) {
        this.ipServer = ipServer;
    }

    public String getIpMachine() {
        return ipMachine;
    }

    public void setIpMachine(String ipMachine) {
        this.ipMachine = ipMachine;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}
