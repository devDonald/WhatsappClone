package com.codeplateau.whatsappclone

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

class Profile : AppCompatActivity() {
    private lateinit var take_picture: ImageView
    private lateinit var picture_display: ImageView

    //two constants to specify our actions, either we are picking images from gallery or camera
    private val GALLERY = 10
    private val CAMERA = 21
    internal var output: File? = null

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Profile"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        picture_display = findViewById(R.id.profile_image)


        take_picture = findViewById(R.id.imgFloating)
        take_picture.setOnClickListener(View.OnClickListener {

            //create an object of the alert dialog
            val pictureDialog = AlertDialog.Builder(this)

            // we set out title
            pictureDialog.setTitle("Select Action")

            //we specify the options on this line
            val pictureDialogItems =
                arrayOf("Select photo from gallery", "Capture photo from camera")
            //we set our actions here. if user select any option what should it do
            pictureDialog.setItems(
                pictureDialogItems
            ) { dialog, which ->
                when (which) {
                    //action 1 chooses image from the gallery
                    0 -> choosePhotoFromGallary()//this function that performs the action is below
                    //action 2 takes a photo from the camera
                    1 -> takePhotoFromCamera()//this function that perform this action is below
                }
            }
            //always put this line for the dialog to show
            pictureDialog.show()

            val bitmap = (picture_display.getDrawable() as BitmapDrawable).getBitmap()
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val image = stream.toByteArray()
        })




    }

    fun choosePhotoFromGallary() {

        //create an object of an Intent that picks files for you and spcify that it should pick images
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, GALLERY)

    }

    private fun takePhotoFromCamera() {
        //allows you to use your phone's camera to snap pitures
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivityForResult(intent, CAMERA)
    }

    //After selecting an image from gallery or capturing photo from camera, an onActivityResult() method is executed.
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        // checks if we picked image from Gallery
        if (requestCode == GALLERY) {
            if (data != null) {
                //gets the image we picked
                val contentURI = data!!.data
                try {
                    picture_display = findViewById(R.id.profile_image)
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    //displays the image for us on our image view
                    picture_display!!.setImageBitmap(bitmap)

                }
                //catches erros if there is any
                catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        }
        //checks if we snapped picture with camera
        else if (requestCode == CAMERA) {
            //gets the image we snapped with the camera
            picture_display = findViewById(R.id.profile_image)
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            //displays the image on our image view
            picture_display!!.setImageBitmap(thumbnail)
            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show()
        }


    }
}
        val actionBar = supportActionBar
        actionBar!!.title = "Profile"
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
