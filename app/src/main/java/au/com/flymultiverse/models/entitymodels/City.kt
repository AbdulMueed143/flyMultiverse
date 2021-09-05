package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName(COL_CITY_CODE)
    val cityCode : String?,

    @SerializedName(COL_CITY_NAME)
    val cityName : String?,

    @SerializedName(COL_TIME_ZONE_NAME)
    val timeZoneName : String?,
) : Parcelable  {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cityCode)
        parcel.writeString(cityName)
        parcel.writeString(timeZoneName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }

        const val COL_CITY_CODE = "cityCode"
        const val COL_CITY_NAME = "cityName"
        const val COL_TIME_ZONE_NAME = "timeZoneName"
    }
}
