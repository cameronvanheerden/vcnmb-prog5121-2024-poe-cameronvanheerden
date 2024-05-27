import com.mycompany.prog5121_part1.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PROG5121_Part2_UnitTesting {
    
    @Test
    public void testCheckTaskDescription_Success(){
    
        Task testSuccess = new Task (1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8,"To do", "" );    
        
        boolean actual = testSuccess.checkTaskDescription();
        boolean expected = true;
    
        assertEquals(expected, actual, "Task description expected to be valid");
        
        if(actual){
         
            System.out.println("Task successfully captured");
        }
        else{
            
            System.out.println("Please enter a task description of less than 50 characters");
        }
    }
    
    @Test
    public void testCheckTaskDescription_Failure(){
        
        Task testFailed = new Task(1, "Login feature", "The task description is intentionally going to be longer than 50 character",
                "Robyn Harrison", 8, "To do", "");
        
        boolean actual = testFailed.checkTaskDescription();
        boolean expected = false;
        
        assertEquals(expected, actual, "Task description expected to be invalid");
        
        if(actual){
            
            System.out.println("Task successfully captured");
        }
        else{
            
            System.out.println("Please enter a task description of less than 50 characters");
        }
        
    }
    
    @Test
    public void testCreateTaskID(){
  
        Task testID = new Task(1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To do", "");
        
        
        String actual = testID.createTaskID();
        String expected = "AD:1:BYN";
        
       // assertEquals(expected, actual, "Test case 1 failed");
        
        Task[] tasks = {new Task(0, "Cr", "Test description 1", "Ike", 5, "To do", ""),
                        new Task(1, "Cr", "Test description 2", "Ard", 2, "Done", "" ),
                        new Task(2, "Cr", "Test description 3", "Tha", 1, "Doing", ""),
                        new Task(3, "Cr", "Test description 4", "Nd", 8, "Done", "") };
        
        String[] expectedResults = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "CR:3:ND"};
        
        for(int i = 0; i < tasks.length; i++){
            
            assertEquals(expectedResults[i], tasks[i].createTaskID());
            
        }
    }
   
}
