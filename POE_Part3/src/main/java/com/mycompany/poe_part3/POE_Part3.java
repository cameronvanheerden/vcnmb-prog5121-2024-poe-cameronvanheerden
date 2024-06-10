package com.mycompany.poe_part3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class POE_Part3 {

       // Static variables to keep track of task count, status options, and a list to store tasks
       static int taskCounter = 0;
       static String statusOptions[] = {"To do", "Done", "Doing"};//(Farrell, 2018)
       static List<Task> tasks = new ArrayList();//(GeeksforGeeks, 2021)
       static List<String> taskStatusArray = new ArrayList<>();
       static List<String> developerArray = new ArrayList<>();
       static List<String> taskNameArray = new ArrayList<>();
       static List<String> taskIDArray = new ArrayList<>();
       static List<Integer> taskDurationArray = new ArrayList<>(); 
       
    public static void main(String[] args) {
        int choice;
        boolean quit = false;
        
        displayWelcome();
        do{choice = displayMenu();// Main loop to display menu and perform actions based on user choice//(Farrell, 2018)
        
            switch(choice){//(Farrell, 2018)
                case 1: 
                    addTasks();// Add tasks
                break;
                
                case 2: 
                    showReport();// Show report(placeholder)
                break;
                
                case 3:
                    quit = confirmQuit();// Confirm and quit program
                    if(quit){
                    goodbyeMessage();// Display goodbye message
                    }
                break;//(Farrell, 2018)
                
                default://(Farrell, 2018)
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Please select again", JOptionPane.ERROR_MESSAGE);//(Wanvig, 2021)
                    
            }
    }
        while(!quit);
        
    }
    private static void displayWelcome(){// Display welcome message
        
       JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.", "Welcome", JOptionPane.INFORMATION_MESSAGE); //(Wanvig, 2021)
       
    }
    
    private static int displayMenu(){// Display the main menu and return the user's choice
        String options[] = {"Add Task", "Show Report", "Quit"};//(Farrell, 2018)
              
       int choice = JOptionPane.showOptionDialog(null, "Please select an option:", "Main Menu",
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);//(Farrell, 2018)
       
       return choice +1;// +1 to match switch case values//(Farrell, 2018)
        
    }
    private static void addTasks(){// Prompt user for the number of tasks to add
        
        int taskNumber=Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to create?",
                   "Number of Tasks", JOptionPane.PLAIN_MESSAGE));//(Wanvig, 2021)
          
        for(int counter=0; counter<taskNumber; counter++ ){// Loop to add the specified number of tasks//(Farrell, 2018)
         
           addingTasks();// Adding each task
       } 
        
        JOptionPane.showMessageDialog(null, "The Total combined hours of all tasks: " + Task.returnTotalHours(tasks)
                + " Total Hours", "Combined hours", JOptionPane.INFORMATION_MESSAGE);// Display total hours of all tasks//(Wanvig, 2021)
    }
    
    private static void addingTasks(){// Add a single task by gathering all required information
       
        String taskName = createTaskName();
        String taskDescription = createTaskDescription();
        String developerName = developersDetails();
        int taskDuration = taskDuration();
        String taskStatus =taskStatus();
        String taskID = createTaskID(taskName, developerName);
        
        // Create a new Task object and add it to the tasks list if valid
        Task addingTasks = new Task(taskCounter, taskName, taskDescription, developerName, taskDuration, taskStatus, taskID); //(GeeksforGeeks, 2023)
        
        if(addingTasks.checkTaskDescription()){// Check if task description is valid and add task to the list
            tasks.add(addingTasks);//(GeeksforGeeks, 2021)
            taskCounter++;// Increment task counter for the next task//(Farrell, 2018)
                JOptionPane.showMessageDialog(null, "Task captured successfully", "Task Description captured", JOptionPane.INFORMATION_MESSAGE);//(Wanvig, 2021)
        }
        else{
            JOptionPane.showMessageDialog(null, "Task description is required", "Error", JOptionPane.ERROR_MESSAGE);//(Wanvig, 2021)
        }
        
         displayTask(addingTasks);// Display task details
         
        
    }
          
    private static String createTaskName(){// Prompt user for task name
                     
        String taskName="";
        
        boolean validName=false;
                        
        while(!validName){// Ensure task name is not empty//(Farrell, 2018)
        
        taskName=JOptionPane.showInputDialog(null, "Enter your task name:", "Task Name", JOptionPane.PLAIN_MESSAGE); 
            
            if(taskName==null|| taskName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Task Name is required", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{    
                validName=true;//(Farrell, 2018)
            }
        }  
        return taskName;//(Farrell, 2018)
    }  
      
    
    private static String createTaskDescription(){// Prompt user for task description

        
         String taskDescription= "";
                             
         while(true){// Ensure task description is within 50 characters and not empty
            taskDescription = JOptionPane.showInputDialog(null, "Enter a short description of the task (Max 50 characters): ", 
                "Task Description", JOptionPane.PLAIN_MESSAGE);//(Farrell, 2018)
        
        if(taskDescription.isEmpty()){//(Farrell, 2018)
            
            JOptionPane.showMessageDialog(null, "Task description is required", "Error", JOptionPane.ERROR_MESSAGE);
            
        } 
            
       else if(taskDescription.length()>50){//(Farrell, 2018)
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters"
                , "Description exceeded limit", JOptionPane.ERROR_MESSAGE);  //(Wanvig, 2021)
        }
        else{//(Farrell, 2018)
             JOptionPane.showMessageDialog(null, "Task successfully captured", "Task Description captured", JOptionPane.INFORMATION_MESSAGE);//(Wanvig, 2021)
             
             break;// Exit loop when a valid description is entered//(Farrell, 2018)
            }    
        }
        return taskDescription;//(Farrell, 2018)
                
    }
    
    private static String developersDetails(){//Prompts the user to enter their name and surname
        
       String developerName = "";
        
        boolean validDetails = false;
                
        while(!validDetails){// Ensure developer name is not empty//(Farrell, 2018)
        
        developerName = JOptionPane.showInputDialog(null, "Enter the developers first name and last name:",
                "Developers Details", JOptionPane.PLAIN_MESSAGE);//(Wanvig, 2021)
        
        if(developerName==null||developerName.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "The developers details are required","Error",JOptionPane.ERROR_MESSAGE);//(Wanvig, 2021)
        }
        else{ 
            validDetails=true;//(Farrell, 2018)
        } 
        }
        return developerName;//(Farrell, 2018)
    }
    
    private static int taskDuration(){// Prompt user for task duration in hours

       
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the estimated duration of your task in hours:",
                   "Task Duration", JOptionPane.PLAIN_MESSAGE));//(Farrell, 2018)//(Wanvig, 2021)
    }
    
    // Create a unique task ID using the task name and developer details
    private static String createTaskID(String taskName, String developerName){
        
        return taskName.substring(0 , 2).toUpperCase()+ ":" + taskCounter + ":"+ developerName.substring(developerName.length() - 3).toUpperCase();//(Farrell, 2018)
    }
    
    
    private static String taskStatus(){// Prompt user to select their task status from 3 different options

        
      int choice = JOptionPane.showOptionDialog(null, "Select your Task Status: ", "Task Status", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);
               
          return statusOptions[choice];  //(Farrell, 2018)
    }  
    
    private static void displayTask(Task tasks){// Display task details in a message dialog

        
        JOptionPane.showMessageDialog(null, tasks.printTaskDetails(), 
                                   "Task Details", JOptionPane.INFORMATION_MESSAGE);//(Wanvig, 2021)
    }
    
    private static void showReport(){// Placeholder for showing report and shows user that the report is coming soon

    String reportOptions[] = {  "Full report",
                                "Display Done Tasks",
                                "Longest Duration Task", 
                                "Search Task by Name", 
                                "Search Tasks by Developer", 
                                "Delete Task by Name", 
                                "Back to Main Menu"};    
    
    int reportChoice;
    boolean backToMenu = false;
    
    while(!backToMenu){
        
        reportChoice = JOptionPane.showOptionDialog(null, "Please select a report option:", "Report Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, reportOptions, reportOptions[0]);
        
        switch(reportChoice){
            case 0: displayFullReport();
            break;
            
            case 1: displayDoneTasks();
            break;
        }
        
    }
    
    }
    
    private static void displayFullReport(){
        
        StringBuilder report =  new StringBuilder("Full report of all Tasks: \n\n");
        
        for(Task task: tasks){
            
            report.append(task.printTaskDetails()).append("\n\n");
        }
        
        JOptionPane.showMessageDialog(null, report.toString(), "Full Report", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void displayDoneTasks(){
        
        StringBuilder doneTasks = new StringBuilder("Tasks that have been completed: \n");
        
        for(int i = 0; i < taskStatusArray.size(); i++){
            
            if(taskStatusArray.get(i).equals("Done")){
                
                doneTasks.append("Developer: ").append(str)
                
                
            } 
        }
    }   
     
    private static boolean confirmQuit(){// Confirm with the user if they want to quit the program
        
        int confirmQuit = JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit the program?",
                "Confirm Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//(Wanvig, 2021)
        
      
        return confirmQuit ==JOptionPane.YES_OPTION;//(Farrell, 2018)
    }
    
    private static void goodbyeMessage(){// Display goodbye message
        
        JOptionPane.showMessageDialog(null, "Thank you for using my adding Tasks feature program", "Goodbye", JOptionPane.INFORMATION_MESSAGE);//(Wanvig, 2021)
    }
}

/*
References List
Farrell, J., 2018. Java Programming. 9 ed. Boston: Cengage Learning.
GeeksforGeeks, 2021. Creating an ArrayList with Multiple Object Types in Java. [Online] 
Available at: https://www.geeksforgeeks.org/creating-an-arraylist-with-multiple-object-types-in-java/
[Accessed 25 May 2024].
GeeksforGeeks, 2023. Classes and Objects in Java. [Online] 
Available at: https://www.geeksforgeeks.org/classes-objects-java/
[Accessed 25 May 2024].
GeeksforGeeks, 2024. Java Constructors. [Online] 
Available at: https://www.geeksforgeeks.org/constructors-in-java/
[Accessed 25 May 2024].
Wanvig, R., 2021. PROG5212 LU1 -J OptionPane, Port Elizabeth: IIEVC School of Computer Science.
Wanvig, R., 2022. Basic Unit testing example, Port Elizabeth: IIEVC School of Computer Science .
*/
