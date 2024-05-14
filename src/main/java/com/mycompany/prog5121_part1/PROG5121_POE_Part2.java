package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
       static String firstName = "";
       static String lastName = "";
       static String menuMessage = "Please select an option:\n"
                               + "1.) Add Tasks\n"
                               + "2.) Show Report\n"
                               + "3.) Quit\n";
       
    public static void main(String[] args) {
        
        displayWelcome();
        displayName();  
        JOptionPane.showMessageDialog(null, "Welcome, "+ firstName + " " + lastName+ ", to the adding Tasks feature!" , 
                "Task feature", JOptionPane.PLAIN_MESSAGE);
        displayMenu();
        
        
    }
    
    private static void displayWelcome(){
        
       JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome", JOptionPane.PLAIN_MESSAGE); 
       
    }
    
    private static void displayName(){
              
        while(firstName.isBlank()||lastName.isBlank()){
        firstName = JOptionPane.showInputDialog(null, "Please enter your first name:", "Sign up", JOptionPane.PLAIN_MESSAGE);
        lastName = JOptionPane.showInputDialog(null, "Please enter your last name: ", "Sign up", JOptionPane.PLAIN_MESSAGE);
        
        if(firstName.isEmpty())
            JOptionPane.showMessageDialog(null, "First name is required", "Error", JOptionPane.ERROR_MESSAGE);
        
        if(lastName.isEmpty())  
           JOptionPane.showMessageDialog(null, "Last name is required", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private static int displayMenu(){
        
        String Menu = JOptionPane.showInputDialog(null, menuMessage, "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        
        if(Menu==null){
            
            return 3;
         }
        
       return Integer.parseInt(Menu);
    }
    
    
    
}

