package com.mycompany.poe_part3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class POE_Part3 {

       // Static variables to keep track of task count, status options, and a list to store tasks
       static int taskCounter = 0;
       static String statusOptions[] = {"To do", "Done", "Doing"};//(Farrell, 2018)
       static List<Task> tasks = new ArrayList();//(GeeksforGeeks, 2021)
       public static List<String> taskStatusArray = new ArrayList<>();//List to store task statuses(GeeksforGeeks, 2024)
       public static List<String> developerArray = new ArrayList<>();// List to store developer names(GeeksforGeeks, 2024)
       public static List<String> taskNameArray = new ArrayList<>();// List to store task names(GeeksforGeeks, 2024)
       public static List<String> taskIDArray = new ArrayList<>();// List to store task IDs(GeeksforGeeks, 2024)
       public static List<Integer> taskDurationArray = new ArrayList<>(); // List to store task durations(GeeksforGeeks, 2024)
       
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
            developerArray.add(developerName);//Adds new developer name to the list to be stored(GeeksforGeeks, 2024)
            taskNameArray.add(taskName);//Adds new task name to the list to be store(GeeksforGeeks, 2024)
            taskIDArray.add(taskID);//Adds new task ID to list to be stored(GeeksforGeeks, 2024)
            taskDurationArray.add(taskDuration);//Adds new task duration to the list to be stored(GeeksforGeeks, 2024)
            taskStatusArray.add(taskStatus);//Adds new task statuses to the list to be stored(GeeksforGeeks, 2024)
            
                JOptionPane.showMessageDialog(null, "Task captured successfully", "Task captured", JOptionPane.INFORMATION_MESSAGE);//(Wanvig, 2021)
        }
        else{
            JOptionPane.showMessageDialog(null, "Task not captured", "Error", JOptionPane.ERROR_MESSAGE);//(Wanvig, 2021)
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
    
    private static void showReport(){//New show report method that displays options for the user to select

    String reportOptions[] = {  "Full report",
                                "Display Done Tasks",
                                "Longest Duration Task", 
                                "Search Task by Task Name", 
                                "Search Tasks by Developer", 
                                "Delete Task using Task Name", 
                                "Back to Main Menu"};//(GeeksforGeeks, 2023)    
    
    int reportChoice;
    boolean backToMenu = false;
    
    while(!backToMenu){//Loop continues until back to menu has been selected by the user// (Farrell, 2018)
        
        reportChoice = JOptionPane.showOptionDialog(null, "Please select a report option:", "Report Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, reportOptions, reportOptions[0]);// (Farrell, 2018)
        
        //Switch statement holds the methods that are going to be used when the user selects an option
        switch(reportChoice){// (Farrell, 2018)
            
            case 0: displayFullReport();
            break;// (Farrell, 2018)
            
            case 1: displayDoneTasks();
            break;// (Farrell, 2018)
            
            case 2: displayTaskDuration();
            break;// (Farrell, 2018)
            
            case 3: searchTaskByName();
            break;// (Farrell, 2018)
            
            case 4: searchTaskByDeveloper();
            break;// (Farrell, 2018)
            
            case 5: deleteTaskNames();
            break;// (Farrell, 2018)
            
            case 6: backToMenu = true;
            break;// (Farrell, 2018)
            
            default: 
                JOptionPane.showMessageDialog(null, "Invalid choice", "Please Select again", JOptionPane.ERROR_MESSAGE);// (Farrell, 2018)
        }
        
    }
    
    }
    
    private static void displayFullReport(){ // Display full report of all tasks
        
        StringBuilder report =  new StringBuilder("Full report of all Tasks: \n\n");//(GeeksforGeeks, 2023)
        
        for(Task task: tasks){// (Farrell, 2018)
            
            report.append(task.printTaskDetails()).append("\n\n");
        }
        
        JOptionPane.showMessageDialog(null, report.toString(), "Full Report", JOptionPane.INFORMATION_MESSAGE);//Displays full report of all tasks created
    }
    
    private static void displayDoneTasks(){// Display tasks that are marked as 'Done'
        
        StringBuilder doneTasks = new StringBuilder("Tasks that have been completed: \n");//(GeeksforGeeks, 2023)
        
        for(int i = 0; i < taskStatusArray.size(); i++){// (Farrell, 2018)
            
            if(taskStatusArray.get(i).equals("Done")){//If statement check if the task status at specific index is equal to done
                
                doneTasks.append("Developer: ").append(developerArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Name: ").append(taskNameArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Duration: ").append(taskDurationArray.get(i))// (GeeksforGeeks, 2023)
                        .append("\n\n");  // (GeeksforGeeks, 2023) 
            } 
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString(), "Done Tasks", JOptionPane.INFORMATION_MESSAGE);//Displays tasks with the status done(GeeksforGeeks, 2023)
    }
    
    private static void displayTaskDuration(){// Display the task with the longest duration
        
        int maxDurationIndex = 0;
        
        for(int i = 1; i < taskDurationArray.size(); i++){// (Farrell, 2018)
            if(taskDurationArray.get(i)> taskDurationArray.get(maxDurationIndex)){// (GeeksforGeeks, 2023)
                
                maxDurationIndex = i;
            }
        }
        
        String taskDetails = "Task with the longest duration: \n"
                + "\nDeveloper: " + developerArray.get(maxDurationIndex)//Gets the element stored at the specific index from the developer(GeeksforGeeks, 2023)
                + "\nTask Name: " + taskNameArray.get(maxDurationIndex)//Gets the element stored at the specific index from the task name array(GeeksforGeeks, 2023)
                + "\nTask Duration: "+ taskDurationArray.get(maxDurationIndex);//Gets the element stored at the specific index from the task duration array(GeeksforGeeks, 2023)
        
        JOptionPane.showMessageDialog(null, taskDetails,
                "Longest Duration Task", JOptionPane.INFORMATION_MESSAGE);//Displays task with longest duration// (Farrell, 2018)
    }
    
    private static void searchTaskByName(){// Search and display task by name
        
        String taskName = JOptionPane.showInputDialog(null, "Enter the Task Name you would like to search for:",
                "Search for Task", JOptionPane.PLAIN_MESSAGE);// (Farrell, 2018)
        
        StringBuilder searchedName = new StringBuilder("Search results for Task Name: " + taskName + "\n");//(GeeksforGeeks, 2023)
        
        for(int i = 0; i < taskNameArray.size(); i++){// (Farrell, 2018)
            if(taskNameArray.get(i).equalsIgnoreCase(taskName)){
                searchedName.append("Developer: ").append(developerArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Name: ").append(taskNameArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Duration: ").append(taskDurationArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Status: ").append(taskStatusArray.get(i))// (GeeksforGeeks, 2023)
                        .append("\n\n");  // (GeeksforGeeks, 2023)
            }
        }
        if(taskName.length()== 0){//If task name is empty the following message will appear(Farrell, 2018)
            
            JOptionPane.showMessageDialog(null, "Task Name has not been found", "Invalid search", JOptionPane.ERROR_MESSAGE);// (Farrell, 2018)
        }
        else{
        JOptionPane.showMessageDialog(null, searchedName.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);//displays the task that was searched(GeeksforGeeks, 2023)
    }
    }
    
    private static void searchTaskByDeveloper(){// Search and display tasks by developer name
        
        String developerName = JOptionPane.showInputDialog(null, "Enter the developers first name and surname:", "Developer Details", JOptionPane.PLAIN_MESSAGE);// (Farrell, 2018)
        StringBuilder searchByDeveloper = new StringBuilder();//(GeeksforGeeks, 2023)
        
        for(int i = 0; i < developerArray.size(); i++){// (Farrell, 2018)
            
            if(developerArray.get(i).equalsIgnoreCase(developerName)){//(GeeksforGeeks, 2024)
    
                searchByDeveloper.append("Developer: ").append(developerArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Name: ").append(taskNameArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Duration:").append(taskDurationArray.get(i)).append("\n")// (GeeksforGeeks, 2023)
                        .append("Task Status: ").append(taskStatusArray.get(i))// (GeeksforGeeks, 2023)
                        .append("\n\n");// (GeeksforGeeks, 2023)  
            } 
        }
        if(developerName.length()== 0){//Checks if the is empty and the following message will appear or if the developer is not found
            
          JOptionPane.showMessageDialog(null, "No tasks found by this developer", "Search invalid", JOptionPane.ERROR_MESSAGE); // (Farrell, 2018)
        }
        else{//Displays tasks from specified developer searched
            JOptionPane.showMessageDialog(null, searchByDeveloper.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);//(GeeksforGeeks, 2023)
        }
    }
    
    private static void deleteTaskNames(){// Delete a task by name
        
        String taskName = JOptionPane.showInputDialog(null, "Enter the Task Name you would like to delete:", "Delete Task", JOptionPane.PLAIN_MESSAGE);// (Farrell, 2018)
        boolean found = false;// (Farrell, 2018)         
        
        for(int i = 0; i < taskNameArray.size(); i++){// (Farrell, 2018)
            
            if(taskNameArray.get(i).equalsIgnoreCase(taskName)){//(GeeksforGeeks, 2024)
                
                developerArray.remove(i);//Removes developer name at stored index(GeeksforGeeks, 2024)(GeeksforGeeks, 2023)
                taskNameArray.remove(i);//Removes task name at stored index (GeeksforGeeks, 2024)(GeeksforGeeks, 2023)
                taskIDArray.remove(i);//Removes task ID at stored index(GeeksforGeeks, 2024)(GeeksforGeeks, 2023)
                taskDurationArray.remove(i);//Removes task duration at stored index(GeeksforGeeks, 2024)(GeeksforGeeks, 2023)
                taskStatusArray.remove(i);//Removes task status at stored index(GeeksforGeeks, 2024)(GeeksforGeeks, 2023)  
                i--;
     
                //Returns the following message if the task has been deleted
                JOptionPane.showMessageDialog(null, taskName + " Task has successfully been deleted",
                        "Task Deleted", JOptionPane.INFORMATION_MESSAGE);// (Farrell, 2018)
                
                found = true;// (Farrell, 2018)
                break;  
            }
        }
            //If task wasnt found this message will be displayed
        if(!found)
            JOptionPane.showMessageDialog(null, taskName +" Task has not been found", "Task not Found", JOptionPane.ERROR_MESSAGE);// (Farrell, 2018)
        
    }
    
    //Method that is used in unit test which adds data to an array to be tested in unit test
    public static void populateTestData(){
        
        developerArray.add("Mike Smith");//(GeeksforGeeks, 2024)
        taskNameArray.add("Create Login");//(GeeksforGeeks, 2024)
        taskDurationArray.add(5);//(GeeksforGeeks, 2024)
        taskStatusArray.add("To Do");//(GeeksforGeeks, 2024)
        taskIDArray.add("CR:0:ITH");//(GeeksforGeeks, 2024)
        
        developerArray.add("Edward Harrison");//(GeeksforGeeks, 2024)
        taskNameArray.add("Create Add Features");//(GeeksforGeeks, 2024)
        taskDurationArray.add(8);//(GeeksforGeeks, 2024)
        taskStatusArray.add("Doing");//(GeeksforGeeks, 2024)
        taskIDArray.add("CR:1:SON");//(GeeksforGeeks, 2024)
        
        developerArray.add("Samantha Paulson");//(GeeksforGeeks, 2024)
        taskNameArray.add("Create Reports");//(GeeksforGeeks, 2024)
        taskDurationArray.add(2);//(GeeksforGeeks, 2024)
        taskStatusArray.add("Done");//(GeeksforGeeks, 2024)
        taskIDArray.add("CR:2:SON");//(GeeksforGeeks, 2024)
        
        developerArray.add("Glenda Oberholzer");//(GeeksforGeeks, 2024)
        taskNameArray.add("Add Arrays");//(GeeksforGeeks, 2024)
        taskDurationArray.add(11);//(GeeksforGeeks, 2024)
        taskStatusArray.add("To Do");//(GeeksforGeeks, 2024)
        taskIDArray.add("AD:3:ZER");//(GeeksforGeeks, 2024)
    
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
GeeksforGeeks, 2023. ArrayList get(index) Method in Java with Examples. [Online] 
Available at: https://www.geeksforgeeks.org/arraylist-get-method-java-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. Removing Element from the Specified Index in Java ArrayList. [Online] 
Available at: https://www.geeksforgeeks.org/removing-element-from-the-specified-index-in-java-arraylist/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. String Arrays in Java. [Online] 
Available at: https://www.geeksforgeeks.org/string-arrays-in-java/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. StringBuilder append() Method in Java With Examples. [Online] 
Available at: https://www.geeksforgeeks.org/stringbuilder-append-method-in-java-with-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. StringBuilder Class in Java with Examples. [Online] 
Available at: https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2024. ArrayList in Java. [Online] 
Available at: https://www.geeksforgeeks.org/arraylist-in-java/?ref=ml_lbp
[Accessed 25 June 2024].
*/
