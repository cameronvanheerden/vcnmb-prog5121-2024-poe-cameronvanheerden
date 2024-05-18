package com.mycompany.prog5121_part1;

public class Task {
    
    private String taskID ="";
    private String taskName = "";
    private int taskNumber;
    private String developerName ="";
    private int taskDuration;
    private String taskDescription;
    private String developerDetails;
    private String statusOptions[]= {"To do", "Done", "Doing"};
    private int choice;

    public Task(String taskName, int taskNumber, String developerName){
        
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.developerName = developerName;
    }
    
    public boolean checkTaskDescription(String taskDescription){
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){
    
        String firstTwoLetters = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase();
        
        String lastThreeLetters = developerName.substring(0, Math.max(developerName.length() - 3, 0)).toUpperCase();
    
        taskID = firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    
    return taskID;
    }
    
    /*public String printTaskDetails(){
        
        return "Task Status: " + statusOptions[choice]
               + "\nDeveloper Details: " + developerDetails
               + "\nTask Number: "+taskNumber
               + "\nTask Name: "+ taskName 
               + "\nTask Descrpition: "+taskDescription
               + "\nTask ID: " + taskID
               + "\nTask Duration: " + taskDuration + " hours";
    } 
    
    public int returnTotalHours(){
        
        
        
    }*/
    
}
