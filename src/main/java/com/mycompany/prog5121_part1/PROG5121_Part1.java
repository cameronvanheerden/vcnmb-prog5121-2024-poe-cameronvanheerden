package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;
public class PROG5121_Part1 {

    public static void main(String[] args) {
        //Before creating the Registration feature allow the user to enter their first name and surname 
        String strfirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
        String strlastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
        
        JOptionPane.showMessageDialog(null,"Welcome " + strfirstName + " " + strlastName +"!", "Output", JOptionPane.PLAIN_MESSAGE); 
        
        int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm account creation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
        if(iUserResponse == JOptionPane.YES_OPTION){
        
        JOptionPane.showMessageDialog(null, "You may proceed to create an account.", "Output", JOptionPane.PLAIN_MESSAGE);//If they select yes they may proceed with creating the username and the password
        
        
        }
        else if(iUserResponse == JOptionPane.NO_OPTION)
        {
            
        JOptionPane.showMessageDialog(null, "Thank you for using my app.", "Output", JOptionPane.ERROR);//If they select no thank the user for using my app
        
        }
        //I am calling the create Username and create Password method within the main method
        createUsername();
        createPassword();
    }
    public static void createUsername(){
    String strUserName = JOptionPane.showInputDialog(null, "Create a username"
            + "\nThe username must contain an underscore & should not be longer than 5 characters.",
            "Username Requirements", JOptionPane.INFORMATION_MESSAGE);
    
    if(strUserName.length()>=5){
    JOptionPane.showMessageDialog(null, "Username captured successfully.", " Success", JOptionPane.PLAIN_MESSAGE);
    
    }
    else{
    JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore"
            + " and is no more than 5 character in length", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    public static void createPassword(){
    
    
    }
}
