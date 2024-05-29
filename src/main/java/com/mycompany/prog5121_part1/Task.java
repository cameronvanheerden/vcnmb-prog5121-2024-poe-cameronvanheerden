package com.mycompany.prog5121_part1;

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
    public Task(int taskNumber, String taskName, String taskDescription, String developerName, int taskDuration, String taskStatus, String taskID){
        
        this.taskNumber= taskNumber;
        this.taskName = taskName;
        this.taskDescription= taskDescription;
        this.developerName = developerName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = taskID;
              
    }   
    
    public boolean checkTaskDescription(){ // Method to check if the task description is within the allowed 50 characters
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){// Method to create a unique task ID based on task name and developer name
        // Ensure task name part is at least 2 characters and developer name part is at least 3 characters
        String namePart = taskName.length()>= 2? taskName.substring(0 , 2).toUpperCase(): taskName.toUpperCase();
        String devName= developerName.length() >= 3? developerName.substring(developerName.length() - 3).toUpperCase(): developerName.toUpperCase();
             
        return namePart + ":" + taskNumber + ":" + devName;
    }
    
    public String printTaskDetails(){// Method to return a formatted string with all task details
        
        return "Task Status: " + taskStatus
               + "\nDeveloper Details: " + developerName
               + "\nTask Number: "+ taskNumber
               + "\nTask Name: "+ taskName 
               + "\nTask Descrpition: "+taskDescription
               + "\nTask ID: " + taskID
               + "\nTask Duration: " + taskDuration + " hours";
    } 
    
    public int gettaskDuration(){// Getter method for task duration
        
        return taskDuration;
    }
    
    public static int returnTotalHours(List <Task> tasks){// Static method to calculate the total hours from a list of tasks
        int totalHours = 0;
              
        for(Task task: tasks){// Sum up the duration of each task
     
            totalHours += task.gettaskDuration();
        }
        return totalHours;
              
    }
    
}
