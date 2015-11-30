package example.FTPServer;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerFTP {

    public static void main(String[] args) throws Exception{

        UFValidation uf = new UFValidation();
        Scanner input = new Scanner(System.in);

        uf.setfServer("C:\\FTP\\serverFTP\\");
        String exit = " ";

        System.out.println("\t\t\tServerFTP ON\n");

        do {

            System.out.println("Waiting for user to connect...");

            uf.setSs(new ServerSocket(9000));
            uf.setS(uf.getSs().accept());
            uf.setOos(new ObjectOutputStream(uf.getS().getOutputStream()));
            uf.setOis(new ObjectInputStream(uf.getS().getInputStream()));


            uf.User();
            System.out.println("User " + uf.getUser() + " is logged in");

            do {

                uf.Command();
                uf.setCmd((String) uf.getOis().readObject());
                System.out.print(uf.getUser()+">");

                switch (uf.getCmd()){

                    case "put":{
                        uf.putCommand();
                        break;
                    }

                    case "get":{
                        uf.getCommand();
                        break;
                    }

                    case "delete":{
                        uf.deleteCommand();
                        break;
                    }

                    case "list":{
                        uf.listCommand();
                        break;
                    }

                    case "help":{
                        uf.helpCommand();
                        break;
                    }

                    case "quit":{
                        System.out.println("User logged out.");
                        System.out.print("Do you want to shutdown the server?(y/n):");
                        exit = input.nextLine();
                        break;
                    }

                    default:{
                        System.out.println("Invalid Command ");
                        break;
                    }
                }
            }while (!"quit".equals(uf.getCmd()));
            uf.getSs().close();
            uf.getS().close();
            uf.getOos().close();
            uf.getOis().close();
        }while ("n".equals(exit));
        System.out.println("ServerFTP OFF");
    }
}
