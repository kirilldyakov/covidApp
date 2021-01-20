package ru.strongit.covidapp.ui.global.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.strongit.covid.model.entity.Country
import ru.strongit.covidapp.databinding.CellCountryBinding
import ru.strongit.covidapp.databinding.HeaderCountryBinding
import ru.strongit.covidapp.ui.global.GlobalViewModel

class CountryItemViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = CellCountryBinding.bind(parent)

    fun bindTo(country:Country, viewModel: GlobalViewModel?=null) {
        binding.country = country
        //binding.viewModel = viewModel
    }
}

class CountryHeaderViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = HeaderCountryBinding.bind(parent)

    fun bindTo(name: String) {
        binding.name = name
    }
}