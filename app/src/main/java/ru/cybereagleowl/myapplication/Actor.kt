package ru.cybereagleowl.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(val picture: Int = -1, val name: CharSequence = "") : Parcelable
