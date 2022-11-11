package mentutor.adminStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mentutor.loginAdmin.AdminAPI;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class GetSingleUserStepdef {

    @Steps
    AdminAPI adminAPI;

    //GetSingleUser_001
    @Given("Get single user using valid id {int} with authorization")
    public void getSingleUserUsingValidIdIdWithAuthorization(int id) {
        adminAPI.getSingleUserValidID(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(AdminAPI.GET_SINGLE_USER);
    }

    @And("Get single user with valid id json schema validator")
    public void getSingleUserWithValidIdJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/GetSingleUserValidIDJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GetSingleUser_002
    @Given("Get single user using valid id {int} without authorization")
    public void getSingleUserUsingValidIdIdWithoutAuthorization(int id) {
    }

    //GetSingleUser_003
    @Given("Get single user with unregistered id {int}")
    public void getSingleUserWithUnregisteredIdId(int id) {
    }

    @Then("Should return status code {int} Method Not Allowed")
    public void shouldReturnStatusCodeMethodNotAllowed(int id) {
    }

    //GetSingleUser_004
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidIdId(String id) {
    }

    //GetSingleUser_005
    @Given("Get single user with id {int} has been deleted")
    public void getSingleUserWithIdIdHasBeenDeleted(int id) {
    }

}
