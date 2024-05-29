package com.mycompany.poe_part2;


import java.util.List;

public class Task {
    // Private member variables for storing task details
    private String taskID;
    private String taskName;
    private int taskNumber;
    private String developerName;
    private int taskDuration;
    private String taskDescription;
    private String taskStatus;

   // Constructor to initialize a new Task object with given parameters
    public Task(int taskNumber, String taskName, String taskDescription, String developerName, int taskDuration, String taskStatus, String taskID){//(GeeksforGeeks, 2024)
        
        this.taskNumber= taskNumber;//(GeeksforGeeks, 2024)
        this.taskName = taskName;//(GeeksforGeeks, 2024)
        this.taskDescription= taskDescription;//(GeeksforGeeks, 2024)
        this.developerName = developerName;//(GeeksforGeeks, 2024)
        this.taskDuration = taskDuration;//(GeeksforGeeks, 2024)
        this.taskStatus = taskStatus;//(GeeksforGeeks, 2024)
        this.taskID = taskID;//(GeeksforGeeks, 2024)
              
    }   
    
    public boolean checkTaskDescription(){ // Method to check if the task description is within the allowed 50 characters
        
        return taskDescription.length()<=50;//(Farrell, 2018)
    }
    
    public String createTaskID(){// Method to create a unique task ID based on task name and developer name
        // Ensure task name part is at least 2 characters and developer name part is at least 3 characters
        String namePart = taskName.length()>= 2? taskName.substring(0 , 2).toUpperCase(): taskName.toUpperCase();
        String devName= developerName.length() >= 3? developerName.substring(developerName.length() - 3).toUpperCase(): developerName.toUpperCase();
             
        return namePart + ":" + taskNumber + ":" + devName;//(Farrell, 2018)
    }
    
    public String printTaskDetails(){// Method to return a formatted string with all task details
        
        return "Task Status: " + taskStatus//(Farrell, 2018)
               + "\nDeveloper Details: " + developerName//(Farrell, 2018)
               + "\nTask Number: "+ taskNumber//(Farrell, 2018)
               + "\nTask Name: "+ taskName //(Farrell, 2018)
               + "\nTask Descrpition: "+taskDescription//(Farrell, 2018)
               + "\nTask ID: " + taskID//(Farrell, 2018)
               + "\nTask Duration: " + taskDuration + " hours";//(Farrell, 2018)
    } 
    
    public int gettaskDuration(){// Getter method for task duration
        
        return taskDuration;//(Farrell, 2018)
    }
    
    public static int returnTotalHours(List <Task> tasks){// Static method to calculate the total hours from a list of tasks
        int totalHours = 0;
              
        for(Task task: tasks){// Sum up the duration of each task//(Farrell, 2018)
     
            totalHours += task.gettaskDuration();
        }
        return totalHours;//(Farrell, 2018)
              
    }
    
}