package me.zhenxin.qqbot.api

import me.zhenxin.qqbot.api.v1.GatewayApi
import me.zhenxin.qqbot.entity.AccessInfo

/**
 * API 管理器
 *
 * @author 真心
 * @since 2023/10/3 20:37
 */
class ApiManager(private val accessInfo: AccessInfo) {

    fun getGatewayApi(): GatewayApi {
        return GatewayApi(accessInfo)
    }
}