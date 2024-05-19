package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
       static String firstName = "";
       static String lastName = "";
       static int numericMenu;
       static String taskNumber;
       static String taskName="";
       static String taskDescription="";
       static String developerName = "";
       static int taskDuration;
       static String taskID ="";
       static String options[] = {"Add Task", "Show Report", "Quit"};
       static String statusOptions[] = {"To do", "Done", "Doing"};
       static int choice;
       
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
              
       return JOptionPane.showOptionDialog(null, "Please select an option:", "Main Menu",
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) +1;
        
}
    private static void addTasks(){
         
        Integer numTask = null;
        
        while(numTask==null){
            
           taskNumber= JOptionPane.showInputDialog(null, "How many tasks would you like to create?",
                   "Number of Tasks", JOptionPane.PLAIN_MESSAGE);
            
        if(taskNumber==null||taskNumber.trim().isEmpty())
            
            JOptionPane.showMessageDialog(null, "Adding the number of task you would like to create is required",
                    "Error", JOptionPane.ERROR_MESSAGE);
        
        else if(isNumeric(taskNumber.trim()))
            numTask = Integer.parseInt(taskNumber.trim());
        
        
        else
            JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
        
}
        
        for(int counter=0; counter<numTask; counter++ ){
           createTask();
           taskStatus();
           displayTask();
           goodbyeMessage();
           System.exit(0);
       } 
    }
    
    private static void createTask(){
        
        taskDescription=null;
        taskName =null;
        
        Task createTask = new Task(taskName, taskNumber, developerName, taskDescription, taskDuration, taskID, choice);
         
        while(taskName == null||taskName.isEmpty()){
        
        taskName=JOptionPane.showInputDialog(null, "Enter your task name:", "Task Name", JOptionPane.PLAIN_MESSAGE); 
            
            if(taskName==null|| taskName.isEmpty())
                JOptionPane.showMessageDialog(null, "Task Name is required", "Error", JOptionPane.ERROR_MESSAGE);
        
         }
         
         
        do{
            taskDescription = JOptionPane.showInputDialog(null, "Enter a short description of the task (Max 50 characters): ", 
                "Task Description", JOptionPane.PLAIN_MESSAGE);
        
        if(taskDescription==null||taskDescription.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Task description is required", "Error", JOptionPane.ERROR_MESSAGE);
            
            taskDescription=null;
        } 
            
       else if(!createTask.checkTaskDescription(taskDescription)){
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters"
                , "Description exceeded limit", JOptionPane.ERROR_MESSAGE);  
        }
        else{
             JOptionPane.showMessageDialog(null, "Task successfully captured", "Description captured", JOptionPane.PLAIN_MESSAGE);
            }    
        }
        while(taskDescription==null||!createTask.checkTaskDescription(taskDescription));
        
        developerName = JOptionPane.showInputDialog(null, "Enter the developers First name and Last name:",
                "Developers Details", JOptionPane.PLAIN_MESSAGE);

        taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of hours the task is estimated to be:",
                "Task Duration", JOptionPane.PLAIN_MESSAGE));
        
        taskID =createTask.createTaskID();
    }
    
    private static String taskStatus(){
        
      choice = JOptionPane.showOptionDialog(null, "Select your Task Status: ", "Task Status", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);
       
        if(choice >= 0 && choice < statusOptions.length ){
            
          return statusOptions[choice];  
        }     
        else{
                
          return "Invalid choice";
        }   
    }  
    
    private static void displayTask(){
        
        Task displayTask = new Task(taskName, taskNumber, developerName, taskDescription, taskDuration, taskID, choice);
            
        JOptionPane.showMessageDialog(null,displayTask.printTaskDetails(), 
                                   "Task Displayed", JOptionPane.INFORMATION_MESSAGE);
        
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
        
        if(quit==JOptionPane.NO_OPTION){
            displayMenu();
        }
    }
    
    private static void goodbyeMessage(){
        
        JOptionPane.showMessageDialog(null, "Thank you for using my adding Tasks feature program", "Goodbye", JOptionPane.PLAIN_MESSAGE);
    }

    private static boolean isNumeric(String numeric) {
     
        return numeric.matches("\\d+");
        
    }
}

