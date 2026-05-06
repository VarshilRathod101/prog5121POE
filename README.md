# prog5121POE 
part1 Registration and login feature

*part1 objective 
>This is a simple Java program where users can create an account and log in.
>Before creating the account the program checks if the user entered correct information like a valid username, a strong password, and a valid South African cellphone number.
>The project also uses JUnit tests to automatically check that all the main features (like registration and login) are working properly and giving the correct results.

 *User Registration
 
The system allows a user to create an account by entering their details.
This includes:
First name
Last name
Username
Password
Cellphone number
All of this information is saved only if it passes the validation rules.

*Username Validation

The program checks if the username is valid  before allowing registration.
A valid username must:
Contain an underscore (_ )
Be 5 characters or less in length
If it does not follow these rules  the system rejects it and asks the user to try again.

*Password  Validation

The password must be strong for security reasons.
A valid password must:
Be at least 8 characters long
Contain at least one uppercase letter
Contain at least one number
Contain at least one special character (like % or *)
If the password is weak or missing any of these requirements the system will not accept it.

*South African phone Number Validation

The system checks if the cellphone number is in the correct South African format.
It must:
Start with the country code +27
Follow a valid number structure after that
If the format is incorrect the registration will fail.

*Login Authentication

After registration, the user can log in using their username and password.
The system checks:
If the username exists
If the password matches the saved password
Only if both are correct will the user be allowed to log in.

*uccess and Failure Messages

The program gives feedback after every login attempt:
If login is correct . It shows a success message (login successful)
If login is incorrect . It shows a failure message (wrong username or password)
This helps the user understand what went right or wrong.

*Unit testing

way to automatically check if your program works correctly. Instead of testing everything manually, you write small test cases that run by themselves and verify your code.

Tests cover:
 >Username validation
>Password complexity validation
> Cell phone number validation
> Login authentication

* messages display  ( Registration )


USERNAME 

True : Username successfully captured. 
False : Username is not correctly formatted please ensure that your username contains an underscore and is no more than five characters in length.

PASSWROD 

True : Password successfully captured.
False : Password is not correctly formatted please ensure that the password contains at least eight characters, a capital letter, a number, and a special character

Phone number 

True : Cell phone number  successfully added
False : Cell phone number incorrectly formatted or does not contain international code 

* messages display  ( Login  ) 

 USERNAME AND PASSWORD 

 True : Welcome (first and last name) it is great to see you again.
 False : Username or password incorrect please try again 


 # References part 1 

Bro Code, 2025. Java Full Course for free ☕. [video online] Available at: 
<https://youtu.be/xTtL8E4LzTQ> [Accessed 10 April 2026].

Emeris School of Computer Science, 2025. PROG5121 Unit Testing Getting Started. [video online] Available at: 
<https://www.youtube.com/watch?v=MOhiM2SXZl0> [Accessed 13 April 2026].

Farrell, J., 2022. Java Programming. 15 August 2022.

Stack Overflow, 2026 . Java Regex Phone Number. [online] Available at: 
<https://stackoverflow.com/questions/33477950/java-regex-phone-number> [Accessed 13 April 2026]


 W3Schools, 2025. Java Tutorial. [online] Available at: 
<https://www.w3schools.com/java/> [Accessed 10 April 2026].

Part 2 quickchat 

Part 2 of the program starts only after the user has logged in successfully.
After the correct login details are entered the system grants the user access to the QuickChat application and message processing can start.
This section is designed to a basic messaging system where a user can create, store, and manage text messages.

*Quickchat menu 

After login the user is presented with a menu that contains three options:

Option 1 ) Send message
Option 2 ) Show recently sent messages (Coming Soon)
Option 3 ) Quit 

> A while loop is being used for this menu becuase the application  must keep on running unitl the user decides to exit by picking option 3 ) quit .

*Number of messeges system 

When the user chooses Option 1 the program asks: how many messages you wish to enter ? 
Than thw asnwer is palced in the varible called numMessage.
A for loop is then used because the same message capturing process must repeat according to the number entered by the user.
Example : the user say 2 messeges the progess will go through the message process 2 times .

*Entering and Checking the Recipient Cell Number 

The first detail that must be entered for every message is the recipient cellphone number.
The program uses the checkRecipientCell() method from the Message class to verify if the recipient number is valid.
the method checks that the number start with the south african code and making sure the the bumber is 10 digit.

A while loop is used together with the boolean variable isCellValid.
This loop keeps asking the user for the recipient number until the method returns:
 Cell phone number successfully captured
If the number is incorrect, an error message is displayed and the user must enter the number again.
This prevents invalid recipient details from moving forward in the program.

*Entering and Verifying the Message ID

After the recipient number is accepted the user is asked to enter a message ID.
The checkMessageID() method checks whether the ID is 10 characters or less ands which is one of the assignment requirements.
A second validation loop is used here.
If the message ID is too long the program displays:Message ID is too long. Please try again.
The loop continues until a correct ID is entered.
This ensures every message has an acceptable identifier before being processed.

*Entering and Checking the Message Content 

The user then types the actual message content.
The checkMessageLength() method is responsible for checking whether the message stays within the maximum limit of 250 characters.

Two outcomes.
If the message is valid:
The method returns:
Message ready to send.

If the message is too long:
The method calculates how many characters are over the limit and returns a message such as:
"Message exceeds 250 characters by X; please reduce the size."

Another while loop is used so the user cannot continue until the message content meets the allowed size.
This is important because it forces proper input validation instead of allowing incorrect data.

* Creating a Unique Message Hash
Once all three inputs are valid:
recipient number,message ID and message content.

the program then creates a unique message hash by calling the createMessageHash() method.
This hash is generated by combining:
the first two characters of the message ID,the current number of sent messages,the first word in the message the last word in the message.

The purpose of this hash is to create a short code that uniquely identifies each message.
This makes the message easier to track and display.

 *Selecting the Message Action
After the hash is create the user must choose what should happen to the message.

The available actions are:
1)Send
2)Disregard
3)Store

This value is passed into the sendMessage() method.
The method uses an if / else if / else structure to determine which output message should be returned.
If option 1 is chosen:
the message is marked as successfully sent
the totalMessagesSent counter is increased by 1.

If option 2 is chosen:
the message is disregarded.

If option 3 is chosen:
the message is stored.

This makes the program behave differently depending on the user’s choice.

*Displaying Sent Message Details
When a message is successfully sent the program prints the full message information back to the screen.
The displayed details include:
Message ID

Message Hash

Recipient Number

Message Content

This gives the user confirmation that the message was processed correctly.


*Saving the Message into a JSON File
After displaying the sent message the saveMessageToJson() method is called.
This method stores the message information inside a file named messages.json.
The information saved is:
recipient
id
content
hash

A FileWriter is used in append mode (true) so that:
old messages are not deleted

each new message is added to the bottom of the file.
This allows permanent storage of sent message details.

*Counting the Total Messages Sent
The class variable totalMessagesSent keeps track of how many messages were successfully sent.
Every time option 1 (Send) is selected this counter increases.
The returnTotalMessages() method is then used to display the final total after all messages have been processed.
This helps the user know how many messages were sent during that session.

  # References part 2 

ChargeAhead, 2024. Parsing JSON in Java. [video online] Available at: <https://youtu.be/0nN2stWIHM0?si=CA5bS2rFHyBNC8us>

Farrell, J., 2022. Java Programming. 15 August 2022.

TutorialsPoint, 2026. JSON with Java Example. [online] Available at: < https://www.tutorialspoint.com/json/json_java_example.htm >
[Accessed 5 May 2026].

W3Schools, 2026. Java For Loop. [online] Available at: https://www.w3schools.com/java/java_for_loop.asp 
[Accessed 5 May 2026].

Web Dev Simplified, 2018. Learn JSON in 10 Minutes. [video online] Available at:
https://youtu.be/iiADhChRriM?si=s5jKjrDb8aWeDtIe
[Accessed 6 May 2026].
  
