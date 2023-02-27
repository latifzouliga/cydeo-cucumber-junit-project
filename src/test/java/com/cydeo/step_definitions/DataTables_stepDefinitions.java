package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTables_stepDefinitions {

    @Then("user should see bellow list")
    public void user_should_see_bellow_list(List<String> fruitsAndVegetables) {

        System.out.println(fruitsAndVegetables);
        for (String each : fruitsAndVegetables) {
            System.out.println(each);
        }

    }

    @Then("user uses this color in his project")
    public void user_uses_this_color_in_his_project(List<String> colors) {
        System.out.println("-------------------");
        for (String each : colors) {
            System.out.println(each);
        }
    }

    @Then("I will share their favorites")
    public void i_will_share_their_favorites(List<String> pets) {
        System.out.println(pets); //
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String,String> driverInfo) {
        System.out.println(driverInfo);
        driverInfo.forEach((k,v) -> System.out.println(k + ": "+v));

        System.out.println("-----------------------");
        System.out.println(driverInfo.get("name"));

    }



}
