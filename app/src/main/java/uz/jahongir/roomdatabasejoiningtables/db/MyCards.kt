package uz.jahongir.roomdatabasejoiningtables.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyCards {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var cardName:String? = null
    var cardNumber:Long? = null

    constructor(cardName: String?, cardNumber: Long?) {
        this.cardName = cardName
        this.cardNumber = cardNumber
    }

    constructor()


}