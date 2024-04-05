package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class FaqResponses(
    @SerializedName("success"  ) var success  : String?   = null,
    @SerializedName("response" ) var response : QResponse? = QResponse()
)

data class Faqs (
    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null,
    @SerializedName("question"   ) var question  : String? = null,
    @SerializedName("Answer"     ) var Answer    : String? = null
)

data class Help (
    @SerializedName("helpline" ) var helpline : String? = null,
    @SerializedName("email"    ) var email    : String? = null
)


data class QResponse (
    @SerializedName("faqs" ) var faqs : ArrayList<Faqs> = arrayListOf(),
    @SerializedName("help" ) var help : ArrayList<Help> = arrayListOf()
)
