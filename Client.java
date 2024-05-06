package company.com;
import java.net.*;
import java.io.*;


/**
 * Project05 - Option2 - Client
 *
 * The program will create the Client of the application.
 *
 * No external resources used
 *
 * @author Nischal Kalahasti  LC12
 * @version 26 November, 2020
 *
 */


public class Client {
    
    // This class is public so it can be used by anyone.
    // Most methods in this class send a command phrase along with parameter values to the Sever.
    // The server will differentiate the output sent from this class by the command phrase.
    // For example, an output sent by the Client saying "create_account" will run the create_account method in the Server that will try to create an account.
    // initialize socket and input output streams
    
    private Socket socket            = null;
    private DataInputStream input   = null;
    private DataInputStream in = null;
    private DataOutputStream out     = null;

    public String firstName;
    public String lastName;
    public String phoneNo;
    public String email;
    public String dob;
    public String password;
    public String username;
    public String likes = "";
    public String aboutMe = "";
    public String friends = "";
    public String sentByMe = "";
    public String sentToMe = "";
    public String client_data;

    
    public Client(String address, int port) throws IOException {
        
        // constructor to put ip address and port
        // try to establish a connection
        
        try {
            
            socket = new Socket(address, port);

            /* takes input from terminal
            input = new DataInputStream(System.in);
            */
            
            in = new DataInputStream(socket.getInputStream());

            // sends output to the socket
            
            out = new DataOutputStream(socket.getOutputStream());
            
            //BufferedReader br = new BufferedReader(new InputStreamReader(in));

        } catch (IOException u) {
            
            throw new IOException();
            
        }

        // string to read message from input
        
        String line = "";

    }

    
    public String createPassword(String firstname, String lastName, String phoneNumber) {

        // This method will create a unique password for a user who has just created/editted an account.

        String passwordPart1 =  lastName.charAt(0) + String.valueOf(firstname.charAt(0));
        String passwordPart2 = phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
        return(passwordPart1 + passwordPart2);

    }

    
    public String createUsername(String firstname, String email, String dateOfBirth) {

        // This method creates a unique username for a user who justed created/editted their account.

        int usernamePart2 = Integer.parseInt(dateOfBirth.substring(dateOfBirth.indexOf("-") + 1, dateOfBirth.lastIndexOf("-")));
        String usernamePart3 = email.substring(email.indexOf("@") + 1, email.indexOf("."));
        return (firstname + usernamePart2 + usernamePart3);
        
    }

    
    public boolean checkForSuccess() throws IOException {

        // This method reads output from the Server class and stores it in the client_data field if it contains the word "success".
        // Success would refer to the idea of successfully signing into an account or successfully finding an account from the file.
        
        String line = in.readUTF();
        
        if (!line.contains("Success!") &&
                (!line.contains("Fail!"))) {
            
            line = in.readUTF();
            
        }
        
        if (line.contains("Success!")) {
            
            client_data = in.readUTF();
            
            if (client_data.contains("Success!")) {
                
                client_data = in.readUTF();
                
            }
            
            return true;
            
        } else {
            
            return false;
            
        }
        
    }

    
    public void create_account(String firstName, String lastName, String phoneNumber, String email, String dob, String userName, String password, String likes, String aboutMe, String friends, String sentByMe, String sentToMe) throws IOException, Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "create_account".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (firstName == null || lastName == null || phoneNumber == null || email == null || dob == null ||
                    userName == null || password == null || likes == null || friends == null || sentByMe == null || sentToMe == null || aboutMe == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }

        String command = "create_account";
        String totalString = "Command:" + command + "||First Name:" + firstName + "||Last Name:" + lastName
                + "||Phone No.:" + phoneNumber + "||Email:" + email
                + "||Date Of Birth:" + dob +  "||Username:" + userName + "||Password:" + password
                + "||Likes:" + likes + "||AboutMe:" + aboutMe + "||Friends:" + friends + "||SentByMe:" + sentByMe + "||SentToMe:" + sentToMe;

        try {
            
            out.writeUTF(totalString);
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        view_account();
        
    }

    
    public boolean signIn_account(String userName, String pw) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "signIn_account".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (userName == null || pw == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {

            throw new Exception();
            
        }
        
        String command = "signIn_account";
        String fullString = "Command:" + command + "||Username:" + userName + "||Password:" + pw;
        
        try {
            
            out.writeUTF(fullString);
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        return true;
        
    }

    
    public void view_account() throws IOException {
        
        //  A string saying "view_account" is sent to the server class.
        // using the checkForSuccess() method the user's account details are read in if the account exists.
        
        String command = "view_account";
        String fullString1 = "Command:" + command;
        
        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        checkForSuccess();
        String[] tempLine = client_data.split("\\|\\|");
        this.firstName = tempLine[0].split(":")[1];
        this.lastName = tempLine[1].split(":")[1];
        this.email = tempLine[3].split(":")[1];
        this.phoneNo = tempLine[2].split(":")[1];
        this.dob = tempLine[4].split(":")[1];
        this.password = tempLine[6].split(":")[1];
        this.username = tempLine[5].split(":")[1];
        
        // Need to get profile data as well...
        
        String[] tempStr = tempLine[7].split(":");
        
        if (tempStr.length > 1) {
            
            this.likes = tempLine[7].split(":")[1];

        }
        
        String[] tempStr2 = tempLine[8].split(":");
        
        if (tempStr2.length > 1) {
            
            this.aboutMe = tempLine[8].split(":")[1];
            
        }
        
        String[] tempStr3 = tempLine[9].split(":");
        
        if (tempStr3.length > 1) {
            
            this.friends = tempLine[9].split(":")[1];
            
        }
        
        String[] tempStr4 = tempLine[10].split(":");
        
        if (tempStr4.length > 1) {
            
            this.sentByMe = tempLine[10].split(":")[1];
            
        }
        
        String[] tempStr5 = tempLine[11].split(":");
        
        if (tempStr5.length > 1) {
            
            this.sentToMe = tempLine[11].split(":")[1];
            
        }
        
    }

    
    public void create_profile(String firstName, String lastName, String phoneNumber, String email, String dob, String userName, String password, String likes, String aboutMe) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "create_profile".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (firstName == null || lastName == null || phoneNumber == null || email == null || dob == null ||
                    userName == null || password == null || likes == null || aboutMe == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }

        String command = "create_profile";
        String totalString = "Command:" + command + "||First Name:" + firstName + "||Last Name:" + lastName
                + "||Phone No.:" + phoneNumber + "||Email:" + email
                + "||Date Of Birth:" + dob + "||Username:" + userName + "||Password:" + password + "||Likes:" + likes + "||About Me:" + aboutMe
                + "||Friends:" + friends + "||SentByMe:" + sentByMe + "||SentToMe:" + sentToMe;

        try {
            
            out.writeUTF(totalString);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        view_account();

    }


    public void delete_account(String userName, String pw) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "delete_account".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (userName == null || pw == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "delete_account";
        String fullString1 = "Command:" + command + "||Username:" + userName + "||Password:" + pw;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
    }
    

    public void get_friend_info(String username) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "get_friend_info".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (username == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "get_friend_info";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
    }
    

    public void get_user_info(String username) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "get_user_info".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (username == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "get_user_info";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        checkForSuccess();

    }
    

    public void accept_request(String username) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "accept_request".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (username == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "accept_request";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }

    }
    
    
    public void reject_request(String username) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "reject_request".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (username == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "reject_request";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }

    }
    
    
    public void send_request(String username) throws Exception {

        // If the parameters are not null nor blank they are paired together in a string whose first letters are "send_request".
        // This string is then sent to the server class.
        // If the parameters are null or blank an exception is thrown.
        
        try {
            
            if (username == null) {

                throw new Exception();

            }
            
        } catch (Exception e) {
            
            throw new Exception();
            
        }
        
        String command = "send_request";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }

    }

    
    public void get_all_users() {
        
        // A string whose first letters are "get_all_users" is sent to the server class.
        
        String command = "get_all_users";
        String fullString1 = "Command:" + command + "||Username:" + username;

        try {
            
            out.writeUTF(fullString1);
            out.flush();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }

    }

    
}
