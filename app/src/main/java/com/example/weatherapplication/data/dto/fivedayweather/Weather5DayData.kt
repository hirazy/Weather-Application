import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Parcel
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapplication.base.OBase
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class Weather1DayDetail(var listData: List<WeatherDetail>) : OBase(), Serializable {
    var weatherShow: WeatherDetail = listData[listData.size / 2]

    var tempMin: Double =
        String.format("%.0f", listData.minByOrNull { it.main.temp_min }!!.main.temp_min - 273.15)
            .toDouble()
    var tempMax: Double =
        String.format("%.0f", listData.maxByOrNull { it.main.temp_max }!!.main.temp_max - 273.15)
            .toDouble()

    fun getTempShow(): Double {
        return String.format("%.0f", weatherShow.main.temp - 273.15)
            .toDouble()
    }

    fun setTime(): String {
        return weatherShow.dt_txt.split(" ")[1].substring(0, 5)
    }

    fun setDate(): String {
        var dt: Long = weatherShow.dt.toLong()
        return when (dt?.let { getDateTime(it) }) {
            org.threeten.bp.DayOfWeek.MONDAY -> "Monday"
            DayOfWeek.TUESDAY -> "Tuesday"
            DayOfWeek.WEDNESDAY -> "Wednesday"
            DayOfWeek.THURSDAY -> "Thursday"
            DayOfWeek.FRIDAY -> "Friday"
            DayOfWeek.SATURDAY -> "Saturday"
            DayOfWeek.SUNDAY -> "Sunday"
            else -> "Monday"
        }
    }

    fun setColor(): Int {
        var dt: Long = weatherShow.dt.toLong()
        when (dt?.let { getDateTime(it) }) {
            DayOfWeek.MONDAY -> return Color.parseColor("#28E0AE")
            DayOfWeek.TUESDAY -> return Color.parseColor("#FF0090")
            DayOfWeek.WEDNESDAY -> return Color.parseColor("#FFAE00")
            DayOfWeek.THURSDAY -> return Color.parseColor("#0090FF")
            DayOfWeek.FRIDAY -> return Color.parseColor("#DC0000")
            DayOfWeek.SATURDAY -> return Color.parseColor("#0051FF")
            DayOfWeek.SUNDAY -> return Color.parseColor("#3D28E0")
            else -> return Color.parseColor("#28E0AE")
        }
    }

    fun getDateTime(s: Long): DayOfWeek? {
        return try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val netDate = Date(s * 1000)
            val formattedDate = sdf.format(netDate)

            LocalDate.of(
                formattedDate.substringAfterLast("/").toInt(),
                formattedDate.substringAfter("/").take(2).toInt(),
                formattedDate.substringBefore("/").toInt()
            ).dayOfWeek
        } catch (e: Exception) {
            e.printStackTrace()
            DayOfWeek.MONDAY
        }
    }
}

@Parcelize
data class City5Day(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("coord") val coord: Coord5Day? = null,
    @SerializedName("country") val country: String,
    @SerializedName("population") val population: Int,
    @SerializedName("timezone") val timezone: Int,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int
) : OBase()

data class Clouds5Day(
    @SerializedName("all") val all: Int
) : Serializable

@Parcelize
data class Coord5Day(

    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
): OBase()

@SuppressLint("ParcelCreator")
data class WeatherDetail(

    @SerializedName("dt") val dt: Long,
    @SerializedName("main") val main: Main5Day,
    @SerializedName("weather") val weather: List<Weather5Day>,
    @SerializedName("clouds") val clouds: Clouds5Day,
    @SerializedName("wind") val wind: Wind5Day,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("sys") val sys: Sys5Day,
    @SerializedName("dt_txt") val dt_txt: String
) : OBase(), Serializable {
    fun getTime(): String {

        return dt_txt.split(" ")[1].substring(0, 5)
    }

    fun getTemp(): String {
        return String.format("%.0f", main.temp - 273.15) + "°"
    }

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

    fun setColor(): Int {
        return when (dt?.let { getDateTime(it) }) {
            DayOfWeek.MONDAY -> Color.parseColor("#28E0AE")
            DayOfWeek.TUESDAY -> Color.parseColor("#FF0090")
            DayOfWeek.WEDNESDAY -> Color.parseColor("#FFAE00")
            DayOfWeek.THURSDAY -> Color.parseColor("#0090FF")
            DayOfWeek.FRIDAY -> Color.parseColor("#DC0000")
            DayOfWeek.SATURDAY -> Color.parseColor("#0051FF")
            DayOfWeek.SUNDAY -> Color.parseColor("#3D28E0")
            else -> Color.parseColor("#28E0AE")
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

}


data class Main5Day(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("temp_min") val temp_min: Double,
    @SerializedName("temp_max") val temp_max: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("sea_level") val sea_level: Int,
    @SerializedName("grnd_level") val grnd_level: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("temp_kf") val temp_kf: Double
) : Serializable

data class Sys5Day(

    @SerializedName("pod") val pod: String
) : Serializable

data class Weather5Day(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
) : Serializable


data class Wind5Day(

    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val deg: Int
) : Serializable