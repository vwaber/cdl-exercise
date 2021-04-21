package com.vwaber.cdlexercise.ui.requestequipment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vwaber.cdlexercise.databinding.FragmentRequestequipmentBinding

class RequestequipmentFragment : Fragment() {

    private lateinit var binding: FragmentRequestequipmentBinding
    private lateinit var requestequipmentViewModel: RequestequipmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRequestequipmentBinding.inflate(layoutInflater)
        requestequipmentViewModel =
            ViewModelProvider(this).get(RequestequipmentViewModel::class.java)

        requestequipmentViewModel.text.observe(viewLifecycleOwner, Observer {
//            binding.textHome.text = it
        })

        binding.ivCdl.setOnClickListener {
            findNavController().navigate(
                RequestequipmentFragmentDirections
                    .actionNavigationRequestequipmentToCatalogCategoryFragment()
            )
        }

        return binding.root
    }
}
