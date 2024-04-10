package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class Login {
   private String firstName;//Declaring Necessary string variables
   private String lastName;
   private String Username;
   private String Password;
   private String Registration;
   
   private int UserResponse;//Declaring Necessary integar variable
   
   private boolean validPassword; //Declaring Necessary boolean variables
   private boolean validUsername;
   private boolean verifyLogin;
   
   
   public void fullName(){
   //Before creating the Registration feature allow the user to enter their first name and surname 
   firstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
   lastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
        
   }
   
   public int accountCreation(int iUserInput){
    UserResponse = iUserInput;
    
    iUserInput = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm account creation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
    if(iUserInput == JOptionPane.YES_OPTION){
        
    JOptionPane.showMessageDialog(null, "You may proceed to create an account.", "Output", JOptionPane.PLAIN_MESSAGE);
        //If they select yes they may proceed with creating the username and the password
        
        
    }
    else if(iUserInput == JOptionPane.NO_OPTION)
    {
            
    JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.ERROR);
        //If they select no thank the user for using my app
      
   }
    return UserResponse;
   }
   
    public boolean checkUserName(){
   
    validUsername=true;
    
    while(validUsername == true){
        
    Username = JOptionPane.showInputDialog(null, "Create a username"
            + "\n-The username must contain an underscore \n-Should not be longer than 5 characters.",
            "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
    
    if(Username.contains("_")&& Username.length()<=5 ){
    
    JOptionPane.showMessageDialog(null, "Username captured successfully.", "Username successfully created", JOptionPane.PLAIN_MESSAGE);
     
    validUsername = false;   
    }
    else{
    JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore"
            + " and is no more than 5 character in length", "Error", JOptionPane.ERROR_MESSAGE);
    }    
       
}
     return validUsername;  
}    

    public boolean checkPasswordComplexity(){
    validPassword = true;
    
    while(validPassword ==true ){
        String Password = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
           
    if(Password.length()>=8 && Password.matches(".*[A-Z].*") && Password.matches(".*[0-9].*")&&
            Password.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements
    {
    
        JOptionPane.showMessageDialog(null, "Password successfully captured", "Password successfully created", JOptionPane.PLAIN_MESSAGE);
    validPassword = false;
    }
    
    else{
    JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains"
            + " at least 8 characters, a capital letters, a number and a special character.", "Error", JOptionPane.ERROR_MESSAGE);
    
    }    
    }
    return validPassword;
    }
    
    public String registerUser(){ 
                
    if(validPassword && validUsername){//This if statement checks if the username and password are valid
        JOptionPane.showMessageDialog(null, "The user has successfully been registered.", "Registered", JOptionPane.PLAIN_MESSAGE);
        Registration = "Success";//If true this is the registration status
    }
    else{
        JOptionPane.showMessageDialog(null, "The username has been incorrectly formatted or"
                + "The password did not meet the complexity requirements.", "Error", JOptionPane.ERROR_MESSAGE);
        Registration = "Error";//If false this is the registration status
        }
      
        return Registration;//This return function returns the registration status 
    }
  
    public boolean loginUser(String inputUsername, String inputPassword){
     if(inputUsername.equals(Username) && inputPassword.equals(Password)){ //This if statement ensures that the login details entered matches the login in detauls stored when the user re
         JOptionPane.showMessageDialog(null, "Login details entered are correct", "Login successful", JOptionPane.PLAIN_MESSAGE);
     
      return true;//If login status matches it returns a true
     }
     else{
         JOptionPane.showMessageDialog(null, "Login details are incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        
     return false;//If login status doesnt match it returns a false
     }
    
  }
    
    public String returnLoginStatus(){
   
    }
    
}