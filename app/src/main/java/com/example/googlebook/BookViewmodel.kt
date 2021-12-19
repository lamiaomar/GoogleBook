package com.example.googlebook

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebook.data.ItemsItem
import com.example.googlebook.network.BooksApi
import kotlinx.coroutines.launch

class BookViewmodel : ViewModel(){


    var result = MutableLiveData<List<ItemsItem?>>()
    var secresult = MutableLiveData<List<ItemsItem?>>()
    var thieresult = MutableLiveData<List<ItemsItem?>>()


    var title = MutableLiveData<String?>()
    var image = MutableLiveData<String?>()


init {
    getBook()
}


    private fun getBook(){

        viewModelScope.launch {
            result.value = BooksApi.retrofitService.getBook( "fantasy").items
            secresult.value = BooksApi.retrofitService.getBook( "classic").items
            thieresult.value = BooksApi.retrofitService.getBook( "kids").items

            //"inauthor:steve inauthor:jobs"
//            title.value = result.value!![0]?.volumeInfo?.title
//            Log.e("IMAGE" , "${title.value}")
//            image.value = result.value!![0]?.volumeInfo?.imageLinks?.thumbnail
//            Log.e("IMAGE" ,"${image.value}")
        }
    }


}