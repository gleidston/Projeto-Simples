package store.www.kinggames.domain
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize




@Parcelize
class User(
    val name: String,
    val image: Int,
    val status: Boolean = true
) : Parcelable {

    companion object {
        const val KEY = "user-key"
    }
}