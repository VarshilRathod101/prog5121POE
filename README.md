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


 # References

Bro Code, 2025. Java Full Course for free ☕. [video online] Available at: 
<https://youtu.be/xTtL8E4LzTQ> [Accessed 10 April 2026].

Emeris School of Computer Science, 2025. PROG5121 Unit Testing Getting Started. [video online] Available at: 
<https://www.youtube.com/watch?v=MOhiM2SXZl0> [Accessed 13 April 2026].

Farrell, J., 2022. Java Programming. 15 August 2022.

Stack Overflow, 2026 . Java Regex Phone Number. [online] Available at: 
<https://stackoverflow.com/questions/33477950/java-regex-phone-number> [Accessed 13 April 2026]


 W3Schools, 2025. Java Tutorial. [online] Available at: 
<https://www.w3schools.com/java/> [Accessed 10 April 2026].





 

