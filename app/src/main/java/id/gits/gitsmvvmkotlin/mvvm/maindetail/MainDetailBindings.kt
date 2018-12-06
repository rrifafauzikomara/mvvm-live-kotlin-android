package id.gits.gitsmvvmkotlin.mvvm.maindetail

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso
import id.gits.gitsmvvmkotlin.R

object MainDetailBindings {

    @BindingAdapter("android:imageSource")
    @JvmStatic
    fun setImageSource(imageView: ImageView, urlSource: String) {
        if (!TextUtils.isEmpty(urlSource)) {
            Picasso.with(imageView.context)
                    .load(urlSource)
                    .error(R.color.colorAccent)
                    .into(imageView)
        }
    }
}