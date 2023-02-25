package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)                             // turns the class into runnable class
@CucumberOptions(   //
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html", // html report for passed and failed Tests
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt"             // storing tailed text for rerun
        },
        features = "src/test/resources/features",    // looking for Scenarios in feature folder
        glue = "com/cydeo/step_definitions",         // looking for implementation of feature files in step defs folder
        tags = "",                            // specifying which test(s) needs to be run
        publish = true,                              // generating a link for sharing html report
        dryRun = false                               // generating snippets when we change the value to true
)
public class CukesRunner { /** Run Me */
}           // trigger button


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",              // pointing to directly to rerun.txt
        glue = "com/cydeo/step_definitions"
)
class FailedTestRunner {
}                              // its job to run failed tests only

