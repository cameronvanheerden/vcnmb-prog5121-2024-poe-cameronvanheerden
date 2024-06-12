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

}
