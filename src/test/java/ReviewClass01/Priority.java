package ReviewClass01;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 1)
    public void bIAMTEST1(){
        System.out.println("Test 1 from priority class");
    }
    @Test(priority = 2)
    public void aIAMTEST2(){
        System.out.println("Test 2 from priority class");
    }
}
