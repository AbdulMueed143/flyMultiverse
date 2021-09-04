package au.com.flymultiverse.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Region.TABLE_NAME)
data class Region(
//    @ColumnInfo(name = COL_REGION_CODE)
    @SerializedName(COL_REGION_CODE)
    val regionCode : String,

//    @ColumnInfo(name = COL_REGION_NAME)
    @SerializedName(COL_REGION_NAME)
    val regionName : String,
)  {

    companion object {
        const val TABLE_NAME = "region"

        const val COL_REGION_CODE = "regionCode"
        const val COL_REGION_NAME = "regionName"
    }
}
