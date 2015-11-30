package example.FTPServer;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Console extends Connection{

    private String file;
    private String fServer;
    private File f;
    private InetAddress ipServer;
    private String cmd;
    private int count;


    public void putCommand() throws IOException {

        System.out.println("PUT EXECUTED");
        String response;
        try {

            this.setFile((String)this.getOis().readObject());
            this.setSsSend(new ServerSocket(10000));
            this.setsR(this.getSsSend().accept());
            response = (String)this.getOis().readObject();
            if ("do".equals(response)){
                this.setIs(this.getsR().getInputStream());
                this.setOs(new FileOutputStream(this.getfServer() + this.getFile()));
                byte[] bytes = new byte[1024];
                while ((count = this.getIs().read(bytes))> 0){
                    this.getOs().write(bytes, 0, count);
                }
                System.out.println(this.getFile() + " file was uploaded to the server");
                System.out.println("FINISH");
                this.getOs().close();
                this.getIs().close();
            }
            else {
                System.out.println("File doesn't exist");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (this.getSsSend() != null) this.getSsSend().close();
        }
    }

    public void getCommand() throws ClassNotFoundException {

        String response;

        System.out.println("GET EXECUTED");
        try {

            this.setIpServer((InetAddress)this.getOis().readObject());
            this.setFile((String)this.getOis().readObject());
            this.setsR(new Socket(this.getIpServer(), 10000));
            this.setF(new File(this.getfServer()+this.getFile()));
            if (!this.getF().exists()){
                System.out.println("File doesn't exists");
                response = "don't";
            }else {
                response = "do";
                byte[] bytes = new byte[1024];
                this.setIs(new FileInputStream(this.getF()));
                this.setOs(this.getsR().getOutputStream());
                while ((count = this.getIs().read(bytes))> 0){
                    this.getOs().write(bytes, 0, count);
                }
                this.getOs().close();
                this.getIs().close();
                System.out.println("FINISH");
            }
            this.getOos().writeObject(response);
            this.getsR().close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void deleteCommand() throws ClassNotFoundException {

        String response;
        System.out.println("DELETE EXECUTED");

        try {

            this.setFile((String)this.getOis().readObject());
            this.setF(new File(this.getfServer() + this.getFile()));
            if (this.getF().exists()){
                boolean deleted = this.getF().delete();
                response = "File " + this.getFile()+ " was deleted from server";
                System.out.println(response + " by user ");
            }else {
                response = "File doesn't exists";
            }
            this.getOos().writeObject(response);


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FINISH");
    }

    public void listCommand() throws IOException {

        System.out.println("LIST EXECUTED");
        File lists = new File(this.getfServer());
        String[] files = lists.list();
        this.getOos().writeObject(files);
        if (files.length != 0){
            this.getOos().writeObject(this.getfServer());
            System.out.println("FINISH");
        }else {
            String response = "Folder is empty";
            this.getOos().writeObject(response);
            System.out.println(response);
        }

    }

    public void helpCommand() throws IOException {
        String[] response ={"put: Upload a file from current local machine to current server folder. ex: put file.txt\n"
                ,"get: Download a file from current server folder to current machine. ex: get file.txt\n"
                ,"list:List all files in current folder\n"
                ,"delete:Delete a folder in current server folder. ex: delete file.txt\n"
                ,"help:Never gonna give you up, never gonna let you down." +
                "\nNever gonna run around and desert you." +
                "\nNever gonna make you cry,never gonna say goodbye" +
                "\nNever gonna tell a lie and hurt you."};
        this.getOos().writeObject(response);

    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getfServer() {
        return fServer;
    }

    public void setfServer(String fServer) {
        this.fServer = fServer;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public InetAddress getIpServer() {
        return ipServer;
    }

    public void setIpServer(InetAddress ipServer) {
        this.ipServer = ipServer;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}
