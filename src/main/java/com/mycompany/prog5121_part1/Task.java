package com.mycompany.prog5121_part1;

public class Task {
    
    private String taskID ="";
    private String taskName = "";
    private int taskNumber;
    private String developerName ="";
    private String taskDuration;
    private String taskDescription;
    private String statusOptions[]= {"To do", "Done", "Doing"};
    private int choice;
    private static int totalHours;

    public Task(String taskName, String developerName, String taskDescription, String taskID, int taskCounter, String taskDuration){
        
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.developerName = developerName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        if(choice >=0 && choice < statusOptions.length){
            this.choice = choice;
        }  
    }
    
    public boolean checkTaskDescription(){
        
        return taskDescription.length()<=50;
    }
    
    public String createTaskID(){

        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        
        String lastThreeLetters = developerName.substring(developerName.length() - 3).toUpperCase();
             
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
             
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
    
    public int returnTotalHours(){
          
        return totalHours;
    }
    
}
