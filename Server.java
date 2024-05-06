package company.com;
import java.net.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;


/**
 * Project05 - Option2 - Server
 *
 * The program will create the server of the application.
 *
 * No external resources used
 *
 * @author Nischal Kalahasti  LC12
 * @version 26 November, 2020
 *
 */


public class Server implements Runnable {

     // This class is public so it can be used by anyone.
    // The server will differentiate the output sent from the Client class by the command phrase (starting of the string).
    // For example, an output sent by the Client saying "create_account" will run the create_account method in the Server that will try to create an account.
    // initialize socket and input output streams

    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out = null;
    public String path = "src/company/com/Account.txt";
    public String tmppath = "src/company/com/tempFile.txt";
    public String userName;


    // constructor with port

    public Server(Socket csocket){

        // starts server and waits for a connection

        this.socket = csocket;

    }


    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5001);

        while(true) {

            Socket sock = server.accept();
            new Thread(new Server(sock)).start();

        }

    }


    public void run() {

        try {

            // takes input from the client socket

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String line = "";

            // reads message from client until "Over" is sent

            while (!line.equals("Over")) {

                try {

                    line = in.readUTF();
                    if (line.contains("create_account")) {

                        String testString = line.replace("Command:create_account||", "");
                        create_account(testString);

                    } else if (line.contains("signIn_account")) {

                        String testString = line.replace("Command:signIn_account||", "");
                        signIn_account(testString);

                    } else if (line.contains("view_account")) {

                        view_account();

                    } else if (line.contains("delete_account")) {

                        String testString = line.replace("Command:delete_account||", "");
                        replaceLine2(this.userName);
                        delete_account(testString);

                    } else if (line.contains("create_profile")) {

                        String testString = line.replace("Command:create_profile||", "");
                        if (create_profile(testString)){

                            out.writeUTF("Success!");

                        } else {

                            out.writeUTF("Fail!");

                        }

                        out.flush();

                    } else if (line.contains("get_friend_info")) {

                        out.writeUTF("Success!");
                        out.flush();
                        get_friend_info();

                    } else if (line.contains("get_user_info")) {

                        out.writeUTF("Success!");
                        out.flush();
                        get_user_info(line.split("\\|\\|")[1].split(":")[1]);

                    } else if (line.contains("accept_request")) {

                        out.writeUTF("Success!");
                        out.flush();
                        accept_request(line.split("\\|\\|")[1].split(":")[1]);

                    } else if (line.contains("reject_request")) {

                        out.writeUTF("Success!");
                        out.flush();
                        reject_request(line.split("\\|\\|")[1].split(":")[1]);

                    } else if (line.contains("send_request")) {

                        out.writeUTF("Success!");
                        out.flush();
                        send_request(line.split("\\|\\|")[1].split(":")[1]);

                    } else if (line.contains("get_all_users")) {

                        out.writeUTF("Success!");
                        out.flush();
                        get_all_users(line.split("\\|\\|")[1].split(":")[1]);

                    }

                } catch(Exception i) {

                    break;

                }

            }

            // close connection
            socket.close();
            in.close();

        } catch(Exception i) {

            i.printStackTrace();

        }
    }


    public boolean create_account(String totalString) throws Exception {

        // Creates a new account using the input sent from the Client class.
        // Writes the account to the file

        if (totalString == null || totalString.isBlank()) {

            throw new Exception();

        }

        String[] accountAttributes = totalString.split("\\|\\|");
        this.userName = accountAttributes[5].split(":")[1];

        try {

            Path accountPath = Paths.get("src/company/com/Account.txt");
            Path tempPath = Paths.get("src/company/com/tempFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();
            boolean added = false;

            if (line == null){

                temp_file.write(totalString);
                out.writeUTF("Success!");
                out.writeUTF(totalString);
                out.flush();

            } else {

                while (line != null) {

                    if (line.contains("Username:" + this.userName)) {

                        temp_file.write(totalString);
                        temp_file.write('\n');
                        added = true;
                        out.writeUTF("Success!");
                        out.writeUTF(totalString);
                        out.flush();

                    } else {

                        temp_file.write(line);
                        temp_file.write('\n');

                    }

                    line = reader.readLine();

                }
                if (!added) {

                    temp_file.write(totalString);
                    temp_file.write('\n');
                    out.writeUTF("Success!");
                    out.writeUTF(totalString);
                    out.flush();

                }

            }

            reader.close();
            temp_file.flush();
            temp_file.close();
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }

        return true;
    }


    public void signIn_account(String fullString) throws Exception {

        // Uses the data sent from the Client and comparing it with the file data to see if there is a match.
        // If a match is found it sends "success" to the client or else "Fail"

        if (fullString == null || fullString.isBlank()) {

            throw new Exception();

        }

        String[] accountUserAndPw = fullString.split("\\|\\|");
        this.userName = accountUserAndPw[0].split(":")[1];
        File myObj = new File(this.path);
        Scanner myReader = new Scanner(myObj);
        boolean found = false;
        String data = "";

        while (myReader.hasNextLine()) {

            data = myReader.nextLine();

            if (data.contains(accountUserAndPw[0]) && data.contains(accountUserAndPw[1])) {

                found = true;
                break;

            }

        }

        if (found) {

            out.writeUTF("Success!");
            out.writeUTF(data);

        } else {

            out.writeUTF("Fail!");

        }

        out.flush();
        myReader.close();

    }


    public void view_account() throws IOException {

        // Tries to find a specific account in the file.
        // If the account is found it is sent to the client.
        // An account is always found as the user can access this method only if the user creates/signs into an account.

        String viewString = "";
        File file = new File(this.path);
        Scanner myReader1 = new Scanner(file);
        while (myReader1.hasNextLine()) {

            String line = myReader1.nextLine();

            if (line.contains("Username:" + this.userName)) {

                out.writeUTF("Success!");
                viewString = line;
                out.writeUTF(viewString);
                out.flush();
                break;

            }

        }

        myReader1.close();
    }


    public void get_friend_info() throws IOException {

        // Tries to find a specific account in the file.
        // If the account is found it is sent to the client.
        // An account is always found as the user's friends are existing account users of this application.

        try {

            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            String line = reader.readLine();

            while (line != null) {

                if (line.contains("Username:" + this.userName)) {
                    out.writeUTF(line);
                    out.flush();
                    break;

                }

                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public void get_user_info(String userName) throws Exception {

        // Tries to find a specific account in the file.
        // If the account is found it is sent to the client.
        // An account is always found as the username is of an existing account in the application.

        if (userName == null || userName.isBlank()) {

            throw new Exception();

        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            String line = reader.readLine();

            while (line != null) {

                String trim_user = userName.trim();
                String search = "Username:" + trim_user;

                if (line.contains(search)) {

                    out.writeUTF(line);
                    out.flush();
                    break;

                }

                line = reader.readLine();

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public void get_all_users(String userName) throws Exception {

        // Gets all the users of the application and stores them in an ArrayList for use in other methods.

        if (userName == null || userName.isBlank()) {

            throw new Exception();

        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            String friends = "";
            String requests = "";
            String line = reader.readLine();
            List<String> list_of_users = new ArrayList<>();
            List<String> friend_list = new ArrayList<>();
            List<String> request_list = new ArrayList<>();

            while (line != null) {

                String tmpUser = (line.split("\\|\\|")[5]).split(":")[1];

                if (tmpUser.equals(userName.trim())) {

                    if ((line.split("\\|\\|")[9]).split(":").length > 1) {

                        friends = (line.split("\\|\\|")[9]).split(":")[1];

                    }

                    if ((line.split("\\|\\|")[10]).split(":").length > 1) {

                        requests = (line.split("\\|\\|")[10]).split(":")[1];

                    }

                    friend_list = new ArrayList<String>(Arrays.asList(friends.split(",")));
                    friend_list.add(tmpUser);
                    request_list = new ArrayList<String>(Arrays.asList(requests.split(",")));

                }

                list_of_users.add(tmpUser);
                line = reader.readLine();

            }

            // Exclude friends & requests from list_of_users

            list_of_users.removeAll(friend_list);
            list_of_users.removeAll(request_list);
            String joined_list = String.join(":", list_of_users);
            out.writeUTF(joined_list);
            out.flush();
            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public void delete_account(String fullString1) throws Exception {

        // Deletes an account by looking for the account in the file
        // Deletes every instance of the user from the file using the replaceLine2 method

        if (fullString1 == null || fullString1.isBlank()) {

            throw new Exception();

        }

        try {

            Path accountPath = Paths.get(this.path);
            Path tempPath = Paths.get(this.tmppath);
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();

            while (line != null ) {

                if (!line.contains("Username:" + this.userName)) {

                    temp_file.write(line);
                    temp_file.write('\n');

                }

                line = reader.readLine();

            }

            temp_file.flush();
            temp_file.close();
            reader.close();
            File newName = new File(this.path);
            File oldName = new File(this.tmppath);
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public boolean create_profile(String totalString) throws Exception {

        // creates an account using input from the client.

        String[] profileAttributes = totalString.split("\\|\\|");

        if (totalString == null || totalString.isBlank()) {

            throw new Exception();

        }

        try {

            Path accountPath = Paths.get(this.path);
            Path tempPath = Paths.get(this.tmppath);
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();

            while (line != null ) {

                if (line.contains("Username:" + this.userName)) {

                    temp_file.write(totalString);

                } else {

                    temp_file.write(line);

                }

                temp_file.write('\n');
                line = reader.readLine();

            }

            temp_file.flush();
            temp_file.close();
            reader.close();
            File newName = new File(this.path);
            File oldName = new File(this.tmppath);
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return true;

    }


    public boolean accept_request(String userName) throws Exception {

        // This method adds the user who said the friend request and the current user to each others friend list.
        // This method will delete the request from both accounts (with additional help of the replaceLine1 method)

        if (userName == null || userName.isBlank()) {

            throw new Exception();

        }

        try {

            replaceLine1(userName);
            Path accountPath = Paths.get(this.path);
            Path tempPath = Paths.get(this.tmppath);
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();

            while (line != null ) {

                String tmpLine = line.replace(']', '\0');

                if (tmpLine.contains("Username:" + this.userName.trim())) {

                    String[] lineParts = tmpLine.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 9) {

                            mostOfLine += lineParts[9];

                            if (lineParts[9].charAt(lineParts[9].length() - 1) != ':') {

                                mostOfLine += ",";

                            }

                            mostOfLine += userName.trim();
                            mostOfLine += "||";

                        } else if (i == 11) {

                            String[] tmpStr = lineParts[11].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j = 0; j < friendUsernames.length; j++) {

                                    if (!friendUsernames[j].equals(userName)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }

                                }

                            }

                        } else if (i == 10) {

                            String[] tmpStr = lineParts[10].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j=0; j<friendUsernames.length; j++) {

                                    String tmp1 = friendUsernames[j].trim();
                                    String tmp2 = userName.trim();

                                    if (!tmp1.equals(tmp2)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();
                                        }

                                    }

                                }

                            }

                            mostOfLine += "||";

                        } else {

                            mostOfLine += lineParts[i] + "||";

                        }

                    }

                    temp_file.write(mostOfLine);

                } else if (tmpLine.contains("Username:" + userName.trim())) {

                    String[] lineParts = tmpLine.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 9) {

                            mostOfLine += lineParts[9];

                            if (lineParts[9].charAt(lineParts[9].length() - 1) != ':') {

                                mostOfLine += ",";

                            }

                            mostOfLine += this.userName.trim();
                            mostOfLine += "||";

                        } else if (i == 10) {

                            String[] tmpStr = lineParts[10].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j=0; j<friendUsernames.length; j++) {

                                    String tmp1 = friendUsernames[j].trim();
                                    String tmp2 = this.userName.trim();

                                    if (!tmp1.equals(tmp2)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }
                                }
                            }

                            mostOfLine += "||";

                        } else if (i == 11) {

                            String[] tmpStr = lineParts[11].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j = 0; j < friendUsernames.length; j++) {

                                    if (!friendUsernames[j].equals(this.userName)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }
                                }
                            }

                        } else {

                            mostOfLine += lineParts[i];
                            mostOfLine += "||";

                        }

                    }

                    temp_file.write(mostOfLine);

                } else {

                    temp_file.write(line);

                }

                temp_file.write('\n');
                line = reader.readLine();

            }

            temp_file.flush();
            temp_file.close();
            reader.close();
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return true;
    }


    public boolean reject_request(String userName) throws Exception {

        // removes a friend request from the sender and receiver.

        if (userName == null || userName.isBlank()) {

            throw new Exception();

        }

        try {

            replaceLine1(userName);
            Path accountPath = Paths.get(this.path);
            Path tempPath = Paths.get(this.tmppath);
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();
            String trimUserName = userName.trim();

            while (line != null ) {

                String tmpLine = line;

                if (tmpLine.contains("Username:" + this.userName)) {

                    String[] lineParts = tmpLine.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 11) {

                            String[] tmpStr = lineParts[11].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";
                            String tmpUserNames = tmpStr[1];
                            String[] friendUsernames = tmpUserNames.split(",");

                            for (int j = 0; j < friendUsernames.length; j++) {

                                String tmp1 = friendUsernames[j].trim();
                                String tmp2 = userName.trim();

                                if (!tmp1.equals(tmp2)) {

                                    if (j != friendUsernames.length - 1) {

                                        if (j == 0) {

                                            mostOfLine += friendUsernames[j].trim();

                                        } else {

                                            mostOfLine += "," + friendUsernames[j];

                                        }

                                    } else {

                                        if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                            mostOfLine += ",";

                                        }

                                        mostOfLine += friendUsernames[j].trim();

                                    }
                                }
                            }

                        } else if (i == 10) {

                            String[] tmpStr = lineParts[10].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j=0; j<friendUsernames.length; j++) {

                                    String tmp1 = friendUsernames[j].trim();
                                    String tmp2 = userName.trim();

                                    if (!tmp1.equals(tmp2)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }
                                }
                            }

                            mostOfLine += "||";

                        } else {

                            mostOfLine += lineParts[i];
                            mostOfLine += "||";

                        }
                    }

                    temp_file.write(mostOfLine);

                } else if (tmpLine.contains("Username:" + trimUserName)) {

                    String[] lineParts = tmpLine.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 10) {

                            String[] tmpStr = lineParts[10].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String[] friendUsernames = tmpStr[1].split(",");

                                for (int j=0; j<friendUsernames.length; j++) {

                                    String tmp1 = friendUsernames[j].trim();
                                    String tmp2 = this.userName.trim();

                                    if (!tmp1.equals(tmp2)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }
                                }
                            }

                            mostOfLine += "||";

                        } else if (i == 11) {

                            String[] tmpStr = lineParts[11].split(":");
                            mostOfLine += tmpStr[0];
                            mostOfLine += ":";

                            if (tmpStr.length > 1) {

                                String tmpUserNames = tmpStr[1];
                                String[] friendUsernames = tmpUserNames.split(",");

                                for (int j = 0; j < friendUsernames.length; j++) {

                                    String tmp1 = friendUsernames[j].trim();
                                    String tmp2 = this.userName.trim();

                                    if (!tmp1.equals(tmp2)) {

                                        if (j != friendUsernames.length - 1) {

                                            if (j == 0) {

                                                mostOfLine += friendUsernames[j].trim();

                                            } else {

                                                mostOfLine += "," + friendUsernames[j];

                                            }

                                        } else {

                                            if (mostOfLine.charAt(mostOfLine.length() - 1) != ':') {

                                                mostOfLine += ",";

                                            }

                                            mostOfLine += friendUsernames[j].trim();

                                        }
                                    }
                                }
                            }

                        } else {

                            mostOfLine += lineParts[i].trim();
                            mostOfLine += "||";

                        }
                    }

                    temp_file.write(mostOfLine);

                } else {

                    temp_file.write(line);
                }

                temp_file.write('\n');
                line = reader.readLine();

            }

            temp_file.flush();
            temp_file.close();
            reader.close();
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return true;
    }


    public boolean send_request(String userName) throws Exception {

        // the user sends a request to another user - friend request gets added to one's send list and to the others receive list

        if (userName == null || userName.isBlank()) {

            throw new Exception();

        }

        try {

            Path accountPath = Paths.get(this.path);
            Path tempPath = Paths.get(this.tmppath);
            BufferedReader reader = new BufferedReader(new FileReader((this.path)));
            FileWriter temp_file = new FileWriter(this.tmppath);
            String line = reader.readLine();

            while (line != null ) {

                if (line.contains("Username:" + this.userName.trim())) {

                    String[] lineParts = line.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 10) {

                            mostOfLine += lineParts[10];

                            if (lineParts[10].charAt(lineParts[10].length() - 1) != ':') {

                                mostOfLine += ",";

                            }

                            mostOfLine += userName.trim();
                            mostOfLine += "||";

                        } else if (i == 11) {

                            mostOfLine += lineParts[i].trim();

                        } else {

                            mostOfLine += lineParts[i] + "||";

                        }
                    }

                    temp_file.write(mostOfLine);

                } else if (line.contains("Username:" + userName.trim())) {

                    String[] lineParts = line.split("\\|\\|");
                    String mostOfLine = "";

                    for (int i = 0; i < lineParts.length; i++) {

                        if (i == 11) {

                            mostOfLine += lineParts[11].trim();

                            if (lineParts[11].charAt(lineParts[11].length() - 1) != ':') {

                                mostOfLine += ",";

                            }

                            mostOfLine += this.userName.trim();

                        } else {

                            mostOfLine += lineParts[i] + "||";

                        }
                    }

                    temp_file.write(mostOfLine);

                } else {

                    temp_file.write(line);

                }

                temp_file.write('\n');
                line = reader.readLine();

            }

            temp_file.flush();
            temp_file.close();
            reader.close();
            CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE,
                    LinkOption.NOFOLLOW_LINKS };
            Files.move(tempPath, accountPath, options);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return true;
    }


    public void replaceLine1(String name) throws Exception {

        // This method removes the name of the another user from the current user's list of sentByMe field when the accept/request buttons are pressed.

        if (name == null || name.isEmpty()) {

            throw new Exception();

        }

        ArrayList<String> one = new ArrayList<>();
        String two = "";

        try {

            File n = new File("src/company/com/Account.txt");
            FileReader fr = new FileReader(n);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line!= null) {

                String anew = "";

                if (line.contains("Username:" + name)) {

                    String[] h = line.split("\\|\\|");
                    String[] l = h[10].split(":");
                    int x = l[1].indexOf(",");
                    int y = l[1].indexOf(",", x + 1);

                    if (x == -1 && y == -1) {

                        anew = "";

                    } else if (x == 0 && y == -1) {

                        anew = l[1].substring(x + 1);

                    } else if (x >= 0 && y == -1) {

                        anew = l[1].substring(0, x);

                    } else if (x == 0 && y > 0){

                        anew = l[1].replace(name, "");

                    }else {

                        anew = l[1].replace(", " + name, "");
                    }

                    for (int i = 0; i < h.length; i++) {

                        if (i == h.length - 1) {

                            two += h[i];

                        } else if (i == 10) {

                            two += l[0] + ":" + anew + "||";

                        } else {

                            two += h[i] + "||";

                        }

                    }

                    one.add(two);

                } else {

                    one.add(line);

                }

                line = br.readLine();

            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            File n = new File("src/company/com/Account.txt");
            FileOutputStream fos = new FileOutputStream(n);
            PrintWriter pw = new PrintWriter(fos);

            for (int i = 0; i < one.size(); i++) {

                pw.println(one.get(i));

            }

            pw.close();

        } catch (Exception ef) {

            ef.printStackTrace();

        }

    }


    public void replaceLine2(String name) throws Exception {

        // This method removes every instance of a user's name in the Account.txt file when they delete their account/profile.

        if (name == null) {

            throw new Exception();

        }

        ArrayList<String> w = new ArrayList<>();

        try {

            File n = new File("src/company/com/Account.txt");
            FileReader fr = new FileReader(n);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String line1 = "";
            while (line!= null) {

                if (!line.contains("Username:" + name)) {

                    line1 = line.replaceAll(name, "");

                    if (line1.contains(",,")) {

                        line1 = line1.replaceAll(",,", ",");

                    }

                    w.add(line1);

                } else {

                    w.add(line);
                }

                line = br.readLine();

            }

            br.close();

        } catch (Exception r) {

            r.printStackTrace();

        }


        try {

            File n = new File("src/company/com/Account.txt");
            FileOutputStream fos = new FileOutputStream(n);
            PrintWriter pw = new PrintWriter(fos);

            for (int i = 0; i < w.size(); i++) {

                pw.println(w.get(i));

            }

            pw.close();

        } catch (Exception re) {

            re.printStackTrace();

        }

    }


}

