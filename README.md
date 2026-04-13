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

South African phone Number Validation
The system checks if the cellphone number is in the correct South African format.
It must:
Start with the country code +27
Follow a valid number structure after that
If the format is incorrect the registration will fail.
