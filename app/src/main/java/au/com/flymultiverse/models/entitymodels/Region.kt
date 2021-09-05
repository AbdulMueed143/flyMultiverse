package au.com.flymultiverse.models.entitymodels

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//@Entity(tableName = Region.TABLE_NAME)
data class Region(
//    @ColumnInfo(name = COL_REGION_CODE)
    @SerializedName(COL_REGION_CODE)
    val regionCode : String?,

//    @ColumnInfo(name = COL_REGION_NAME)
    @SerializedName(COL_REGION_NAME)
    val regionName : String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(regionCode)
        parcel.writeString(regionName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Region> {
        override fun createFromParcel(parcel: Parcel): Region {
            return Region(parcel)
        }

        override fun newArray(size: Int): Array<Region?> {
            return arrayOfNulls(size)
        }

        const val TABLE_NAME = "region"

        const val COL_REGION_CODE = "regionCode"
        const val COL_REGION_NAME = "regionName"
    }
}
