# CS180-PJ05
## PJ05- Handout (will be changed to description of our project later)

Our group chose option 2. Our platform is called SimpleSocial. It allows users to create a profile with information about themselves. With SimpleSocial you can stay connected with others by adding users as friends. You can also update your profile at any time to keep everyone up to date with how you are doing. 

#### Client.java

This class creates a Client object that allows a user to connect to the server. It takes in information to create an account and access the account as well. The class allows for deletion of profiles and friend interactions with other accounts. The Client class writes important information to a text file in order to save it.

<ins>Methods:</ins>
##### public Client(String address, int port) throws IOException

This method is a constructor to put in an IP address and port

##### public String createPassword(String firstname, String lastName, String phoneNumber)

This method will create a unique password for a user who has just created/edited an account.
Password is created from user's initials and last four digits of phone number.
 
##### public String createUsername(String firstname, String email, String dateOfBirth)

This method creates a unique username for a user who justed created/editted their account.
Username is created from first name, month of birth, and email.

##### public boolean checkForSuccess() throws IOException

This method reads output from the Server class and stores it in the client_data field if it contains the word "success".
Success would refer to the idea of successfully signing into an account or successfully finding an account from the file.

##### public void create_account(String firstName, String lastName, String phoneNumber, String email, String dob, String userName, String password, String likes, String  aboutMe, String friends, String sentByMe, String sentToMe) throws IOException, Exception)

This method creates an account for the user. If the parameters are not null nor blank they are paired together in a string whose first letters are "create_account". This string is then sent to the server class. If the parameters are null or blank an exception is thrown.

The correct format of the information to create account includes:

First name: String with no spaces

Last name: String with no spaces

Phone number: (999)999-9999

Email: email@email.email

Date of Birth: 01-01-2001

##### public boolean signIn_account(String userName, String pw) throws Exception

If the parameters are not null nor blank they are paired together in a string whose first letters are "signIn_account".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void view_account() throws IOException

This method views an account by a string saying "view_account" is sent to the server class.
using the checkForSuccess() method the user's account details are read in if the account exists.

##### public void create_profile(String firstName, String lastName, String phoneNumber, String email, String dob, String userName, String password, String likes, String aboutMe) throws Exception

This method sends creates a profile by sending a string to the server. If the parameters are not null nor blank they are paired together in a string whose first letters are "create_profile".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void delete_account(String userName, String pw) throws Exception

This method deletes an account by sending a string to the server class. If the parameters are not null nor blank they are paired together in a string whose first letters are "delete_account".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void get_friend_info(String username) throws Exception 

This method gets a friends information by sending a string to the server. If the parameters are not null nor blank they are paired together in a string whose first letters are "get_friend_info".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void get_user_info(String username) throws Exception

This method gets a users information by sending a string to the server. If the parameters are not null nor blank they are paired together in a string whose first letters are "get_user_info".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void accept_request(String username) throws Exception 

This method accepts a friend request by sending a string to the server. If the parameters are not null nor blank they are paired together in a string whose first letters are "accept_request".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void reject_request(String username) throws Exception

This method rejects a friend request by sending a string to the server. If the parameters are not null nor blank they are paired together in a string whose first letters are "reject_request".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void send_request(String username) throws Exception

This method sends a friend request by sending a string to the server.
If the parameters are not null nor blank they are paired together in a string whose first letters are "send_request".
This string is then sent to the server class.
If the parameters are null or blank an exception is thrown.

##### public void get_all_users()

This method access all of the users accounts by sending a string whose first letters are "get_all_users" is sent to the server class.

<ins>Testing:</ins>

We used the class NewTest.java to test the Client class. It is a JUnit testing class that makes sure Client.java has all the correct fields with the correct type and modifiers. Along with that it makes sure the client class has all the correct methods with the correct return types, exceptions, and modifiers. Lastly, it makes sure the class works with correct input and fails with incorrect input.


#### ClientWithGUI.java

This is a public class that extends JComponent and implements Runnable. This class will create multiple GUIs and their respective buttons with functionality. This class has methods that will allow the user to edit/create/ delete accounts and profiles. The user can send/receive friend requests from other users of the application. All changes made to an account are saved to the Accounts.txt file. In the case the user comes across an error or inputs information in an invalid format, there will be an error message provided. 


<ins>Methods:</ins>

##### public static void main(String[] args) throws IOException

This main method will start to run the GUI class by first running the run() method followed by button functionality

##### public void run()

This method creates a GUI that asks the user wheather they want to create an account or sign in into an existing account.
This method has two buttons - Create Account and Sign In.
The Create Account button will run the createAccountGUI() method by which a first time user can create a new account in the application. 
The Sign In button will run the signInGUI() method by which an existing user of the application can log into their account.

##### public void mainMenuGUI() 

This method will feature a GUI that contains the variety of options the application has to offer.
This method creates three new buttons - Account, Profile and Friend & Friend Requests.
The Account button will create an GUI which contains the user's account details in 
an editable format thus allowing the user to make changes to their account details. 
The Profile button will run the profileGUI() method that will allow the user to make changes to their profile details.
The Account button will run the friendAndFriendRequestsGUI() method allowing the user to access the user's current list of friends, 
and new list of friend requests send and received.

##### public void actionPerformed(ActionEvent e) (overridden method from the ActionListener Class)

This method has an action listener looking for any buttons that were pressed. If depending on the button pressed, GUIs could be closed or opened and account information could be changed. 

##### public void isValid (String firstName, String lastName, String email, String phoneNumber, String dateOfBirth) throws Exception

This method checks to see if the user has entered valid input data while creating/editing of profiles and accounts.

##### public ClientWithGUI() throws IOException

This method will keep track of movement in the JFrame.

##### protected void paintComponent(Graphics g)

This method will reset the canvas for when it is opened once again

##### public void profileGUI() 

This method creates a GUI that allows the user to fill in details to create/edit an account.
The GUI also has a delete button at the bottom if they want to delete their profile.

##### public void listOfUsers()

This method reads input from a file and stores the username's present in each line in the listOfOtherUsers field.

##### public void friendsGUI()

This method creates a GUI that lists all the friends of the user along with buttons to other features of the application.

##### public void friendAndFriendRequestsGUI()

This method creates a GUI that showcases the variety of options offered by the aapplication in regards to friend requests.

##### public void createAccountGUI()

This method will create a GUI in which the user can enter details to create a new account.

##### public void signInGUI()

This method will create a GUI that will allow the user to enter their password and username. Another method will check to see of the inputs are valid.

##### public void friendRequestsSendToYouGUI()

This method will create a GUI which will feature the list of new friend requests received with buttons that allow the user
to view the person's profile and accept-reject friend request options.

##### public void viewUserProfileGUI(String userName) throws IOException

This method will create a GUI that will showcase the profile of user other than yourself.

##### public void accept(String userName)

This method will add the person whose friend request you accepted to your list of friends and visa versa.
It will remove the name from your list of new friend requests.
It will remove your name from the list of friend requests send for that peron.

##### public void sendRequest(String userName)

This method will send a new friend requests to the user you want to be friends with.

##### public void reject(String userName)

This method will remove the name from your list of new friend requests.
It will remove your name from the list of friend requests send for that peron.

##### public void friendRequestsSentByYouGUI()

This method will create a GUI that will feature a list of friend requests you have sent to others.
It will also contain a list of application users - choose a user to whom you want to submit a friend request.
You can also view the user's profile before sending them a friend request.
 
 
<ins>Testing:</ins>

We used the class ClientWithGUITest.java to test the ClientWithGUI class. It is a JUnit testing class that makes sure ClientWithGUI.java has all the correct fields with the correct type and modifiers. Along with that it makes sure the ClientWithGUI class has all the correct methods with the correct return types, exceptions, and modifiers. Lastly, it makes sure the class works with correct input and fails with incorrect input. Since we could not test all of the GUI methods with JUnit we manually test those methods. We would run the Server class and ClientWithGUI class to make sure the code ran correctly and any error messages popped up when needed.


#### Server.java
 
This is a public class that implements Runnable. This class creates a server that once started, stays running. It allows multiple clients to connect so they can use SimpleSocial. The server provides information about the user’s account.

<ins>Methods:</ins>

##### public Server(Socket csocket)

This method is a constructor that takes in a port. The server starts and waits for a connection.

##### public static void main(String[] args) throws Exception

This method accepts new clients and creates a new thread to run them.

##### public void run()

This method takes input from the client socket and reads message from client until "Over" is sent

##### public boolean create_account(String totalString) throws Exception

This method creates a new account using the input sent from the Client class.
It then writes the account to the Account.txt file.

##### public void signIn_account(String fullString) throws Exception

This method uses the data sent from the Client and compares it with the file data to see if there is a match.
If a match is found it sends "success" to the client or else it sends "Fail".

##### public void view_account() throws IOException

This method tries to find a specific account in the file.
If the account is found it is sent to the client.
An account is always found as the user can access this method only if the user creates/signs into an account.

##### public void get_friend_info() throws IOException

This method tries to find a specific account in the file.
If the account is found it is sent to the client.
An account is always found as the user's friends are existing account users of this application.

##### public void get_user_info(String userName) throws Exception

This method tries to find a specific account in the file.
If the account is found it is sent to the client.
An account is always found as the username is of an existing account in the application.

##### public void get_all_users(String userName) throws Exception

This method gets all the users of the application and stores them in an ArrayList for use in other methods.

##### public void delete_account(String fullString1) throws Exception

This method deletes an account by looking for the account in the file. It deletes every instance of the user from the file using the replaceLine2 method.

##### public boolean create_profile(String totalString) throws Exception

This method creates an account using input from the client.

##### public boolean accept_request(String userName) throws Exception 

This method adds the user who said the friend request and the current user to each others friend list.
This method will delete the request from both accounts (with additional help of the replaceLine1 method).

##### public boolean reject_request(String userName) throws Exception

This method removes a friend request from the sender and receiver.

##### public boolean send_request(String userName) throws Exception

This method alls the user to send a request to another user - friend request gets added to one's send list and to the others receive list

##### public void replaceLine1(String name) throws Exception

This method removes the name of the another user from the current user's list of sentByMe field when the accept/request buttons are pressed.

##### public void replaceLine2(String name) throws Exception

This method removes every instance of a user's name in the Account.txt file when they delete their account/profile.

<ins>Testing:</ins>

We used the class NewTest2.java to test the Server class. It is a JUnit testing class that makes sure Server.java has all the correct fields with the correct type and modifiers. Along with that it makes sure the server class has all the correct methods with the correct return types, exceptions, and modifiers. Lastly, it makes sure the class works with correct input and fails with incorrect input.


