package company.com;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import junit.framework.TestCase;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static org.junit.Assert.fail;


/**
 * Project05 - Option2 - ClientWithGUITest
 *
 * The program will create run test cases on the ClientWithGUI.java.
 *
 * No external resources used
 *
 * @author Allison Kramp
 * @version 6 December, 2020
 *
 */


class ClientWithGUITest {
	
	// Make sure to Run the Server class before running this class.
	//The default settings in Account.txt file should be - 
	// First Name:John||Last Name:Doe||Phone No.:(897)987-0987||Email:jdoe@gmail.com||Date Of Birth:29-11-2009||Username:John11gmail||
	// Password:DJ0987||Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:
        // First Name:Avi||Last Name:Katare||Phone No.:(999)999-9999||Email:a@gmail||Date Of Birth:11-11-1111||Username:Avi11gmail||
	// Password:KA9909||Likes:||AboutMe:||Friends:||SentByMe:||SentToMe:

	
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
        public void clientWithGUIClassDeclarationTest() {
		
	    // Makes sure the class name is "ClientWithGUI".
            // Makes sure no interhance class (thus inherits from Object Class)
            // Makes sure the class is public.
            // No interface used.
            // If any condition is not meet then print out the error.
		
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;
            clazz = ClientWithGUI.class;
            className = "ClientWithGUI";
	    modifiers = clazz.getModifiers();
	    superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();
            Assert.assertTrue("Ensure that `"+ className +"` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends `JComponet`!", JComponent.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements 1 interface!", 1, superinterfaces.length);
		
        }

	    
        @Test(timeout = 1_000)
        public void clientFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a client field that is private, non-static and type Client.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "client";
            Class<?> expectedType = Client.class;
            clazz = ClientWithGUI.class;
		
            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void listOfOtherUsersFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a listOfOtherUsers field that is public, non-static and type ArrayList.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "listOfOtherUsers";
            Class<?> expectedType = ArrayList.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void numberFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a number field that is public, non-static and type int.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "number";
            Class<?> expectedType = int.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void curXFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a curX field that is type int.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "curX";
            Class<?> expectedType = int.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void curYFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a curY field that is type int.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "curY";
            Class<?> expectedType = int.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }


        @Test(timeout = 1_000)
        public void oldXFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has an oldX field that is type int.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "oldX";
            Class<?> expectedType = int.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }


        @Test(timeout = 1_000)
        public void oldYFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has an oldY field that is type int.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            int modifiers;
            Class<?> type;
            String fieldName = "oldY";
            Class<?> expectedType = int.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            modifiers = testField.getModifiers();
            type = testField.getType();
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }


        @Test(timeout = 1_000)
        public void imageFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a image field that is type Image.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "image";
            Class<?> expectedType = Image.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void graphics2DFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a graphics2D field that is type Graphics2D.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;

            Class<?> type;
            String fieldName = "graphics2D";
            Class<?> expectedType = Graphics2D.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }


        @Test(timeout = 1_000)
        public void oneFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a one field that is type JComboBox.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "one";
            Class<?> expectedType = JComboBox.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void twoFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a two field that is type JComboBox.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "two";
            Class<?> expectedType = JComboBox.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void threeFieldDeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a three field that is type JComboBox.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "three";
            Class<?> expectedType = JComboBox.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame1DeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a frame1 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame1";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame2DeclarationTest() {	
		
	    // Make sure that the ClientWithGUI class has a frame2 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame2";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;
           
            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }


        @Test(timeout = 1_000)
        public void frame3DeclarationTest() {	
		
	    // Make sure that the ClientWithGUI class has a frame3 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame3";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame4DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame4 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame4";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame5DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame5 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame5";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame6DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame6 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame6";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame7DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame7 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame7";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");
		   
                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame8DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame8 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame8";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void frame9DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame9 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame9";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void frame10DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame10 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame10";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void frame11DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a frame11 field that is type JFrame.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "frame11";
            Class<?> expectedType = JFrame.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button1 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button1";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button2DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button2 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button2";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button3DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button3 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button3";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button4DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button4 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button4";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button5DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button5 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button5";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button8DeclarationTest() {
		
	    // Make sure that the ClientWithGUI class has a button8 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button8";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button9DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button9 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button9";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button10DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button10 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button10";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button11DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button11 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button11";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button12DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button12 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button12";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button13DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button13 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button13";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button14DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button14 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button14";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button15DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button15 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button15";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button16DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button16 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button16";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button17DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button17 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button17";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button18DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button18 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button18";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button19DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button19 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button19";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button20DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button20 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button20";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button21DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button21 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button21";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void button22DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button22 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button22";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button23DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button23 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button23";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button24DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button24 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button24";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button25DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button25 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button25";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button26DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button26 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button26";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button27DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button27 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button27";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void button28DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a button28 field that is type JButton.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "button28";
            Class<?> expectedType = JButton.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void userName1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userName1 field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userName1";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void username2DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userName2 field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "username2";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userEmailDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userEmail field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userEmail";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userPhoneNoDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userPhoneNo field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userPhoneNo";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userDateOfBirthDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userDateOfBirth field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userDateOfBirth";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void likes1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a likes1 field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "likes1";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void usernameDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userName field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "username";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void passwordDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a password field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "password";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void area1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a area1 field that is type JTextField.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "area1";
            Class<?> expectedType = JTextField.class;
            clazz = ClientWithGUI.class;
		
            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void userPasswordDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userPassword field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userPassword";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void userUsernameDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userUsername field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userUsername";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void userFirstNameDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userFirstName field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userFirstName";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userLastNameDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userLastName field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userLastName";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void userEmailIDDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userEmailID field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userEmailID";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void UserPhoneNumberDeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a UserPhoneNumber field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "UserPhoneNumber";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userPassword1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userPassword1 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userPassword1";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void userUsername1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a userUsername1 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "userUsername1";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void aboutMe1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a aboutMe1 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "aboutMe1";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void likes2DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a likes2 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "likes2";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void label1DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label1 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label1";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void label2DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label2 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label2";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void label3DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label3 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label3";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void label4DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label4 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label4";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void label5DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label5 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label5";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void label6DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label6 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label6";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void label7DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label7 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label7";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }
	    

        @Test(timeout = 1_000)
        public void label8DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label8 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label8";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            }

            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
		
        }

	    
        @Test(timeout = 1_000)
        public void label9DeclarationTest() {
			
	    // Make sure that the ClientWithGUI class has a label9 field that is type JLabel.
            // If any of these features do not meet then print out the error.
		
            Class<?> clazz;
            String className = "ClientWithGUI";
            Field testField;
            Class<?> type;
            String fieldName = "label9";
            Class<?> expectedType = JLabel.class;
            clazz = ClientWithGUI.class;

            try {
		    
                testField = clazz.getDeclaredField(fieldName);
		    
            } catch (NoSuchFieldException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
		    
            } 
		
            type = testField.getType();
            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
	
        }

	    
        @Test(timeout = 1_000)
        public void clientWithGUIParameterizedConstructorDeclarationTest() {

            // This makes sure that the ClientWithGUI class has a constructor that is public and has no parameters.
            
            Class<?> clazz;
            String className = "ClientWithGUI";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;
            clazz = ClientWithGUI.class;

            try {
		    
                constructor = clazz.getDeclaredConstructor();
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has 0 parameters!");

                return;
		    
            } 

            modifiers = constructor.getModifiers();
            exceptions = constructor.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has only one `throws` clause!",
                    expectedLength, exceptions.length);

        }
	    

        @Test(timeout = 1000)
        public void runMethodTest() {

            // Make sure that the ClientWithGUI class has a run method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "run";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void mainMenuGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a mainMenuGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "mainMenuGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void actionListenerMethodTest() {

            // Make sure that the ClientWithGUI class has a actionListener method - void type,  1 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "actionPerformed";
            Class<?> expectedReturnType = void.class;
            clazz = ActionListener.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, ActionEvent.class);
		    
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
        public void paintComponentMethodTest() {

            // Make sure that the ClientWithGUI class has a paintComponent method - void type,  1 parameters, protected.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "paintComponent";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, Graphics.class);
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter !");

                return;
		    
            }

            modifiers = method.getModifiers();
            actualReturnType = method.getReturnType();
            exceptions = method.getExceptionTypes();
            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `protected`!", Modifier.isProtected(modifiers));
            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!",
                    expectedReturnType, actualReturnType);
            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has no `throws` clause!",
                    expectedLength, exceptions.length);

        }
	    

        @Test(timeout = 1000)
        public void profileGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a profileGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "profileGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void friendsGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a friendsGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "friendsGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void friendAndFriendRequestsGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a friendAndFriendRequestsGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "friendAndFriendRequestsGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void createAccountGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a createAccountGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "createAccountGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void signInGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a signInGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "signInGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void friendRequestsSendToYouGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a friendRequestsSendToYouGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "friendRequestsSendToYouGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void viewUserProfileGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a viewUserProfileGUI method - void type,  1 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid cases as the functionality is done internally.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "viewUserProfileGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, String.class);
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter !");

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
        public void friendRequestsSentByYouGUIMethodTest() {

            // Make sure that the ClientWithGUI class has a friendRequestsSentByYouGUI method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "friendRequestsSentByYouGUI";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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
        public void isValidMethodTest() {

            // Make sure that the ClientWithGUI class has a isValid method - void type,  5 parameters, public.
            // If any of these features do not meet then print out the error.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "isValid";

            Class<?> expectedReturnType = void.class;

            clazz = ClientWithGUI.class;

            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 5 parameters of type String!");

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
        public void acceptMethodTest() {

            // Make sure that the ClientWithGUI class has an accept method - void type,  1 parameter, public.
            // If any of these features do not meet then print out the error.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "accept";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, String.class);
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameters of type String!");

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
        public void sendRequestMethodTest() {

            // Make sure that the ClientWithGUI class has a sendRequest method - void type,  1 parameter, public.
            // If any of these features do not meet then print out the error.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "sendRequest";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, String.class);
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameters of type String!");

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
        public void rejectMethodTest() {

            // Make sure that the Client class has a run method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;
            String methodName = "reject";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

            try {
		    
                method = clazz.getDeclaredMethod(methodName, String.class);
		    
            } catch (NoSuchMethodException e) {
		    
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameters of type String!");

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
        public void listOfUsersMethodTest() {

            // Make sure that the ClientWithGUI class has a listOfUsers method - void type,  0 parameters, public.
            // If any of these features do not meet then print out the error.
            // There is no test for valid/invalid cases as the functionality is done internally and the inputs used are always in the correct format.

            Class<?> clazz;
            String className = "ClientWithGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;
            String methodName = "listOfUsers";
            Class<?> expectedReturnType = void.class;
            clazz = ClientWithGUI.class;

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

	    
        @Test(timeout = 3000)
        public void isValidTest() {

            // Make sure that isValid method throws an error if the input values are invalid and no error if valid.

            String result = "";
		
            try {

                ClientWithGUI cwg = new ClientWithGUI();
                cwg.isValid("Allison", "Kramp", "a@gmail.com", "(630)340-8787", "31-12-2001");
                result = "success";
                cwg.isValid("0", "0", "0", "0", "0");
                System.out.println("Failure: Invalid Format");
                cwg.isValid(null, null, null, null, null);
                System.out.print("Failure: Didn't throw exception");

            } catch (Exception e) {

                if (result.equals("")) {
			
                    System.out.println("Failure with Correct Input");
			
                }

            }

        }

	    
        @Test(timeout = 3000)
        public void acceptTest() {

            // Make sure that accept method throws an error if the input values are invalid.
            // If the input is valid then it runs a client method - tested in NewTest.java

            String result = "";
		
            try {

                ClientWithGUI cwg = new ClientWithGUI();
                result = "success";
                cwg.accept("");
                System.out.println("Failure: Invalid String");
                cwg.accept(null);
                System.out.print("Failure: Didn't throw exception");

            } catch (Exception e) {

                if (result.equals("")) {
			
                    System.out.println("Failure with Correct Input");
			
                }

            }

        }

	    
        @Test(timeout = 3000)
        public void sendRequestTest() {

            // Make sure that sendRequest method throws an error if the input values are invalid.
            // If the input is valid then it runs a client method - tested in NewTest.java

            String result = "";
		
            try {

                ClientWithGUI cwg = new ClientWithGUI();
                result = "success";
                cwg.sendRequest("");
                System.out.println("Failure: Invalid String");
                cwg.sendRequest(null);
                System.out.print("Failure: Didn't throw exception");

            } catch (Exception e) {

                if (result.equals("")) {
			
                    System.out.println("Failure with Correct Input");
			
                }

            }

        }

	    
        @Test(timeout = 3000)
        public void rejectTest() {

            //Make sure that reject method throws an error if the input values are invalid.
            // If the input is valid then it runs a client method - tested in NewTest.java

            String result = "";
		
            try {

                ClientWithGUI cwg = new ClientWithGUI();
                result = "success";
                cwg.reject("");
                System.out.println("Failure: Invalid String");
                cwg.reject(null);
                System.out.print("Failure: Didn't throw exception");

            } catch (Exception e) {

                if (result.equals("")) {
			
                    System.out.println("Failure with Correct Input");
			
                }

            }

        }
	    

        @Test(timeout = 3000)
        public void viewUserProfileTest() {

            //Make sure that viewUserProfileGUI method throws an error if the input values are invalid.

            String result = "";
		
            try {

                ClientWithGUI cwg = new ClientWithGUI();
                result = "success";
                cwg.viewUserProfileGUI(null);
                System.out.println("Failure: Invalid String");
                cwg.reject(null);
                System.out.print("Failure: Didn't throw exception");

            } catch (Exception e) {

                if (result.equals("")) {
			
                    System.out.println("Failure with Correct Input");
			
                }

            }

        }


    }

	
}
