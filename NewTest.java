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


public class NewTest {
    
    // This class is public so it can be used by anyone.
   // Whenever you run this class you must run the Server before it and wait a 12-15 seconds.
    // Account.txt file values to be used - First Name:John||Last Name:Doe||Phone No.:(897)987-0987||Email:jdoe@gmail.com||Date Of Birth:29-11-2009||
    // Username:John11gmail||Password:DJ0987||Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:Avi11gmail
    // First Name:Avi||Last Name:Katare||Phone No.:(999)999-9999||Email:a@gmail||Date Of Birth:11-11-1111||Username:Avi11gmail||Password:KA9909||
    // Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:


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
        public void clientClassDeclarationTest() {
            
            // Makes sure the class name is "Client".
            // Makes sure no interhance class (thus inherits from Ogject Class)
            // Makes sure the class is public.
            // No interface used.
            // If any condition is not meet then print out the error.
            
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;
            clazz = Client.class;
            className = "Client";
            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();
            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `" + className + "` extends `Object`!", Object.class, superclass);
            Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 0, superinterfaces.length);
            
        }


        @Test(timeout = 1_000)
        public void firstNameDeclarationTest() {
            
            // Make sure that the Client class has a firstName field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "firstName";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void lastNameDeclarationTest() {
            
            // Make sure that the Client class has a lastName field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "lastName";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void emailDeclarationTest() {
            
            // Make sure that the Client class has an email field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "email";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void phoneNumberDeclarationTest() {
            
            // Make sure that the Client class has a phoneNo field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "phoneNo";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void dateOfBirthDeclarationTest() {
            
            // Make sure that the Client class has a dob field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "dob";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void passwordDeclarationTest() {
            
            // Make sure that the Client class has a password field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "password";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void usernameDeclarationTest() {
            
            // Make sure that the Client class has a username field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "username";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void clientDataDeclarationTest() {
            
            // Make sure that the Client class has a client_data field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "client_data";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void likesDeclarationTest() {
            
            // Make sure that the Client class has a likes field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "likes";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void sentByMeDeclarationTest() {
            
            // Make sure that the Client class has a sentByMe field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "sentByMe";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void sentToMeDeclarationTest() {
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "sentToMe";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void aboutMeDeclarationTest() {
            
            // Make sure that the Client class has a aboutMe field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "aboutMe";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void socketDeclarationTest() {
            
            // Make sure that the Client class has a socket field that is private, non-static and type Socket.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "socket";
            Class<?> expectedType = Socket.class;
            clazz = Client.class;

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
        public void inputDeclarationTest() {
            
            // Make sure that the Client class has a input field that is private, non-static and type DataInputStream.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "input";
            Class<?> expectedType = DataInputStream.class;
            clazz = Client.class;

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
        public void friendsDeclarationTest() {
            
            // Make sure that the Client class has a friends field that is public, non-static and type String.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "friends";
            Class<?> expectedType = String.class;
            clazz = Client.class;

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
        public void inDeclarationTest() {
            
            // Make sure that the Client class has a in field that is private, non-static and type DataInputStream.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "in";
            Class<?> expectedType = DataInputStream.class;
            clazz = Client.class;

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
        public void outDeclarationTest() {
            
            // Make sure that the Client class has a out field that is private, non-static and type DataOutputStream.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "out";
            Class<?> expectedType = DataOutputStream.class;
            clazz = Client.class;

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
        public void clientParameterizedConstructorDeclarationTest() {
            
            // Make sure that the Client class has a constructor with two parameters - int and String
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;
            clazz = Client.class;

            try {
                
                constructor = clazz.getDeclaredConstructor(String.class, int.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has two parameters with types int and String!");

                return;
                
            } 

            modifiers = constructor.getModifiers();
            exceptions = constructor.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has only one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 6_000)
        public void testConstructor() {
            
            // Make sure that the Client class has constructor gives no error when the input values are valid and throws an error if they are invalid.

            try {
                
                Client a = new Client("", 1);
                System.out.println("Error");
                
            } catch (Exception e) {

            }

            try {
                
                Client c = new Client("127.0.0.1", 5001);

            } catch (Exception e) {
                
                System.out.println(e.getMessage());

            }
            
        }
        

        @Test(timeout = 1000)
        public void createPasswordMethodTest() {
            
            // Make sure that the Client class has a createPassword method - String type,  3 String parameters, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "createPassword";
            Class<?> expectedReturnType = String.class;
            clazz = Client.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 3 parameters of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3000)
        public void createPasswordTest() {
            
            // Make sure that createPassword method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.createPassword("Avi", "Katare", "(999)999-9999");
                one = "success";
                a.createPassword(null, null, null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void createUsernameMethodTest() {
            
            // Make sure that the Client class has a createUsername - type String, 3 parameters String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "createUsername";
            Class<?> expectedReturnType = String.class;
            clazz = Client.class;
            
            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 3 parameters of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!",
                    expectedLength, exceptions.length);

        }

        @Test(timeout = 3000)
        public void createUsernameTest() {
            
            // Make sure that createUsername method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.createUsername("Avi", "a@gmail.com", "15-11-2001");
                one = "success";
                a.createUsername(null, null, null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void checkForSuccessMethodTest() {
            
            // Make sure that the Client class has a checkForSuccess - type boolean, 0 parameters, public.
            // If any of these features do not meet then print out the error.
            // No method to test valid/invalid inputs as the functionality is based on data from other programs and will always in the correct format.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "checkForSuccess";
            Class<?> expectedReturnType = boolean.class;
            clazz = Client.class;

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
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has one `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 1000)
        public void createAccountMethodTest() {
            
            // Make sure that the Client class has a createAccount - type void, 12 parameters String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 2;
            Class<?>[] exceptions;
            String methodName = "create_account";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class, String.class, String.class,
                        String.class, String.class, String.class, String.class, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 12 parameters of type string!");

                return;
                
            } 

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has two `throws` clause!",
                    expectedLength, exceptions.length);

        }
        

        @Test(timeout = 3_000)
        public void createAccountTest() { 
            
            // Make sure that create_account method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.create_account("Ben", "Katarej", "(999)999-9999", "a@gmail", "11-11-1111",
                        "Ben11gmail", "KA999809", "", "", "", "", "");
                one = "success";
                a.create_account(null, null, null, null, null, null, null, null,
                        null, null, null, null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void signInAccountMethodTest() {
            
             // Make sure that the Client class has a signIn_account - type boolean, 2 parameters String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "signIn_account";
            Class<?> expectedReturnType = boolean.class;
            clazz = Client.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters of type string!");

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
        public void signInAccountTest() {
            
            // Make sure that signIn_account method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                one = "success";
                a.signIn_account(null, null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }

        
        @Test(timeout = 1000)
        public void viewAccountMethodTest() {
            
            // Make sure that the Client class has a view_account - type void, 0 parameters, public.
            // If any of these features do not meet then print out the error.
            // No method to test valid/invalid inputs as the functionality is based on data from other programs and will always in the correct format.
            
            Class<?> clazz;
            String className = "Client";
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
        public void createProfileMethodTest() {
            
            // Make sure that the Client class has a create_profile - type void, 9 parameters String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "create_profile";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class, String.class, String.class,
                        String.class, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 9 parameters of type string!");

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
        

        @Test(timeout = 6000)
        public void createProfileTest() {

            // Make sure that create_profile method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.create_profile("Avi", "Katarei", "(999)999-9999", "a@gmail", "11-11-1111",
                        "Avi11gmail", "KA9909", "cricket", "I love cricket.");
                one = "success";
                a.create_profile(null, null, null, null, null, null, null, null,
                        null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println(e.getMessage());
                    
                }
                
            }

        }

        
        @Test(timeout = 1000)
        public void friendInfoMethodTest() {
            
            // Make sure that the Client class has a get_friend_info - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "get_friend_info";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

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
        public void friendInfoTest() {
            
            // Make sure that get_friend_info method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.get_friend_info("Avi11gmail");
                one = "success";
                a.get_friend_info(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("fail");
                    
                }

            }

        }

            
        @Test(timeout = 1000)
        public void userInfoMethodTest() {
            
            // Make sure that the Client class has a get_user_info - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "get_user_info";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

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
            

        @Test(timeout = 6000)
        public void userInfoTest() {
            
            // Make sure that get_user_info method throws an error if the input values are invalid and no error if valid.
     
            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.get_user_info("Avi11gmail");
                one = "success";
                a.get_user_info(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("filure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void acceptRequestMethodTest() {
            
            // Make sure that the Client class has a accept_request - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "accept_request";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

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
        public void acceptTest() {
            
            // Make sure that accept_request method throws an error if the input values are invalid and no error if valid.
            
            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.send_request("Avi11gmail");
                a.signIn_account("Avi11gmail", "KA9909");
                a.accept_request("John11gmail");
                one = "success";
                a.accept_request(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void rejectRequestMethodTest() {
            
            // Make sure that the Client class has a reject_request - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "reject_request";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

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
        public void rejectTest() {
            
            // Make sure that reject_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("John11gmail", "DJ0987");
                a.send_request("Avi11gmail");
                a.signIn_account("Avi11gmail", "KA9909");
                a.reject_request("John11gmail");
                one = "success";
                a.reject_request(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void sendRequestMethodTest() {
            
            // Make sure that the Client class has a send_request - type void, 1 parameter String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "send_request";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;

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
        public void sendRequestTest() {
            
            // Make sure that send_request method throws an error if the input values are invalid and no error if valid.

             String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.send_request("John11gmail");
                one = "success";
                a.send_request(null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


        @Test(timeout = 1000)
        public void allUsersMethodTest() {
            
            // Make sure that the Client class has a get_all_users - type void, 0 parameters, public.
            // If any of these features do not meet then print out the error.
            // No test cases as it functionality is handled internally and all valuew used are always in the correct form.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "get_all_users";
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
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has no `throws` clause!",
                    expectedLength, exceptions.length);

        }
            

        @Test(timeout = 1000)
        public void deleteAccountMethodTest() {
            
            // Make sure that the Client class has a delete_account - type void, 2 parameters String, public.
            // If any of these features do not meet then print out the error.
            
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "delete_account";
            Class<?> expectedReturnType = void.class;
            clazz = Client.class;
            
            try {
                
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
                
            } catch (NoSuchMethodException e) {
                
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters of type string!");

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
        public void deleteAccountTest() {
            
            // Make sure that send_request method throws an error if the input values are invalid and no error if valid.

            String one = "";
            
            try {
                
                Client a = new Client("127.0.0.1", 5001);
                a.signIn_account("Avi11gmail", "KA9909");
                a.delete_account("Avi11gmail", "KA9909");
                one = "success";
                a.delete_account(null, null);
                System.out.println("Failure");

            } catch (Exception e) {

                if (one.equals("")) {
                    
                    System.out.println("Failure");
                    
                }

            }

        }


    }

}
