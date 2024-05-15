package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
       static String firstName = "";
       static String lastName = "";
       static int numericMenu;
       static int numTask;
       
    public static void main(String[] args) {
        
        displayWelcome();
        displayName();  
        do{numericMenu = displayMenu();
        
            switch(numericMenu){
                case 1: 
                    addTasks();
                break;
                
                case 2: 
                    showReport();
                break;
                
                case 3:
                    confirmQuit();
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Please select again", JOptionPane.ERROR_MESSAGE);
                    
            }
    }
        while(numericMenu != 3);
        
        goodbyeMessage();
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
        
        JOptionPane.showMessageDialog(null, "Welcome, "+ firstName + " " + lastName+ ", to the adding Tasks feature!" , 
                "Task feature", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    private static int displayMenu(){
       String[] options = {"Add Task", "Show Report", "Quit"};
        
       return JOptionPane.showOptionDialog(null, "Please select an option:", "Main Menu",
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) +1;
        
}
    private static void addTasks(){
        
        numTask = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to create",
                   "Input", JOptionPane.PLAIN_MESSAGE));
       /* Task[] tasks = new Task[numTask];
        
        for(){
            
        } */       
    }
    
    private static void showReport(){
        JOptionPane.showMessageDialog(null, "Coming soon", "Report", JOptionPane.INFORMATION_MESSAGE);
        
        goodbyeMessage();
        System.exit(0);
    }
    
    private static void confirmQuit(){
        
        int quit = JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit the program?",
                "Confirm Quit", JOptionPane.YES_NO_OPTION);
        
        if(quit==JOptionPane.YES_OPTION) {
            
            goodbyeMessage();
            System.exit(0);
        }
        
        if(quit==JOptionPane.NO_OPTION)
            displayMenu();
            
    }
    
    private static void goodbyeMessage(){
        
        JOptionPane.showMessageDialog(null, "Thank you for using my adding Tasks feature program", "Goodbye", JOptionPane.PLAIN_MESSAGE);
    }
}
