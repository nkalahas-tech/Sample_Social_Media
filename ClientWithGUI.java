package  company.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Project05 - Option2 - ClientWithGUI
 *
 * The program will create multiple GUIs and will contain all the features of the application.
 *
 * No external resources used
 *
 * @author Avi Katare, Nischal Kalahasti  LC12
 * @version 26 November, 2020
 *
 */


public class ClientWithGUI extends JComponent implements Runnable {
    
    private static Client client;

    // This is a public class that extends JComponent and implements Runnable.
    // This class will create multiple GUIs and their respective buttons with functionality.
    // This class has methods that will allow the user to edit/create/ delete accounts and profiles.
    // The user can send/receive friend requests from other users of the application.
    // All changes made to an account are saved to the Account.txt file.

    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate
    Image image;
    Graphics2D graphics2D;

    JComboBox<String> one;
    JComboBox<String> two;
    JComboBox<String> three;

    JFrame frame1;
    JFrame frame2;
    JFrame frame3;
    JFrame frame4;
    JFrame frame5;
    JFrame frame6;
    JFrame frame7;
    JFrame frame8;
    JFrame frame9;
    JFrame frame10;
    JFrame frame11;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton button11;
    JButton button12;
    JButton button13;
    JButton button14;
    JButton button15;
    JButton button16;
    JButton button17;
    JButton button18;
    JButton button19;
    JButton button20;
    JButton button21;
    JButton button22;
    JButton button23;
    JButton button24;
    JButton button25;
    JButton button26;
    JButton button27;
    JButton button28;

    JTextField userName1;
    JTextField username2;
    JTextField userEmail;
    JTextField userPhoneNo;
    JTextField userDateOfBirth;
    JTextField likes1;
    JTextField username;
    JTextField password;
    JTextField area1;

    JLabel userPassword;
    JLabel userUsername;
    JLabel userFirstName;
    JLabel userLastName;
    JLabel userEmailID;
    JLabel UserPhoneNumber;
    JLabel userDateOfBirth1;
    JLabel userPassword1;
    JLabel userUsername1;
    JLabel aboutMe1;
    JLabel likes2;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;

    public  ArrayList<String> listOfOtherUsers = new ArrayList<>();
    public int number = 0;

    
    public static void main(String[] args) throws IOException {

        // This main method will start to run the Social2020GUI class by first running the run() method followed by button functionality
        
        client = new Client("127.0.0.1", 5001);
        SwingUtilities.invokeLater(new ClientWithGUI());
        
    }


    public void run() {

        // This method creates a GUI that asks the user wheather they want to create an account or sign in into an existing account.
        // This method has two buttons - Create Account and Sign In.
        // The Create Account button will run the createAccountGUI() method by which a first time user can create a new account in the application. 
        // The Sign In button will run the signInGUI() method by which an existing user of the application can log into their account.

        frame1 = new JFrame("Application Main Page");
        Container content = frame1.getContentPane();
        content.setLayout(new BorderLayout());
        GridLayout layout = new GridLayout(1,2);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel one = new JPanel();
        button14 = new JButton("Create Account");
        button15 = new JButton("Sign in");
        button14.addActionListener(actionListener);
        button15.addActionListener(actionListener);
        one.add(button14);
        one.add(button15);
        one.setLayout(layout);
        frame1.add(one);
        frame1.setSize(600, 400);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        
    }
    

    public void mainMenuGUI() {

        // This method will feature a GUI that contains the variety of options the application has to offer.
        // This method creates three new buttons - Account, Profile and Friend & Friend Requests.
        // The Account button will create an GUI which contains the user's account details in 
        // an editable format thus allowing the user to make changes to their account details. 
        // The Profile button will run the profileGUI() method that will allow the user to make changes to their profile details.
        // The Account button will run the friendAndFriendRequestsGUI() method allowing the user to access the user's current list of friends, 
        // and new list of friend requests send and received.
        
        frame2 = new JFrame("Main Menu");
        Container content = frame2.getContentPane();
        content.setLayout(new BorderLayout());
        GridLayout layout = new GridLayout(1,3);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel one = new JPanel();
        one.setLayout(layout);
        button1 = new JButton("Account");
        button1.addActionListener(actionListener);
        button2 = new JButton("Profile");
        button2.addActionListener(actionListener);
        button3 = new JButton("Friends & Friend Requests");
        button3.addActionListener(actionListener);
        one.add(button1);
        one.add(button3);
        one.add(button2);
        frame2.add(one, BorderLayout.CENTER);
        frame2.setSize(600, 400);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

    }
    

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button1) {
            
                // This will result in the creation of GUI containing an editable fields for the user to enter their personal data.
                // This button must stop running the mainMenuGUI() method, that is, it must close the GUI created 
                // in the mainMenuGUI() method and open the new GUI created below.
                // The GUI will contain a Enter button that will create a new account for the user if he/she has entered valid input.
                
                try {
                    
                    client.view_account();
                    
                } catch (IOException ioException) {
                    
                    ioException.printStackTrace();
                    
                }
                
                frame2.dispose();
                frame8 = new JFrame("Account Details");
                Container content = frame8.getContentPane();
                content.setLayout(new BorderLayout());
                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GridLayout layout = new GridLayout(8, 2);
                JPanel two = new JPanel();
                two.setLayout(layout);
                userName1 = new JTextField(5);
                userFirstName = new JLabel("FIRST NAME");
                username2 = new JTextField(5);
                userLastName = new JLabel("LAST NAME");
                userEmail = new JTextField(5);
                userEmailID = new JLabel("EMAIL ID");
                userPhoneNo = new JTextField(5);
                UserPhoneNumber = new JLabel("PHONE NUMBER");
                userDateOfBirth = new JTextField(5);
                userDateOfBirth1 = new JLabel("DATE OF BIRTH");
                userPassword = new JLabel(client.password);
                userPassword1 = new JLabel("PASSWORD");
                userUsername = new JLabel(client.username);
                userUsername1 = new JLabel("USERNAME");
                two.add(userFirstName);
                two.add(userName1);
                two.add(userLastName);
                two.add(username2);
                two.add(userEmailID);
                two.add(userEmail);
                two.add(UserPhoneNumber);
                two.add(userPhoneNo);
                two.add(userDateOfBirth1);
                two.add(userDateOfBirth);
                two.add(userPassword1);
                two.add(userPassword);
                two.add(userUsername1);
                two.add(userUsername);
                frame8.add(two, BorderLayout.CENTER);
                JPanel three = new JPanel();
                button4 = new JButton("Confirm Changes");
                button4.addActionListener(actionListener);
                button5 = new JButton("Delete Account");
                button5.addActionListener(actionListener);
                three.add(button4);
                three.add(button5);
                content.add(three, BorderLayout.SOUTH);
                userName1.setText(client.firstName);
                username2.setText(client.lastName);
                userEmail.setText(client.email);
                userPhoneNo.setText(client.phoneNo);
                userDateOfBirth.setText(client.dob);
                frame8.setSize(600, 400);
                frame8.setLocationRelativeTo(null);
                frame8.setVisible(true);

            }

            if (e.getSource() == button2) {
            
                // This button must stop running the mainMenuGUI() method, that is, it must close the GUI created in the mainMenuGUI() method 
                // and open the GUI created in the profileGUI() method.
                
                frame2.dispose();
                profileGUI();

            }

            if (e.getSource() == button3) {
            
                
                // This button must stop running the mainMenuGUI() method, that is, it must close the GUI in the mainMenuGUI()
                // method and open the new GUI created in the friendAndFriendRequestsGUI() method.
                // This button will run the checkForSuccess()-  get the latest information about a specific account in the application from the Account.txt file. 
                // This button will also check to see if the user has got any new friend requests by checking the length of the sentToMe field (items separated by commas).
                // If the length is greater than 0, a JOptionPane will appear on the screen. 
                // If the length is 0, then there will be no JOptionPane.
                
                try {
                    
                    client.get_friend_info(client.username);
                    
                } catch (Exception ioException) {
                    
                    ioException.printStackTrace();
                    
                }
                
                try {
                    
                    if (!client.checkForSuccess()) {
                        
                        JOptionPane.showMessageDialog(null, "Could not fetch friend information!", "Social2020",
                                JOptionPane.ERROR_MESSAGE);
                        
                    } else {
                        
                        String[] tempLine = client.client_data.split("\\|\\|");
                        String[] tempStr3 = tempLine[9].split(":");
                        
                        if (tempStr3.length > 1) {
                            
                            client.friends = tempLine[9].split(":")[1];
                            
                        }
                        
                        String[] tempStr4 = tempLine[10].split(":");
                        
                        if (tempStr4.length > 1) {
                            
                            client.sentByMe = tempLine[10].split(":")[1];
                            
                        }
                        
                        String[] tempStr5 = tempLine[11].split(":");
                        
                        if (tempStr5.length > 1) {
                            
                            client.sentToMe = tempLine[11].split(":")[1];
                            
                        }

                        if (!client.sentToMe.equals("")) {
                            
                            JOptionPane.showMessageDialog(null, "You have new friend requests",
                                    "Social2020", JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
                    
                } catch (IOException ioException) {
                    
                    ioException.printStackTrace();
                    
                }

                frame2.dispose();
                friendAndFriendRequestsGUI();
                
            }

            if (e.getSource() == button4) {
            
                // This button must close the GUI created in the actionListener of button1 and open the new GUI created in the MainMenuGUI().
                // This allowed only if the user has entered valid input in the GUI created by actionListener of button1 (validated using the isValid method). 
                // Also, if the inputs are valid, the changes made to the textfields will be stored in the Account.txt file.
                // If the user input is invalid the isValid method will throw an exception that will be caught in the try-catch block and will be displayed to user
                // in the form of an Error Message. The entered text will be replaced by the text that was in its place earlier.
                // The user will make the neccessary changes and try to see if their inputs are valid.
                
                try {
                    
                    isValid(userName1.getText(), username2.getText(), userEmail.getText(), userPhoneNo.getText(), userDateOfBirth.getText());
                    String userUsername4 = String.valueOf(userName1.getText().charAt(0)).toUpperCase() + userName1.getText().substring(1);
                    String lastName2 = String.valueOf(username2.getText().charAt(0)).toUpperCase() + username2.getText().substring(1);
                    client.create_account(userUsername4, lastName2, userPhoneNo.getText(), userEmail.getText(), userDateOfBirth.getText(),
                            client.username, client.password, client.likes, client.aboutMe, client.friends, client.sentByMe, client.sentToMe);
                    frame8.dispose();
                    mainMenuGUI();

                } catch (Exception exception) {
                    
                    JOptionPane.showMessageDialog(null, exception.getMessage() + " Try Again!", "Social2020",
                            JOptionPane.ERROR_MESSAGE);
                    userName1.setText("John");
                    username2.setText("Doe");
                    userEmail.setText("jdoe@gmail.com");
                    userPhoneNo.setText("(897)987-0987");
                    userDateOfBirth.setText("29-11-2009");
                    userUsername.setText("");
                    userPassword.setText("");
                    
                }
                
            }

            if (e.getSource() == button5 || e.getSource() == button8) {
            
                // This button actionListener is run when the user selects the Delete Profile and Delete Account buttons.
                // As the user's profile details contain all the aspects of the user's account details, deleting a profile is equivalent to deleting an account.
                // Thus, the profileGUI() or the GUI() in actionListener of button1 is closed and the GUI created in the run() method is opened.
                // The delete_account() method is run to delete the account from Account.txt file.
                
                try {
                    
                    client.delete_account(client.username, client.password);
                    
                } catch (Exception exception) {
                    
                    exception.printStackTrace();
                    
                }

                if (e.getSource() == button5) {

                frame8.dispose();

            } else {

                frame4.dispose();
            }

            run();
        }

            if (e.getSource() == button9) {
            
                // This button must close the GUI created in the profileGUI() method and open the new GUI created in the MainMenuGUI().
                // This allowed only if the user has entered valid input in the GUI created by profileGUI() (validated using the isValid method). 
                // Also, if the inputs are valid, the changes made to the textfields will be stored in the Account.txt file.
                // If the user input is invalid the isValid method will throw an exception that will be caught in the try-catch block and will be displayed to user
                // in the form of an Error Message. The entered text will be replaced by the text that was in its place earlier.
                // The user will make the neccessary changes and try to see if their inputs are valid.

                try {
                    
                    isValid(userName1.getText(), username2.getText(), userEmail.getText(), userPhoneNo.getText(), userDateOfBirth.getText());
                    client.create_profile(userName1.getText(), username2.getText(), userPhoneNo.getText(), userEmail.getText(), userDateOfBirth.getText(),
                            client.username, client.password, likes1.getText(), area1.getText());
                    frame4.dispose();
                    mainMenuGUI();

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage() + " Try Again!", "Social2020",
                            JOptionPane.ERROR_MESSAGE);
                    userName1.setText("John");
                    username2.setText("Doe");
                    userEmail.setText("jdoe@gmail.com");
                    userPhoneNo.setText( "(897)987-0987");
                    userDateOfBirth.setText("29-11-2009");
                }
                
            }

            if (e.getSource() == button10) {
            
                // If the user's friends field is null an Information Message will be displayed on the screen.
                // If the user currently has zero or more friends from the application the Information Message is not diplayed but the friendAndFriendRequestsGUI() method is 
                // closed and the GUI created in the friendsGUI() is opened.
                
                if (client.friends != null) {
                    
                    frame3.dispose();
                    friendsGUI();

                } else {
                    
                    JOptionPane.showMessageDialog(null, "Currently you have no online friends", "Social2020",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                }

            }

            if (e.getSource() == button11) {
            
                // The friendAndFriendRequestsGUI() method created GUI is closed and the GUI created in the friendRequestsSentByYouGUI() is opened.
                
                frame3.dispose();
                friendRequestsSentByYouGUI();

            }

            if (e.getSource() == button12) {
            
                // If the user currently has not been send any new friend requests an Information Message will be displayed on the screen.
                // If the user currently has one or more new friends requests the Information Message is not diplayed but the friendAndFriendRequestsGUI() method created GUI is 
                // closed and the GUI created in the friendsRequestsReceivedToYouGUI() is opened.
                
                try {
                    
                    client.get_friend_info(client.username);
                    
                } catch (Exception ioException) {
                    
                    ioException.printStackTrace();
                }
                
                try {
                    
                    if (!client.checkForSuccess()) {
                        
                        JOptionPane.showMessageDialog(null, "Could not fetch friend information!", "Social2020",
                                JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                } catch (IOException ioException) {
                    
                    ioException.printStackTrace();
                    
                }

                String[] friendRequests = (client.client_data.split("\\|\\|")[11]).replace(']', '\0').split(":");
                
                if (friendRequests.length == 1) {

                    JOptionPane.showMessageDialog(null, "No new friend requests",
                            "Social2020", JOptionPane.INFORMATION_MESSAGE);
                    frame3.dispose();
                    friendAndFriendRequestsGUI();

                } else {
                    
                    frame3.dispose();
                    friendRequestsSendToYouGUI();
                    
                }
            }

            if (e.getSource() == button13) {
            
                // The friendAndFriendRequestsGUI() method created GUI is closed and the GUI created in the mainMenuGUI() is opened.
                
                frame3.dispose();
                mainMenuGUI();
                
            }

            if (e.getSource() == button14) {
            
                // The run() method created GUI is closed and the GUI created in the createAccountGUI() is opened.
                
                frame1.dispose();
                createAccountGUI();
                
            }

            if (e.getSource() == button15) {
            
                // The run() method created GUI is closed and the GUI created in thesignInGUI() is opened.
                
                frame1.dispose();
                signInGUI();
                
            }

            if (e.getSource() == button16) {
            
                // This button must close the GUI created in the createAccount() method and open the new GUI created in the MainMenuGUI().
                // This allowed only if the user has entered valid input in the GUI created by createAccount() method (validated using the isValid method). 
                // Also, if the inputs are valid, the changes made to the textfields will be stored in the Account.txt file.
                // If the user input is invalid the isValid method will throw an exception that will be caught in the try-catch block and will be displayed to user
                // in the form of an Error Message. The entered text will be replaced by the text that was in its place earlier.
                // The user will make the neccessary changes and try to see if their inputs are valid.
                
                try {
                    
                    String password = client.createPassword(userName1.getText(), username2.getText(), userPhoneNo.getText());
                    String userName = client.createUsername(userName1.getText(), userEmail.getText(), userDateOfBirth.getText());
                    client.username = userName;
                    client.password = password;
                    client.create_account(userName1.getText(), username2.getText(), userPhoneNo.getText(), userEmail.getText(), userDateOfBirth.getText(), client.username, client.password,
                            client.likes, client.aboutMe, client.friends, client.sentByMe, client.sentToMe);
                    
                    if (!client.checkForSuccess()) {
                        
                        JOptionPane.showMessageDialog(null, " Account could not be created! Try Again!", "Social2020",
                                JOptionPane.ERROR_MESSAGE);
                        
                    } else {
                        
                        frame6.dispose();
                        mainMenuGUI();
                        
                    }
                    
                } catch (Exception exception) {
                    
                    JOptionPane.showMessageDialog(null, exception.getMessage() + " Try Again!", "Social2020",
                            JOptionPane.ERROR_MESSAGE);
                    userName1.setText("John");
                    username2.setText("Doe");
                    userEmail.setText("jdoe@gmail.com");
                    userPhoneNo.setText( "(897)987-0987");
                    userDateOfBirth.setText("29-11-2009");
                    
                }
                
            }
            
            if (e.getSource() ==  button17) {
            
                // This button will run the signIn method that will check to see if the user has entered a valid password and username.
                // If the inputs are correct, the signInGUI() method GUI is closed and the mainMenuGUI() GUI is opened.

                try {
                    
                    client.signIn_account(username.getText(), password.getText());
                    
                } catch (Exception exception) {
                    
                    exception.printStackTrace();
                    
                }
                
                try {
                    
                    if (!client.checkForSuccess()) {
                        
                        JOptionPane.showMessageDialog(null, " Password/Username is wrong! Try Again!", "Social2020",
                                JOptionPane.ERROR_MESSAGE);
                        
                    } else {

                        try {
                            
                            client.view_account();
                            
                        } catch (IOException ioException) {
                            
                            ioException.printStackTrace();
                            
                        }
                        
                        frame7.dispose();
                        mainMenuGUI();
                        
                    }
                    
                } catch (IOException ioException) {
                    
                    ioException.printStackTrace();
                    
                }
            }

            if (e.getSource() == button18) {
            
                // The friendsGUI() method GUI is closed and the friendAndFriendRequestsGUI() GUI is opened.
                
                frame5.dispose();
                friendAndFriendRequestsGUI();
                
            }

            if (e.getSource() == button19) {
            
                // The friendRequestsSendToYou() method GUI is closed and the viewUserProfileGUI(int number) GUI is opened.
                
                String r = (String) one.getSelectedItem();
                
                if (r.contains("You have")) {
                    
                } else {
                    
                    frame9.dispose();
                    
                    try {
                        
                        viewUserProfileGUI(r);
                        
                    } catch (Exception ioException) {
                        
                        ioException.printStackTrace();
                        
                    }
                }
            }

            if (e.getSource() == button20) {
            
                // This button must close the GUI created in the friendRequestsSendToYouGUI() method and open the new GUI created in the friendRequestsSendToYouGUI().
                
                String r = (String) one.getSelectedItem();
                
                if (r.contains("You have")) {
              
                } else {
                    
                    try {
                        
                        accept(r);
                        
                    } catch (Exception exception) {
                        
                        exception.printStackTrace();
                        
                    }
                    
                    try {
                        
                        client.get_friend_info(client.username);
                        
                    } catch (Exception ioException) {
                        
                        ioException.printStackTrace();
                        
                    }
                    
                    try {
                        
                        if (!client.checkForSuccess()) {
                            
                            JOptionPane.showMessageDialog(null, "Could not fetch friend information!", "Social2020",
                                    JOptionPane.ERROR_MESSAGE);
                            
                        } else {
                            
                            //String clientData1 = client.client_data.replace('[', '\0').replace(']', '\0');
                            
                            String[] tempLine = client.client_data.split("\\|\\|");

                            String[] tempStr3 = tempLine[9].split(":");
                            
                            if (tempStr3.length > 1) {
                                
                                client.friends = tempLine[9].split(":")[1];
                                
                            }
                            
                            String[] tempStr4 = tempLine[10].split(":");
                            
                            if (tempStr4.length > 1) {
                                
                                client.sentByMe = tempLine[10].split(":")[1];
                                
                            }
                            
                            String[] tempStr5 = tempLine[11].split(":");
                            
                            if (tempStr5.length > 1) {
                                
                                client.sentToMe = tempLine[11].split(":")[1];
                                
                            }

                        }
                        
                    } catch (IOException ioException) {
                        
                        ioException.printStackTrace();
                        
                    }

                    if (client.sentToMe.equals("")) {
                        
                        JOptionPane.showMessageDialog(null, "No new friend requests",
                                "Social2020", JOptionPane.INFORMATION_MESSAGE);
                        frame9.dispose();
                        friendAndFriendRequestsGUI();

                    } else {
                        
                        frame9.dispose();
                        friendRequestsSendToYouGUI();
                        
                    }
                }

            }

            if (e.getSource() == button21) {
            
                // This button must close the GUI created in the friendRequestsSendToYouGUI() method and open the new GUI created in the friendRequestsSendToYouGUI().
                
                String r = (String) one.getSelectedItem();

                try {
                    
                    reject(r);
                    
                } catch (Exception exception) {
                    
                    exception.printStackTrace();
                    
                }

                String[] friendRequests = (client.client_data.split("\\|\\|")[11]).replace(']', '\0').split(":");

                if (friendRequests.length == 1) {

                    JOptionPane.showMessageDialog(null, "No new friend requests",
                            "Social2020", JOptionPane.INFORMATION_MESSAGE);
                    frame9.dispose();
                    friendAndFriendRequestsGUI();

                } else {
                    
                    frame9.dispose();
                    friendRequestsSendToYouGUI();
                    
                }
            }

            if (e.getSource() == button22) {
            
                // The friendsGUI() method GUI is closed and the friendRequestsSentByYouGUI() GUI is opened.

                frame5.dispose();
                friendRequestsSentByYouGUI();
                
            }

            if (e.getSource() == button23) {
            
                String[] friendRequests = (client.client_data.split("\\|\\|")[11]).replace(']', '\0').split(":");
                
                if (friendRequests.length == 1) {

                    JOptionPane.showMessageDialog(null, "You have no new friend requests",
                            "Social2020", JOptionPane.INFORMATION_MESSAGE);
                    frame5.dispose();
                    friendAndFriendRequestsGUI();
                    
                } else {
                    
                    frame5.dispose();
                    friendRequestsSendToYouGUI();
                    
                }
            }

            if (e.getSource() == button24) {
            
                // This button must close the GUI created in the viewUserProfile method and open the new GUI created in the friendRequestsSendToYouGUI()
                
                String[] friendRequests = (client.client_data.split("\\|\\|")[11]).replace(']', '\0').split(":");
                
                if (friendRequests.length == 1) {

                    JOptionPane.showMessageDialog(null, "You have no new friend requests",
                            "Social2020", JOptionPane.INFORMATION_MESSAGE);
                    frame10.dispose();
                    friendAndFriendRequestsGUI();
                    
                } else {
                    
                    frame10.dispose();
                    friendRequestsSendToYouGUI();
                    
                }
            }

            if (e.getSource() == button25) {
              
                // This button must close the GUI created in the viewUserProfile method and open the new GUI created in the friendRequestsSentByYouGUI().
                
                frame10.dispose();
                friendRequestsSentByYouGUI();

            }

            if (e.getSource() == button26) {
            
                // This button must close the GUI created in the friendRequestsSentByYouGUI() method and open the new GUI created in the viewUserProfileGUI(int number).
                
                String r = (String) three.getSelectedItem();
                frame11.dispose();
                
                try {

                    viewUserProfileGUI(r);
                    
                } catch (Exception ioException) {
                    
                    ioException.printStackTrace();
                    
                    }
                }

            if (e.getSource() == button27) {
            
                // This button must close the GUI created in the friendRequestsSentByYouGUI() method and open the new GUI created in the friendAndFriendRequestsGUI().
                
                frame11.dispose();
                friendAndFriendRequestsGUI();
                
            }

            if (e.getSource() == button28) {
            
                // This button must close the GUI created in the friendRequestsSentByYouGUI() method and open the new GUI created in the friendRequestsSentByYouGUI().
                
                String r = (String) three.getSelectedItem();
                
                if (r.contains("You have")) {
                    
                } else {
                    
                    try {
                        
                        client.send_request(r);
                        
                    } catch (Exception exception) {
                        
                        exception.printStackTrace();
                        
                    }
                    
                    try {
                        
                        client.get_friend_info(client.username);
                        
                    } catch (Exception ioException) {
                        
                        ioException.printStackTrace();
                        
                    }
                    
                    try {
                        
                        if (!client.checkForSuccess()) {
                            
                            JOptionPane.showMessageDialog(null, "Could not fetch friend information!", "Social2020",
                                    JOptionPane.ERROR_MESSAGE);
                        
                        } else {

                            String clientData1 = client.client_data.replace('[', '\0').replace(']', '\0');
                            String[] tempLine = clientData1.split("\\|\\|");
                            String[] tempStr3 = tempLine[9].split(":");
                            
                            if (tempStr3.length > 1) {
                                
                                client.friends = tempLine[9].split(":")[1];
                                
                            }
                            
                            String[] tempStr4 = tempLine[10].split(":");
                            
                            if (tempStr4.length > 1) {
                                
                                client.sentByMe = tempLine[10].split(":")[1];
                                
                            }
                            
                            String[] tempStr5 = tempLine[11].split(":");
                            
                            if (tempStr5.length > 1) {
                                
                                client.sentToMe = tempLine[11].split(":")[1];
                                
                            }

                            if (!client.sentToMe.equals("")) {
                                
                                JOptionPane.showMessageDialog(null, "You have new friend requests",
                                        "Social2020", JOptionPane.INFORMATION_MESSAGE);

                            }

                        }
                        
                    } catch (IOException ioException) {
                        
                        ioException.printStackTrace();
                        
                    }
                    frame11.dispose();
                    friendRequestsSentByYouGUI();
                    
                }
            }
        }

    };


    public void isValid (String firstName, String lastName, String email, String phoneNumber, String dateOfBirth) throws Exception {


        // This method checks to see if the user has entered valid input data while creating/editing of profiles and accounts.

        if (firstName.contains(" ")) {
            
            throw new Exception("Please enter your first name without spaces");
            
        }

        if (lastName.contains(" ")) {
            
            throw new Exception("Please enter your last name without spaces");
            
        }

        if (email.contains(" ") || !email.contains("@") || !email.contains(".")) {
            throw new Exception("Please enter a valid email id");
            
        }

        int x = phoneNumber.indexOf("-");
        int a = phoneNumber.indexOf("(");
        int b = phoneNumber.indexOf(")");

        if ( x != 8 || a != 0 || b != 4) {
            
            throw new Exception("Please enter a valid phone number");
            
        }

        int numberPart1 = -1;
        int numberPart2 = -1;
        int numberPart3 = -1;

        try {
            
            numberPart1 = Integer.parseInt(phoneNumber.substring(a + 1, b));
            numberPart2 = Integer.parseInt(phoneNumber.substring(b + 1, x));
            numberPart3 = Integer.parseInt(phoneNumber.substring(x + 1));
            
        } catch (NumberFormatException t) {

            throw new Exception("Enter a valid phone number");
            
        }

        int r = dateOfBirth.indexOf("-");
        int q = dateOfBirth.indexOf("-", r + 1);

        if (dateOfBirth.contains(" ") ||r != 2 || q != 5) {
            
            throw new Exception("Please enter a valid date of birth");
            
        }

        int month = -1;
        int day = -1;
        int year = -1;
        
        try {
            
            day = Integer.parseInt(dateOfBirth.substring(0, r));
            month = Integer.parseInt(dateOfBirth.substring(r+ 1, q));
            year = Integer.parseInt(dateOfBirth.substring(q + 1));
            
        } catch (NumberFormatException e) {
            
            throw new Exception("Enter a valid month, year and day");
            
        }

        if (year < 0) {
            
            throw new Exception("Enter a valid year");
            
        }
        
        switch (month) {
                
            case 1, 3, 5, 7, 8, 10, 12 -> {
                
                if (day < 0 || day > 31 ) {
                    
                    throw new Exception("Enter a valid day");
                    
                }
                
            }
                
            case 4,6,9,11 -> {
                
                if (day < 0 || day > 30) {
                    
                    throw new Exception();
                    
                }
                
            }
                
            case 2 -> {
                
                if (year % 4 == 0) {
                    
                    if (day < 0 || day > 29) {
                        
                        throw new Exception("Enter a valid day");
                        
                    }
                    
                } else {
                    
                    if (day < 0 || day > 28) {
                        
                        throw new Exception("Enter a valid day");
                        
                    }
                    
                }
                
            }
                
            default -> throw new Exception("Enter a valid month");

        }
        
    }


    public ClientWithGUI() throws IOException {
    
        // This method will keep track of movement in the JFrame.
        //client = new Client("127.0.0.1", 5001);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                /* set oldX and oldY coordinates to beginning mouse press*/
                
                oldX = e.getX();
                oldY = e.getY();
                
            }

        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
                /* set current coordinates to where mouse is being dragged*/
                
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                
                repaint();
                oldX = curX;
                oldY = curY;
            }
        } );
    }

    
    protected void paintComponent(Graphics g) { // reset the canvas for when it is opened once again
        
        if (image == null) {
            
            image = createImage(getSize().width, getSize().height);
            
            /* this lets us draw on the image (ie. the canvas)*/
            
            graphics2D = (Graphics2D) image.getGraphics();
            
            /* gives us better rendering quality for the drawing lines */
            
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            /* set canvas to white with default paint color */
            
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            graphics2D.drawString("WELCOME MESSAGE", 250, 10);
            repaint();
            
        }
        
        g.drawImage(image, 0, 0, null);

    }

    
    public void profileGUI() {

        // This method creates a GUI that allows the user to fill in details to create/edit an account.
        // The GUI also has a delete button at the bottom if they want to delete their profile.

        frame4 = new JFrame("Profile Details");
        Container content = frame4.getContentPane();
        content.setLayout(new BorderLayout());
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(9,2);
        JPanel two = new JPanel();
        two.setLayout(layout);
        userName1 = new JTextField(2);
        userFirstName = new JLabel("FIRST NAME");
        username2 = new JTextField(2);
        userLastName = new JLabel("LAST NAME");
        userEmail = new JTextField(2);
        userEmailID = new JLabel("EMAIL ID");
        userPhoneNo = new JTextField(2);
        UserPhoneNumber = new JLabel("PHONE NUMBER");
        userDateOfBirth = new JTextField(2);
        userDateOfBirth1 = new JLabel("DATE OF BIRTH");
        area1 = new JTextField();
        likes1 = new JTextField(2);
        likes2 = new JLabel("LIKES");
        aboutMe1 = new JLabel("ABOUT ME");
        two.add(userFirstName);
        two.add(userName1);
        two.add(userLastName);
        two.add(username2);
        two.add(userEmailID);
        two.add(userEmail);
        two.add(UserPhoneNumber);
        two.add(userPhoneNo);
        two.add(userDateOfBirth1);
        two.add(userDateOfBirth);
        two.add(likes2);
        two.add(likes1);
        two.add(aboutMe1);
        two.add(area1);
        frame4.add(two, BorderLayout.CENTER);
        JPanel three = new JPanel();
        button9 = new JButton("Confirm Changes");
        button9.addActionListener(actionListener);
        button8 = new JButton("Delete Profile");
        button8.addActionListener(actionListener);
        three.add(button9);
        three.add(button8);
        content.add(three, BorderLayout.AFTER_LAST_LINE);
        userName1.setText(client.firstName);
        username2.setText(client.lastName);
        userPhoneNo.setText(client.phoneNo);
        userEmail.setText(client.email);
        userDateOfBirth.setText(client.dob);
        likes1.setText(client.likes);
        area1.setText(client.aboutMe);
        frame4.setSize(600, 400);
        frame4.setLocationRelativeTo(null);
        frame4.setVisible(true);

    }


    public void friendsGUI() {

        // This method creates a GUI that lists all the friends of the user along with buttons to other features of the application.

        frame5 = new JFrame("List Of Friends");
        Container content = frame5.getContentPane();
        content.setLayout(new BorderLayout());
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2,2);
        JPanel newPanel = new JPanel();
        newPanel.setLayout(layout);
        two = new JComboBox<>();
        
        try {
            
            client.view_account();
            
        } catch (IOException ioException) {
            
            ioException.printStackTrace();
            
        }
        
        String[] tmpFriends = ((client.client_data.split("\\|\\|")[9]).split(":"));
        
        if (tmpFriends.length == 1) {
            
            two.setEditable(true);
            two.setSelectedItem("You have no friends");
            two.setEditable(false);
            
        } else if (tmpFriends.length > 1) {
            
            String[] friends = tmpFriends[1].split(",");
            
            for (String friend : friends) {
                
                two.addItem(friend);
            }
            
            two.setEditable(true);
            two.setSelectedItem("You have " + friends.length + " friends");
            two.setEditable(false);
            
        }
        
        button18 = new JButton("Friend & Friend Request Menu");
        button18.addActionListener(actionListener);
        button22 = new JButton("Friend Requests Sent By You");
        button22.addActionListener(actionListener);
        button23 = new JButton("Friend Requests Sent To You");
        button23.addActionListener(actionListener);
        newPanel.add(two);
        newPanel.add(button18);
        newPanel.add(button22);
        newPanel.add(button23);
        frame5.add(newPanel);
        frame5.setSize(600, 400);
        frame5.setLocationRelativeTo(null);
        frame5.setVisible(true);

    }
    

    public void friendAndFriendRequestsGUI() {

        // This method creates a GUI that showcases the variety of options offered by the aapplication in regards to friend requests.

        frame3 = new JFrame("Friend and Friend Request Menu");
        System.out.println("Im in friendAndFriendRequestsGUI");
        Container content = frame3.getContentPane();
        content.setLayout(new BorderLayout());
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(3,1);
        JPanel newPanel = new JPanel();
        button10 = new JButton("Friends");
        button10.addActionListener(actionListener);
        button11 = new JButton("Friend Requests Sent By You");
        button11.addActionListener(actionListener);
        button12 = new JButton("Friend Requests Sent To You");
        button12.addActionListener(actionListener);
        newPanel.add(button10);
        newPanel.add(button11);
        newPanel.add(button12);
        newPanel.setLayout(layout);
        frame3.add(newPanel, BorderLayout.CENTER);
        JPanel m = new JPanel();
        button13 = new JButton("Main Menu");
        m.add(button13);
        button13.addActionListener(actionListener);
        content.add(m, BorderLayout.SOUTH);
        frame3.setSize(600, 400);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);

    }
    

    public void createAccountGUI() {

        // This method will create a GUI in which the user can enter details to create a new account.

        frame6 = new JFrame("Account Details");
        Container content = frame6.getContentPane();
        content.setLayout(new BorderLayout());
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(8,2);
        JPanel two = new JPanel();
        two.setLayout(layout);
        userName1 = new JTextField(5);
        userFirstName = new JLabel("FIRST NAME");
        username2 = new JTextField(5);
        userLastName = new JLabel("LAST NAME");
        userEmail = new JTextField(5);
        userEmailID = new JLabel("EMAIL ID");
        userPhoneNo = new JTextField(5);
        UserPhoneNumber = new JLabel("PHONE NUMBER");
        userDateOfBirth = new JTextField(5);
        userDateOfBirth1 = new JLabel("DATE OF BIRTH");
        userPassword = new JLabel("");
        userPassword1 = new JLabel("PASSWORD");
        userUsername = new JLabel("");
        userUsername1 = new JLabel("USERNAME");
        two.add(userFirstName);
        two.add(userName1);
        two.add(userLastName);
        two.add(username2);
        two.add(userEmailID);
        two.add(userEmail);
        two.add(UserPhoneNumber);
        two.add(userPhoneNo);
        two.add(userDateOfBirth1);
        two.add(userDateOfBirth);
        two.add(userPassword1);
        two.add(userPassword);
        two.add(userUsername1);
        two.add(userUsername);
        frame6.add(two, BorderLayout.CENTER);
        JPanel three = new JPanel();
        button16 = new JButton("Enter");
        button16.addActionListener(actionListener);
        three.add(button16);
        content.add(three, BorderLayout.SOUTH);
        frame6.setSize(600, 400);
        frame6.setLocationRelativeTo(null);
        frame6.setVisible(true);

    }

    
    public void signInGUI() {

        // This method will create a GUI that will allow the user to enter their password and username. Another method will check to see of the inputs are valid.

        frame7 = new JFrame("Sign In Details");
        Container content = frame7.getContentPane();
        content.setLayout(new BorderLayout());
        frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(4,1);
        JPanel two = new JPanel();
        label1 = new JLabel("USERNAME");
        username = new JTextField(5);
        label2 = new JLabel("PASSWORD");
        password = new JTextField(5);
        two.add(label1);
        two.add(username);
        two.add(label2);
        two.add(password);
        two.setLayout(layout);
        frame7.add(two, BorderLayout.CENTER);
        JPanel three = new JPanel();
        button17 = new JButton("Enter");
        button17.addActionListener(actionListener);
        three.add(button17);
        content.add(three, BorderLayout.SOUTH);
        frame7.setSize(300, 200);
        frame7.setLocationRelativeTo(null);
        frame7.setVisible(true);

    }
    

    public void friendRequestsSendToYouGUI() {

        // This method will create a GUI which will feature the list of new friend requests received with buttons that allow the user
        // to view the person's profile and accept-reject friend request options.

        frame9 = new JFrame("List Of Friend Requests Received");
        Container content = frame9.getContentPane();
        content.setLayout(new BorderLayout());
        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2,2);
        JPanel two = new JPanel();
        two.setLayout(layout);
        one = new JComboBox<>();
        
        try {
            
            client.view_account();
            
        } catch (IOException ioException) {
            
            ioException.printStackTrace();
            
        }
        
        String[] tmpFriendRequests = (client.client_data.split("\\|\\|")[11]).replace(']', '\0').split(":");

        if ((tmpFriendRequests.length == 1) || (tmpFriendRequests[1].charAt(0) == '\0')) {
            
            JOptionPane.showMessageDialog(null, "No friend requests sent to you", "Info", JOptionPane.INFORMATION_MESSAGE);
            frame9.dispose();
            friendAndFriendRequestsGUI();
            return;

        } else {
            
            String[] friends = tmpFriendRequests[1].split(",");
            
            for (String friend : friends) {
                
                one.addItem(friend);
                
            }
            
            one.setEditable(true);
            one.setSelectedItem("You have " + friends.length + " friend requests");
            one.setEditable(false);
            
        }
        
        one.addActionListener(actionListener);
        two.add(one);
        button19 = new JButton("View Profile");
        button19.addActionListener(actionListener);
        button20 = new JButton("Accept");
        button20.addActionListener(actionListener);
        button21 = new JButton("Reject");
        button21.addActionListener(actionListener);
        two.add(button19);
        two.add(button20);
        two.add(button21);
        frame9.add(two,BorderLayout.CENTER);
        frame9.setSize(600, 400);
        frame9.setLocationRelativeTo(null);
        frame9.setVisible(true);

    }


    public void viewUserProfileGUI(String userName) throws Exception {

        // This method will create a GUI that will showcase the profile of user other than yourself.
        
        if (userName == null || userName.isBlank()) {
            
            throw new Exception();
            
        }
        
        client.get_user_info(userName);
        frame10 = new JFrame("Applicant Profile Details");
        Container content = frame10.getContentPane();
        content.setLayout(new BorderLayout());
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(8,2);
        JPanel two = new JPanel();
        String clientData1 = client.client_data.replace('[', '\0').replace(']', '\0');
        String[] clientData = clientData1.split("\\|\\|");
        label3 = new JLabel(clientData[0].split(":")[1]);
        label4 = new JLabel(clientData[1].split(":")[1]);
        label5 = new JLabel(clientData[3].split(":")[1]);
        label6 = new JLabel(clientData[2].split(":")[1]);
        label7 = new JLabel(clientData[4].split(":")[1]);
        
        //label9 = new JLabel(clientData[7].split(":")[1]);

        String[] tmpLikes2 = clientData[7].split(":");
        
        if (tmpLikes2.length > 1) {
            
            label9 = new JLabel(clientData[7].split(":")[1]);
            
        } else {
            
            label9 = new JLabel("No likes");
            
        }

        String[] tmpLikes = clientData[8].split(":");
        
        if (tmpLikes.length > 1) {
            
            label8 = new JLabel(clientData[8].split(":")[1]);
            
        } else {
            
            label8 = new JLabel("Nothing about me");
            
        }
        
        JLabel aboutMe3 = new JLabel("ABOUT ME");
        JLabel likes5 = new JLabel("LIKES");
        userFirstName = new JLabel("FIRST NAME");
        userLastName = new JLabel("LAST NAME");
        userEmailID = new JLabel("EMAIL");
        UserPhoneNumber = new JLabel("PHONE NUMBER");
        userDateOfBirth1 = new JLabel("DATE OF BIRTH");
        two.add(userFirstName);
        two.add(label3);
        two.add(userLastName);
        two.add(label4);
        two.add(userEmailID);
        two.add(label5);
        two.add(UserPhoneNumber);
        two.add(label6);
        two.add(userDateOfBirth1);
        two.add(label7);
        two.add(likes5);
        two.add(label9);
        two.add(aboutMe3);
        two.add(label8);
        two.setLayout(layout);
        frame10.add(two, BorderLayout.CENTER);
        JPanel klm = new JPanel();
        button24 = new JButton("Friend Requests Sent To You");
        button24.addActionListener(actionListener);
        button25 = new JButton("Friend Requests Sent By You");
        button25.addActionListener(actionListener);
        klm.add(button24);
        klm.add(button25);
        content.add(klm, BorderLayout.SOUTH);
        frame10.setSize(600, 400);
        frame10.setLocationRelativeTo(null);
        frame10.setVisible(true);

    }


    public void accept(String userName) throws Exception {

        // This method will add the person whose friend request you accepted to your list of friends and visa versa.
        // It will remove the name from your list of new friend requests.
        // It will remove your name from the list of friend requests send for that peron.
        
        if (userName == null || userName.isBlank()) {
            
            throw new Exception();
            
        }
        
        client.accept_request(userName);
        
    }


    public void sendRequest(String userName) throws Exception {

        // It will send a new friend requests to the user you want to be friends with.
        
        if (userName == null || userName.isBlank()) {
            
            throw new Exception();
            
        }
        
        client.send_request(userName);
        
    }


    public void reject(String userName) throws Exception {

        // It will remove the name from your list of new friend requests.
        // It will remove your name from the list of friend requests send for that peron.
        
        if (userName == null || userName.isBlank()) {
            
            throw new Exception();
            
        }
        
        client.reject_request(userName);

    }


    public void friendRequestsSentByYouGUI() {

        // This method will create a GUI that will feature a list of friend requests you have sent to others.
        // It will also contain a list of application users - choose a user to whom you want to submit a friend request.
        // You can also view the user's profile before sending them a friend request.

        frame11 = new JFrame("List Of Friend Requests Sent");
        Container content = frame11.getContentPane();
        content.setLayout(new BorderLayout());
        frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(2,2);
        JPanel two = new JPanel();
        two.setLayout(layout);
        one = new JComboBox<>();
        three = new JComboBox<>();
        
        try {
            
            client.view_account();
            
        } catch (IOException ioException) {
            
            ioException.printStackTrace();
            
        }
        
        String[] tmpFriends = ((client.client_data.split("\\|\\|")[10]).split(":"));
        
        if (tmpFriends.length == 1) {
            
            one.setEditable(true);
            one.setSelectedItem("You have no friend requests sent by you");
            one.setEditable(false);
            
        } else if (tmpFriends.length > 1) {
            
            String[] friends = tmpFriends[1].split(",");
            
            for (String friend : friends) {
                
                one.addItem(friend);
                //three.addItem(friend);
                
            }
            
            one.setEditable(true);
            one.setSelectedItem("You have " + friends.length + " friend requests sent by you");
            one.setEditable(false);
            
        }
        two.add(one);
        
        // Add all users to combo box3
        
        client.get_all_users();
        
        try {
            
            client.checkForSuccess();
            
        } catch (IOException ioException) {
            
            ioException.printStackTrace();
            
        }

        String[] list_of_users = client.client_data.split(":");
        
        listOfUsers();
        
        if (listOfOtherUsers.size() == 0) {
            
            three.addItem("None");

        } else {

            for (int i = 0; i < listOfOtherUsers.size(); i++) {

                if (!listOfOtherUsers.get(i).equals(client.username)) {
                    
                    three.addItem(listOfOtherUsers.get(i));
                    
                }
            }
        }

        three.addActionListener(actionListener);
        two.add(three);
        button26 = new JButton("View Profile");
        button26.addActionListener(actionListener);
        button27 = new JButton("Friend Menu");
        button27.addActionListener(actionListener);
        button28 = new JButton("Send Request");
        button28.addActionListener(actionListener);
        two.add(button26);
        two.add(button28);
        frame11.add(two,BorderLayout.CENTER);
        content.add(button27, BorderLayout.SOUTH);
        frame11.setSize(600, 400);
        frame11.setLocationRelativeTo(null);
        frame11.setVisible(true);

    }


    public void listOfUsers() {
    
       // This method reads input from a file and stores the username's present in each line in the listOfOtherUsers field.

        try {
            
            File n = new File("src/company/com/Account.txt");
            FileReader fr = new FileReader(n);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            this.listOfOtherUsers = new ArrayList<>();

            while (line != null) {

                String[] a = line.split("\\|\\|");
                String one = a[5].split(":")[1];
                this.listOfOtherUsers.add(one);
                line = br.readLine();
                
            }
            
            br.close();
            
        } catch (Exception e) {
            

            e.printStackTrace();
            
        }
    }

}
