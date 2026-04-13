import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    // Creating a Login object for testing
    Login login = new  Login();

    //testing username
    @Test
    void testUsernameSuccess() {
        assertTrue(login.checkUserName("kyl_1"));
        // correct username
    }

    @Test
    void testUsernameFailure() {
        assertFalse (login.checkUserName("kyle!!!!!!!"));
        // incorrect username
    }

    // testing password
    @Test
    void testPasswordSuccess() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        // correct password
    }

    @Test
    void testPasswordFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
        // incorrect password
    }

    // testing phone number
    @Test
    void testCellPhoneSuccess() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        // correct phone number
    }

    @Test
    void testCellPhoneFailure() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
        //incorrect phone number

    }

    // login test
    @Test
    void testLoginSuccess() {
        // Register user first
        login.registerUser( "Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");

        // Correct login details
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginFailure() {
        // Register user first
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");

        // Wrong password
        assertFalse(login.loginUser("kyl_1" , "wrongPassword123!"));
    }
}