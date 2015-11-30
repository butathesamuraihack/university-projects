package example.FTPServer;


import java.io.IOException;

public class UFValidation extends Console{

    private String vPass;
    private int index;
    private String vUser;
    private String user;
    private String pass;

    public void User() throws IOException, ClassNotFoundException {

        String[][] login = {{"eva00", "rei"}, {"eva01", "shinji"}, {"eva02", "asuka"}};
        String response;

        do {
            do {
                response = "Enter username:";
                this.getOos().writeObject(response);
                this.setUser((String)this.getOis().readObject());
                for (int row = 0; row < login.length; row++) {
                    if (this.getUser().equals(login[row][0])) {
                        String validUser = login[row][0];
                        this.setIndex(row);
                        this.setvUser("Valid");
                        response = "Will log on as user "  + validUser + ". Enter your Password.\nTo Change user use exit to logout.";
                    }

                }
                if (!"Valid".equals(this.getvUser())) {
                       this.setvUser("invalid");
                        response ="Invalid User. Try Again";
                }
                this.getOos().writeObject(this.getvUser());
                this.getOos().writeObject(response);
            } while (!this.getvUser().equals("Valid"));

            do {
                response = "Enter password:";
                this.getOos().writeObject(response);
                this.setPass((String)this.getOis().readObject());
                if (this.getPass().equals(login[this.getIndex()][1])) {
                    this.setvPass("Valid");
                    response = "Valid password";
                } else if (this.getPass().equals("exit")) {
                    this.setvPass("exit");
                    response = "System will ask again for user.Logging out";
                } else {
                    this.setvPass("invalid");
                    response = "Invalid Password. Try Again";
                }
                this.getOos().writeObject(response);
                this.getOos().writeObject(this.getvPass());
                } while (!this.getvPass().equals("Valid") && !this.getvPass().equals("exit"));

        } while ("exit".equals(this.getvPass()));

    }

    public void Command() throws IOException, ClassNotFoundException {

        String IpServer = this.getS().getInetAddress().toString();
            String IpServerA = IpServer.split("/")[1];
            String response = this.getUser() + " | " + IpServerA + " | ftp>";
            this.getOos().writeObject(response);
    }

    public String getvPass() {
        return vPass;
    }

    public void setvPass(String vPass) {
        this.vPass = vPass;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
