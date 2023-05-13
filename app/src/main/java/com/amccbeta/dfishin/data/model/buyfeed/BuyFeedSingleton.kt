package com.amccbeta.dfishin.data.model.buyfeed

import com.amccbeta.dfishin.R

object BuyFeedSingleton {

    private val image = intArrayOf(
        R.drawable.buyfeed_satu, R.drawable.buyfeed_dua, R.drawable.buyfeed_tiga,
        R.drawable.buyfeed_empat, R.drawable.buyfeed_lima, R.drawable.buyfeed_enam,
    )

    private val title = arrayOf(
        "HI PRO VITE 781",
        "PELET SUPRA ZT 20 KG",
        "PF 500 PF 800 1 KG",
        "HI PRO VITE 781",
        "Pelet Lele",
        "Penghilang bau",
    )

    private val harga = arrayOf(
        "Rp9.200",
        "Rp9.200",
        "Rp9.200",
        "Rp135.000",
        "Rp120.200",
        "RP8.500",
    )

    val listBuyFeed: ArrayList<BuyFeedModel>
        get() {
            val list = arrayListOf<BuyFeedModel>()
            for (position in title.indices){
                val buyFeedList = BuyFeedModel()
                buyFeedList.pict = image[position]
                buyFeedList.title = title[position]
                buyFeedList.subTitle = harga[position]
                list.add(buyFeedList)

            }
            return list
        }
}