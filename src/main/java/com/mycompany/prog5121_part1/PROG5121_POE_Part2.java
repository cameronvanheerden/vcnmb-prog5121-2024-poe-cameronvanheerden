package com.mycompany.prog5121_part1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PROG5121_POE_Part2 {
       static String firstName = "";
       static String lastName = "";
       static int numericMenu;
       static int taskCounter = 0;
       static String taskNumber;
       static String taskName;
       static String taskDescription;
       static String developerName;
       static String taskDuration;
       static int taskHours;
       static String taskID ="";
       static String options[] = {"Add Task", "Show Report", "Quit"};
       static String statusOptions[] = {"To do", "Done", "Doing"};
       static int choice;
       static int totalHours;
       static List<Task> tasks = new ArrayList();
       
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
        
       JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome", JOptionPane.INFORMATION_MESSAGE); 
       
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
         
        int numTask = 0;
        
        boolean validTaskNumber = false;
        
        while(!validTaskNumber){
            
           taskNumber= JOptionPane.showInputDialog(null, "How many tasks would you like to create?",
                   "Number of Tasks", JOptionPane.PLAIN_MESSAGE);
            
        if(taskNumber==null||taskNumber.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Adding the number of task you would like to create is required",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            numTask = Integer.parseInt(taskNumber);
            validTaskNumber =true;
        }
    }
        
        for(int counter=0; counter<numTask; counter++ ){
         
           addingTasks();
       } 
    }
    private static void addingTasks(){
        
        taskName = createTaskName();
        taskDescription = createTaskDescription();
        developerName = developersDetails();
        taskHours = taskDuration();
        statusOptions[choice] =taskStatus();
        
        Task addingTasks = new Task(taskName, taskDescription, developerName, taskDuration, taskCounter, statusOptions[choice]); 
        
         displayTask();
         goodbyeMessage();
        
    }
          
    private static String createTaskName(){
                     
        taskName="";
        
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
        
        taskDescription= "";
                             
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
             JOptionPane.showMessageDialog(null, "Task successfully captured", "Description captured", JOptionPane.PLAIN_MESSAGE);
             
             break;
            }    
        }
        return taskDescription;
                
    }
    
    private static String developersDetails(){
        
        developerName = "";
        
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
        
        boolean validTime= false;
        
        taskHours = 0;
                     
        while(!validTime){
            
            taskDuration =JOptionPane.showInputDialog(null, "Enter the estimated duration of your task in hours:",
                   "Task Duration", JOptionPane.PLAIN_MESSAGE);
           
           
            if(taskDuration.isEmpty()){
               
               JOptionPane.showMessageDialog(null, "Entering the task duration is required", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                 taskHours = Integer.parseInt(taskDuration);
                 validTime = true;  
            }
        }
        return taskHours;
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
        
       for(Task task: tasks){
            
        JOptionPane.showMessageDialog(null, task.printTaskDetails(), 
                                   "Task Displayed", JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
    private static int totalHours(){
        
        totalHours = 0;
        
        for(Task task: tasks){
            
            totalHours += task.returnTotalHours();
        }
        return totalHours;
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
}