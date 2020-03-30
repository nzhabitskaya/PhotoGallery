package com.mobile.android.chameapps.photoposes.ui.views

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.tools.setLocalImage
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_add_image_dialog.*

abstract class AddImageDialogActivity : AppCompatActivity(), AddImageDialogContract.View {
    override val clickSave: PublishSubject<Drawable?> = PublishSubject.create()

    companion object {
        private const val GALLERY_IMAGE_REQ_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image_dialog)
    }

    override fun closeDialog() {
        finish()
    }

    fun pickGalleryImage(view: View) {
        ImagePicker.with(this)
            .crop()
            .galleryOnly()
            .maxResultSize(1080, 1920)
            .start(GALLERY_IMAGE_REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.e("TAG", "Path:${ImagePicker.getFilePath(data)}")
            val file = ImagePicker.getFile(data)!!
            when (requestCode) {
                GALLERY_IMAGE_REQ_CODE -> {
                    (findViewById<View>(R.id.bg) as ImageView).setLocalImage(file)
                    findViewById<View>(R.id.bt_create_account).setBackgroundColor(getColor(R.color.pink_400))
                    findViewById<View>(R.id.bt_create_account).setOnClickListener {
                        clickSave.onNext(bg.drawable)
                    }
                }
            }
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}