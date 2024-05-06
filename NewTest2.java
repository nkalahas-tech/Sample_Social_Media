package company.com;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.Assert.fail;


public class NewTest2 {
    
    // This class is public so it can be used by anyone.
    // Whenever you run this class you must run the Server before it and wait a 12-15 seconds.
    // Account.txt file values to be used - First Name:John||Last Name:Doe||Phone No.:(897)987-0987||Email:jdoe@gmail.com||Date Of Birth:29-11-2009||
    // Username:John11gmail||Password:DJ0987||Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:Avi11gmail
    // First Name:Avi||Last Name:Katare||Phone No.:(999)999-9999||Email:a@gmail||Date Of Birth:11-11-1111||Username:Avi11gmail||Password:KA9909||
    // Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:
    // General note - all valid cases are in the same format as the valid cases of the Client class as not doing so will prevent me running the code as it has to
    // send/receive output to/from the client after everytime. For the invalid cases I will be creating server object and run the methods directly as they will be caught in
    // the first two lines of code.

    
    public static void main(String[] args) {

        // If all tests pass then output "Excellent-Test ran successfully".
        
        Result result = JUnitCore.runClasses(TestCase.class);
        
        if (result.wasSuccessful()) {
            
            System.out.println("Excellent - Test ran successfully");
            
        } else {
            
            for (Failure failure : result.getFailures()) {
                
                System.out.println(failure.toString());
                
            }
        }
    }
    

    /**
 * Project05 - Option2 - NewTest
 *
 * The program will create run test cases on the Client.java.
 *
 * No external resources used
 *
 * @author Avi Katare  LC12
 * @version 5 December, 2020
 *
 */

    public static class TestCase {
        
       private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {

            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));

        }

        @After
        public void restoreInputAndOutput() {

            System.setIn(originalSysin);
            System.setOut(originalOutput);

        }

        private String getOutput() {

            return testOut.toString();

        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {

            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);

        }

        @Test(timeout = 1_000)
        public void serverClassDeclarationTest() {
            
            // Makes sure the class name is "Server".
            // Makes sure no interhance class (thus inherits from Ogject Class)
            // Makes sure the class is public.
            // No interface used.
            // If any condition is not meet then print out the error.
                
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;
            clazz = Server.class;
            className = "Server";
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();
            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `" + className + "` extends `Object`!", Object.class, superclass);
            Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 1, superinterfaces.length);
            
        }


        @Test(timeout = 1_000)
        public void socket1DeclarationTest() {

            // Make sure that the Server class has a socket field that is private, non-static and type Socket.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "socket";
            Class<?> expectedType = Socket.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");
                
                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void serverDeclarationTest() {         
            
            // Make sure that the Server class has a server field that is private, non-static and type ServerSocket.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "server";
            Class<?> expectedType = ServerSocket.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
            
        }
        

        @Test(timeout = 1_000)
        public void in1DeclarationTest() {
            
            // Make sure that the Server class has a in field that is private, non-static and type DataInputStream.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "in";
            Class<?> expectedType = DataInputStream.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
            
        }

        @Test(timeout = 1_000)
        public void out1DeclarationTest() {
                          
            // Make sure that the Server class has a out field that is private, non-static and type DataOutputStream.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "out";
            Class<?> expectedType = DataOutputStream.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
            
        }

        
        @Test(timeout = 1_000)
        public void pathDeclarationTest() {
                     
            // Make sure that the Server class has a path field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "path";
            Class<?> expectedType = String.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
            
        }
        

        @Test(timeout = 1_000)
        public void tmppathDeclarationTest() {
            
            // Make sure that the Server class has a temppath field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "tmppath";
            Class<?> expectedType = String.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void username1DeclarationTest() {
            
            // Make sure that the Server class has a userName field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "userName";
            Class<?> expectedType = String.class;
            clazz = Server.class;

            try {
                
                testField = clazz.getDeclaredField(fieldName);
                
            } catch (NoSuchFieldException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
                
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
            
        }
        

        @Test(timeout = 1_000)
        public void serverParameterizedConstructorDeclarationTest() {
            
             // Make sure that the Server class has a constructor with one parameter - socket
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;
            clazz = Server.class;

            try {
                
                constructor = clazz.getDeclaredConstructor(Socket.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has one parameter with types socket!");

                return;
                
            } 

            modifiers = constructor.getModifiers();
            exceptions = constructor.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has no `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3_000)
        public void ConstructorTest() {
            
            // Make sure that the Server class has constructor gives no error when the input values are valid and throws an error if they are invalid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                one = "success";
                Socket s = new Socket("127.0.0.1", 5000);
                Server s1 = new Server(s);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {

                    System.out.println("Error");
                    
                }
            }

        }


        @Test(timeout = 1000)
        public void runMethodTest() {
            
             // Make sure that the Client class has a run method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.
            
            Class<?> clazz;
            String className = "Sever";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "run";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 0 parameters !");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has no `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 1000)
        public void createAccount1MethodTest() {
            
            // Make sure that the Server class has a createAccount - type boolean, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "create_account";
            Class<?> expectedReturnType = boolean.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");
                
                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void createAccount1Test() {
            
            
            // Make sure that create_account method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {

                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.create_account("Ben", "Katarej", "(999)999-9999", "a@gmail", "11-11-1111",
                        "Ben11gmail", "KA999809", "", "", "", "", "");
                one = "success";
                server.create_account(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {

                    System.out.println(e.getMessage());
                    return;
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void signInAccount1MethodTest() {
            
             // Make sure that the Client class has a signIn_account - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "signIn_account";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void signInAccount1Test() {
            
             // Make sure that signIn_account method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                one = "success";
                server.signIn_account(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println(e.getMessage());
                    return;
                    
                }

            }

        }

        @Test(timeout = 1000)
        public void viewAccount1MethodTest() {
            
            // Make sure that the Server class has a view_account - type void, 0 parameters, public.
            // If any of these features do not meet then print out the error.
            // No method to test valid/invalid inputs as the functionality is based on data from other programs and will always in the correct format.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "view_account";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 0 parameters!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void createProfile1MethodTest() {
            
            // Make sure that the Server class has a create_profile - type boolean, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "create_profile";
            Class<?> expectedReturnType = boolean.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void createProfile1Test() {

            // Make sure that create_profile method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.create_profile("Avi", "Katarei", "(999)999-9999", "a@gmail", "11-11-1111",
                        "Avi11gmail", "KA9909", "cricket", "I love cricket.");
                one = "success";
                server.create_profile(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println(e.getMessage());
                    return;
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void friendInfo1MethodTest() {
            
            // Make sure that the Server class has a get_friend_info - type void, 0 parameters, public.
            // If any of these features do not meet then print out the error.
            // No method to test valid/invalid inputs as the functionality is based on data from other programs and will always in the correct format.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "get_friend_info";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;
            
            try {
                
                method = clazz.getDeclaredMethod(methodName);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 0 parameters!");

                return;
                
            }

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }

        
        @Test(timeout = 1000)
        public void userInfo1MethodTest() {
            
            // Make sure that the Server class has a user_info - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "get_user_info";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }

        
        @Test(timeout = 3000)
        public void userInfo1Test() {
            
               // Make sure that user_info method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.get_user_info("Avi11gmail");
                one = "success";
                server.get_user_info(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void acceptRequest1MethodTest() {
            
             // Make sure that the Server class has a accept_request - type boolean, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "accept_request";
            Class<?> expectedReturnType = boolean.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 7000)
        public void accept1Test() {
            
            // Make sure that accept_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.send_request("Avi11gmail");
                a.signIn_account("Avi11gmail", "KA9909");
                a.accept_request("John11gmail");
                one = "success";
                server.accept_request(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void rejectRequest1MethodTest() {
            
             // Make sure that the Server class has a reject_request - type boolean, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "reject_request";
            Class<?> expectedReturnType = boolean.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 9000)
        public void reject1Test() {
            
            // Make sure that reject_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.send_request("Avi11gmail");
                a.signIn_account("Avi11gmail", "KA9909");
                a.reject_request("John11gmail");
                one = "success";
                server.reject_request(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println(e.getMessage());
                    return;
                }

            }

        }


        @Test(timeout = 1000)
        public void sendRequest1MethodTest() {
            
            // Make sure that the Server class has a send_request - type boolean, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "send_request";
            Class<?> expectedReturnType = boolean.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            }

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void sendRequest1Test() {
            
              // Make sure that send_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.send_request("John11gmail");
                one = "success";
                server.send_request(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    return;
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void allUsers1MethodTest() {
            
            // Make sure that the Server class has a get_all_users - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "get_all_users";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type String!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void deleteAccount1MethodTest() {
            
            // Make sure that the Server class has a delete_account - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "delete_account";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }

        
        @Test(timeout = 3000)
        public void deleteAccount1Test() {
            
            // Make sure that send_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.delete_account("Avi11gmail", "KA9909");
                one = "success";
                server.delete_account(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    return;

                }

            }

        }

        @Test(timeout = 1000)
        public void replaceLine1MethodTest() {
            
            // Make sure that the Server class has a replaceLine1 - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "replaceLine1";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");
                
                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void replaceLine1Test() {

            // Make sure that replaceLine1 method throws an error if the input values are invalid and no error if valid.
            
            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                server.replaceLine1("Avi11gmail");
                one = "success";
                server.replaceLine1(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    return;

                }

            }
            
        }
        

        @Test(timeout = 1000)
        public void replaceLine2MethodTest() {
            
            // Make sure that the Server class has a replaceLine2 - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "replaceLine2";
            Class<?> expectedReturnType = void.class;
            clazz = Server.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }

        
        @Test(timeout = 3000)
        public void replaceLine2Test() {
            
            // Make sure that replaceLine2 method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                server.replaceLine2("John11gmail");
                one = "success";
                server.replaceLine2(null);
                System.out.println("Failure");
                return;

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    return;

                }

            }
            
        }

        
        @Test(timeout = 3000)
        public void allUsers1Test() { 
            
            // Make sure that get_all_users method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Socket socket = new Socket("127.0.0.1", 5001);
                Server server = new Server(socket);
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.get_all_users();
                one = "success";
                server.get_all_users(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println(e.getMessage());
                    
                }

            }

        }
        
    }

}
