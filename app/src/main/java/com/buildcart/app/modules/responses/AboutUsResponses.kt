package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

class AboutUsResponses {
    @SerializedName("success"  ) var success  : String?             = null
    @SerializedName("response" ) var response : List<AboutResponse> = arrayListOf()
}

data class AboutResponse (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("created_at"  ) var createdAt   : String? = null,
    @SerializedName("updated_at"  ) var updatedAt   : String? = null,
    @SerializedName("heading"     ) var heading     : String? = null,
    @SerializedName("description" ) var description : String? = null

)