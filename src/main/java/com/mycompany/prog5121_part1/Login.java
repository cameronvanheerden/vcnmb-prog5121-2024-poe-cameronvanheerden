package com.mycompany.prog5121_part1;

public class Login {
   private String Username;//Declaring the necessary String variables
   private String Password;
   
   private boolean validPassword; //Declaring Necessary boolean variables
   private boolean validUsername;
   
    public boolean checkUserName(){
   
    validUsername= false;//Username before user input has been assign to false by default
        
    if(Username.contains("_")&& Username.length()<=5 ){//The condition states that the username has to have an underscore and is not more than 5 characters long
    
    validUsername = true;//If user inputs their username according to the condition it will be true
    } 
    return validUsername;//Returns the whether the conditions have been met 
}    

    public boolean checkPasswordComplexity(){
    validPassword = false;//Password before user input is assigned to false by default
           
    if(Password.length()>=8 && Password.matches(".*[A-Z].*") && Password.matches(".*[0-9].*")&&
            Password.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements
    {
    validPassword = true;//If user inputs their password according to the condition it will be true
    }  
    return validPassword;
    }
    
    public String registerUser(){   
        
    if(validPassword && validUsername){//This if statement checks if the username and password are valid
     return "The User has been registered successfully";
        
    }
    else if(validUsername == false && validPassword == false){
    return "The username has been incorrectly formatted and "
            + "The password does not meet the complexity requirements";//If both conditions are not met this statement will return
    
    }
    else if(validUsername == false)
            {
       return "The username has been incorrectly formatted";//If the username is not correct it will return this statement
    }
    else if(validPassword == false){
    return "The password does not meet the complexity requirements";//If the password is not correct it will return this statement
      
    }
     else{ 
        return "Error";//If none of the conditions are met this statement will return
    }
    }  
 
  
    public boolean loginUser(String inputUsername, String inputPassword){
       return inputPassword.equals(Password) && inputUsername.equals(Username); //This if statement ensures that the login details entered matches the login in detaIls stored when the username and password strings
       //If login status matches it returns
       //If login status doesnt match it returns a false
    }
    
    public String returnLoginStatus(){
     if(validPassword && validUsername){//This if statement checks if the information that the user gave is correct
     return "Login Successful";//this statement will return if the login is correct
     }
     else{
         return "Login failed";//If the login in is incorrect it will print this statement
     }  
    }
    
}