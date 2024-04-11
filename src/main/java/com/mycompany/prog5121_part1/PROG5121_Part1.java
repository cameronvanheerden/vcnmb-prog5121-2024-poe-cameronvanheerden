package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_Part1 {
    
    public static void main(String[] args) {   
        
      int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
       if(iUserResponse == JOptionPane.YES_OPTION){

     Name(); //Calling this method within the main method
     createUsername();
     createPassword();
     
     }
      else if(iUserResponse == JOptionPane.NO_OPTION)
     {
            
     JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.PLAIN_MESSAGE);
      //If they select no thank the user for using my app
        
      System.exit(iUserResponse);//Exits the program without continuing 
      
      }
     
    }
     public static void Name(){
         String firstName;
         String lastName;
         
         firstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
         lastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
       
    }
     
    public static void createUsername(){
    String Username1;
    String Password1 = "";
                       
    Username1 = JOptionPane.showInputDialog(null, "Create a username"
                + "\n-The username must contain an underscore \n-Should not be longer than 5 characters.",
                "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
     
     Login validUsername = new Login (Username1, Password1);
          
     if(validUsername.checkUserName(Username1)==true){
     JOptionPane.showMessageDialog(null, "Username successfully captured", "Username valid", JOptionPane.PLAIN_MESSAGE);
     }
     else if(validUsername.checkUserName(Username1)==false){
     JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that "
             + "your username contains an underscore and is no more than 5 characters in length.",
             "Username not valid", JOptionPane.ERROR_MESSAGE);
     }
    }
          
    public static void createPassword(){
        
        String Username2 = "";
        String Password2;
                    
     Password2 = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
     
    Login validPassword =  new Login(Username2, Password2);
             
     if(validPassword.checkPasswordComplexity(Password2)==true){
     JOptionPane.showMessageDialog(null, "Password successfully captured", "Password valid", JOptionPane.PLAIN_MESSAGE);
     
     }
     else if(validPassword.checkPasswordComplexity(Password2)==false){
      JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password"
              + " contains at least 8 characters, a capital letter, a number and a special character.", "Password not valid", JOptionPane.ERROR_MESSAGE);
         
     }     
}
}
