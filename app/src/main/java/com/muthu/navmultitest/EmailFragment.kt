package com.muthu.navmultitest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.muthu.navmultitest.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        val name = arguments?.getString("name")
        binding.apply {
            tvName.text = name
            btnSubmitEmail.setOnClickListener {
                val bundle = bundleOf(
                    "name" to tvName.text.toString(),
                    "email" to edtEmail.text.toString()
                )
                it.findNavController()
                    .navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            }
        }

        return binding.root

    }

}