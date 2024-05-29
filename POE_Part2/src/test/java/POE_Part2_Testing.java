
import com.mycompany.poe_part2.Task;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class POE_Part2_Testing {
    
    @Test
    void testCheckTaskDescription_Success(){
        // Create a Task object with a valid description
        Task testSuccess = new Task (1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8,"To do", "" ); //(GeeksforGeeks, 2023)
        
        // Call the method to check if the task description is valid
        boolean actual = testSuccess.checkTaskDescription();//(Wanvig, 2022)
        boolean expected = true;//(Wanvig, 2022)
        
        // Assert that the description is valid
        assertEquals(expected, actual, "Task description expected to be valid");//(Wanvig, 2022)
        
    }
    
    @Test
    void testCheckTaskDescription_Failure(){
        // Create a Task object with an invalid description (more than 50 characters)
        Task testFailed = new Task(1, "Login feature", "The task description is intentionally going to be longer than 50 character",
                "Robyn Harrison", 8, "To do", "");//(GeeksforGeeks, 2023)
        
        // Call the method to check if the task description is invalid
        boolean actual = testFailed.checkTaskDescription();//(Wanvig, 2022)
        boolean expected = false;//(Wanvig, 2022)
        
        //Assert that the description is invalid
        assertEquals(expected, actual, "Task description expected to be invalid");//(Wanvig, 2022)
        
    }
    
    @Test
    void testCreateTaskID(){
        // Create a Task object to test the task ID generation
        Task testID = new Task(1, "Login feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To do", "");//(GeeksforGeeks, 2023)
        
        // Call the method to create the task ID
        String actual = testID.createTaskID();//(Wanvig, 2022)
        String expected = "LO:1:SON";//(Wanvig, 2022)
        
        // Assert that the task ID is as expected
        assertEquals(expected, actual, "Test case 1 failed");//(Wanvig, 2022)
      
    }
    
    @Test
    void testReturnTotalHours(){
        // Create a list of tasks to test the total hours calculation
        List <Task> totalHours = new ArrayList<>();//(GeeksforGeeks, 2021)
        
        totalHours.add(new Task(1, "Login feature", "Create login to authenicate users","Robyn Harrison", 8, "To do", "" ));//(GeeksforGeeks, 2021)//(GeeksforGeeks, 2023)
        totalHours.add(new Task(2, "Add Task feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing", ""));//(GeeksforGeeks, 2021)//(GeeksforGeeks, 2023)
        
        // Call the method to calculate the total hours for the list of tasks
        int actual = Task.returnTotalHours(totalHours);//(Wanvig, 2022)
        int expected = 18;//(Wanvig, 2022)
        
         // Assert that the total hours is as expected
        assertEquals(expected, actual , "Total Hours should be 18");//(Wanvig, 2022)      
    }
}