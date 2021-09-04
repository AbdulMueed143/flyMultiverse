package au.com.flymultiverse.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Location.TABLE_NAME)
data class Location(
//    @ColumnInfo(name = COL_ABOVE_SEA_LEVEL)
    @SerializedName(COL_ABOVE_SEA_LEVEL)
    val aboveSeaLevel : String,

//    @ColumnInfo(name = COL_LATITUDE)
    @SerializedName(COL_LATITUDE)
    val latitude : Double,

//    @ColumnInfo(name = COL_LONGITUDE)
    @SerializedName(COL_LONGITUDE)
    val longitude : Double,

//    @ColumnInfo(name = COL_LATITUDE_RADIUS)
    @SerializedName(COL_LATITUDE_RADIUS)
    val latitudeRadius : Double,

//    @ColumnInfo(name = COL_LONGITUDE_RADIUS)
    @SerializedName(COL_LONGITUDE_RADIUS)
    val longitudeRadius : Double,

//    @ColumnInfo(name = COL_LATITUDE_DIRECTION)
    @SerializedName(COL_LATITUDE_DIRECTION)
    val latitudeDirection : String,

//    @ColumnInfo(name = COL_LONGITUDE_DIRECTION)
    @SerializedName(COL_LONGITUDE_DIRECTION)
    val longitudeDirection : String,

    )  {

    companion object {
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
