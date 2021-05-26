import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class ApiTestingSteps {
    private long id;
    private Response response;
    private String path;
    JSONObject jsonObj;

    @Then("user receive status code {int}")
    public void compareStatusCodes(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @When("user receive number {int}")
    public void getIdNumber(int number) {
        response.then().body(equalTo(number + ""));
    }

    @Then("response don't equal zero")
    public void checkThatResponseNotNull() {
        response.then().body(Matchers.notNullValue());
    }

    @Given("path to data is {string}")
    public void pathToDataIs(String arg0) {
        this.path = arg0;
    }

    @When("user try to get id by path")
    public void userTryToGetProducerById() {
        response = new FireBaseEndPoint().getData(path);
    }

    @Given("path to data is {string} and name is {string}")
    public void pathToDataIsAndNameIsJohn(String arg0, String arg1) {
        Map<Object, Object> data = new HashMap<>();
        data.put("nam", arg1);
        path = arg0;
        jsonObj = new JSONObject(data);

    }

    @When("user try to add data to db")
    public void userTryToAddDataToDb() {
        response = new FireBaseEndPoint().AddData(path, jsonObj);
    }

    @Then("user must received {string}")
    public void userMustReceived(String arg0) {
        response.then().body(equalTo(arg0));
    }
}
