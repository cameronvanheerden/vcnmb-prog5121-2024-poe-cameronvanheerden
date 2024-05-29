import com.mycompany.prog5121_part1.Task;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PROG5121_Part2_UnitTesting {
    
    @Test
    public void testCheckTaskDescription_Success(){
    
        Task testSuccess = new Task (1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8,"To do", "" );    
        
        boolean actual = testSuccess.checkTaskDescription();
        boolean expected = true;
    
        assertEquals(expected, actual, "Task description expected to be valid");
        
    }
    
    @Test
    public void testCheckTaskDescription_Failure(){
        
        Task testFailed = new Task(1, "Login feature", "The task description is intentionally going to be longer than 50 character",
                "Robyn Harrison", 8, "To do", "");
        
        boolean actual = testFailed.checkTaskDescription();
        boolean expected = false;
        
        assertEquals(expected, actual, "Task description expected to be invalid");
        
    }
    
    @Test
    public void testCreateTaskID(){
  
        Task testID = new Task(1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To do", "");
        
        
        String actual = testID.createTaskID();
        String expected = "LO:1:SON";
        
        assertEquals(expected, actual, "Test case 1 failed");
      
    }
    
    @Test
    public void testReturnTotalHours(){
        
        List <Task> totalHours = new ArrayList<>();
        
        totalHours.add(new Task(1, "Login feature", "Create login to authenicate users","Robyn Harrison", 8, "To do", "" ));
        totalHours.add(new Task(2, "Add Task feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing", ""));
        
        int actual = Task.returnTotalHours(totalHours);
        int expected = 18;
        
        assertEquals(expected, actual , "Total Hours should be 18");       
    }
}
