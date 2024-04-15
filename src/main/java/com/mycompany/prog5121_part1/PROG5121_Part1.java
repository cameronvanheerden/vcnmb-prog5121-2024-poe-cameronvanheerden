package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_Part1 {
        
    public static void main(String[] args) {   
        
    int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
    if(iUserResponse == JOptionPane.YES_OPTION){
             
        String firstName1 = "";
        String lastName1 = "";
        String Username1 = "";
        String Password1 = "";
               
        while(firstName1.isEmpty() || lastName1.isEmpty()){
         firstName1 = JOptionPane.showInputDialog(null, "Enter your first name: ");
         lastName1 = JOptionPane.showInputDialog(null, "Enter your last name: ");
         
         }
         
        if(firstName1.isBlank()|| lastName1.isBlank()){
             JOptionPane.showMessageDialog(null, "First name and Last name is required",
                     "Retry", JOptionPane.ERROR_MESSAGE);
         }
       boolean validUsername = false;
           
       while(!validUsername){
        
       Username1 = JOptionPane.showInputDialog(null, "Create a username"
                    + "\n-The username must contain an underscore"
                    + "\n-Should not be longer than 5 characters.",
                    "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
       
       Login validUsername1 = new Login(Username1, Password1, "", "");
       
        if(validUsername1.checkUserName(Username1)){
            
            JOptionPane.showMessageDialog(null, "Username captured successfully", "Username valid", JOptionPane.PLAIN_MESSAGE);
            
            validUsername= true;
    }else{
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                + "please ensure that your username meets the following criteria: "
                + "\n-The username should contain an underscore"
                + "\n-The username should also not be longer than 5 characters long", "Username is invalid", JOptionPane.ERROR_MESSAGE);
    }
    }
       boolean validPassword = false;
  
        while(!validPassword) {
       
       Password1 = JOptionPane.showInputDialog(null, "Create a password"
                         + "\n-Must be at least 8 Characters long"
                         + "\n-Contain a capital letter"
                         + "\n-Contain a number"
                         + "\n-Contain a special character"
                        , "Password Requirements", JOptionPane.INFORMATION_MESSAGE);

        Login validPassword1 = new Login(Username1, Password1, "","");

        if(validPassword1.checkPasswordComplexity(Password1)) {

        JOptionPane.showMessageDialog(null, "Password captured successfully",
                            "Password valid", JOptionPane.PLAIN_MESSAGE);

         validPassword = true;
        }
	else {
          JOptionPane.showMessageDialog(null, "Password is not correctly formatted,"
                    + " please ensure that your password meets the following criteria:"
                    + "\n-The password should contain at least 8 characters"
                    + "\n-A capital letter"
                    + "\n-A number"
                    + "\n-And a special character",
                    "Password not valid", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        JOptionPane.showMessageDialog(null,"Login details" + "\nFirst name: "+ firstName1 + "\nLast name: "+ lastName1 
                + "\nUsername: " + Username1 + "\nPassword: " + Password1
                , "Login Details", JOptionPane.PLAIN_MESSAGE);
        
        Login Registered = new Login(Username1, Password1, firstName1, lastName1);
             
        
         int Login = JOptionPane.showConfirmDialog(null, "Would you like to sign into your account", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
         if(Login==JOptionPane.YES_OPTION){
        Username1 = JOptionPane.showInputDialog(null, "Enter your username:", "Login", JOptionPane.PLAIN_MESSAGE);
        Password1 =JOptionPane.showInputDialog(null, "Enter your password:", "Login", JOptionPane.PLAIN_MESSAGE);
                
          if (Registered.loginUser(Username1, Password1)){
              
              JOptionPane.showMessageDialog(null, Registered.registerUser(Username1, Password1), "Logged in", JOptionPane.PLAIN_MESSAGE);;
          }
          else{
              JOptionPane.showMessageDialog(null, Registered.registerUser(Username1, Password1), "Error", JOptionPane.ERROR_MESSAGE);
              
         return; 
          }      
         
         Login Return1 = new Login(Username1, Password1, firstName1, lastName1);
         
        if(Return1.loginUser(Username1, Password1)){
            
        JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1) + firstName1 + " " + lastName1 + ", great to see you again", "Successful login", JOptionPane.PLAIN_MESSAGE);
    
        }  
        else{
            JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
        } else if (Login == JOptionPane.NO_OPTION) {
            
            JOptionPane.showMessageDialog(null, "Goodbye!", "Output", JOptionPane.PLAIN_MESSAGE);
            System.exit(Login);
        
    }
     else if(iUserResponse == JOptionPane.NO_OPTION)     
    {
            
     JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.PLAIN_MESSAGE);
      //If they select no thank the user for using my app
           
      System.exit(iUserResponse);//Exits the program without continuing
      
    }  
    }
}
}