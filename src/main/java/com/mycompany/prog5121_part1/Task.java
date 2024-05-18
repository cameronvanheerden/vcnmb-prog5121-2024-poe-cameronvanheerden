package com.mycompany.prog5121_part1;

public class Task {
    
    private String taskID ="";
    private String taskName = "";
    private int taskNumber;
    private String developerName ="";

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
        
        String lastThreeLetters = developerName.substring(0, Math.max(developerName.length(), 3)).toUpperCase();
    
        taskID = firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    
    return taskID;
    }
    
   /* public String printTaskDetails(){
        
        
        return 
    } 
    
    public int returnTotalHours(){
        
        
        
    }*/
    
}
