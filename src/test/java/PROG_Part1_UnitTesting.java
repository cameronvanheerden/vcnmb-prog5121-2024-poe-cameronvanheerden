import com.mycompany.prog5121_part1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class PROG_Part1_UnitTesting {
     
   @Test
   public void testUsername(){
       Login test1 = new Login("","","","");
       boolean Actual = test1.checkUserName("camo_");
       boolean Expected = true;
       
      Assertions.assertEquals(Expected, Actual);
       
   }
   @Test
   public void testPassword(){
       Login test2 = new Login("","","","");
       boolean Actual = test2.checkPasswordComplexity("Carpediem143.");
       boolean Expected = true;
       
       Assertions.assertEquals(Expected, Actual);
       
   }
   
   @Test
   public void testLoginUser(){
       Login test3 = new Login("","","","");
        boolean Actual = test3.loginUser("camo_", "Carpediem143." );
        boolean Expected = true;
       
       
       
   }
   

}

