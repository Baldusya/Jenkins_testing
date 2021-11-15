public enum EndPoints {
    POSTS("posts/"), USERS("users/");

    private final String endPoint;

    EndPoints(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}
