package me.zhenxin.qqbot.exception

/**
 * API 请求异常
 *
 * @author 真心
 * @since 2023/10/5 20:30
 */
class ApiException(
    /**
     * 错误码
     */
    val code: Int,
    /**
     * 错误详情
     */
    val detail: String,
    /**
     * 错误 ID
     */
    val traceId: String,
    /**
     * 错误信息
     */
    override val message: String = "Status Code: $code, Detail: $detail, TraceId: $traceId"
) : RuntimeException(message)