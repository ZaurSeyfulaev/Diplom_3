package site.nomoreparties.stellarburgers.client;

import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.pojo.UserRequest;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private static final String USER_CREATE = "auth/register";
    private static final String USER_EDIT = "auth/user";
    private static final String USER_LOGIN = "auth/login";

    public ValidatableResponse createUser(UserRequest request) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(request)
                .log()
                .all()
                .post(USER_CREATE)
                .then();

    }
    public ValidatableResponse userLogin(UserRequest request) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(request)
                .post(USER_LOGIN)
                .then();

    }

    public ValidatableResponse deleteUser(String token) {
        return given()
                .header("Authorization", "Bearer" + token)
                .spec(getDefaultRequestSpec())
                .delete(USER_EDIT)
                .then();

    }

}
