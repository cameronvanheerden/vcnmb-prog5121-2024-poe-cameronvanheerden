package com.mycompany.prog5121_part1;

public class Login {
    
   private String Username1;//Declaring the necessary String variables
   private String Password1;
   private String strUsername;
   private String strPassword;
   private String strName;
   private String strSurname;
   private boolean Registration;

    public Login(String Username1, String Password1, String strName, String strSurname) {
        
        this.strName = strName;
        this.strSurname = strSurname;
        this.Username1 = Username1;
        this.Password1 = Password1;
        Registration = false;
    }
    
     public boolean checkUserName(String strUsername){
       
    if(strUsername.contains("_")&& strUsername.length()<=5 ){//The condition states that the username has to have an underscore and is not more than 5 characters long
   
        return true;//Returns the whether the conditions have been met
    } 
     return false;
}    

    public boolean checkPasswordComplexity(String strPassword){
           
    if(strPassword.length()>=8 
      && strPassword.matches(".*[A-Z].*") 
      && strPassword.matches(".*[0-9].*")
      && strPassword.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements
    { 
        return true;
    }else{
        
       return false;
    }
   }
   
   public String registerUser(String Username1, String Password1){ 
       boolean validUsername = checkUserName(strUsername);
       boolean validPassword = checkPasswordComplexity(strPassword);
      
     if(!validUsername && !validPassword){
        return "Username is incorrectly formatted and Password doesn't meet complexity requirements";
        
    }else if(!validUsername){
        
        return "Username is incorrectly formatted";
        
    } else if(!validPassword) {
        
        return "Password doesn't meet complexity requirements";
        
    } else{
 
        return "User registered successfully";
    }
       
}


 
   public boolean loginUser(String Username1, String Password1) {
       if(this.Username1.equals(Username1) && this.Password1.equals(Password1)){
           
           return true;
       }
       return false;
}
    
    
    public String returnLoginStatus(String Username1, String Password1){
     if (Username1.equals(this.Username1) && Password1.equals(this.Password1)) {
        return "Welcome ";
        }
     return "Failed login";
    }

  
}