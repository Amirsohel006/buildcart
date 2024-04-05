package com.buildcart.app.modules.signuofifteen.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.buildcart.app.R
import com.buildcart.app.data.ProfileDataResponse
import com.buildcart.app.data.SessionManager
import com.buildcart.app.service.APIManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.koin.android.ext.android.bind
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class AccountUpdate : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager


    private var name:String=""
    private var mobileNumber:String=""
    private var email:String=""
    private var profile_picture:String=""
    private var city:String=""
    private var pincode:String=""




    private val pickImage = 100
    private lateinit var imageUri: Uri
    private lateinit var nimage:ImageView
    private lateinit var updatedimagefile: File

    private lateinit var selecetedFileUri:Uri

    var multipartImage: MultipartBody.Part? = null
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {


        sessionManager= SessionManager(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_update)



        name=intent.getStringExtra("username").toString()
        mobileNumber=intent.getStringExtra("phone_number").toString()
        email=intent.getStringExtra("email").toString()
        city=intent.getStringExtra("city").toString()
        pincode=intent.getStringExtra("zipcode").toString()
       // profile_picture=intent.getStringExtra("profile_picture").toString()


        val newname=findViewById<EditText>(R.id.etFullName)
        val newemail=findViewById<EditText>(R.id.etEmailId)
        val newphoneNumber=findViewById<EditText>(R.id.etMobileNumber)
        val cityEdit=findViewById<EditText>(R.id.etCity)
        val pincodeEdit=findViewById<EditText>(R.id.etPincode)
        //val newprofilePicture=findViewById<ImageView>(R.id.imageEllipseSeven)
        nimage=findViewById(R.id.imageEllipseSeven)

        val editProfileImageView:ImageView=findViewById(R.id.editImageview)
        editProfileImageView.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }



        newname.setText(name)
        newemail.setText(email)
        newphoneNumber.setText(mobileNumber)
        cityEdit.setText(city)
        pincodeEdit.setText(pincode)
        Picasso.get().load(sessionManager.fetchProfileImage()).transform(CircleCrop()).into(nimage)



      imageUri=profile_picture.toUri()


val backArrow=findViewById<ImageView>(R.id.imageComputer)
        backArrow.setOnClickListener{
            super.onBackPressed()
        }




        val button=findViewById<AppCompatButton>(R.id.btnUpdate)
        button.setOnClickListener{
            val editname=findViewById<EditText>(R.id.etFullName)
            name=editname.text.toString()

            val editemail=findViewById<EditText>(R.id.etEmailId)
            email=editemail.text.toString()

            val editMobileNumber=findViewById<EditText>(R.id.etMobileNumber)
            mobileNumber=editMobileNumber.text.toString()


            val editCity=findViewById<EditText>(R.id.etCity)
            city=editCity.text.toString()

            val editZipCode=findViewById<EditText>(R.id.etPincode)
            pincode=editZipCode.text.toString()


            fetchData()
        }
        window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
    }


    private fun fetchData() {


        val map: MutableMap<String, RequestBody> = mutableMapOf()
        val name=createPartFromString(name)
        val email=createPartFromString(email)
        val mobile=createPartFromString(mobileNumber)
        val city=createPartFromString(city)
        val pincode=createPartFromString(pincode)

        updatedimagefile=getFile(this,imageUri)

//        updatedimagefile = getFile(this, imageUri)
        //val skills=createPartFromString(skills)
        // val languages=createPartFromString(languages)
        map.put("full_name",name)
        map.put("email",email)
        map.put("mobile_number",mobile)
        map.put("zipcode",pincode)
        map.put("city",city)

            val requestFile: RequestBody = RequestBody.create(
                "image/jpg".toMediaType(),
                updatedimagefile)
            multipartImage =
                MultipartBody.Part.createFormData("photo", updatedimagefile.getName(), requestFile)




        // Make the API call using enqueue for asynchronous execution
        val serviceGenerator = APIManager.apiInterface
        val accessToken = sessionManager.fetchAuthToken()
        val authorization = "Bearer $accessToken"
        val call = serviceGenerator.editUserProfile(authorization,map,multipartImage!!)


        call.enqueue(object : retrofit2.Callback<ProfileDataResponse> {

            override fun onResponse(
                call: Call<ProfileDataResponse>,
                response: Response<ProfileDataResponse>,
            ) {
                if (response.isSuccessful) {
                    val profileResponse = response.body()
//                   if(profileResponse!=null){
//                       val name=findViewById<EditText>(R.id.etGroupTwentyEight11)
//                       val email=findViewById<EditText>(R.id.etGroupTwentyEight111)
//
//                       name.setText(profileResponse.username)
//                       email.setText(profileResponse.email)
//                   }

                    Toast.makeText(
                        this@AccountUpdate,
                        "Profile updated successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    // Handle API error
                    Toast.makeText(
                        this@AccountUpdate,
                        "Failed to update profile",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ProfileDataResponse>, t: Throwable) {
                // Handle network failures or other errors
                Toast.makeText(this@AccountUpdate, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        })
    }



    private fun createPartFromString(text: String): RequestBody {
        return RequestBody.create("text/plain".toMediaTypeOrNull(), text)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            nimage.setImageURI(imageUri)
            val selectedFileURI: Uri =imageUri
            updatedimagefile = getFile(this, selectedFileURI)
            //file = File(selectedFileURI.path.toString())
            Log.d("", "File : " + updatedimagefile.name)
            //uploadedFileName = file.toString()
            println("upload file name ${updatedimagefile.absoluteFile}")

            Log.d("my location","$updatedimagefile")

        }else{
               updatedimagefile=getFile(this,profile_picture.toUri())
//            updatedimagefile=getFile(this,imageUri)
//            Picasso.get().load(updatedimagefile).into(nimage)
        }
    }
    @Throws(IOException::class)
    fun getFile(context: Context, uri: Uri): File {
        val destinationFilename =
            File(context.filesDir.path + File.separatorChar + queryName(context, uri))
        try {
            context.contentResolver.openInputStream(uri).use { ins ->
                createFileFromStream(
                    ins!!,
                    destinationFilename
                )
            }
        } catch (ex: Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
        return destinationFilename
    }
    fun createFileFromStream(ins: InputStream, destination: File?) {
        try {
            FileOutputStream(destination).use { os ->
                val buffer = ByteArray(4096)
                var length: Int
                while (ins.read(buffer).also { length = it } > 0) {
                    os.write(buffer, 0, length)
                }
                os.flush()
            }
        } catch (ex: Exception) {
            Log.e("Save File", ex.message!!)
            ex.printStackTrace()
        }
    }

    private fun queryName(context: Context, uri: Uri): String {
        var name = ""

        val returnCursor = context.contentResolver.query(uri, null, null, null, null)

        returnCursor?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                name = cursor.getString(nameIndex)
            }
        }

        return name
//        val returnCursor = context.contentResolver.query(uri, null, null, null, null)!!
//        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
//        returnCursor.moveToFirst()
//        val name = returnCursor.getString(nameIndex)
//        returnCursor.close()
//        return name
    }




    // Circular crop transformation class
    class CircleCrop : Transformation {
        override fun key(): String {
            return "circleCrop"
        }

        override fun transform(source: Bitmap): Bitmap {
            val size = Math.min(source.width, source.height)
            val x = (source.width - size) / 2
            val y = (source.height - size) / 2

            val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
            if (squaredBitmap != source) {
                source.recycle()
            }

            val bitmap = Bitmap.createBitmap(size, size, source.config)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            val shader = BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = shader
            paint.isAntiAlias = true

            val radius = size / 2f
            canvas.drawCircle(radius, radius, radius, paint)

            squaredBitmap.recycle()
            return bitmap
        }
    }
}