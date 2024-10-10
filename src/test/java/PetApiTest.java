import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
@Feature("Pet api CRUD test")
public class PetApiTest {
    private final String baseUrl = "https://petstore.swagger.io/v2";
    private final int petId = 12159;

    @Test
    public void createPet() {
        String createPetPayload = "{"
                + "\"id\": " + petId + ","
                + "\"category\": {"
                + "    \"id\": 1,"
                + "    \"name\": \"Kopek\""
                + "},"
                + "\"name\": \"Pasa\","
                + "\"tags\": ["
                + "    {"
                + "        \"id\": 1,"
                + "        \"name\": \"Evcil\""
                + "    }"
                + "],"
                + "\"status\": \"available\""
                + "}";

        given().body(createPetPayload).contentType(ContentType.JSON).when().post(baseUrl+"/pet").then().statusCode(200);
    }

    @Test
    public void getPet(){
        given().when().get(baseUrl + "/pet/" + petId).then().statusCode(200);
    }

    @Test
    public void updatePet(){
        String updatePetPayload = "{"
                + "\"id\": " + petId + ","
                + "\"category\": {"
                + "    \"id\": 2,"
                + "    \"name\": \"Kedi\""
                + "},"
                + "\"name\": \"Pamuk\","
                + "\"tags\": ["
                + "    {"
                + "        \"id\": 1,"
                + "        \"name\": \"Evcil\""
                + "    }"
                + "],"
                + "\"status\": \"available\""
                + "}";

        given().body(updatePetPayload).contentType(ContentType.JSON).when().put(baseUrl+"/pet").then().statusCode(200);
    }
    @Test
    public void deletePet(){
        given().when().delete(baseUrl + "/pet/" + petId).then().statusCode(200);
    }
}
