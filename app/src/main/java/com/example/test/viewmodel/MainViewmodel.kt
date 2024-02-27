package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.models.PostListResponseItem
import com.example.test.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewmodel(private val mainRepository: MainRepository) : ViewModel() {
    private var _postlist = MutableLiveData<List<PostListResponseItem>>()
    val postList: LiveData<List<PostListResponseItem>>
        get() = _postlist

    fun getPostList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = mainRepository.getposts()
                _postlist.postValue(result)
            } catch (e: Exception) {
            }
        }
    }
}