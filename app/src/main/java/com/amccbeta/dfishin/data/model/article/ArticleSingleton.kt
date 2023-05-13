package com.amccbeta.dfishin.data.model.article

import com.amccbeta.dfishin.R

object ArticleSingleton {

    private val image = intArrayOf(
        R.drawable.article1,R.drawable.article1,R.drawable.article1,
    )

    private val title = arrayOf(
        "Budidaya Ikan",
        "Budidaya Ikan",
        "Budidaya Ikan",
    )

    private val subTitle = arrayOf(
        "Begini Cara Pemberian Pakan Ikan Gurami yang Baik",
        "Begini Cara Pemberian Pakan Ikan Gurami yang Baik",
        "Begini Cara Pemberian Pakan Ikan Gurami yang Baik",
    )

    private val date = arrayOf(
        "1 day ago",
        "1 day ago",
        "1 day ago",
    )

    private val description = arrayOf(
        "+Ikan lele memiliki peluang pasar yang luas, mulai dari tukang sayur, pedagang di pasar, pedagang lele pinggir jalan, hingga restoran mewah. Ikan lele lebih mudah dibudidayakan dibanding ikan lainnya karena bisa tahan dikembangbiakkan dalam kolam kecil dengan modal yang tidak besar. Selain itu, harga ikan lele juga cenderung stabil.\n" +
                "\n" +
                "Lele termasuk ikan yang mudah dipasarkan jika kualitasnya baik saat dipanen. Untuk membuat lele laku dengan cepat, Bapak/Ibu bisa menjual ikan melalui fitur Lapak Ikan di aplikasi eFisheryKu. ",
        "+Ikan lele memiliki peluang pasar yang luas, mulai dari tukang sayur, pedagang di pasar, pedagang lele pinggir jalan, hingga restoran mewah. Ikan lele lebih mudah dibudidayakan dibanding ikan lainnya karena bisa tahan dikembangbiakkan dalam kolam kecil dengan modal yang tidak besar. Selain itu, harga ikan lele juga cenderung stabil.\n" +
                "\n" +
                "Lele termasuk ikan yang mudah dipasarkan jika kualitasnya baik saat dipanen. Untuk membuat lele laku dengan cepat, Bapak/Ibu bisa menjual ikan melalui fitur Lapak Ikan di aplikasi eFisheryKu. ",
        "+Ikan lele memiliki peluang pasar yang luas, mulai dari tukang sayur, pedagang di pasar, pedagang lele pinggir jalan, hingga restoran mewah. Ikan lele lebih mudah dibudidayakan dibanding ikan lainnya karena bisa tahan dikembangbiakkan dalam kolam kecil dengan modal yang tidak besar. Selain itu, harga ikan lele juga cenderung stabil.\n" +
                "\n" +
                "Lele termasuk ikan yang mudah dipasarkan jika kualitasnya baik saat dipanen. Untuk membuat lele laku dengan cepat, Bapak/Ibu bisa menjual ikan melalui fitur Lapak Ikan di aplikasi eFisheryKu. ",

    )

    val listLocation: ArrayList<ArticleModel>
        get() {
            val list = arrayListOf<ArticleModel>()
            for (position in title.indices){
                val article = ArticleModel()
                article.pict = image[position]
                article.title = title[position]
                article.subTitle = subTitle[position]
                article.date = date[position]
                article.description = description[position]
                list.add(article)

            }
            return list
        }
}