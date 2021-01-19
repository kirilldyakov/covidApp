package ru.strongit.covidapp.ui.global

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.strongit.covid.model.entity.Country
import ru.strongit.covidapp.domain.GetCasesUseCase
import ru.strongit.repository.AppDispatchers
import ru.strongit.repository.CountryRepository
import ru.strongit.repository.utils.Resource

class GlobalViewModel(
    private val countryRepository: CountryRepository,
    private val getCasesUseCase: GetCasesUseCase,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    val isLoading = MutableLiveData(false)

    private val _items = MediatorLiveData<Resource<List<Country>>>()
    val items: LiveData<Resource<List<Country>>> get() = _items
    private var itemsSource: LiveData<Resource<List<Country>>> = MutableLiveData()

    val label = "Global_label"

    init {
        getCountries(false)
    }

    fun reload(){
        getCountries(true)
    }

    private fun getCountries(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        isLoading.value = true
        _items.removeSource(itemsSource)
        withContext(dispatchers.io) {
            itemsSource = getCasesUseCase(forceRefresh = forceRefresh)
        }
        _items.addSource(itemsSource) {
            _items.value = it
            isLoading.value = false
//            if (it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.an_error_happened)
        }
    }
}