import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //making a scanner to read the input
        Scanner input = new Scanner(System.in);
        Login auth = new Login();

        //start of the regisstation
        System.out.println("Account sign up (registration)");
        // Collecting first and last name
        System.out.print ("Enter First Name: ");
        String firstname = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lastname = input.nextLine();

        // Collecting username
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        //checking if username meet the rules
        if (!auth.checkUserName(username)) {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            return;
        }
        System.out.println("Username successfully captured.");


        // Collecting password
        System.out.print ("Enter password: ");
        String password = input.nextLine();
        //checking if password meet the rules
        if (!auth.checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        }
        System.out.println("Password successfully captured.");


        // Collecting cell phone number
        System.out.print("Enter Cell Phone Number (e.g. +27123456789): ");
        String cell = input.nextLine();
        //checking if cell phone number meet the rules
        if (!auth.checkCellPhoneNumber(cell)) {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }
        System.out.println("Cell phone number  successfully added.");

        // Finishing the registration process
        auth.registerUser(firstname, lastname, username, password);
        System.out.println("\n  REGISTRATION COMPLETED SUCCESSFULLY ");

        // Login process
        System.out.println("\nPlease login to your account");
        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print ("Password: ");
        String loginPass = input.nextLine();

        boolean isSuccess = auth.loginUser(loginUser, loginPass);
        System.out.println("\n" + auth.returnLoginStatus(isSuccess));

    }
}
    class Login {
        // capture the input after registration
        private String savedFirstName;
        private String savedLastName;
        private String savedUsername;
        private String savedPassword;

        // checking the username meeting the requirement
        public boolean checkUserName(String username) {
            return username.contains("_") && username.length() <= 5;
        }

        //checking the password if its strong enough
        public boolean checkPasswordComplexity(String password) {
            boolean CheckingCapital = !password.equals(password.toLowerCase());
            boolean FindingNumber = password.matches(".*\\d.*");
            boolean CheckingSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
            boolean CheckingLength = password.length() >= 8;

            return CheckingCapital && FindingNumber &&  CheckingSpecialChar  &&  CheckingLength ;
        }

        //
        public boolean checkCellPhoneNumber(String cell) {
            return Pattern.matches("^\\+27\\d{9}$", cell);
        }

        // saving user information into  variables
        public void registerUser(String firstName, String lastName, String userName, String password) {
            this.savedFirstName = firstName;
            this.savedLastName = lastName;
            this.savedUsername = userName;
            this.savedPassword = password;
        }

        //checking if the login information matches the saved information
        public boolean loginUser(String userAttempt, String passAttempt)  {
            return userAttempt.equals(this.savedUsername) && passAttempt.equals(this.savedPassword);
        }

        // disaplying final message after login
        public String returnLoginStatus(boolean success) {
            if (success) {
                return "Welcome " + savedFirstName + " " + savedLastName + " it is great to see you again.";
            } else {
                return "Username or password incorrect please try again.";
            }
        }
    }