package com.amccbeta.dfishin.data.model.distribusi

import com.amccbeta.dfishin.R
import com.amccbeta.dfishin.data.model.detailfish.DetailFishModel

object DistribusiSingleton {

    private val image = intArrayOf(
        R.drawable.distribusi_satu, R.drawable.distribusi_dua, R.drawable.distribusi_tiga,
        R.drawable.distribusi_empat, R.drawable.distribusi_lima, R.drawable.distribusi_enam,
    )

    private val title = arrayOf(
        "Lusas Wharf",
        "Fish Restaurant & Bar",
        "Gurame Resto",
        "Ubud Resto",
        "Pecel Lele \n" +
                "Lamongan",
        "Bebakaran Jogja",
    )

    val listDistribusi: ArrayList<DistribusiModel>
        get() {
            val list = arrayListOf<DistribusiModel>()
            for (position in title.indices){
                val distribusi = DistribusiModel()
                distribusi.pict = image[position]
                distribusi.title = title[position]
                list.add(distribusi)

            }
            return list
        }
}