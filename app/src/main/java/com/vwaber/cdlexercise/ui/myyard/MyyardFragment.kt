package com.vwaber.cdlexercise.ui.myyard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vwaber.cdlexercise.databinding.FragmentMyyardBinding

class MyyardFragment : Fragment() {

    private lateinit var binding: FragmentMyyardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyyardBinding.inflate(layoutInflater)
        return binding.root
    }

}