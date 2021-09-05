package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Location.TABLE_NAME)
data class Location(
//    @ColumnInfo(name = COL_ABOVE_SEA_LEVEL)
    @SerializedName(COL_ABOVE_SEA_LEVEL)
    val aboveSeaLevel : String?,

//    @ColumnInfo(name = COL_LATITUDE)
    @SerializedName(COL_LATITUDE)
    val latitude : Double?,

//    @ColumnInfo(name = COL_LONGITUDE)
    @SerializedName(COL_LONGITUDE)
    val longitude : Double?,

//    @ColumnInfo(name = COL_LATITUDE_RADIUS)
    @SerializedName(COL_LATITUDE_RADIUS)
    val latitudeRadius : Double?,

//    @ColumnInfo(name = COL_LONGITUDE_RADIUS)
    @SerializedName(COL_LONGITUDE_RADIUS)
    val longitudeRadius : Double?,

//    @ColumnInfo(name = COL_LATITUDE_DIRECTION)
    @SerializedName(COL_LATITUDE_DIRECTION)
    val latitudeDirection : String?,

//    @ColumnInfo(name = COL_LONGITUDE_DIRECTION)
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

        const val TABLE_NAME = "location"

        const val COL_ABOVE_SEA_LEVEL = "aboveSeaLevel"
        const val COL_LATITUDE = "latitude"
        const val COL_LONGITUDE = "longitude"
        const val COL_LATITUDE_RADIUS = "latitudeRadius"
        const val COL_LONGITUDE_RADIUS = "longitudeRadius"
        const val COL_LATITUDE_DIRECTION = "latitudeDirection"
        const val COL_LONGITUDE_DIRECTION = "longitudeDirection"
    }
}
