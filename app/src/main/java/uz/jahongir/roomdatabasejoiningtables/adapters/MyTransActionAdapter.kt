package uz.jahongir.roomdatabasejoiningtables.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.jahongir.roomdatabasejoiningtables.databinding.ItemTransactionRvBinding
import uz.jahongir.roomdatabasejoiningtables.db.AppDataBase
import uz.jahongir.roomdatabasejoiningtables.db.MyTransactions

class MyTransActionAdapter(var list: List<MyTransactions>, val appDataBase: AppDataBase): RecyclerView.Adapter<MyTransActionAdapter.VH>() {
    inner class VH(private var rvItemBinding: ItemTransactionRvBinding): RecyclerView.ViewHolder(rvItemBinding.root) {
        fun onBind(myTransactions: MyTransactions , position: Int) {
            rvItemBinding.apply {
                summa.text = myTransactions.summa.toString() + " so'm"
                txtDate.text = myTransactions.date
                txtToCard.text = appDataBase.myDao().getCardByID(myTransactions.toCardID!!).cardNumber.toString()
                txtFromCard.text = appDataBase.myDao().getCardByID(myTransactions.fromCardId!!).cardNumber.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemTransactionRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)

    }
    override fun getItemCount(): Int = list.size
}
