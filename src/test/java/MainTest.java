import com.google.common.collect.Ordering;
import io.restassured.response.Response;
import models.PostModel;
import models.UserModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesParser;

import java.util.ArrayList;
import java.util.List;


public class MainTest extends BaseTest {

    @Test
    public void getAllPostsTest() {
        logger.info("First test step");
        Response posts = request.getPosts();
        posts.then().assertThat().statusCode(200);
        List<PostModel> postModels = posts.then().extract().body().jsonPath().getList("", PostModel.class);
        List<Integer> modelsId = new ArrayList<>();
        for (PostModel postModel : postModels) {
            modelsId.add(postModel.getId());
        }
        Assert.assertTrue(Ordering.natural().isOrdered(modelsId), "models id is not ordering");

        logger.info("Second test step");
        Response post99 = request.getDefinitePost(99);
        post99.then().assertThat().statusCode(200);
        PostModel postModelOf99Post = post99.then().extract().body().as(PostModel.class);
        Assert.assertEquals((int) postModelOf99Post.getUserId(), 10, "user id is not correct");
        Assert.assertEquals((int) postModelOf99Post.getId(), 99, "id is not correct");
        Assert.assertFalse(postModelOf99Post.getTitle().isEmpty(), "title is empty");
        Assert.assertFalse(postModelOf99Post.getBody().isEmpty(), "body is empty");

        logger.info("Third test step");
        Response post150 = request.getDefinitePost(150);
        post150.then().assertThat().statusCode(404);
        PostModel postModelOf150Post = post150.then().extract().body().as(PostModel.class);
        Assert.assertNull(postModelOf150Post.getBody(), "body is not empty");

        logger.info("Fourth test step");
        int userId = Integer.parseInt(PropertiesParser.propertiesParse("config.properties", "userId"));
        String randomTitle = RandomStringUtils.randomAlphabetic(5);
        String randomBody = RandomStringUtils.randomAlphabetic(10);
        Response responsePostRequest = request.postForWritePosts(userId, randomTitle, randomBody);
        responsePostRequest.then().assertThat().statusCode(201);
        PostModel postModelOfPostedRequest = responsePostRequest.then().extract().body().as(PostModel.class);
        Assert.assertEquals(randomTitle, postModelOfPostedRequest.getTitle(), "title is not equals with posted");
        Assert.assertEquals(randomBody, postModelOfPostedRequest.getBody(), "body is not equals with posted");
        Assert.assertNotNull(postModelOfPostedRequest.getId(), "id is null");

        logger.info("Fifth test step");
        Response users = request.getUsers();
        users.then().assertThat().statusCode(200);
        Assert.assertTrue(request.isJsonFormat(users), "users returned not in json format");
        List<UserModel> userModels = users.then().extract().body().jsonPath().getList("", UserModel.class);
        System.out.println(userModels.get(4));
        Assert.assertTrue(request.is5User(userModels.get(4)), "user 5 is not equals with necessary");

        logger.info("Sixth test step");
        Response user5 = request.getDefiniteUser(5);
        user5.then().assertThat().statusCode(200);
        UserModel userModel5 = user5.then().extract().body().as(UserModel.class);
        Assert.assertEquals(userModel5, userModels.get(4), "user 5 is not equals with findings");
    }
}
