package ru.strongit.covidapp.ui.global.adapter

import androidx.recyclerview.widget.DiffUtil

class CountryItemDiffCallback(private val oldList: List<ItemTypes>,
                             private val newList: List<ItemTypes>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}