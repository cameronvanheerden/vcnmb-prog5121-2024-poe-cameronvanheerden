package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;
public class PROG5121_Part1 {

    public static void main(String[] args) {
        //Before creating the Registration feature allow the user to enter their first name and surname 
        String strfirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
        String strlastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
        
        int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm account creation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
        if(iUserResponse == JOptionPane.YES_OPTION){
        
        JOptionPane.showMessageDialog(null, "You may proceed to create an account.", "Output", JOptionPane.PLAIN_MESSAGE);
        //If they select yes they may proceed with creating the username and the password
        
        
        }
        else if(iUserResponse == JOptionPane.NO_OPTION)
        {
            
        JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.ERROR);
        //If they select no thank the user for using my app
        
        }
        //I am calling the create Username and create Password method within the main method
        createUsername();
        createPassword();
        
        boolean createUsername = true;//Boolean checks if the Username and password entered are correct and if they are correct it will display the welcome message
        boolean createPassword = true;
        
        if(createUsername && createPassword){
            JOptionPane.showMessageDialog(null,"Welcome " + strfirstName + " " + strlastName + ", it is great to see you again!"
                , "Output", JOptionPane.PLAIN_MESSAGE); 
        createUsername = false;
        createPassword = false;
        }
        
        else{
        JOptionPane.showMessageDialog(null, "Username or password is incorrect please try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void createUsername(){
        boolean correctUsername = true;//Checks if the username entered is correct
        while(correctUsername == true)//Start of loop and will loop until username entered is correct
        {
            
    String strUserName = JOptionPane.showInputDialog(null, "Create a username"
            + "\n-The username must contain an underscore \n-Should not be longer than 5 characters.",
            "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
    
    if(strUserName.contains("_")&& strUserName.length()<=5 )//If statement ensures that username contains a underscore and is not longer than 5 characters
    {
    JOptionPane.showMessageDialog(null, "Username captured successfully.", " Success", JOptionPane.PLAIN_MESSAGE);
     
    correctUsername = false;
    }
   
    else{
    JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore"
            + " and is no more than 5 character in length", "Error", JOptionPane.ERROR_MESSAGE);
    }    
    }//end loop
        
    }
    
    public static void createPassword(){
    boolean correctPassword = true;//Checks if the password is correct
    while(correctPassword == true){//Start of loop and will loop until password entered is entered correctly
    
   String strPassword = JOptionPane.showInputDialog(null, "Create a password"
           + "\n-Must be at least 8 Characters long"
           + "\n-Contain a capital letter"
           + "\n-Contain a number"
           + "\n-Contain a special character"
           , "Password Requirements",JOptionPane.INFORMATION_MESSAGE);//Password requirements
           
    if(strPassword.length()>=8 && strPassword.matches(".*[A-Z].*") && strPassword.matches(".*[0-9].*")&&
            strPassword.matches(".*[!,.,&,*,?,@,#,%,$].*")) //If statement checks if password entered meets the requirements
    {
    
        JOptionPane.showMessageDialog(null, "Password successfully captured", "Success", JOptionPane.PLAIN_MESSAGE);
    correctPassword = false;
    }
    
    else{
    JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains"
            + "at least 8 characters, a capital letters, a number and a special character.", "Error", JOptionPane.ERROR_MESSAGE);
    
    }
    
    
      }//end loop
    }
}
