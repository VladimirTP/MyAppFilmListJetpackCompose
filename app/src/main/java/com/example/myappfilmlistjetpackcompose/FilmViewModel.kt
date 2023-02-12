package com.example.myappfilmlistjetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappfilmlistjetpackcompose.domain.FilmRepository
import com.example.myappfilmlistjetpackcompose.domain.FilmUIData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    private val _filmLiveData = MutableLiveData<List<FilmUIData>>()
    val filmLiveData: LiveData<List<FilmUIData>> get() = _filmLiveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorLiveData.value = R.string.connection_error
            else -> _errorLiveData.value = R.string.unknown_error
        }
    }

    fun getFilms() {
        viewModelScope.launch(exceptionHandler) {
            val filmInfo = repository.getFilms()
            _filmLiveData.value = filmInfo
        }
    }
}

