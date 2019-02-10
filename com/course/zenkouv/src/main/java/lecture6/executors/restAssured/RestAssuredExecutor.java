package lecture6.executors.restAssured;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lecture6.constant.RequestType;
import lecture6.executors.IRequestExecutor;


public class RestAssuredExecutor implements IRequestExecutor {

    @Override
    public String doRequest(String uri, RequestType type, Map<String, String> params) {
        RequestSpecification specification = RestAssured.given().params(params);
        switch (type) {
            case GET: {
                return specification.get(uri).asString();
            }
            case PUT: {
                return specification.put(uri).asString();
            }
            default: {
                throw new IllegalArgumentException("Invalid request type: " + type);
            }
        }
    }
}

