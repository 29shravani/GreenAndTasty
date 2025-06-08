package hooks;

import context.APIContext;
import io.cucumber.java.Before;

public class APIHooks {
    private APIContext apiContext;

    public APIHooks(APIContext apiContext){
        this.apiContext = apiContext;
    }

}
