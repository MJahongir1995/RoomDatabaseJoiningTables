package uz.jahongir.roomdatabasejoiningtables.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import uz.jahongir.roomdatabasejoiningtables.adapters.MyTransActionAdapter
import uz.jahongir.roomdatabasejoiningtables.databinding.FragmentTransactionBinding
import uz.jahongir.roomdatabasejoiningtables.db.AppDataBase
import uz.jahongir.roomdatabasejoiningtables.db.MyCards
import uz.jahongir.roomdatabasejoiningtables.db.MyTransactions

class TransactionFragment : Fragment() {
    private val binding by lazy { FragmentTransactionBinding.inflate(layoutInflater) }
    private lateinit var cardList:ArrayList<MyCards>
    private lateinit var cardNameList:ArrayList<String>
    private lateinit var appDataBase: AppDataBase
    private lateinit var listTransaction: ArrayList<MyTransactions>
    private lateinit var myTransActionAdapter: MyTransActionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        appDataBase = AppDataBase.getInstance(binding.root.context)

        loadCardsIntoSpinner()
        makeTransaction()
        showAllTransactions()

        return binding.root
    }

    private fun makeTransaction() {
        binding.save.setOnClickListener {
            val myTransactions = MyTransactions(
                cardList[binding.spinnerToCard.selectedItemPosition].id,
                cardList[binding.spinnerFromCard.selectedItemPosition].id,
                binding.edtAmount.text.toString().toDouble()
            )
            appDataBase.myDao().addTransaction(myTransactions)
            showAllTransactions()
        }
    }

    fun showAllTransactions(){
        listTransaction = ArrayList()
        listTransaction.addAll(appDataBase.myDao().getTransaction())
        myTransActionAdapter = MyTransActionAdapter(listTransaction,appDataBase)
        binding.myRvForTransactions.adapter = myTransActionAdapter
    }

    private fun loadCardsIntoSpinner() {
        cardList = ArrayList()
        cardList.addAll(appDataBase.myDao().getCards())
        cardNameList = ArrayList()

        cardList.forEach {
            cardNameList.add(it.cardName!!)
        }

        val spinnerAdapter = ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, cardNameList)

        binding.spinnerToCard.adapter = spinnerAdapter
        binding.spinnerFromCard.adapter = spinnerAdapter
    }
}