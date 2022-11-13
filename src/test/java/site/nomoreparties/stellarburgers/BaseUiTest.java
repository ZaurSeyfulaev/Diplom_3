package site.nomoreparties.stellarburgers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import site.nomoreparties.stellarburgers.client.UserClient;
import site.nomoreparties.stellarburgers.pojo.UserRequest;
import site.nomoreparties.stellarburgers.valuegenerator.UserDataGenerator;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public abstract class BaseUiTest {
    private static UserDataGenerator userDataGenerator;
    private static UserClient userClient;
    public static String name;
    public static String email;
    public static String password;
    private static String token;

    @BeforeClass
    public static void setUp() {

        userDataGenerator = new UserDataGenerator();
        name = userDataGenerator.getRandomName(5);
        email = userDataGenerator.getRandomEmail(5);
        password = userDataGenerator.getPassword(6);

        UserRequest createUserRequest = new UserRequest();
        userClient = new UserClient();
        createUserRequest.userRegistration(name, email, password);
        token = userClient.createUser(createUserRequest)
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("success", equalTo(true))
                .extract()
                .path("accessToken");
    }

    @AfterClass
    public static void tearDown() {
        if (token != null) {
            userClient.deleteUser(token)
                    .assertThat()
                    .statusCode(SC_ACCEPTED)
                    .body("success", is(true));
        }
    }

}
