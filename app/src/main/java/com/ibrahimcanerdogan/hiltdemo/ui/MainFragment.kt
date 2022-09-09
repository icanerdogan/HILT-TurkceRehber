package com.ibrahimcanerdogan.hiltdemo.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibrahimcanerdogan.hiltdemo.HomeFragment
import com.ibrahimcanerdogan.hiltdemo.R
import com.ibrahimcanerdogan.hiltdemo.databinding.FragmentMainBinding
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName

class MainFragment(
    @DatabaseName private val databaseName: String
) : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewDatabase.text = databaseName
        binding.buttonMainToHome.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container, HomeFragment::class.java, null)
                ?.addToBackStack(TAG)
                ?.commit()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "MainFragment"
    }
}