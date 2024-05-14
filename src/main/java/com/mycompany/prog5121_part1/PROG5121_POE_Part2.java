package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
    
    
    public static void main(String[] args) {
        
        String firstName = "";
        String lastName = "";
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome ", JOptionPane.PLAIN_MESSAGE);
        
        while(firstName.isBlank()||lastName.isBlank()){
        firstName = JOptionPane.showInputDialog(null, "Please enter your name:", "Sign up", JOptionPane.PLAIN_MESSAGE);
        lastName = JOptionPane.showInputDialog(null, "Please enter your last name: ", "Sign up", JOptionPane.PLAIN_MESSAGE);
        
        if(firstName.isEmpty())
            JOptionPane.showMessageDialog(null, "First name is required", "Error", JOptionPane.ERROR_MESSAGE);
        
        if(lastName.isEmpty())  
           JOptionPane.showMessageDialog(null, "Last name is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

