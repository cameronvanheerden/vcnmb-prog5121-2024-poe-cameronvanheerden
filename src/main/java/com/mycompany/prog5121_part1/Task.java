package com.mycompany.prog5121_part1;

public class Task {
    
    private String taskID ="";
    private String taskName = "";
    private int taskNumber;
    private String developerName ="";
    private String taskDuration;
    private String taskDescription;
    private String developerDetails;
    private String statusOptions[]= {"To do", "Done", "Doing"};
    private int choice;
    private static int totalHours;

    public Task(String taskName, String developerName, String taskDescription, String taskID, String taskDuration){
        
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.developerName = developerName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        if(choice >=0 && choice < statusOptions.length){
            this.choice = choice;
        }  
    }
    
    public boolean checkTaskDescription(String taskDescription){
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){

        String firstTwoLetters = taskName.substring(Math.min(0, 2)).toUpperCase();
        
        String lastThreeLetters = developerName.substring(Math.max(developerName.length() - 3, 0)).toUpperCase();
             
        taskID = firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
        
     return taskID;
     
    }
    
    public String printTaskDetails(){
        
        return "Task Status: " + statusOptions[choice]
               + "\nDeveloper Details: " + developerName
               + "\nTask Number: "+taskNumber
               + "\nTask Name: "+ taskName 
               + "\nTask Descrpition: "+taskDescription
               + "\nTask ID: " + taskID
               + "\nTask Duration: " + taskDuration + " hours";
    } 
    
    public static int returnTotalHours(){
          
        return totalHours;
    }
    
}
