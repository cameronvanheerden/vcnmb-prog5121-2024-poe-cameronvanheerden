import com.mycompany.poe_part3.POE_Part3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class POE_Testing {
    
    @BeforeEach
    public void setUp() {
        
        POE_Part3.populateTestData();
    }
    
    @Test
    public void testDeveloperArray(){
        
        assertEquals("Mike Smith", POE_Part3.developerArray.get(0));
        assertEquals("Edward Harrison", POE_Part3.developerArray.get(1));
        assertEquals("Samantha Paulson", POE_Part3.developerArray.get(2));
        assertEquals("Glenda Oberholzer", POE_Part3.developerArray.get(3));
        
    }
    
    @Test
    public void testLongestDurationArray(){
        
        int maxDurationIndex = 0;
        
        for(int i = 1; i < POE_Part3.taskDurationArray.size(); i++){
            
            if(POE_Part3.taskDurationArray.get(i) > POE_Part3.taskDurationArray.get(maxDurationIndex)){
             
                maxDurationIndex = i;
            }
        }
        
        assertEquals("Glenda Oberholzer", POE_Part3.developerArray.get(maxDurationIndex));
        assertEquals(11, (int )POE_Part3.taskDurationArray.get(maxDurationIndex));
    }
    
    @Test
    public void testSearchByName(){
        
        String taskName = "Create Login";
        boolean found = false;
        
        for(int i = 0; i < POE_Part3.taskNameArray.size(); i++){
            
            if(POE_Part3.taskNameArray.get(i).equalsIgnoreCase(taskName)){
                
               assertEquals("Mike Smith", POE_Part3.developerArray.get(i)); 
               assertEquals("Create Login", POE_Part3.taskNameArray.get(i));
                               
                found = true;
                break;
            }
         }
        
        assertTrue(found);
    }
    
    @Test
    public void testTaskAssignedToDeveloper(){
        
        String developerName = "Samantha Paulson";
        StringBuilder searchByDeveloper = new StringBuilder();
        
        for(int i = 0; i < POE_Part3.developerArray.size(); i++){
            
            if(POE_Part3.developerArray.get(i).equalsIgnoreCase(developerName)){
                
                searchByDeveloper.append(POE_Part3.taskNameArray.get(i));
            }
        }
        assertEquals("Create Reports", searchByDeveloper.toString());
    }
    
    @Test
    public void testDeleteTaskByName(){
        
        String taskName = "Create Reports";
        boolean found = false;
        
        for(int i = 0; i < POE_Part3.taskNameArray.size(); i++){
            
            if(POE_Part3.taskNameArray.get(i).equalsIgnoreCase(taskName)){
                POE_Part3.developerArray.remove(i);
                POE_Part3.taskNameArray.remove(i);
                POE_Part3.taskIDArray.remove(i);
                POE_Part3.taskDurationArray.remove(i);
                POE_Part3.taskStatusArray.remove(i);
                found = true;
                break;
            }
        }
        assertTrue(found);
        assertFalse(POE_Part3.taskNameArray.contains(taskName));
    }
    
    @Test
    public void testDisplayFullReport(){
        
        
        
    }
}
