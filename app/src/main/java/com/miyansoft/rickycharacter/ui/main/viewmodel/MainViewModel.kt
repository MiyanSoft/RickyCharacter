package com.miyansoft.rickycharacter.ui.main.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miyansoft.rickycharacter.data.model.Response
import com.miyansoft.rickycharacter.data.repository.MainRepository
import com.miyansoft.rickycharacter.utils.Resource
import retrofit2.Call
import retrofit2.Callback

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val users

    get() = MutableLiveData<Resource<Response?>>().apply {

        value = Resource.loading(data = null)
        val mT = this

        mainRepository.getUsers().enqueue(
            object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {

                    mT.value = Resource.success(data = response.body())
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {

                    mT.value = Resource.error(data = null, message = t.message ?: "Error message")
                }

            }
        )

    }


}