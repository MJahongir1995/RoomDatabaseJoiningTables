package uz.jahongir.roomdatabasejoiningtables.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyCards::class, MyTransactions::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun myDao(): MyDao

    companion object {
        @Volatile
        private var appDatabase: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDataBase::class.java, "appDatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return appDatabase!!
        }
    }
}