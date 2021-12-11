package me.zhenxin.qqbot.api;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * API基类
 *
 * @author 真心
 * @email qgzhenxin@qq.com
 * @since 2021/12/8 16:53
 */
class BaseApi {
    private final String api;
    private final String token;

    protected BaseApi(Boolean isSandBoxMode, String token) {
        if (isSandBoxMode) {
            api = "https://sandbox.api.sgroup.qq.com";
        } else {
            api = "https://api.sgroup.qq.com";
        }
        this.token = token;
    }

    protected String get(String url) {
        HttpRequest request = HttpRequest.get(api + url);
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return response.body();
    }

    protected String post(String path, Map<String, Object> data) {
        HttpRequest request = HttpRequest
                .post(api + path)
                .body(JSONUtil.toJsonStr(data));
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return response.body();
    }

    protected String put(String path, Map<String, Object> data) {
        HttpRequest request = HttpRequest
                .put(api + path)
                .body(JSONUtil.toJsonStr(data));
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return response.body();
    }

    protected String delete(String path, Map<String, Object> data) {
        HttpRequest request = HttpRequest
                .delete(api + path)
                .body(JSONUtil.toJsonStr(data));
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return response.body();
    }

    protected String patch(String path, Map<String, Object> data) {
        HttpRequest request = HttpRequest
                .patch(api + path)
                .body(JSONUtil.toJsonStr(data));
        request.header("Authorization", token);
        HttpResponse response = request.execute();
        return response.body();
    }
}
