package com.epam.greenandtasty.utils;


import com.epam.greenandtasty.models.UserLogin;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.epam.greenandtasty.utils.ApiReader.*;

public class AuthUtil {
    private static final Logger logger = LogManager.getLogger(AuthUtil.class);


    private AuthUtil(){}

    public static String login(String email, String password){
        logger.info("Logging in with email: {}", email);


        UserLogin user = new UserLogin.UserBuilder()
                .setEmail(email)
                .setPassword(password)
                .builder();

        Response response = RequestHelper.post(getSignIn(), user);

        if(response.getStatusCode() == 200){
            String token = response.jsonPath().getString("data.accessToken");
            return token;
        }else{
            logger.error("Failed to login. Status code: {}",
                    response.getStatusCode());
            throw new RuntimeException("Failed to login: "+ response.getBody().asString());
        }

    }



}
