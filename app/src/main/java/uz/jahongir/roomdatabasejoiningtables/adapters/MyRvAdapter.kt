package uz.jahongir.roomdatabasejoiningtables.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.jahongir.roomdatabasejoiningtables.databinding.ItemRvBinding
import uz.jahongir.roomdatabasejoiningtables.db.MyCards


class MyCardAdapter(var list: List<MyCards>): RecyclerView.Adapter<MyCardAdapter.VH>() {
    inner class VH(private var itemRvBinding: ItemRvBinding ): RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myCards: MyCards, position: Int) {
            itemRvBinding.tvName.text = myCards.cardName
            itemRvBinding.tvNumber.text = myCards.cardNumber.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)

    }
    override fun getItemCount(): Int = list.size
}
