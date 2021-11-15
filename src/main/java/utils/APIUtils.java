package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.PostModel;


public class APIUtils {

    public static Response getRequest(String url) {
        return RestAssured.given().accept(ContentType.JSON).when().get(url);
    }

    public static Response postRequest(String url, Integer userId, String title, String body) {
        PostModel model = new PostModel();
        RestAssured.baseURI = url;
        model.setUserId(userId);
        model.setTitle(title);
        model.setBody(body);
        return RestAssured.given().contentType(ContentType.JSON).body(model).when().post();
    }
}
