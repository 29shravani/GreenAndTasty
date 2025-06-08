package utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestHelper {
    public static RequestSpecification requestSpecification;



    static {
        RequestHelper.requestSpecification = given()
                .header("Content-Type", "application/json")
                .baseUri(ApiReader.getBaseUrl());

    }

    public static Response getWithAuth(String api, String accessToken ){

        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(api);

    }
    public static Response postWithAuth(String api, Object payload, String accessToken){

        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .when()
                .post(api);

    }



    public static Response get(String api){
        return given()
                .spec(requestSpecification)
                .when()
                .get(api);
    }
    public static Response post(String api, Object object){
        return given()
                .spec(requestSpecification)
                .body(object)
                .when()
                .post(api);
    }
    // GET with query parameters
    public static Response getWithQueryParams(String api, Map<String, Object> queryParams) {
        return given()
                .spec(requestSpecification)
                .queryParams(queryParams)
                .when()
                .get(api);
    }


    public static Response postWithQueryParams(String api, Object payload,Map<String, Object> queryParams) {
        return given()
                .spec(requestSpecification)
                .queryParams(queryParams)
                .body(payload)
                .when()
                .post(api);
    }

    public static Response deleteWithAuth(String api, String accessToken){
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete(api);


    }
    public static Response delete(String api){

                return given()
                        .spec(requestSpecification)
                        .when()
                        .delete(api);


    }


}
