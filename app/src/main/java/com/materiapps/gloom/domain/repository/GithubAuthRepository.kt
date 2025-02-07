package com.materiapps.gloom.domain.repository

import com.materiapps.gloom.rest.service.GithubAuthApiService

class GithubAuthRepository(
    private val service: GithubAuthApiService
) {

    suspend fun getAccessToken(code: String) = service.getAccessToken(code)

    suspend fun deleteAccessToken(token: String) = service.deleteAccessToken(token)

}