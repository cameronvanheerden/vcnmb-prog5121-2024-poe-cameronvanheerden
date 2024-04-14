package com.mycompany.prog5121_part1;

public class Login {
    
   private String Username1;//Declaring the necessary String variables
   private String Password1;
   private String strUsername;
   private String strPassword;
   private String strName;
   private String strSurname;
   private boolean validPassword;
   private boolean validUsername;
   private boolean Registration;

    public Login(String Username1, String Password1, String strName, String strSurname) {
        
        this.strName = strName;
        this.strSurname = strSurname;
        this.Username1 = strUsername;
        this.Password1 = strPassword;
        Registration = false;
    }

     public void setfirstName(String strName) {
         
        this.strName = strName;
    }

    public void setlastName(String strSurname) {
        
        this.strSurname = strSurname;
    }
    
    public String getFirstName(){
      
        return strName;
    }
    
    public String getLastName(){
    
        return strSurname;
    
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
   
   public String registerUser(){ 
       
      
     if(){
         
     }
         
         
       
}


 
    public boolean loginUser(String Username, String Password){
       if(Username.equals(this.Username1) && Password.equals(this.Password1)){; //This if statement ensures that the login details entered matches the login in detauls stored when the user re
      
       return true;
       }
       else{
             return false;  
       }
    
       
  }
    
    
    public String returnLoginStatus(String Username1, String Password1){
     if (Username1.equals(this.strUsername) && Password1.equals(this.Password1)) {
        return "Welcome ";
        }
     else{
         return "Username or password is incorrect, please try again";
        }
    }
}