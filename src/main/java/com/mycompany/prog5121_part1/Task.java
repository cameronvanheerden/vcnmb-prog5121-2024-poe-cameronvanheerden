package com.mycompany.prog5121_part1;

import java.util.ArrayList;
import java.util.List;

public class Task {
    
    private String taskID ="";
    private String taskName = "";
    private int taskNumber = 0;
    private String developerName ="";
    private int taskDuration;
    private String taskDescription;
    private String statusOptions[]= {"To do", "Done", "Doing"};
    private int choice;
    private String taskStatus ="";
    private int totalHours = 0;
    static List<Task> tasks = new ArrayList();

    public Task(){
        
        this.taskStatus= taskStatus;
        this.developerName = developerName;
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskID = createTaskID();
        this.taskDuration = taskDuration;
        if(choice >= 0 && choice < statusOptions.length ){
          
            this.choice=choice;
        }
    }   
    
    public boolean checkTaskDescription(){
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){

        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        
        String lastThreeLetters = developerName.substring(developerName.length() - 3).toUpperCase();
        
        taskID = firstTwoLetters + ":" + (taskNumber + 1) + ":"+ lastThreeLetters;
             
        return taskID;
             
    }
    
    public String printTaskDetails(){
        
        return "Task Status: " + statusOptions[choice]
               + "\nDeveloper Details: " + developerName
               + "\nTask Number: "+ taskNumber++
               + "\nTask Name: "+ taskName 
               + "\nTask Descrpition: "+taskDescription
               + "\nTask ID: " + taskID
               + "\nTask Duration: " + taskDuration + " hours";
    } 
    
    public int returnTotalHours(){
              
        for(Task task: tasks){
     
            totalHours += task.taskDuration;
        }
        return totalHours;
              
    }
    
}
