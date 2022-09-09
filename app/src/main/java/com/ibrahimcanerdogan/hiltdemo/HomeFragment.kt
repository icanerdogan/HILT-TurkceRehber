package com.ibrahimcanerdogan.hiltdemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.ibrahimcanerdogan.hiltdemo.databinding.FragmentHomeBinding
import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.ui.MainFragment
import com.ibrahimcanerdogan.hiltdemo.ui.MainViewModel
import com.ibrahimcanerdogan.hiltdemo.util.Car
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment(
    @ApiKey private val apiKey: String
) : Fragment() {

    @Inject
    lateinit var car: Car

    // private lateinit var viewModel: HomeViewModel
    // private val viewModel: MainViewModel by viewModels()
    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        val name = car.getCareName()
        val batterySize = car.getBatterySize()

        Log.d("TAG", name)
        Log.d("TAG", batterySize)

        binding.textViewApi.text = apiKey
        binding.buttonHomeToMain.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_fragment_container, MainFragment::class.java, null)
                ?.addToBackStack(TAG)
                ?.commit()
        }

        getDatabaseName()
    }

    private fun getDatabaseName() {
        viewModel.databaseName.observe(viewLifecycleOwner) {
            Log.i(TAG, it)
            Log.d(TAG, viewModel.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        const val TAG = "HomeFragment"
    }
}