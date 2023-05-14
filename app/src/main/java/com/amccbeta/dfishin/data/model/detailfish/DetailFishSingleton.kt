package com.amccbeta.dfishin.data.model.detailfish

import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.data.model.article.ArticleModel

object DetailFishSingleton {

    private val image = intArrayOf(
        R.drawable.gurame, R.drawable.lele, R.drawable.nila,
    )

    private val title = arrayOf(
        "Suhu",
        "Pemberian Makan",
        "Kepadatan Populasi",
    )

    private val description = arrayOf(
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary.",
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary.",
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary.",
        )

    val listDetail: ArrayList<DetailFishModel>
        get() {
            val list = arrayListOf<DetailFishModel>()
            for (position in title.indices){
                val detailFish = DetailFishModel()
                detailFish.pict = image[position]
                detailFish.title = title[position]
                detailFish.content = description[position]
                list.add(detailFish)

            }
            return list
        }
}