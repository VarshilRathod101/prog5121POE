import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    // Creating a Login object for testing
    Login login = new Login();
    Message message = new Message();

    //testing username
    void testUsernameSuccess() {
        assertTrue(login.checkUserName("kyl_1"));
        // correct username
    }

    @Test
    void testUsernameFailure() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
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
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
        // Correct login details
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginFailure() {
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!");
        assertFalse(login.loginUser("kyl_1", "wrongPassword123!"));
    }
// part 2

    @Test
    void testCheckMessageID() {
        // testing message id when 10 or less characters
        assertTrue(message.checkMessageID("0012345678"));
        // testing message id when more than 10
        assertFalse(message.checkMessageID("0012345678911"));
    }

    @Test
    void testCheckRecipientCell() {
        // testing if phone number has the right SA code and digit
        assertEquals("Cell phone number successfully captured.",
                message.checkRecipientCell("+27838968976"));
    }

    // testing message is under 250 character is accepted
    @Test
    void testCheckMessageLengthSuccess() {

        assertEquals("Message ready to send.",
                message.checkMessageLength("This is a test message."));
    }

    @Test
    void testCheckMessageLengthFailure() {
        // Creating a string long enough to definitely fail (> 250 chars)
        String longMsg = "This is a very long message. ".repeat(20);
        String result = message.checkMessageLength(longMsg);

        // This confirms the logic returns 'true' that the failure string was found
        assertTrue(result.contains("Message exceeds 250 characters"));
    }

    @Test
    void testCreateMessageHash() {
        String hash = message.createMessageHash("0012345678", "Hi Mike, can you join us for dinner tonight?");

        assertEquals("00:0:HITONIGHT", hash);
    }
}