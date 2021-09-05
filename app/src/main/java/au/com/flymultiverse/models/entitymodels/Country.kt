package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Country.TABLE_NAME)
data class Country(
//    @ColumnInfo(name = COL_COUNTRY_CODE)
    @SerializedName(COL_COUNTRY_CODE)
    val countryCode : String?,

//    @ColumnInfo(name = COL_COUNTRY_NAME)
    @SerializedName(COL_COUNTRY_NAME)
    val countryName : String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(countryCode)
        parcel.writeString(countryName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }

        const val TABLE_NAME = "country"

        const val COL_COUNTRY_CODE = "countryCode"
        const val COL_COUNTRY_NAME = "countryName"

    }
}
