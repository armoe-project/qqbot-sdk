package me.zhenxin.qqbot.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.zhenxin.qqbot.entity.AccessInfo;
import me.zhenxin.qqbot.exception.ApiException;
import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.util.Map;

/**
 * API基类
 *
 * @author 真心
 * @since 2021/12/8 16:53
 */
@Slf4j
public abstract class BaseApi {
    private final String api;
    private final String token;

    private final OkHttpClient client = new OkHttpClient.Builder().build();
    private final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    protected BaseApi(AccessInfo accessInfo) {
        Integer botAppId = accessInfo.getBotAppId();
        String botToken = accessInfo.getBotToken();
        Boolean isUseSandBoxMode = accessInfo.getUseSandBoxMode();
        if (isUseSandBoxMode) {
            api = "https://sandbox.api.sgroup.qq.com";
        } else {
            api = "https://api.sgroup.qq.com";
        }
        this.token = "Bot " + botAppId + "." + botToken;
    }

    protected <T> T get(String url, Class<T> tClass) throws ApiException {
        log.debug("GET Url: {}", url);
        Request request =
                new Request.Builder()
                        .url(api + url)
                        .header("Authorization", token)
                        .get()
                        .build();
        return result(request, tClass);
    }

    protected <T> T post(String path, Map<String, Object> data, Class<T> tClass) throws ApiException {
        log.debug("POST Data: {}", JSON.toJSONString(data));
        RequestBody body = RequestBody.create(JSON.toJSONString(data), mediaType);
        Request request =
                new Request.Builder()
                        .url(api + path)
                        .header("Authorization", token)
                        .post(body)
                        .build();
        return result(request, tClass);
    }

    protected <T> T put(String path, Map<String, Object> data, Class<T> tClass) throws ApiException {
        log.debug("PUT Data: {}", JSON.toJSONString(data));
        RequestBody body = RequestBody.create(JSON.toJSONString(data), mediaType);
        Request request =
                new Request.Builder()
                        .url(api + path)
                        .header("Authorization", token)
                        .put(body)
                        .build();
        return result(request, tClass);
    }

    protected void delete(String path, Map<String, Object> data) throws ApiException {
        log.debug("DELETE Data: {}", JSON.toJSONString(data));
        RequestBody body = RequestBody.create(JSON.toJSONString(data), mediaType);
        Request request =
                new Request.Builder()
                        .url(api + path)
                        .header("Authorization", token)
                        .delete(body)
                        .build();
        result(request, null);
    }

    protected <T> T patch(String path, Map<String, Object> data, Class<T> tClass) throws ApiException {
        log.debug("PATCH Data: {}", JSON.toJSONString(data));
        RequestBody body = RequestBody.create(JSON.toJSONString(data), mediaType);
        Request request =
                new Request.Builder()
                        .url(api + path)
                        .header("Authorization", token)
                        .patch(body)
                        .build();
        return result(request, tClass);
    }

    private <T> T result(Request request, Class<T> tClass) throws ApiException {
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            int status = response.code();
            log.debug("API请求: 状态码 {}", status);
            if (status == 204) {
                log.debug("API请求成功: 无Body");
                return null;
            }
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            String bodyStr = body.string();
            if (status == 201 || status == 202) {
                log.warn("API异步请求成功: {}", bodyStr);
                return null;
            }

            JSONObject obj = JSON.parseObject(bodyStr);
            Integer code = obj.getInteger("code");
            if (code != null) {
                String message = obj.getString("message");
                String traceId = response.header("X-Tps-Trace-Id");
                log.error("API请求错误!");
                log.error("TraceId: {}", traceId);
                log.error("请求地址: {}", request.url().encodedPath());
                log.error("状态码: {}", status);
                log.error("返回内容: {}", bodyStr);
                // 解析requestBody
                RequestBody requestBody = request.body();
                if (requestBody != null) {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    log.error("请求体: {}", buffer.readUtf8());
                }
                exception(code, message, traceId);
            }

            log.debug("API请求成功: {}", bodyStr);
            if (tClass == JSONArray.class) {
                //noinspection unchecked
                return (T) JSON.parseArray(bodyStr);
            }

            if (tClass != null) {
                return JSON.parseObject(bodyStr, tClass);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void exception(Integer code, String message, String traceId) throws ApiException {
        switch (code) {
            case 10001:
                throw new ApiException(code, "账号异常", message, traceId);
            case 10003:
                throw new ApiException(code, "子频道异常", message, traceId);
            case 10004:
                throw new ApiException(code, "频道异常", message, traceId);
            case 11281:
                throw new ApiException(code, "检查是否是管理员失败", message, traceId);
            case 11282:
                throw new ApiException(code, "需要管理员权限", message, traceId);
            case 11251:
                throw new ApiException(code, "AppId 错误", message, traceId);
            case 11252:
                throw new ApiException(code, "检查应用权限失败", message, traceId);
            case 11253:
                throw new ApiException(code, "没有应用权限", message, traceId);
            case 11254:
                throw new ApiException(code, "应用接口被封禁", message, traceId);
            case 11261:
                throw new ApiException(code, "缺少 AppId", message, traceId);
            case 11262:
                throw new ApiException(code, "当前接口不支持使用机器人 Bot Token 调用", message, traceId);
            case 11263:
                throw new ApiException(code, "检查频道权限失败", message, traceId);
            case 11264:
                throw new ApiException(code, "未授予此接口权限", message, traceId);
            case 11265:
                throw new ApiException(code, "机器人已经被封禁", message, traceId);
            case 11241:
                throw new ApiException(code, "缺少 Token", message, traceId);
            case 11242:
                throw new ApiException(code, "校验 Token 失败", message, traceId);
            case 11243:
                throw new ApiException(code, "校验 Token 未通过", message, traceId);
            case 11273:
                throw new ApiException(code, "检查用户权限失败", message, traceId);
            case 11274:
                throw new ApiException(code, "检查用户权限未通过", message, traceId);
            case 11275:
                throw new ApiException(code, "无 AppId", message, traceId);
            case 12001:
                throw new ApiException(code, "替换 ID 失败", message, traceId);
            case 12002:
                throw new ApiException(code, "请求体错误", message, traceId);
            case 12003:
                throw new ApiException(code, "回包错误", message, traceId);
            case 20028:
                throw new ApiException(code, "子频道消息触发限频", message, traceId);
            case 50006:
                throw new ApiException(code, "消息为空", message, traceId);
            case 50035:
                throw new ApiException(code, "内容异常", message, traceId);
            case 304003:
                throw new ApiException(code, "URL未报备", message, traceId);
            case 304004:
                throw new ApiException(code, "没有发送Ark消息权限", message, traceId);
            case 304005:
                throw new ApiException(code, "Embed 长度超限", message, traceId);
            case 304006:
                throw new ApiException(code, "后台配置错误", message, traceId);
            case 304007:
                throw new ApiException(code, "查询频道异常", message, traceId);
            case 304008:
                throw new ApiException(code, "查询机器人异常", message, traceId);
            case 304009:
                throw new ApiException(code, "查询子频道异常", message, traceId);
            case 304010:
                throw new ApiException(code, "图片转存错误", message, traceId);
            case 304011:
                throw new ApiException(code, "模板不存在", message, traceId);
            case 304012:
                throw new ApiException(code, "取模板错误", message, traceId);
            case 304014:
                throw new ApiException(code, "没有模板权限", message, traceId);
            case 304016:
                throw new ApiException(code, "发消息错误", message, traceId);
            case 304017:
                throw new ApiException(code, "图片上传错误", message, traceId);
            case 304018:
                throw new ApiException(code, "机器人没连上 Gateway", message, traceId);
            case 304019:
                throw new ApiException(code, "@全体成员 次数超限", message, traceId);
            case 304020:
                throw new ApiException(code, "文件大小超限", message, traceId);
            case 304021:
                throw new ApiException(code, "下载文件错误", message, traceId);
            case 304022:
                throw new ApiException(code, "推送消息时间限制", message, traceId);
            case 304023:
                throw new ApiException(code, "推送消息异步调用成功, 等待人工审核", message, traceId);
            case 304024:
                throw new ApiException(code, "回复消息异步调用成功, 等待人工审核", message, traceId);
            case 304025:
                throw new ApiException(code, "消息被打击", message, traceId);
            case 304026:
                throw new ApiException(code, "回复的消息ID错误", message, traceId);
            case 304027:
                throw new ApiException(code, "回复的消息过期", message, traceId);
            case 304028:
                throw new ApiException(code, "非艾特当前用户的消息不允许回复", message, traceId);
            case 304029:
                throw new ApiException(code, "调语料服务错误", message, traceId);
            case 304030:
                throw new ApiException(code, "语料不匹配", message, traceId);
            case 501001:
                throw new ApiException(code, "参数校验失败", message, traceId);
            case 501002:
                throw new ApiException(code, "创建子频道公告失败", message, traceId);
            case 501003:
                throw new ApiException(code, "删除子频道公告失败", message, traceId);
            case 501004:
                throw new ApiException(code, "获取频道信息失败", message, traceId);
            case 1100100:
                throw new ApiException(code, "安全打击：消息被限频", message, traceId);
            case 1100101:
                throw new ApiException(code, "安全打击：内容涉及敏感，请返回修改", message, traceId);
            case 1100102:
                throw new ApiException(code, "安全打击：抱歉，暂未获得新功能体验资格", message, traceId);
            case 1100103:
                throw new ApiException(code, "安全打击", message, traceId);
            case 1100104:
                throw new ApiException(code, "安全打击：该群已失效或当前群已不存在", message, traceId);
            case 1100300:
                throw new ApiException(code, "系统内部错误", message, traceId);
            case 1100301:
                throw new ApiException(code, "调用方不是群成员", message, traceId);
            case 1100302:
                throw new ApiException(code, "获取指定频道名称失败", message, traceId);
            case 1100303:
                throw new ApiException(code, "主页频道非管理员不允许发消息", message, traceId);
            case 1100304:
                throw new ApiException(code, "@次数鉴权失败", message, traceId);
            case 1100305:
                throw new ApiException(code, "TinyId转换Uin失败", message, traceId);
            case 1100306:
                throw new ApiException(code, "非私有频道成员", message, traceId);
            case 1100307:
                throw new ApiException(code, "非白名单应用子频道", message, traceId);
            case 1100308:
                throw new ApiException(code, "触发频道内限频", message, traceId);
            case 1100499:
                throw new ApiException(code, "其他错误(" + message + ")", message, traceId);
            default:
                if (code > 500000 && code < 500999) {
                    throw new ApiException(code, "公告错误(" + message + ")", message, traceId);
                } else if (code > 1000000 && code < 2999999) {
                    throw new ApiException(code, "发消息错误(" + message + ")", message, traceId);
                } else {
                    throw new ApiException(code, "未知错误(" + message + ")", message, traceId);
                }

        }
    }
}
