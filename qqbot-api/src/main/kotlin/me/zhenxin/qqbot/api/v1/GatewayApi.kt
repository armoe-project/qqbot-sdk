package me.zhenxin.qqbot.api.v1

import me.zhenxin.qqbot.api.OpenApi
import me.zhenxin.qqbot.entity.AccessInfo
import me.zhenxin.qqbot.entity.Gateway

/**
 * 网关接口
 *
 * @author 真心
 * @since 2023/10/3 20:37
 */
class GatewayApi(accessInfo: AccessInfo) : OpenApi(accessInfo) {
    fun getGateway(): Gateway {
        return get("/gateway", Gateway::class.java)
    }

    fun getBotGateway(): Gateway {
        return get("/gateway/bot", Gateway::class.java)
    }
}