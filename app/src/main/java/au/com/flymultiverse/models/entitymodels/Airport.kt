package au.com.flymultiverse.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = Airport.TABLE_NAME)
data class Airport(
    @PrimaryKey
    @ColumnInfo(name = COL_AIRPORT_CODE)
    @SerializedName(COL_AIRPORT_CODE)
    val airportCode : String,

    @ColumnInfo(name = COL_AIRPORT_NAME)
    @SerializedName(COL_AIRPORT_NAME)
    val airportName : String,

    @ColumnInfo(name = COL_INTERNATIONAL_AIRPORT)
    @SerializedName(COL_INTERNATIONAL_AIRPORT)
    val internationalAirport : Boolean = false,

    @ColumnInfo(name = COL_DOMESTIC_AIRPORT)
    @SerializedName(COL_DOMESTIC_AIRPORT)
    val domesticAirport : Boolean = false,

    @ColumnInfo(name = COL_REGIONAL_AIRPORT)
    @SerializedName(COL_REGIONAL_AIRPORT)
    val regionalAirport : Boolean = false,

    @ColumnInfo(name = COL_ONLINE_INDICATOR)
    @SerializedName(COL_ONLINE_INDICATOR)
    val onlineIndicator : Boolean = false,

    @ColumnInfo(name = COL_ETICKETABLE_AIRPORT)
    @SerializedName(COL_ETICKETABLE_AIRPORT)
    val eticketableAirport : Boolean = false,

    @SerializedName(COL_LOCATION)
    @Embedded
    val location : Location?,

    @SerializedName(COL_CITY)
    @Embedded
    val city : City?,

    @SerializedName(COL_COUNTRY)
    @Embedded
    val country : Country?,

    @SerializedName(COL_REGION)
    @Embedded
    val region : Region?,

    ) : Cloneable {

        companion object {
            const val TABLE_NAME = "Airport"

            const val COL_AIRPORT_CODE = "airportCode"
            const val COL_INTERNATIONAL_AIRPORT = "internationalAirport"
            const val COL_DOMESTIC_AIRPORT = "domesticAirport"
            const val COL_REGIONAL_AIRPORT = "regionalAirport"
            const val COL_ONLINE_INDICATOR = "onlineIndicator"
            const val COL_ETICKETABLE_AIRPORT = "eticketableAirport"
            const val COL_AIRPORT_NAME = "airportName"
            const val COL_LOCATION = "location"
            const val COL_CITY = "city"
            const val COL_COUNTRY = "country"
            const val COL_REGION = "region"

        }

    }
