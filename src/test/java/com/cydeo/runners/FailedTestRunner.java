package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",              // pointing to directly to rerun.txt
        glue = "com/cydeo/step_definitions"
)
class FailedTestRunner {
}                              // its job to run failed tests only
