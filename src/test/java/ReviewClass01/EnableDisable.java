package ReviewClass01;

import org.testng.annotations.Test;

public class EnableDisable {
    //default is enable true
    @Test(enabled = false)
    public void test1(){
        System.out.println("I am enable/disable test 1");
    }
    @Test
    public void test2(){
        System.out.println("I am enable/disable test 2");
    }
}
