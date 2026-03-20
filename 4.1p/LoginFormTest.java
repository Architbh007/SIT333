package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{
    @Test
    public void testStudentIdentity() {
        String studentId = "s224094385";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Archit Bhullar";
        Assert.assertNotNull("Student name is null", studentName);
    }

    //Empty username, Empty password, Don't care val code
    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertTrue(status.isLoginSuccess() == false);
    }

    //Empty username, Wrong password, Don't care val code
    @Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    //Empty username, Correct password, Don't care val code
    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    //Wrong username, Empty password, Don't care val code
    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("wronguser", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    //Wrong username, Wrong password, Don't care val code
    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("wronguser", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    //Wrong username, Correct password, Don't care val code
    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("wronguser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    //Correct username, Empty password, Don't care val code
    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    //Correct username, Wrong password, Don't care val code
    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    //Correct username, Correct password, Empty val code
    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        boolean codeResult = LoginForm.validateCode(null);
        Assert.assertFalse(codeResult);
    }

    //Correct username, Correct password, Wrong val code
    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        boolean codeResult = LoginForm.validateCode("wrongcode");
        Assert.assertFalse(codeResult);
    }

    //Correct username, Correct password, Correct val code
    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        boolean codeResult = LoginForm.validateCode("123456");
        Assert.assertTrue(codeResult);
    }
}