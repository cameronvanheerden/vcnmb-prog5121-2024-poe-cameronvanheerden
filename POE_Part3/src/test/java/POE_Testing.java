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
        
        assertEquals("Mike Smith", POE_Part3.developerArray.get(0));// (GeeksforGeeks, 2023)
        assertEquals("Edward Harrison", POE_Part3.developerArray.get(1));// (GeeksforGeeks, 2023)
        assertEquals("Samantha Paulson", POE_Part3.developerArray.get(2));// (GeeksforGeeks, 2023)
        assertEquals("Glenda Oberholzer", POE_Part3.developerArray.get(3));// (GeeksforGeeks, 2023)
        
    }
    
    @Test
    public void testLongestDurationArray(){
        
        int maxDurationIndex = 0;
        
        for(int i = 1; i < POE_Part3.taskDurationArray.size(); i++){// (Farrell, 2018)
            
            if(POE_Part3.taskDurationArray.get(i) > POE_Part3.taskDurationArray.get(maxDurationIndex)){// (GeeksforGeeks, 2023)
             
                maxDurationIndex = i;
            }
        }
        
        assertEquals("Glenda Oberholzer", POE_Part3.developerArray.get(maxDurationIndex));// (GeeksforGeeks, 2023)
        assertEquals(11, (int )POE_Part3.taskDurationArray.get(maxDurationIndex));// (GeeksforGeeks, 2023)
    }
    
    @Test
    public void testSearchByName(){
        
        String taskName = "Create Login";
        boolean found = false;
        
        for(int i = 0; i < POE_Part3.taskNameArray.size(); i++){// (Farrell, 2018)
            
            if(POE_Part3.taskNameArray.get(i).equalsIgnoreCase(taskName)){// (GeeksforGeeks, 2023)
                
               assertEquals("Mike Smith", POE_Part3.developerArray.get(i)); // (GeeksforGeeks, 2023)
               assertEquals("Create Login", POE_Part3.taskNameArray.get(i));// (GeeksforGeeks, 2023)
                               
                found = true;
                break;
            }
         }
        
        assertTrue(found);// (Farrell, 2018)
    }
    
    @Test
    public void testTaskAssignedToDeveloper(){
        
        String developerName = "Samantha Paulson";
        StringBuilder searchByDeveloper = new StringBuilder();//(GeeksforGeeks, 2023)
        
        for(int i = 0; i < POE_Part3.developerArray.size(); i++){// (Farrell, 2018)
            
            if(POE_Part3.developerArray.get(i).equalsIgnoreCase(developerName)){// (GeeksforGeeks, 2023)
                
                searchByDeveloper.append(POE_Part3.taskNameArray.get(i));
            }
        }
        assertEquals("Create Reports", searchByDeveloper.toString());// (Farrell, 2018)
    }
    
    @Test
    public void testDeleteTaskByName(){
        
        String taskName = "Create Reports";
        boolean found = false;
        
        for(int i = 0; i < POE_Part3.taskNameArray.size(); i++){// (Farrell, 2018)
            
            if(POE_Part3.taskNameArray.get(i).equalsIgnoreCase(taskName)){// (GeeksforGeeks, 2023)
                POE_Part3.developerArray.remove(i);//(GeeksforGeeks, 2023)
                POE_Part3.taskNameArray.remove(i);// (GeeksforGeeks, 2023)
                POE_Part3.taskIDArray.remove(i);// (GeeksforGeeks, 2023)
                POE_Part3.taskDurationArray.remove(i);// (GeeksforGeeks, 2023)
                POE_Part3.taskStatusArray.remove(i);// (GeeksforGeeks, 2023)
                found = true;
                break;
            }
        }
        assertTrue(found);// (Farrell, 2018)
        assertFalse(POE_Part3.taskNameArray.contains(taskName));// (Farrell, 2018)
    }
    
    @Test
    public void testDisplayFullReport(){
        
        StringBuilder fullReport = new StringBuilder("Full details of all Tasks: \n\n");//(GeeksforGeeks, 2023)
        
        int arraySize = POE_Part3.developerArray.size();// (Farrell, 2018)
        
        assertEquals(arraySize, POE_Part3.taskNameArray.size());// (Farrell, 2018)
        assertEquals(arraySize, POE_Part3.developerArray.size());// (Farrell, 2018)
        assertEquals(arraySize, POE_Part3.taskDurationArray.size());// (Farrell, 2018)
        assertEquals(arraySize, POE_Part3.taskStatusArray.size());// (Farrell, 2018)
        assertEquals(arraySize, POE_Part3.taskIDArray.size());// (Farrell, 2018)
        
        for(int i = 0; i < arraySize; i++){// (Farrell, 2018)
            
            fullReport.append("Task Name: ").append(POE_Part3.taskNameArray.get(i)).append("\n");// (GeeksforGeeks, 2023)
            fullReport.append("Developer: ").append(POE_Part3.developerArray.get(i)).append("\n");// (GeeksforGeeks, 2023)
            fullReport.append("Task Duration: ").append(POE_Part3.taskDurationArray.get(i)).append("\n");// (GeeksforGeeks, 2023)
            fullReport.append("Task Status: ").append(POE_Part3.taskStatusArray.get(i)).append("\n");// (GeeksforGeeks, 2023)
            fullReport.append("Task ID: ").append(POE_Part3.taskIDArray.get(i)).append("\n");// (GeeksforGeeks, 2023)
        }
        assertNotNull(fullReport.toString());// (Farrell, 2018)
        assertTrue(fullReport.length() > 0);// (Farrell, 2018)
    }
}
/*
References List
Farrell, J., 2018. Java Programming. 9 ed. Boston: Cengage Learning.
GeeksforGeeks, 2023. ArrayList get(index) Method in Java with Examples. [Online] 
Available at: https://www.geeksforgeeks.org/arraylist-get-method-java-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. Removing Element from the Specified Index in Java ArrayList. [Online] 
Available at: https://www.geeksforgeeks.org/removing-element-from-the-specified-index-in-java-arraylist/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. String Arrays in Java. [Online] 
Available at: https://www.geeksforgeeks.org/string-arrays-in-java/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. StringBuilder append() Method in Java With Examples. [Online] 
Available at: https://www.geeksforgeeks.org/stringbuilder-append-method-in-java-with-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2023. StringBuilder Class in Java with Examples. [Online] 
Available at: https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
[Accessed 25 June 2024].
GeeksforGeeks, 2024. ArrayList in Java. [Online] 
Available at: https://www.geeksforgeeks.org/arraylist-in-java/?ref=ml_lbp
[Accessed 25 June 2024].
*/