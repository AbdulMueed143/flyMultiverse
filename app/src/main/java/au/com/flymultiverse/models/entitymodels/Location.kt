package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName(COL_ABOVE_SEA_LEVEL)
    val aboveSeaLevel : String?,

    @SerializedName(COL_LATITUDE)
    val latitude : Double?,

    @SerializedName(COL_LONGITUDE)
    val longitude : Double?,

    @SerializedName(COL_LATITUDE_RADIUS)
    val latitudeRadius : Double?,

    @SerializedName(COL_LONGITUDE_RADIUS)
    val longitudeRadius : Double?,

    @SerializedName(COL_LATITUDE_DIRECTION)
    val latitudeDirection : String?,

    @SerializedName(COL_LONGITUDE_DIRECTION)
    val longitudeDirection : String?,

    )  : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(aboveSeaLevel)
        parcel.writeValue(latitude)
        parcel.writeValue(longitude)
        parcel.writeValue(latitudeRadius)
        parcel.writeValue(longitudeRadius)
        parcel.writeString(latitudeDirection)
        parcel.writeString(longitudeDirection)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }

        const val COL_ABOVE_SEA_LEVEL = "aboveSeaLevel"
        const val COL_LATITUDE = "latitude"
        const val COL_LONGITUDE = "longitude"
        const val COL_LATITUDE_RADIUS = "latitudeRadius"
        const val COL_LONGITUDE_RADIUS = "longitudeRadius"
        const val COL_LATITUDE_DIRECTION = "latitudeDirection"
        const val COL_LONGITUDE_DIRECTION = "longitudeDirection"
    }
}
