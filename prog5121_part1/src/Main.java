
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login userAuth = new Login();

        //start of the regisstation
        System.out.println("Account sign up (registration)");
        System.out.print("Enter First Name: ");
        String firstname = input.nextLine();
        System.out.print("Enter Last Name: ") ;
        String lastname = input.nextLine();

        // Collecting username
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        if (!userAuth.checkUserName(username)) {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            return;
        }
        System.out.println("Username successfully captured.");

        // Collecting password
        System.out.print("Enter password: ");
        String password =  input.nextLine();
        if (!userAuth.checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        }
        System.out.println("Password successfully captured.");

        // Collecting cell phone number
        System.out.print("Enter Cell Phone Number (e.g. +27123456789): ");
        String cell = input.nextLine();
        if (!userAuth.checkCellPhoneNumber(cell)) {
            System.out.println("Cell phone number incorrectly formatted.");
            return;
        }
        System.out.println("Cell phone number successfully added.");

        // Finishing the registration process
        userAuth.registerUser(firstname, lastname, username, password);
        System.out.println("\n  REGISTRATION COMPLETED SUCCESSFULLY ");

        // Login process
        System.out.println("\nPlease login to your account");
        System.out.print("Username: ");
        String loginUser = input .nextLine();
        System.out.print("Password: ");
        String loginPass = input.nextLine();

        boolean isSuccess = userAuth.loginUser(loginUser, loginPass);
        System.out.println("\n" + userAuth.returnLoginStatus(isSuccess));

        //part 2 quickchat
        if (isSuccess) {
            System.out.println("Welcome to QuickChat");
            Message messageApp = new Message();
            int choice = 0;

            //keeps app running unitl 3 is typed
            while (choice != 3) {
                System.out.println("\nPlease choose an option:");
                System.out.println("Option 1) Send Messages");
                System.out.println("Option 2) Show recently sent messages (Coming Soon)");
                System.out.println("Option 3) Quit");

                choice = input.nextInt() ;
                input.nextLine();

                //number of messages a uder want to send
                if (choice == 1) {
                    System.out.print("How many messages you wish to enter? ");
                    int numMessages = input.nextInt();

                    input.nextLine();

                    for (int i = 0; i < numMessages; i++) {
                        System.out.println("\n--- Message " + (i + 1) + " ---");

                        //loop to check if  recipient is right
                        String recipient = "";
                          boolean isCellValid =  false;
                        while (!isCellValid) {
                            System.out.print("Recipient Number: ");
                            recipient = input.nextLine();

                            String result = messageApp.checkRecipientCell(recipient);
                            System.out.println(result);
                            //stops if the nubmer is correct
                            if (result.equals("Cell phone number successfully captured.")) {
                                isCellValid = true;
                            }
                        }


                        //checking message id to be 10 or less
                        String msgID = "";
                        boolean isIDValid = false;
                        while (!isIDValid) {
                            System.out.print(" Message ID (less than 10 digits): ");
                            msgID =  input.nextLine();
                            if (messageApp.checkMessageID(msgID))  {

                                isIDValid = true;
                                System.out.println("Message ID successfully captured.");
                            } else {
                                System.out.println("Message ID is too long. Please try again.");
                            }
                        }

                        //checking if message is under 250 charhcter
                        String content = "";
                        boolean isContentValid = false;
                        while (!isContentValid) {
                            System.out.print("Enter Message (250 characters limit): ");
                            content = input.nextLine();
                            String result =  messageApp.checkMessageLength(content);
                            System.out.println(result);

                            // ONLY exit this loop if message is under 250 characters
                            if (result.equals("Message ready to send.")) {
                                isContentValid =  true;
                            }
                        }

                        String hash = messageApp.createMessageHash(msgID, content);

                        System.out.println("\nSelect Action:\n1) Send\n2) Disregard\n3) Store");
                        int action = input.nextInt ();

                        input.nextLine();

                        if (action == 1) {
                            String status = messageApp.sendMessage(action);
                            System.out.println(status);

                            // Displays in exactly the order requested by the table
                            System.out.println("\nMessage detail");
                            System.out.println("Message ID: " + msgID)  ;
                            System.out.println("Message Hash: " + hash);
                            System.out.println("Recipient: " + recipient);
                            System.out.println("Message: " + content);


                            messageApp.saveMessageToJson(recipient, msgID, content, hash);
                        } else {
                            System.out.println(messageApp.sendMessage(action));
                        }
                    }
                    System.out.println("\nTotal messages sent: " + messageApp.returnTotalMessages());
                } else if (choice == 2) {
                    System.out.println("Coming Soon");
                }
            }
            System.out.println("Exiting QuickChat.");
        }
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
        return CheckingCapital && FindingNumber && CheckingSpecialChar && CheckingLength;
    }

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
    public boolean loginUser(String userAttempt, String passAttempt) {
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

class Message {
    private int totalMessagesSent = 0;

    public boolean checkMessageID(String id) {
        return id.length() <= 10;
    }

    //checking cellphone number is right
    public String checkRecipientCell(String cell) {
        if (cell.startsWith("+27") && cell.length() <= 12) {
            return "Cell phone number successfully captured.";
        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    //cheakes message is under 250
    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            //Works out how many characters need to be deleted
            int extra = message.length() - 250;
            return "Message exceeds 250 characters by " + extra + "; please reduce the size.";
        }
    }

    //creating unique code for the message
    public String createMessageHash(String id, String message) {
        String idPart = id.substring(0, 2);
        String[] words = message.trim().split("\\s+");
        String first = words[0].toUpperCase().replaceAll("[^A-Z]", "");
        String last = words[words.length - 1].toUpperCase().replaceAll("[^A-Z]", "");
        return idPart + ":" + totalMessagesSent + ":" + first + last;
    }

    public String sendMessage(int action) {
        if (action == 1) {
            totalMessagesSent++;
            return "Message successfully sent.";
        } else if (action == 2) {

            return "Press 0 to delete the message.";
        } else {
            return "Message successfully stored.";
        }
    }

    //gives total number of messages
    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    //saving the message in JSON file
    public void saveMessageToJson(String recipient, String id, String content, String hash) {
        String jsonEntry = "{\n" +
                "   \"recipient\": \"" + recipient + "\",\n" +
                "   \"id\": \"" + id + "\",\n" +
                "  \"content\": \"" + content + "\",\n" +
                "  \"hash\": \"" + hash + "\"\n" +
                "}\n";

        //Writes to the file without replacing old content
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(jsonEntry);
            System.out.println("Message saved in JSON file.");
        } catch (IOException e) {
            System.out.println("Error saving to JSON: " + e .getMessage());
        }
    }
}