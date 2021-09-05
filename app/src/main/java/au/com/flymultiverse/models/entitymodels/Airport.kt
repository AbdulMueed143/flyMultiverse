package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = Airport.TABLE_NAME)
data class Airport(
    @PrimaryKey
    @ColumnInfo(name = COL_AIRPORT_CODE)
    @SerializedName(COL_AIRPORT_CODE)
    val airportCode : String,

    @ColumnInfo(name = COL_AIRPORT_NAME)
    @SerializedName(COL_AIRPORT_NAME)
    val airportName : String?,

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

    ) : Parcelable {

    @Ignore
    var internationalAirportString : String = ""
        get() {
            return "International Airport ${internationalAirport} "
        }

    @Ignore
    var domesticAirportString : String = ""
        get() {
            return "Domestic Airport ${domesticAirport} "
        }

    @Ignore
    var regionalAirportString : String = ""
        get() {
            return "Regional Airport ${regionalAirport} "
        }

    @Ignore
    var onlineIndicatorString : String = ""
        get() {
            return "Online Indicator ${onlineIndicator} "
        }

    @Ignore
    var eticketableAirportString : String = ""
        get() {
            return "E-Ticketable Airport ${eticketableAirport} "
        }

    @Ignore
    var cityInformation : String = ""
        get() {
            return "City: ${city?.cityName} Code ${city?.cityCode}"
        }

    @Ignore
    var regionInformation : String = ""
        get() {
            return "Region: ${region?.regionName}, Code ${region?.regionCode}"
        }

    @Ignore
    var countryInformation : String = ""
        get() {
            return "Country: ${country?.countryName}, Code ${country?.countryCode}"
        }

    @Ignore
    var locationInformation : String = ""
        get() {
            return "Location: Above Sea Level ${location?.aboveSeaLevel}, Latitude ${location?.latitude}, Longitude ${location?.longitude}" +
                    "Latitude Radius ${location?.latitudeRadius}, Longitude Radius ${location?.longitudeRadius}" +
                    "Latitude ${location?.latitudeDirection}, Longitude ${location?.longitudeDirection}"
        }


    constructor(parcel: Parcel) : this(
        airportCode = parcel.readString() ?: "",
        airportName = parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readParcelable(City::class.java.classLoader),
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.readParcelable(Region::class.java.classLoader)
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(airportCode)
        parcel.writeString(airportName)
        parcel.writeByte(if (internationalAirport) 1 else 0)
        parcel.writeByte(if (domesticAirport) 1 else 0)
        parcel.writeByte(if (regionalAirport) 1 else 0)
        parcel.writeByte(if (onlineIndicator) 1 else 0)
        parcel.writeByte(if (eticketableAirport) 1 else 0)
        parcel.writeParcelable(location, flags)
        parcel.writeParcelable(city, flags)
        parcel.writeParcelable(country, flags)
        parcel.writeParcelable(region, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Airport> {
        override fun createFromParcel(parcel: Parcel): Airport {
            return Airport(parcel)
        }

        override fun newArray(size: Int): Array<Airport?> {
            return arrayOfNulls(size)
        }

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
