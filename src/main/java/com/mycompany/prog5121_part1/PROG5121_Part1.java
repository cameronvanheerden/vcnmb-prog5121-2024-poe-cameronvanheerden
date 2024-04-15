package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_Part1 {
        
    public static void main(String[] args) {   
        
    int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not(Marilena, 2016)
        
    if(iUserResponse == JOptionPane.YES_OPTION){//(Marilena, 2016)
        //Declaring the neccesary variables   
        String firstName1 = "";
        String lastName1 = "";
        String Username1 = "";
        String Password1 = "";
               
        while(firstName1.isEmpty() || lastName1.isEmpty()){//loops if the name and surname is empty(GeeksforGeeks, 2023)
         firstName1 = JOptionPane.showInputDialog(null, "Enter your first name: ");//(Marilena, 2016)
         lastName1 = JOptionPane.showInputDialog(null, "Enter your last name: ");//(Marilena, 2016)
         
         }
         
        if(firstName1.isBlank()|| lastName1.isBlank()){//(GeeksforGeeks, 2023)
             JOptionPane.showMessageDialog(null, "First name and Last name is required",
                     "Retry", JOptionPane.ERROR_MESSAGE);//If the first or last name is blank it will loop back for user to enter it again(GeeksforGeeks, 2021)
         }
       boolean validUsername = false;//Default variable for username is false
           
       while(!validUsername){//While loop continues until username requirements have been me(Wanvig, 2021)
        
       Username1 = JOptionPane.showInputDialog(null, "Create a username"
                    + "\n-The username must contain an underscore"
                    + "\n-Should not be longer than 5 characters.",
                    "Username Requirements", JOptionPane.INFORMATION_MESSAGE);//Username requirements(Marilena, 2016)
       
       Login validUsername1 = new Login(Username1, Password1, "", "");//(Javatpoint, 2021)
       
        if(validUsername1.checkUserName(Username1)){
            
            JOptionPane.showMessageDialog(null, "Username captured successfully", "Username valid", JOptionPane.PLAIN_MESSAGE);//(GeeksforGeeks, 2021)
            
            validUsername= true;//Boolean variable that is true when the username is meets requirements and while loop will end
    }else{
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                + "please ensure that your username meets the following criteria: "
                + "\n-The username should contain an underscore"
                + "\n-The username should also not be longer than 5 characters long",
                "Username is invalid", JOptionPane.ERROR_MESSAGE);//Username requirements which were not met(GeeksforGeeks, 2021)
    }
    }
       boolean validPassword = false;//Default variable for password is false
  
        while(!validPassword) {//While loop continues until password requirements have been met(Wanvig, 2021)
       
       Password1 = JOptionPane.showInputDialog(null, "Create a password"
                         + "\n-Must be at least 8 Characters long"
                         + "\n-Contain a capital letter"
                         + "\n-Contain a number"
                         + "\n-Contain a special character"
                        , "Password Requirements", JOptionPane.INFORMATION_MESSAGE);//Password requirements(Marilena, 2016)

        Login validPassword1 = new Login(Username1, Password1, "","");//(Javatpoint, 2021)

        if(validPassword1.checkPasswordComplexity(Password1)) {//Checks if the password requirements have been met

        JOptionPane.showMessageDialog(null, "Password captured successfully",
                            "Password valid", JOptionPane.PLAIN_MESSAGE);//(GeeksforGeeks, 2021)

         validPassword = true;//Boolean variable that is true when the password is meets complexity requirements and while loop will end
        }
	else {
          JOptionPane.showMessageDialog(null, "Password is not correctly formatted,"
                    + " please ensure that your password meets the following criteria:"
                    + "\n-The password should contain at least 8 characters"
                    + "\n-A capital letter"
                    + "\n-A number"
                    + "\n-And a special character",
                    "Password not valid", JOptionPane.ERROR_MESSAGE);//Password requirements which were not met(GeeksforGeeks, 2021)
                }
            }
        
        JOptionPane.showMessageDialog(null,"Login details" + "\nFirst name: "+ firstName1 + "\nLast name: "+ lastName1 
                + "\nUsername: " + Username1 + "\nPassword: " + Password1
                , "Login Details", JOptionPane.PLAIN_MESSAGE);//Login details enetered(GeeksforGeeks, 2021)
        
        Login Registered = new Login(Username1, Password1, firstName1, lastName1);//Instance variable(Javatpoint, 2021)
             
        
         int Login = JOptionPane.showConfirmDialog(null, "Would you like to sign into your account", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Int variable allows for a Yes No option to appear(Marilena, 2016)
                    
         if(Login==JOptionPane.YES_OPTION){//(Marilena, 2016)
        Username1 = JOptionPane.showInputDialog(null, "Enter your username:", "Login", JOptionPane.PLAIN_MESSAGE);//(Marilena, 2016)
        Password1 =JOptionPane.showInputDialog(null, "Enter your password:", "Login", JOptionPane.PLAIN_MESSAGE);//(Marilena, 2016)
                
          if (Registered.loginUser(Username1, Password1)){//If the username and passward is met it will display welcome message
              
              JOptionPane.showMessageDialog(null, "Login successful", "Logged in", JOptionPane.PLAIN_MESSAGE);//(GeeksforGeeks, 2021)
          }
          else{
              JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);//(GeeksforGeeks, 2021)
              
         return; //Exits program when the username and password isnt valid
          }      
         
         Login Return1 = new Login(Username1, Password1, firstName1, lastName1);//Instance variable(Javatpoint, 2021)
         
        if(Return1.loginUser(Username1, Password1)){//Decision statement that states if the password and username entered matches the details they put in earlier
            
        JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1) + firstName1 
                + " " + lastName1 + ", great to see you again",
                "Successful login", JOptionPane.PLAIN_MESSAGE);//Welcome message that displays when login details are met(GeeksforGeeks, 2021)
    
        }  
        else{
            JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1),
                    "Error", JOptionPane.ERROR_MESSAGE);//Failed login messsage(GeeksforGeeks, 2021)
        }
       
        } else if (Login == JOptionPane.NO_OPTION) {//(Stackoverflow, 2014)
            
            JOptionPane.showMessageDialog(null, "Goodbye!", "Output", JOptionPane.PLAIN_MESSAGE);//Message that displays when no is selected(GeeksforGeeks, 2021)
            System.exit(Login); //If user selects no it doesnt allow them to login in
        
    }
     else if(iUserResponse == JOptionPane.NO_OPTION)//If user selects no it exits the program(Stackoverflow, 2014)
    {
            
     JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.PLAIN_MESSAGE);
      //If they select no thank the user for using my app(GeeksforGeeks, 2021)
           
      System.exit(iUserResponse);//Exits the program without continuing and displays a message saying thank you(Stackoverflow, 2014)
      
    }  
    }
}
}

/*References
Dexter, M., 2007. Eclipse And Java For Total Beginners. [Online] 
Available at: https://eclipsetutorial.sourceforge.net/Total_Beginner_Companion_Document.pdf
[Accessed 12 April 2024].
GeeksforGeeks, 2021. Message Dialogs in Java (GUI). [Online] 
Available at: https://www.geeksforgeeks.org/message-dialogs-java-gui/
[Accessed 14 April 2024].
GeeksforGeeks, 2023. Java String isEmpty() method with example. [Online] 
Available at: https://www.geeksforgeeks.org/java-string-isempty-method-example/
[Accessed 13 April 2024].
GeeksforGeeks, 2024. Java Cheat Sheet. [Online] 
Available at: https://www.geeksforgeeks.org/java-cheat-sheet/
[Accessed 12 April 2024].
Javatpoint, 2021. What is an Instance in Java?. [Online] 
Available at: https://www.javatpoint.com/what-is-an-instance-in-java
[Accessed 14 April 2024].
Marilena, 2016. Java Swing – JOptionPane showConfirmDialog example. [Online] 
Available at: https://mkyong.com/swing/java-swing-how-to-make-a-confirmation-dialog/
[Accessed 13 April 2024].
Marilena, 2016. Java Swing – JOptionPane showInputDialog example. [Online] 
Available at: https://mkyong.com/swing/java-swing-joptionpane-showinputdialog-example/
[Accessed 14 April 2024].
Stackoverflow, 2014. confirmation before exit dialog. [Online] 
Available at: https://stackoverflow.com/questions/17143394/confirmation-before-exit-dialog
[Accessed 15 April 2024].
Stackoverflow, 2016. Password validate 8 digits, contains upper, lowercase, and a special character. [Online] 
Available at: https://stackoverflow.com/questions/36097097/password-validate-8-digits-contains-upper-lowercase-and-a-special-character
[Accessed 13 April 2024].
Wanvig, R., 2021. PROG5121 LU3 IF statement Examples, Port Elizabeth: Varsity College.
Wanvig, R., 2021. PROG5121 LU4 While loops intro, Port Elizabeth: Varsity College.
Wanvig, R., 2022. Basic Unit testing example, Port Elizabeth: Varsity College.*/

