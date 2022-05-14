package ReviewClass01;

import org.testng.annotations.Test;

public class DependsOn {

    @Test
    public void Login(){
        System.out.println("Login Text ");
    }

    @Test(dependsOnMethods = "Login")
    public void VerifyDashboardPage(){
        System.out.println("Dependent method, this verify dashboardpage is dependent on login method test case");
    }
}
