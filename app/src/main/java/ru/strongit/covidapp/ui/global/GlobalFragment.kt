package ru.strongit.covidapp.ui.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.strongit.covidapp.R
import ru.strongit.covidapp.databinding.GlobalFragmentBinding
import ru.strongit.covidapp.ui.global.adapter.CountryAdapter

class GlobalFragment : Fragment() {

    private lateinit var binding: GlobalFragmentBinding

    private val viewModel: GlobalViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, R.layout.global_fragment, container, false)

        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.isLoading.observe(viewLifecycleOwner, { binding.swipeRefreshLayout.isRefreshing = it })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerView.adapter = CountryAdapter()
        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.reload() }
    }

}