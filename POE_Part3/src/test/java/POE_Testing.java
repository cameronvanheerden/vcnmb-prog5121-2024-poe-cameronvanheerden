import com.mycompany.poe_part3.POE_Part3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class POE_Testing {
    
    @BeforeEach
    public void setUp() {
        
        POE_Part3.populateTestData();
    }
    
}
