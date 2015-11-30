package example.FTPClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientFTP {

    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);
        UFValidation uf = new UFValidation();

        uf.setfClient("C:\\FTP\\clientFTP\\");

        System.out.println("\t\t\tClientFTP ON\n");
        System.out.print("Enter ip or machine name:");

        uf.setIpMachine(input.nextLine());

        uf.setS(new Socket(uf.getIpMachine(), 9000));
        uf.setOos(new ObjectOutputStream(uf.getS().getOutputStream()));
        uf.setOis(new ObjectInputStream(uf.getS().getInputStream()));
        uf.setIpServer(uf.getS().getInetAddress());

        uf.User();

        do {

            uf.Command();
            uf.getOos().writeObject(uf.getCmd());

            switch (uf.getCmd()) {
                case "put": {
                    uf.putCommand();
                    break;
                }

                case "get": {
                    uf.getCommand();
                    break;
                }

                case "delete": {
                    uf.deleteCommand();
                    break;
                }

                case "list": {
                    uf.listCommand();
                    break;
                }

                case "quit": {
                    System.out.println("User will log out");
                    System.out.println("ClientFTP shutdown process");
                    System.exit(0);
                    break;
                }

                case "help":{
                    uf.helpCommand();
                    break;
                }
                default: {
                    System.out.println("Invalid command. Please try again");
                    break;
                }
            }
        } while (!"quit".equals(uf.getCmd()));
        uf.getS().close();
        System.out.println("ClientFTP OFF");
    }
}

