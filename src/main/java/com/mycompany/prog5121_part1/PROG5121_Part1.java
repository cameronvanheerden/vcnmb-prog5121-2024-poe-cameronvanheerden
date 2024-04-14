package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_Part1 {
            
    public static void main(String[] args) {   
        
    int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
    if(iUserResponse == JOptionPane.YES_OPTION){
       String firstName1 = "";
       String lastName1 = "";
       Name(firstName1, lastName1);
       String Username1 = "";
       createUsername(Username1);
       String Password1 = "";
       createPassword(Password1); 
       successfulLogin(Username1, Password1, firstName1, lastName1);
       returnMessage(Username1, Password1, firstName1, lastName1);

    }
    else if(iUserResponse == JOptionPane.NO_OPTION)
    {
            
     JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.PLAIN_MESSAGE);
      //If they select no thank the user for using my app
           
      System.exit(iUserResponse);//Exits the program without continuing
      
    }     
    }
    
     public static void Name(String firstName1, String lastName1){
         String Username1 = "";
         String Password1 = "";
         
         while(firstName1.isEmpty() || lastName1.isEmpty()){
         firstName1 = JOptionPane.showInputDialog(null, "Enter your first name: ");
         lastName1 = JOptionPane.showInputDialog(null, "Enter your last name: ");
         
         if(firstName1.isBlank()|| lastName1.isBlank()){
             JOptionPane.showMessageDialog(null, "First name and Last name is required",
                     "Retry", JOptionPane.ERROR_MESSAGE);     
         }
        }
         
         Login getName = new Login(Username1, Password1, firstName1, lastName1);
         getName.setfirstName(firstName1);
         getName.setlastName(lastName1);
         
     }      
         
       public static void createUsername(String Username1) {
        String Password1 = "";
        String firstName1 = "";
        String lastName1 = "";
        String Username = "";
        String strName = "";
        String strSurname = "";
        boolean Registration = false;

        while(!Registration){
        
       Username1 = JOptionPane.showInputDialog(null, "Create a username"
                    + "\n-The username must contain an underscore"
                    + "\n-Should not be longer than 5 characters.",
                    "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
       
       Login validUsername = new Login(Username1, Password1, "", "");
       
        if(validUsername.checkUserName(Username1)){
            
            JOptionPane.showMessageDialog(null, "Username captured successfully", "Username valid", JOptionPane.PLAIN_MESSAGE);
            Registration = true;
    }else{
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                + "please ensure that your username meets the following criteria: "
                + "\n-The username should contain an underscore"
                + "\n-The username should also not be longer than 5 characters long", "Username is invalid", JOptionPane.ERROR_MESSAGE);
    }
    }
       }
       
    public static void createPassword(String Password1){
        
        String Username1 = "";
        String firstName1= "";
        String lastName1= "";
        boolean Registration = false;
 
     while(!Registration){ 
         
         Password1 = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
         
          Login validPassword =  new Login(Username1, Password1, firstName1, lastName1);
          
     if(validPassword.checkPasswordComplexity(Password1)){
     JOptionPane.showMessageDialog(null, "Password captured sucessfully", 
             "Password valid", JOptionPane.PLAIN_MESSAGE);

     Registration = true;
     }
     else{
      JOptionPane.showMessageDialog(null, "Password is not correctly formatted,"
             + " please ensure that your password meet the following criteria:"
             + "\n-The password should contain at least 8 characters"
             + "\n-A capital letter"
             + "\n-A number"
             + "\n-And a special character", 
              "Password not valid", JOptionPane.ERROR_MESSAGE);
       }     
     }
    }
    
    public static void successfulLogin(String Username1, String Password1, String firstName1, String lastName1) {
       
        Login Registered = new Login(Username1, Password1, firstName1, lastName1);
        
        int Login = JOptionPane.showConfirmDialog(null, "Would you like to sign into your account", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
         if(Login==JOptionPane.YES_OPTION){
        Username1 = JOptionPane.showInputDialog(null, "Enter your username:", "Login", JOptionPane.PLAIN_MESSAGE);
        Password1 =JOptionPane.showInputDialog(null, "Enter your password:", "Login", JOptionPane.PLAIN_MESSAGE);
                
          if (Registered.loginUser()) {
                JOptionPane.showMessageDialog(null, "Login successful", "Logged in", JOptionPane.PLAIN_MESSAGE);
            } else {
              
              JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
          }
             
          
        } else if (Login == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Goodbye!", "Output", JOptionPane.PLAIN_MESSAGE);
            System.exit(Login);
        }       
    }
    
    public static void returnMessage(String Username1, String Password1, String firstName1, String lastName1){
       Login Return1 = new Login(Username1, Password1, firstName1, lastName1);
       
       firstName1 = Return1.getFirstName();
       lastName1 = Return1.getLastName();
       
    
        if(Return1.loginUser()){
        JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1) + firstName1 + " " + lastName1 + ", great to see you again", "Successful login", JOptionPane.PLAIN_MESSAGE);
    
        }  
        else{
            JOptionPane.showMessageDialog(null, Return1.returnLoginStatus(Username1, Password1), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
