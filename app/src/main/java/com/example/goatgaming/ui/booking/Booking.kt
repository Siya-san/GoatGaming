package com.example.goatgaming.ui.booking

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import java.util.Date

data class Booking(var booking_type:String?=null,var booking_date: Date?=null,var booking_rate:String?=null,@DrawableRes val imageResourceId: Int?=0) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        Date(parcel.readLong()),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(booking_type)
        parcel.writeLong(booking_date?.time ?: 0L)
        parcel.writeString(booking_rate)
        parcel.writeValue(imageResourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Booking> {
        override fun createFromParcel(parcel: Parcel): Booking {
            return Booking(parcel)
        }

        override fun newArray(size: Int): Array<Booking?> {
            return arrayOfNulls(size)
        }
    }
}
