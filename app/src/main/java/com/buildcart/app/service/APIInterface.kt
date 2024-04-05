package com.buildcart.app.service

import com.buildcart.app.data.ProductDataResponse
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.response.LoginResponseData
import com.buildcart.app.data.response.ProductCategoriesResponseData
import com.buildcart.app.data.response.RequestSignUpResponse
import com.buildcart.app.data.response.SignUpResponse
import com.buildcart.app.data.response.SignUpUpdateResponse
import com.buildcart.app.modules.catogories.data.model.CategoryIdRequest
import com.buildcart.app.modules.homeone.data.AddToCartRequestBody
import com.buildcart.app.modules.homeone.data.model.ProductDetailsDataResponse
import com.buildcart.app.modules.homeone.data.model.ProductResponseData
import com.buildcart.app.modules.homeone.data.model.ProductdescriptionResponse
import com.buildcart.app.modules.homeone.data.model.ProductsResponse
import com.buildcart.app.modules.mycart.data.model.CartProduct
import com.buildcart.app.modules.mycart.data.model.CartProductItem
import com.buildcart.app.modules.orders.data.model.OrderStatusRequest
import com.buildcart.app.modules.orders.data.model.OrdersData
import com.buildcart.app.modules.orders.data.model.OrdersResponseData
import com.buildcart.app.modules.responses.AboutUsResponses
import com.buildcart.app.modules.responses.AddressResponse
import com.buildcart.app.modules.responses.CancelledResponse
import com.buildcart.app.modules.responses.CategoriesResponse
import com.buildcart.app.modules.responses.CompltedOrderResponse
import com.buildcart.app.modules.responses.FaqResponses
import com.buildcart.app.modules.responses.PrivacyPolicy
import com.buildcart.app.modules.responses.PrivacyResponse
import com.buildcart.app.modules.responses.ProductDescriptionResponses
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import java.io.File


interface APIInterface {



    @POST
    fun signUpRequestOTP()

    @FormUrlEncoded
    @POST("accounts/UserData-signup/")
    fun  signUpRequestOTP(
        @Field("mobile_number") mobile_number: String?,
        @Field("referral_code") referral_code: String?
    ): Call<RequestSignUpResponse>


    //accounts/verify-signup-otp/

    @FormUrlEncoded
    @POST("accounts/verify-signup-otp/")
    fun  verifySignUpOTP(
        @Field("mobile_number") mobile_number: String?,
        @Field("otp") otp: String?
    ): Call<RequestSignUpResponse>

    @FormUrlEncoded
    @POST("accounts/UserData-login/")
    fun  verifyLoginOTP(
        @Field("mobile_number") mobile_number: String?,
    ): Call<RequestSignUpResponse>

    @FormUrlEncoded
    @POST("accounts/verify-login-otp/")
    fun  verifyOTP(
        @Field("otp") otp: String?,
    ): Call<LoginResponseData>


    @Multipart
    @POST("accounts/UserData-post-signup/")
    fun signUp(@PartMap() partMap: MutableMap<String, RequestBody>,
               @Part file: MultipartBody.Part)
            : Call<SignUpUpdateResponse>


    @GET("/accounts/get-user-profile/")
    fun getProfileDetails(@Header("Authorization")authorization:String):Call<ProfileDataResponse>

    @Multipart
    @PATCH("/accounts/get-user-profile/")
    fun editUserProfile(@Header("Authorization")authorization:String,@PartMap() partMap: MutableMap<String, RequestBody>,@Part file: MultipartBody.Part):Call<ProfileDataResponse>


    @GET("/product/all_product_list/")
    suspend fun getAllProducts(): ProductDataResponse

    @GET("/product/categories-list/")
    suspend fun getAllCategories(): Response<ProductCategoriesResponseData>

    @POST("/cart/add-product-cart/")
    suspend fun addProductToCart(@Header("Authorization")authorization:String,@Body requestBody: AddToCartRequestBody):Response<ProductDataResponse>


    @GET("/cart/add-product-cart/")
    suspend fun getCartProducts(@Header("Authorization")authorization:String): Response<List<CartProductItem>>

    @POST("/product/auth_all_product_list/")
    suspend fun showProductsByCategory(@Header("Authorization")authorization:String,@Body categoryIdRequest: CategoryIdRequest):ProductDataResponse


    @POST("/order/add_delivery_address/")
    suspend fun addDeliveryAddress(@Header("Authorization")authorization:String)

    @PATCH("/accounts/edit_delivery_address/2")
    suspend fun editDeliveryAddress(@Header("Authorization")authorization:String)


    @POST("/product/auth_all_product_list/")
    suspend fun allProductsUser(@Header("Authorization")authorization:String)

    @POST("/order/my_order_status/")
    suspend fun activeOrders(@Header("Authorization")authorization:String,@Body request: OrderStatusRequest):Response<OrdersResponseData>

    @GET("/order/track_order/1/")
    suspend fun trackOrder(@Header("Authorization")authorization:String)

    @GET("/order/cancel_order/1/")
    suspend fun cancelOrder(@Header("Authorization")authorization:String)

    @GET("/product/view_coupons/")
    suspend fun viewAllCoupons(@Header("Authorization")authorization:String)

    @GET("/product/product-detail/{product_id}/")
    suspend fun getProductDetailsByProductID(@Header("Authorization")authorization:String,
                                             @Path("product_id") product_id: String):Response<ProductDetailsDataResponse>


    @GET("/order/order-add-address/")
    suspend fun viewAllAddress(@Header("Authorization")authorization:String)


    @GET("/cart/add-product-cart/")
    fun getallproducts(@Header("Authorization")authorization: String):Call<CartProduct>


    @POST("/order/my_order_status/")
    fun getActiveOrder(
        @Header("Authorization") authorization: String,
        @Body request: OrderStatusRequest
    ): Call<CategoriesResponse>

    @POST("/order/my_order_status/")
    fun getCompletedOrder(
        @Header("Authorization") authorization: String,
        @Body request: OrderStatusRequest
    ): Call<CompltedOrderResponse>


    @POST("/order/my_order_status/")
    fun getCancelledOrder(
        @Header("Authorization") authorization: String,
        @Body request: OrderStatusRequest
    ): Call<CancelledResponse>



    @GET("/product/product-detail/{product_id}/")
    fun getProductWithDescription(@Header("Authorization")authorization:String,
                                  @Path("product_id") product_id: String):Call<ProductdescriptionResponse>


    @FormUrlEncoded
    @POST("/cart/add-product-cart/")
    fun addtocart(
        @Header("Authorization")authorization:String,
        @Field("product_id")product_id:String,
        @Field("quantity")quatity:String
    ):Call<ProductDescriptionResponses>


    @GET("/order/order-add-address/")
    fun getAllAddresses(
        @Header("Authorization")authorization:String,
    ):Call<List<AddressResponse>>


    @FormUrlEncoded
    @POST("/order/add_delivery_address/")
    fun postAddress(@Header("Authorization")token: String,
                    @Field("full_name")name:String,
                    @Field("mobile_number")number:String,
                    @Field("place")locality:String,
                    @Field("house_no")flat_no:String,
                    @Field("city")city:String,
                    @Field("state")state:String,
                    @Field("pincode")postal_code:String,
                    @Field("landmark")type_of_address:String,
                    @Field("house_name")house_name:String,
                    @Field("area")area:String,
                    @Field("street")street:String,
                    @Field("set_as_default")default:String):Call<AddressResponse>


    @DELETE("/cart/remove-increase-product-cart/{id}/")
    fun deleteFromCart(
        @Header("Authorization")token: String,
        @Path("id") id: String
    ):Call<CartProduct>


    @GET("/accounts/privacy-policies/")
    fun getPrivacyPolicy(
        @Header("Authorization")token: String
    ):Call<PrivacyPolicy>


    @GET("/accounts/aboutus/")
    fun getAboutUs(
        @Header("Authorization")token: String
    ):Call<AboutUsResponses>


    @GET("/accounts/help-faqs/")
    fun getFaqs(
        @Header("Authorization")token: String
    ):Call<FaqResponses>
}