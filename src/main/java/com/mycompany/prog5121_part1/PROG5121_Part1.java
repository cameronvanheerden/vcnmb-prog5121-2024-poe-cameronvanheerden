package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;
public class PROG5121_Part1 {

    public static void main(String[] args) {
         
        String firstName = JOptionPane.showInputDialog(null, "Enter your first name");
        String lastName = JOptionPane.showInputDialog(null, "Enter your last name");
        
        JOptionPane.showMessageDialog(null, "Welcome " + firstName + lastName);
        
        JOptionPane.showConfirmDialog(null, "Would you like to create an account?" ,firstName + lastName, JOptionPane.YES_NO_OPTION);
        
        createUsername();
        createPassword();
    }
    public static void createUsername(){
    
    }
    public static void createPassword(){
    
    
    }
}
