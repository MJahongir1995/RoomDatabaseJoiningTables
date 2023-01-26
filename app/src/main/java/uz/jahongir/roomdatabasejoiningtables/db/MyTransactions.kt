package uz.jahongir.roomdatabasejoiningtables.db

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyTransactions {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var fromCardId:Int? = null
    var toCardID:Int? = null

    var summa:Double? = null

    @SuppressLint("SimpleDateFormat")
    var date = SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date())

    constructor(fromCardId: Int?, toCardID: Int?, summa: Double?) {
        this.fromCardId = fromCardId
        this.toCardID = toCardID
        this.summa = summa
    }
}