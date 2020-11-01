package stepDefinition;

import Hello.ReportServices;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AudibeneStepDef {
    ReportServices reportServices = new ReportServices();

    private static Logger LOGGER = LoggerFactory.getLogger(AudibeneStepDef.class);

    @Given("^Get the list of fixed categories items$")
    public void get_the_list_of_fixed_categories_items() throws Throwable {
        if (!reportServices.fetchCategories()) {
            Assert.fail();
        }
    }

    @Given("^pick one of the categories and verify the query string in the returned JSON$")
    public void pick_one_of_the_categories_and_verify() throws Throwable {
        if (!reportServices.pickAndVerify()) {
            Assert.fail();
        }
    }
}
