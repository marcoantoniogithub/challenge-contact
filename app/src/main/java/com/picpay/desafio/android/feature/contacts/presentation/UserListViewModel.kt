package com.picpay.desafio.android.feature.contacts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.feature.contacts.domain.model.User
import com.picpay.desafio.android.feature.contacts.domain.usecase.PicPayUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class ContactsUiState(
    var loading: Boolean = false,
    var messageError: String = "",
    var listUser: List<User> = listOf()
)

class UserListViewModel(
    val useCase: PicPayUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<ContactsUiState>()
    val uiState: LiveData<ContactsUiState> = _uiState

    fun getUsers() {
        viewModelScope.launch {
            try {
                _uiState.postValue(ContactsUiState(loading = true))
                val response = useCase.getUsers()
                _uiState.postValue(ContactsUiState(loading = false, messageError = "", listUser = response))
            } catch (e: Exception) {
                _uiState.postValue(ContactsUiState(loading = false, messageError = e.message!!))
            }
        }
    }
}