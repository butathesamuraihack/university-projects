package example.FTPClient;

import java.io.IOException;
import java.util.Scanner;

public class UFValidation extends Console{

    private String vUser;
    private String vPass;
    private String user;
    private String pass;
    private Scanner input;

    public void User() throws IOException, ClassNotFoundException {

        this.setInput(new Scanner(System.in));

        do {
            do {
                    System.out.print((String)this.getOis().readObject());
                    this.setUser(input.nextLine());
                    this.getOos().writeObject(this.getUser());
                    this.setvUser((String)this.getOis().readObject());
                    System.out.println((String)this.getOis().readObject());

                } while (!this.getvUser().equals("Valid"));
            do {
                    System.out.print((String)this.getOis().readObject());
                    this.setPass(input.nextLine());
                    this.getOos().writeObject(this.getPass());
                    System.out.println((String)this.getOis().readObject());
                    this.setvPass((String)this.getOis().readObject());
                } while (!this.getvPass().equals("Valid") && !this.getvPass().equals("exit"));
        } while (this.getvPass().equals("exit"));
    }

    public void Command() throws IOException, ClassNotFoundException {

        System.out.print((String)this.getOis().readObject());
        String fullCommand = input.nextLine();
        String[] command = fullCommand.split(" ");
        this.setCmd(command[0]);
        if(command.length > 1){
            this.setFileString(command[1]);
        }else {
            this.setFileString("");
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvPass(String vPass) {
        this.vPass = vPass;
    }

    public String getvPass() {
        return vPass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
