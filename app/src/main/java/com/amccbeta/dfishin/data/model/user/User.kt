package com.amccbeta.dfishin.data.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var email : String ?= "",
    var password : String ?= "",
    var url : String ?= "",
    var username : String ?= "",
    var telepon : String ?= "",
) : Parcelable