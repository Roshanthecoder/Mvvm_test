package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.models.PostListResponseItem
import com.example.test.network.ResponseState
import com.example.test.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondaryViewmodel(private val mainRepository: MainRepository) : ViewModel() {
    private var _postlist = MutableLiveData<ResponseState<List<PostListResponseItem>>>()
    val postList: LiveData<ResponseState<List<PostListResponseItem>>>
        get() = _postlist
    fun getPostList() {
        viewModelScope.launch(Dispatchers.IO) {
            _postlist.postValue(ResponseState.Loading)
            try {
                val result = mainRepository.getposts()
                withContext(Dispatchers.Main) {
                    _postlist.value = ResponseState.Success(result)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _postlist.value = ResponseState.Error(e.message ?: "An error occurred")
                }
              //  _postlist.value = ResponseState.Error(e.message ?: "An error occurred")
            }
        }
    }
}