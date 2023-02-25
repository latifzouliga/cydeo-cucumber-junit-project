package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/** Will will be abke to create "pre" and "post" condition for all the scenarios and even steps */
public class Hooks {


    // import the @Before coming from io. cucumber. java

    //@Before(order = 1)
    public void setupMethod(){
        System.out.println("-----> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    //@Before(value = "@login", order = 2)
    public void login_scenario_before(){
        System.out.println("-----> @Before: RUNNING BEFORE EACH SCENARIO   @login");
    }

    @After
    public void tearDown(Scenario scenario){

        // condition for taking scenarios (failed scenarios only)
        if (scenario.isFailed()) {
            // taking the screenshots and saving then in html report
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attaching screenshot to html report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // quiting driver session after each scenario
        Driver.closeDriver();
        System.out.println("----> @After RUNNING AFTER EACH SCENARIO");
    }

    //@BeforeStep
    public void setUpStep(){
        System.out.println("------------> @BeforeStep: RUNNING BEFORE EACH STEP");
    }

    //@AfterStep
    public void tearDownStep(){
        System.out.println("------------> @AfterStep: RUNNING BEFORE EACH STEP");
    }

}
