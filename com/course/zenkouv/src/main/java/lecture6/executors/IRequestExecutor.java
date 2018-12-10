package lecture6.executors;

import java.util.Map;

import lecture6.constant.RequestType;

public interface IRequestExecutor {
    String doRequest(String uri, RequestType type, Map<String, String> params);
}
