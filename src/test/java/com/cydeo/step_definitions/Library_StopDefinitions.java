package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Library_StopDefinitions {

    @Given("user is on the login page of the application")
    public void user_is_on_the_login_page_of_the_application() {
        System.out.println("User is on the login page of the application");
    }
    @When("user enters librarian user name")
    public void user_enters_librarian_user_name() {
        System.out.println("user enter librarian user name");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("user enter librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("user see the dashboard");
    }

    @When("user enters student user name")
    public void user_enters_student_user_name() {
        System.out.println("user enters student user name");
    }
    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("user enters student password");
    }

    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("user enters admin username");
    }
    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("user enters admin password");
    }





}
