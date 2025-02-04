package network
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import model.LoginRequest
import model.LoginResponse
import utils.NetworkUtils.httpClient
import utils.Sha512

fun ApiLogIn(usuario: String, password:String, onSuccessResponse:(LoginResponse)-> Unit){
    val url="http://127.0.0.1:5000/gestor/login"
//    val httpClient = HttpClient()
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.post(url) {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(usuario, Sha512(password) ))
        }
        if (response.status == HttpStatusCode.OK){
            val user = response.body<LoginResponse>()
            onSuccessResponse(user)
        }else{
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }

}