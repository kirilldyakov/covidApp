package ru.strongit.covidapp.ui.global

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.strongit.covid.model.entity.Country
import ru.strongit.covidapp.ui.global.adapter.CountryAdapter
import ru.strongit.repository.utils.Resource

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, resource: Resource<List<Country>>?) {
    with(recyclerView.adapter as CountryAdapter) {
        resource?.data?.let { updateData(it) }
    }
}