package uz.jahongir.roomdatabasejoiningtables.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.jahongir.roomdatabasejoiningtables.adapters.MyCardAdapter
import uz.jahongir.roomdatabasejoiningtables.databinding.FragmentCardsBinding
import uz.jahongir.roomdatabasejoiningtables.db.AppDataBase
import uz.jahongir.roomdatabasejoiningtables.db.MyCards

class CardsFragment : Fragment() {
    private val binding by lazy { FragmentCardsBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<MyCards>
    private lateinit var appDataBase: AppDataBase
    private lateinit var myCardAdapter: MyCardAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        appDataBase = AppDataBase.getInstance(binding.root.context)
        list = ArrayList()
        list.addAll(appDataBase.myDao().getCards())
        myCardAdapter = MyCardAdapter(list)

        binding.myRv.adapter = myCardAdapter

        binding.save.setOnClickListener {
            val myCards = MyCards(
                binding.edtName.text.toString(),
                binding.edtNumber.text.toString().toLong()
            )
            appDataBase.myDao().addCard(myCards)
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
            list.add(myCards)
            myCardAdapter.notifyItemInserted(list.size - 1)
        }
        return binding.root
    }
}