import com.mycompany.prog5121_part1.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PROG5121_Part2_UnitTesting {
    
    @Test
    public void testCheckTaskDescription_Success(){
    
        Task testSuccess = new Task (1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");    
        
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
                "Robyn Harrison", 8, "To Do");
        
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
    
    

   
}
