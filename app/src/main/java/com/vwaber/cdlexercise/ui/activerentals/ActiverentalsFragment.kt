package com.vwaber.cdlexercise.ui.activerentals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vwaber.cdlexercise.databinding.FragmentActiverentalsBinding

class ActiverentalsFragment : Fragment() {

    private lateinit var binding: FragmentActiverentalsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActiverentalsBinding.inflate(layoutInflater)
        return binding.root
    }

}
