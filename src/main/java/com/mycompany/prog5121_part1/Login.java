package com.mycompany.prog5121_part1;

public class Login {
   private final String Username1;//Declaring the necessary String variables
   private final String Password1;
   private String Registration;
   private String strUsername;
   private String strPassword;
   private String Name;
   private String Surname;
   private final String firstName1;
   private final String lastName1;
   
   private boolean validPassword; //Declaring Necessary boolean variables
   private boolean validUsername;
   
    public Login(){
    
    this.firstName1 = Name;
    this.lastName1 = Surname;
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
        
      if(validUsername){
          
       return "Username successfully captured";   
      }
      
      else if(!validUsername){
       return """
              The username has been incorrectly formatted, please ensure that your Username has the following criteria: 
              -The username should contain an underscore
              -And it should not be longer than 5 characters""";//If the username is not correct it will return this statement
    }
      else if(validPassword){
          
       return "Password successfully captured";   
      }
        
    else if(!validPassword){
    return """
           The password is not correctly formatted, please ensure that your password has the following criteria: 
           -The password should contain at least 8 characters
           -A capital letter
           -A number
           -And a special character""";//If the password is not correct it will return this statement
      
    }
     else{ 
        return "Error";//If none of the conditions are met this statement will return
    }
    }  
 
    public boolean loginUser(String Username, String Password){
       return Username.equals(strUsername) && Password.equals(strPassword); //This if statement ensures that the login details entered matches the login in detauls stored when the user re
       //If login status matches it returns a true
       //If login status doesnt match it returns a false
    
  }
       
    public String returnLoginStatus(boolean Username, boolean Password){
     if(validPassword == true && validUsername == true){//This if statement checks if the information that the user gave is correct
     return "Welcome " + Name + " " + Surname + " ,it is great to see you again.";//this statement will return if the login is correct
     }
     else{
         return "Username or password is incorrect, please try again";//If the login in is incorrect it will print this statement
     }  
    }
    
}