package com.example.imdbexample.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class MostPopularData(
    public val items : List<MostPopularDataDetail>,
    public val errorMessage : String
)

data class MostPopularDataDetail(
    var id : String,
    public var rank : String,
    public var rankUpDown : String,
    public var title : String,
    public var fullTitle : String,
    public var year : String,
    public var image : String,
    public var crew : String,
    public var imDbRating : String,
    public var imDbRatingCount : String
) {
    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        public fun loadImage(view: ImageView, image: String?) {
            if(image != null)
                Glide.with(view.context)
                    .load(image)
                    .into(view)
        }
    }
}