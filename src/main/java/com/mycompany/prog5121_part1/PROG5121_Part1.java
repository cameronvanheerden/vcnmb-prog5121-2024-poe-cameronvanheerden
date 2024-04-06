package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;
public class PROG5121_Part1 {

    public static void main(String[] args) {
        //Before creating the Registration feature allow the user to enter their first name and surname 
        String strfirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
        String strlastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
        
        JOptionPane.showMessageDialog(null,"Welcome " + strfirstName + strlastName, "Output" , JOptionPane.PLAIN_MESSAGE); 
        
        int iUserResponse = JOptionPane.showConfirmDialog(null, "Would you like to create an account?" , "Confirm account creation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//Allow user to choose whether they want to create an account or not
        
        if(iUserResponse == JOptionPane.YES_OPTION){
        
        JOptionPane.showMessageDialog(null, "You may proceed to create a Username and a Password.");//If they select yes they may proceed with creating the username and the password
        
        
        }
        else if(iUserResponse == JOptionPane.NO_OPTION)
        {
            
        JOptionPane.showMessageDialog(null, "Thank you for using my app.");//If they select no thank the user for using my app
        
        }
        
        createUsername();
        createPassword();
    }
    public static void createUsername(){
    
    }
    public static void createPassword(){
    
    
    }
}
