package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("id"             ) var id           : Int?     = null,
    @SerializedName("pincode"        ) var pincode      : String?  = null,
    @SerializedName("created_at"     ) var createdAt    : String?  = null,
    @SerializedName("updated_at"     ) var updatedAt    : String?  = null,
    @SerializedName("full_name"      ) var fullName     : String?  = null,
    @SerializedName("mobile_number"  ) var mobileNumber : String?  = null,
    @SerializedName("house_no"       ) var houseNo      : String?  = null,
    @SerializedName("house_name"     ) var houseName    : String?  = null,
    @SerializedName("street"         ) var street       : String?  = null,
    @SerializedName("area"           ) var area         : String?  = null,
    @SerializedName("landmark"       ) var landmark     : String?  = null,
    @SerializedName("state"          ) var state        : String?  = null,
    @SerializedName("city"           ) var city         : String?  = null,
    @SerializedName("place"          ) var place        : String?  = null,
    @SerializedName("set_as_default" ) var setAsDefault : Boolean? = null,
    @SerializedName("user"           ) var user         : Int?     = null
)
