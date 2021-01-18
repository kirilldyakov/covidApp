package ru.strongit.covidapp.ui.global

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.strongit.covidapp.R

class GlobalFragment : Fragment() {

    companion object {
        fun newInstance() = GlobalFragment()
    }

    private lateinit var viewModel: GlobalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.global_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GlobalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}