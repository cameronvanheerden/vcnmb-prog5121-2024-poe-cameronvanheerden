package com.mycompany.prog5121_part1;

import java.util.List;

public class Task {
    
    private String taskID;
    private String taskName;
    private int taskNumber;
    private String developerName;
    private int taskDuration;
    private String taskDescription;
    private String taskStatus;

   
    public Task(int taskNumber, String taskName, String taskDescription, String developerName, int taskDuration, String taskStatus, String taskID){
        
        this.taskNumber= taskNumber;
        this.taskName = taskName;
        this.taskDescription= taskDescription;
        this.developerName = developerName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = taskID;
              
    }   
    
    public boolean checkTaskDescription(){
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){
        
        String namePart = taskName.length()>= 2? taskName.substring(0 , 2).toUpperCase(): taskName.toUpperCase();
        String devName= developerName.length() >= 3? developerName.substring(developerName.length() - 3).toUpperCase(): developerName.toUpperCase();
             
        return namePart + ":" + taskNumber + ":" + devName;
    }
    
    public String printTaskDetails(){
        
        return "Task Status: " + taskStatus
               + "\nDeveloper Details: " + developerName
               + "\nTask Number: "+ taskNumber
               + "\nTask Name: "+ taskName 
               + "\nTask Descrpition: "+taskDescription
               + "\nTask ID: " + taskID
               + "\nTask Duration: " + taskDuration + " hours";
    } 
    
    public int gettaskDuration(){
        
        return taskDuration;
    }
    
    public static int returnTotalHours(List <Task> tasks){
        int totalHours = 0;
              
        for(Task task: tasks){
     
            totalHours += task.gettaskDuration();
        }
        return totalHours;
              
    }
    
}
