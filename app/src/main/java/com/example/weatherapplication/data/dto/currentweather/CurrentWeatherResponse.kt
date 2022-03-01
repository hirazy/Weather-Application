package com.example.weatherapplication.data.dto.currentweather

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Parcel
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapplication.base.OBase
import com.example.weatherapplication.data.dto.common.Clouds
import com.example.weatherapplication.data.dto.common.Coord
import com.example.weatherapplication.data.dto.common.Wind
import com.google.gson.annotations.SerializedName
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import java.text.SimpleDateFormat

import java.util.*


@SuppressLint("ParcelCreator")
@Entity(tableName = "WeatherInfo")
data class CurrentWeatherResponse (
    @SerializedName("coord") val coord: Coord,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: Main,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Int,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false) var id: Int? = null,
) : OBase() {
    fun getTemp():String{
        return String.format("%.0f", main.temp - 273.15)
    }

    var colorStatus: Int = Color.parseColor("#FF0090")


    private fun getDateTime(s: Long): DayOfWeek? {
        return try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val netDate = Date(s * 1000)
            val formattedDate = sdf.format(netDate)

            LocalDate.of(
                formattedDate.substringAfterLast("/").toInt(),
                formattedDate.substringAfter("/").take(2).toInt(),
                formattedDate.substringBefore("/").toInt()
            )
                .dayOfWeek
        } catch (e: Exception) {
            e.printStackTrace()
            DayOfWeek.MONDAY
        }
    }

    fun setColor() {
        when (dt?.let { getDateTime(it) }) {
            DayOfWeek.MONDAY -> colorStatus = Color.parseColor("#28E0AE")
            DayOfWeek.TUESDAY -> colorStatus = Color.parseColor("#FF0090")
            DayOfWeek.WEDNESDAY -> colorStatus = Color.parseColor("#FFAE00")
            DayOfWeek.THURSDAY -> colorStatus = Color.parseColor("#0090FF")
            DayOfWeek.FRIDAY -> colorStatus = Color.parseColor("#DC0000")
            DayOfWeek.SATURDAY -> colorStatus = Color.parseColor("#0051FF")
            DayOfWeek.SUNDAY -> colorStatus = Color.parseColor("#3D28E0")
            else -> colorStatus = Color.parseColor("#28E0AE")
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

}

data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String? = "a01d"
)

