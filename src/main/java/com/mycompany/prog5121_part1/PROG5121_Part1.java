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
     successfulLogin(); 
     }
      else if(iUserResponse == JOptionPane.NO_OPTION)
     {
            
     JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.PLAIN_MESSAGE);
      //If they select no thank the user for using my app
           
      System.exit(iUserResponse);//Exits the program without continuing
      
      }
     
    }
     public static void Name(){
         String firstName = ""; 
         String lastName = "";
         
         while(firstName.isEmpty() || lastName.isEmpty()){
         firstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
         lastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
         
         if(firstName.isBlank()|| lastName.isBlank()){
             JOptionPane.showMessageDialog(null, "First name and Last name is required",
                     "Retry", JOptionPane.ERROR_MESSAGE);     
         }
    }
   }
     
    public static void createUsername(){
    String Username1;
    String Password1 = "";
    boolean correctUsername = false; 
                               
    Username1 = JOptionPane.showInputDialog(null, "Create a username"
                + "\n-The username must contain an underscore \n-Should not be longer than 5 characters.",
                "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
     
     Login validUsername = new Login ();
     
     while(!correctUsername) {       
     if(validUsername.checkUserName(Username1)==true){
         
     JOptionPane.showMessageDialog(null, validUsername.registerUser(),
             "Username valid", JOptionPane.PLAIN_MESSAGE);
     
     correctUsername = true;
     }
    
     else{
     JOptionPane.showMessageDialog(null, validUsername.registerUser(),
             "Username not valid", JOptionPane.ERROR_MESSAGE);
     
     Username1 = JOptionPane.showInputDialog(null, "Create a username"
                + "\n-The username must contain an underscore \n-Should not be longer than 5 characters.",
                "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
    
     validUsername.checkUserName(Username1);
     }
    }
   }        
     
    public static void createPassword(){
        
        String Username1 = "";
        String Password1;
        boolean correctPassword = false;
                    
     Password1 = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
     
    Login validPassword =  new Login();
    
     while(!correctPassword){       
         
     if(validPassword.checkPasswordComplexity(Password1)==true){
     JOptionPane.showMessageDialog(null, validPassword.registerUser(), 
             "Password valid", JOptionPane.PLAIN_MESSAGE);

    correctPassword = true;
     }
     else{
      JOptionPane.showMessageDialog(null, validPassword.registerUser(), 
              "Password not valid", JOptionPane.ERROR_MESSAGE);
      
      Password1 = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
      
      validPassword.checkPasswordComplexity(Password1);
         
     }     
   }
    }
    
    public static void successfulLogin(){
        String Username1 = "";
        String Password1 = ""; 
        
        Login Registered = new Login(); 
        
        if(Registered.loginUser(Username1, Password1)){
            
        JOptionPane.showMessageDialog(null, Registered.registerUser(), 
                "Account created successfully", JOptionPane.PLAIN_MESSAGE);
        }
        
}
    
    /*public static void LoginStatus(){
        
        Login Status = new Login ();
        if()
        {
            JOptionPane.showMessageDialog(null, Status.returnLoginStatus(), "Successfully logged in", 0);
        }
    
        else {
            
}
}*/
}