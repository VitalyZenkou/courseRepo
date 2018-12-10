package lecture6.executors.httpComponent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import lecture6.constant.RequestType;
import lecture6.exception.RequestException;
import lecture6.executors.IRequestExecutor;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpComponentExecutor implements IRequestExecutor {

    private final CloseableHttpClient httpClient;

    public HttpComponentExecutor() {
        httpClient = HttpClients.createDefault();
    }

    @Override
    public String doRequest(String uri, RequestType type, Map<String, String> params) {
        try {
            switch (type) {
                case GET: {
                    HttpGet request = new HttpGet(getURIBuilder(uri, params).build());
                    return EntityUtils.toString(httpClient.execute(request).getEntity());
                }
                case PUT: {
                    HttpPut request = new HttpPut(getURIBuilder(uri, params).build());
                    return httpClient.execute(request).getEntity().toString();
                }
                default: {
                    throw new IllegalArgumentException("Invalid request type: " + type);
                }
            }
        } catch (IOException | URISyntaxException e) {
            throw new RequestException("Invalid " + type + " request type!");
        }
    }

    private URIBuilder getURIBuilder(String uri, Map<String, String> params) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(uri);
        for (Map.Entry<String, String> param : params.entrySet()) {
            builder.setParameter(param.getKey(), param.getValue());
        }
        return builder;
    }
}
