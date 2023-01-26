package uz.jahongir.roomdatabasejoiningtables.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {

    @Insert
    fun addCard(myCards: MyCards)

    @Insert
    fun addTransaction(myTransactions: MyTransactions)

    @Query("select*from myCards")
    fun getCards():List<MyCards>

    @Query("select * from myTransactions")
    fun getTransaction():List<MyTransactions>

    @Query("select * from myCards where id=:id")
    fun getCardByID(id:Int):MyCards
}