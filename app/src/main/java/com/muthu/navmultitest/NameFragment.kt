package com.muthu.navmultitest

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.muthu.navmultitest.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        binding.apply {
            btnSubmitName.setOnClickListener {
                if (TextUtils.isEmpty(edtName.text.toString())) {
                    Toast.makeText(activity, "Name is Empty", Toast.LENGTH_SHORT);
                } else {
                    val bundle: Bundle = bundleOf(
                        "name" to edtName.text.toString()
                    )
                    it.findNavController()
                        .navigate(R.id.action_nameFragment_to_emailFragment, bundle)

                }

            }
        }

        return binding.root
    }

}