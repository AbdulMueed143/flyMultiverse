package au.com.flymultiverse.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Country.TABLE_NAME)
data class Country(
//    @ColumnInfo(name = COL_COUNTRY_CODE)
    @SerializedName(COL_COUNTRY_CODE)
    val countryCode : String,

//    @ColumnInfo(name = COL_COUNTRY_NAME)
    @SerializedName(COL_COUNTRY_NAME)
    val countryName : String,
)  {

    companion object {
        const val TABLE_NAME = "country"

        const val COL_COUNTRY_CODE = "countryCode"
        const val COL_COUNTRY_NAME = "countryName"

    }
}
