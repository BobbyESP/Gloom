package dev.materii.gloom.api.service

import dev.materii.gloom.api.Credentials
import dev.materii.gloom.api.URLs
import dev.materii.gloom.api.dto.auth.AccessTokenResponse
import dev.materii.gloom.api.dto.auth.DeleteTokenBody
import dev.materii.gloom.api.util.ApiResponse
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.header
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubAuthApiService(
    private val client: HttpService
) {

    suspend fun getAccessToken(code: String): ApiResponse<AccessTokenResponse> =
        withContext(Dispatchers.IO) {
            client.request {
                url(URLs.AUTH.ACCESS_TOKEN)
                setBody(
                    FormDataContent(Parameters.build {
                        append("client_id", Credentials.CLIENT_ID)
                        append("client_secret", Credentials.CLIENT_SECRET)
                        append("code", code)
                    })
                )
                method = HttpMethod.Post
            }
        }

    suspend fun deleteAccessToken(token: String): ApiResponse<String> =
        withContext(Dispatchers.IO) {
            client.request {
                header(HttpHeaders.Authorization, "Basic ${Credentials.BASIC_TOKEN}")
                url(URLs.AUTH.DELETE_TOKEN(Credentials.CLIENT_ID))
                setBody(DeleteTokenBody(token))
                method = HttpMethod.Delete
            }
        }

}