package ru.strongit.covidapp.ui.comparation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.strongit.covidapp.R

class ComparationFragment : Fragment() {

    companion object {
        fun newInstance() = ComparationFragment()
    }

    private lateinit var viewModel: ComparationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comparation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComparationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}