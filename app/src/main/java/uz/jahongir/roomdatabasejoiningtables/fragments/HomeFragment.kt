package uz.jahongir.roomdatabasejoiningtables.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.jahongir.roomdatabasejoiningtables.R
import uz.jahongir.roomdatabasejoiningtables.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
   private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding.cards.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cardsFragment)
        }

        binding.transactions.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_transactionFragment)
        }

        return binding.root
    }

}