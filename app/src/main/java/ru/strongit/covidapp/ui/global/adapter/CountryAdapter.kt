package ru.strongit.covidapp.ui.global.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.strongit.covid.model.entity.Country
import ru.strongit.covidapp.R

class CountryAdapter():
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<ItemTypes> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> CountryHeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.header_country, parent, false)
            )
            1 -> CountryItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.cell_country, parent, false)
            )
            else -> throw(IllegalStateException("Неверный тип ViewModel"))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItemTypes.TypeCountry -> (holder as CountryItemViewHolder).bindTo(item.country)//, viewModel)
            is ItemTypes.TypeHeader -> (holder as CountryHeaderViewHolder).bindTo(item.header)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemTypes.TypeHeader -> 0
            is ItemTypes.TypeCountry -> 1
        }
    }

    fun updateData(countries: List<Country>) {
        val _items = convert(countries)
        val diffCallback = CountryItemDiffCallback(this.items, _items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(_items)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun convert(items: List<Country>): List<ItemTypes> {
        val list: MutableList<ItemTypes> = ArrayList()
        items.sortedBy { it.continent }
        val groups = items.groupBy { it.continent }
        groups.mapValues { cou ->
            list.add(ItemTypes.TypeHeader(cou.key?:"-"))
            cou.value.map { list.add(ItemTypes.TypeCountry(it)) }
        }
        return list
    }
}

sealed class ItemTypes {
    data class TypeHeader(val header: String) : ItemTypes()
    data class TypeCountry(val country: Country) : ItemTypes()
}