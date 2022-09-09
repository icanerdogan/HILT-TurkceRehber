package com.ibrahimcanerdogan.hiltdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ibrahimcanerdogan.hiltdemo.HomeFragment
import com.ibrahimcanerdogan.hiltdemo.R
import com.ibrahimcanerdogan.hiltdemo.databinding.FragmentMainBinding
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

// Cannot create an instance of class MainViewModel olmasından dolayı @AndroidEntryPoint eklendi!
@AndroidEntryPoint
class MainFragment(
    @DatabaseName private val databaseName: String
) : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
    private val stringBuilder: StringBuilder by lazy {
        StringBuilder()
    }
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

        getDatabaseName()
        getUsers()
    }

    private fun getDatabaseName() {
        viewModel.databaseName.observe(viewLifecycleOwner) {
            binding.textViewDatabase.text = it
        }
    }

    private fun getUsers() {
        viewModel.userList.observe(viewLifecycleOwner) {
            it.forEach { user ->
                stringBuilder.append(user)
                stringBuilder.append(" ")
            }
            binding.textViewUserList.text = stringBuilder
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