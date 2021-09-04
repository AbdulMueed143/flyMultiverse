package au.com.flymultiverse.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = City.TABLE_NAME)
data class City(

//    @ColumnInfo(name = COL_CITY_CODE)
    @SerializedName(COL_CITY_CODE)
    val cityCode : String,

//    @ColumnInfo(name = COL_CITY_NAME)
    @SerializedName(COL_CITY_NAME)
    val cityName : String,

//    @ColumnInfo(name = COL_TIME_ZONE_NAME)
    @SerializedName(COL_TIME_ZONE_NAME)
    val timeZoneName : String,
)  {

    companion object {
        const val TABLE_NAME = "city"

        const val COL_CITY_CODE = "cityCode"
        const val COL_CITY_NAME = "cityName"
        const val COL_TIME_ZONE_NAME = "timeZoneName"

    }
}
