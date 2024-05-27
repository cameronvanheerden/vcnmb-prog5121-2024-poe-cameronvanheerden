package com.mycompany.prog5121_part1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
       static int taskCounter = 1;
       static String statusOptions[] = {"To do", "Done", "Doing"};
       static List<Task> tasks = new ArrayList();
       
    public static void main(String[] args) {
        int choice;
        boolean quit = false;
        
        displayWelcome();
        displayName();  
        do{choice = displayMenu();
        
            switch(choice){
                case 1: 
                    addTasks();
                break;
                
                case 2: 
                    showReport();
                break;
                
                case 3:
                    quit = confirmQuit();
                    if(quit){
                    goodbyeMessage();
                    }
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Please select again", JOptionPane.ERROR_MESSAGE);
                    
            }
    }
        while(!quit);
        
    }
    private static void displayWelcome(){
        
       JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome", JOptionPane.INFORMATION_MESSAGE); 
       
    }
    
    private static void displayName(){
        String firstName = "";
        String lastName = "";
        
        while(firstName.isBlank()||lastName.isBlank()){
        firstName = JOptionPane.showInputDialog(null, "Please enter your first name:", "Login", JOptionPane.PLAIN_MESSAGE);
        lastName = JOptionPane.showInputDialog(null, "Please enter your last name: ", "Login", JOptionPane.PLAIN_MESSAGE);
        
        if(firstName.isEmpty())
            JOptionPane.showMessageDialog(null, "First name is required", "Error", JOptionPane.ERROR_MESSAGE);
        
        if(lastName.isEmpty())  
           JOptionPane.showMessageDialog(null, "Last name is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null, "Welcome, "+ firstName + " " + lastName+ ", to the adding Tasks feature!" , 
                "Task feature", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    private static int displayMenu(){
        String options[] = {"Add Task", "Show Report", "Quit"};
              
       int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "Main Menu",
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       return choice +1;
        
    }
    private static void addTasks(){
        
        int taskNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to create?",
                   "Number of Tasks", JOptionPane.PLAIN_MESSAGE));
          
        for(int counter=0; counter<taskNumber; counter++ ){
         
           addingTasks();
       } 
        
        JOptionPane.showMessageDialog(null, "The Total combined hours of all tasks: " + Task.returnTotalHours(tasks)
                + " Total Hours", "Combined hours", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void addingTasks(){
        
        String taskName = createTaskName();
        String taskDescription = createTaskDescription();
        String developerName = developersDetails();
        int taskDuration = taskDuration();
        String taskStatus =taskStatus();
        String taskID = createTaskID(taskName, developerName);
        
        
        Task addingTasks = new Task(taskCounter, taskName, taskDescription, developerName, taskDuration, taskStatus, taskID); 
        
        if(addingTasks.checkTaskDescription()){
            tasks.add(addingTasks);
            taskCounter++;
                JOptionPane.showMessageDialog(null, "Task captured successfully", "Task Description captured", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Task description is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         displayTask(addingTasks);
         
        
    }
          
    private static String createTaskName(){
                     
        String taskName="";
        
        boolean validName=false;
                        
        while(!validName){
        
        taskName=JOptionPane.showInputDialog(null, "Enter your task name:", "Task Name", JOptionPane.PLAIN_MESSAGE); 
            
            if(taskName==null|| taskName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Task Name is required", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{    
                validName=true;
            }
        }  
        return taskName;
    }  
      
    
    private static String createTaskDescription(){
        
         String taskDescription= "";
                             
         while(true){
            taskDescription = JOptionPane.showInputDialog(null, "Enter a short description of the task (Max 50 characters): ", 
                "Task Description", JOptionPane.PLAIN_MESSAGE);
        
        if(taskDescription.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Task description is required", "Error", JOptionPane.ERROR_MESSAGE);
            
        } 
            
       else if(taskDescription.length()>50){
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters"
                , "Description exceeded limit", JOptionPane.ERROR_MESSAGE);  
        }
        else{
             JOptionPane.showMessageDialog(null, "Task successfully captured", "Task Description captured", JOptionPane.INFORMATION_MESSAGE);
             
             break;
            }    
        }
        return taskDescription;
                
    }
    
    private static String developersDetails(){
        
       String developerName = "";
        
        boolean validDetails = false;
                
        while(!validDetails){
        
        developerName = JOptionPane.showInputDialog(null, "Enter the developers first name and last name:",
                "Developers Details", JOptionPane.PLAIN_MESSAGE);
        
        if(developerName==null||developerName.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "The developers details are required","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{ 
            validDetails=true;
        } 
        }
        return developerName;
    }
    
    private static int taskDuration(){
       
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the estimated duration of your task in hours:",
                   "Task Duration", JOptionPane.PLAIN_MESSAGE));
    }
    
    private static String createTaskID(String taskName, String developerName){
        
        
        return taskName.substring(0 , 2).toUpperCase()+ ":" + taskCounter + ":"+ developerName.substring(developerName.length() - 3).toUpperCase();
    }
    
    
    private static String taskStatus(){
        
      int choice = JOptionPane.showOptionDialog(null, "Select your Task Status: ", "Task Status", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);
               
          return statusOptions[choice];  
    }  
    
    private static void displayTask(Task tasks){
        
        JOptionPane.showMessageDialog(null, tasks.printTaskDetails(), 
                                   "Task Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void showReport(){
        
        JOptionPane.showMessageDialog(null, "Coming soon....", "Report", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private static boolean confirmQuit(){
        
        int confirmQuit = JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit the program?",
                "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
      
        return confirmQuit ==JOptionPane.YES_OPTION;
    }
    
    private static void goodbyeMessage(){
        
        JOptionPane.showMessageDialog(null, "Thank you for using my adding Tasks feature program", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }
}