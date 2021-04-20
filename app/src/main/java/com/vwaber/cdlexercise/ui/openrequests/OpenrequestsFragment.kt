package com.vwaber.cdlexercise.ui.openrequests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vwaber.cdlexercise.databinding.FragmentOpenrequestsBinding

class OpenrequestsFragment : Fragment() {

    private lateinit var binding: FragmentOpenrequestsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOpenrequestsBinding.inflate(layoutInflater)
        return binding.root
    }

}