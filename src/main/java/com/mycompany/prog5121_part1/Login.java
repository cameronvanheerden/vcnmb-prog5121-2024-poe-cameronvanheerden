package com.mycompany.prog5121_part1;

public class Login {
   private String Username1;//Declaring the necessary String variables
   private String Password1;
   private String Registration;
   
   private boolean validPassword; //Declaring Necessary boolean variables
   private boolean validUsername;
   private String strUsername;
   private String strPassword;
    
    public Login(String Username, String Password){
    
    this.Username1 = strUsername;   
    this.Password1 = strPassword;
    
    }
   
     public boolean checkUserName(String strUsername){
   
    validUsername= false;//Username before user input has been assign to false by default
        
    if(strUsername.contains("_")&& strUsername.length()<=5 ){//The condition states that the username has to have an underscore and is not more than 5 characters long
    
    validUsername = true;//If user inputs their username according to the condition it will be true
    } 
    return validUsername;//Returns the whether the conditions have been met 
}    

    public boolean checkPasswordComplexity(String strPassword){
    validPassword = false;//Password before user input is assigned to false by default
           
    if(strPassword.length()>=8 && strPassword.matches(".*[A-Z].*") && strPassword.matches(".*[0-9].*")&&
            strPassword.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements
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
 
    public boolean loginUser(String Username, String Password){
     if(Username.equals(strUsername) && Password.equals(strPassword)){ //This if statement ensures that the login details entered matches the login in detauls stored when the user re
          
      return true;//If login status matches it returns a true
     }
     else{
         
     return false;//If login status doesnt match it returns a false
     }
    
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