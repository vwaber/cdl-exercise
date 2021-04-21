package com.vwaber.cdlexercise.ui.requestequipment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vwaber.cdlexercise.databinding.FragmentRequestequipmentBinding

class RequestequipmentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRequestequipmentBinding.inflate(layoutInflater)

        binding.ivCdl.setOnClickListener {
            findNavController().navigate(
                RequestequipmentFragmentDirections
                    .actionNavigationRequestequipmentToCatalogCategoryFragment()
            )
        }

        return binding.root
    }
}
