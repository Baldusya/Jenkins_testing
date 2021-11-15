import io.restassured.response.Response;
import models.UserModel;
import utils.APIUtils;
import utils.PropertiesParser;

public class ApiApplicationRequest {

    public Response getPosts() {
        String url = PropertiesParser.propertiesParse("config.properties", "url") +
                EndPoints.POSTS.getEndPoint();
        Response response = APIUtils.getRequest(url);
        return (Response) response.body();
    }

    public Response getDefinitePost(Integer numberOfPost) {
        String url = PropertiesParser.propertiesParse("config.properties", "url") +
                EndPoints.POSTS.getEndPoint() + numberOfPost;
        Response response = APIUtils.getRequest(url);
        return (Response) response.body();
    }

    public Response postForWritePosts(Integer userId, String title, String body) {
        String url = PropertiesParser.propertiesParse("config.properties", "url") +
                EndPoints.POSTS.getEndPoint();
        Response response = APIUtils.postRequest(url, userId, title, body);
        return (Response) response.body();
    }

    public Response getDefiniteUser(Integer numberOfUser) {
        String url = PropertiesParser.propertiesParse("config.properties", "url") +
                EndPoints.USERS.getEndPoint() + numberOfUser;
        Response response = APIUtils.getRequest(url);
        return (Response) response.body();
    }

    public Response getUsers() {
        String url = PropertiesParser.propertiesParse("config.properties", "url") +
                EndPoints.USERS.getEndPoint();
        Response response = APIUtils.getRequest(url);
        return (Response) response.body();
    }

    public boolean isJsonFormat(Response response) {
        return response.getContentType().equals("application/json; charset=utf-8");
    }

    public boolean is5User(UserModel model) {
        UserModel user5 = new UserModel();
        user5.setId(5);
        user5.setName("Chelsey Dietrich");
        user5.setUsername("Kamren");
        user5.setEmail("Lucio_Hettinger@annie.ca");
        UserModel.Address address = new UserModel.Address();
        address.setStreet("Skiles Walks");
        address.setSuite("Suite 351");
        address.setCity("Roscoeview");
        address.setZipcode("33263");
        UserModel.Address.Geo geo = new UserModel.Address.Geo();
        geo.setLat("-31.8129");
        geo.setLng("62.5342");
        address.setGeo(geo);
        user5.setAddress(address);
        user5.setPhone("(254)954-1289");
        user5.setWebsite("demarco.info");
        UserModel.Company company = new UserModel.Company();
        company.setName("Keebler LLC");
        company.setCatchPhrase("User-centric fault-tolerant solution");
        company.setBs("revolutionize end-to-end systems");
        user5.setCompany(company);
        return user5.equals(model);
    }
}
