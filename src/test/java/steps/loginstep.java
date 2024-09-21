package steps;

import io.cucumber.java.en.*;

public class loginstep {

    @Given("user navigate to url")
    public void user_navigate_to_url() {
        System.out.println("user navigate to url");
    }

    @When("user enters username & password")
    public void user_enters_username_password() {
        System.out.println("user enters username & password");
    }

    @When("click on login button")
    public void click_on_login_button() {
        System.out.println("click on login button");
    }

    @Then("user will be redirected to homePage")
    public void user_will_be_redirected_to_home_page() {
        System.out.println("user will be redirected to homePage");
    }


    @Given("navigate to {string}")
    public void navigate_to(String url) {
        System.out.println("navigate to "+url);
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String user, String pwd) {
        System.out.println("user enters username as "+user+"and password as "+pwd);
    }

    @When("click on submit button")
    public void click_on_submit_button() {
        System.out.println("click on submit button");
    }

    @Then("Redirected to {string}")
    public void redirected_to(String Home_url) {
        System.out.println("Redirected to "+Home_url);
    }

    @Then("error message {string} should be displayed on console")
    public void error_message_should_be_displayed_on_console(String Error_message) {
        System.out.println("error message "+ Error_message+ " should be displayed on console");
    }
}
