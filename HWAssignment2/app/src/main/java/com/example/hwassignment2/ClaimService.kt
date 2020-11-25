package com.example.hwassignment2

import android.util.Log
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService (val ctx : MainActivity) {

    companion object {
        private var cService : ClaimService? = null

        fun getInstance (act : MainActivity) : ClaimService {
            if (cService == null) {
                cService = ClaimService(act)
            }

            return cService!!
        }
    }
    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Service response : ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            TODO("Not yet implemented")
        }
    }

    fun addClaim(pObj : Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.33:8080/ClaimService/add"
        // 1. Convert the pObj into JSON string
        val cJsonString= Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(cJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }
}
