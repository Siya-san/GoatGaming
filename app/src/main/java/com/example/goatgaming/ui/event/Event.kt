package com.example.goatgaming.ui.event

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Event(var event_name:String?=null, var event_date: Date?=null, var event_prize_pool: Double?=0.0,var event_entry_fee:Double?=0.0,var imageResource: Int?=0) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        Date(parcel.readLong()),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(event_name)
        parcel.writeLong(event_date?.time ?: 0L)
        parcel.writeValue(event_prize_pool)
        parcel.writeValue(event_entry_fee)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }
}
