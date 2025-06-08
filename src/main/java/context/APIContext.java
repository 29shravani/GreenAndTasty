package context;

import io.restassured.response.Response;

public class APIContext {
    private Response response;
    private String accessToken;
    public void setResponse(Response response){
        this.response = response;

    }
    public Response getResponse(){
        return response;
    }
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;

    }
    public String getAccessToken(){
        return accessToken;
    }
}
