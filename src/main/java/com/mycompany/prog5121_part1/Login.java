package com.mycompany.prog5121_part1;

public class Login {
   // Declaring the necessary String variables 
   private String Username1;//Declaring the necessary String variables
   private String Password1;
   private String strUsername;
   private String strPassword;
   private String strName;
   private String strSurname;
   private boolean Registration;

    public Login(String Username1, String Password1, String strName, String strSurname) {//Constructor for login class(GeeksforGeeks, 2024)
        
        this.strName = strName;//(GeeksforGeeks, 2024)
        this.strSurname = strSurname;//(GeeksforGeeks, 2024)
        this.Username1 = Username1;//(GeeksforGeeks, 2024)
        this.Password1 = Password1;//(GeeksforGeeks, 2024)
        Registration = false;//(GeeksforGeeks, 2024)
    }
    
     public boolean checkUserName(String strUsername){
       
    if(strUsername.contains("_")&& strUsername.length()<=5 ){//The condition states that the username has to have an underscore and is not more than 5 characters long(Stackoverflow, 2016)
   
        return true;//Returns the whether the conditions have been met
    } 
     return false;//Returns false if otherwise
}    

    public boolean checkPasswordComplexity(String strPassword){
           
    if(strPassword.length()>=8 
      && strPassword.matches(".*[A-Z].*") 
      && strPassword.matches(".*[0-9].*")
      && strPassword.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements(Stackoverflow, 2016)
    { 
        return true;// Return true if the requirements are met
    }else{
        
       return false;//Returns false if otherwise
    }
   }
   
   public String registerUser(String Username1, String Password1){  //Method to register new user (Wanvig, 2021)     
    // If the username is correctly formatted, check if the password meets the complexity requirements it returns string variables  
    if(checkUserName(Username1)){
             
      return "Welcome <user first name>, <user last name> it is great to see you.";
    } 
    
    else if(!checkUserName(Username1)){//(Wanvig, 2021)
        return "Username is not correctly formatted, please ensure that your username contains an underscore"
                + " and is no more than 5 characters in length.";  
        
    }
     if(checkPasswordComplexity(Password1)){//(Wanvig, 2021)
        return "Password captured successfully";
    } 

    else if(!checkPasswordComplexity(Password1)){//(Wanvig, 2021)
    
    return "Password is not correctly formatted, please ensure that the password contains at least 8"
             + " characters, a capital letter, a number and a special character.";
    }
        else {
        return "Error";
    }
}


 
   public boolean loginUser(String Username1, String Password1) {//Method to login user
       if(this.Username1.equals(Username1) && this.Password1.equals(Password1)){// Check if the username and password match the stored values(Stackoverflow, 2016)
           
           return true;// Return true if the values match
       }
       return false;
}
    
    
    public String returnLoginStatus(String Username1, String Password1){ // Method to return a message indicating whether the login was successful or not
     if (Username1.equals(this.Username1) && Password1.equals(this.Password1)) {//(Stackoverflow, 2016)
        return "Welcome ";//If true it displays message welcome
        }
     return "Failed login";//If false it displays failed login message
    }

  
}