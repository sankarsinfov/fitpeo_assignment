package comp.fitpeo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import comp.fitpeo.retrofit.RetrofitInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class alpumViewModel : ViewModel() {
    private var alpumLiveData = MutableLiveData<List<AlpumItem>>()



    fun getServices() {

        RetrofitInstance.api.getServices().enqueue(object : Callback<Alpum> {
            override fun onResponse(call: Call<Alpum>, response: Response<Alpum>) {
               // Log.d("hjtgyfyfgt",""+response.body())
                if (response.body()!=null){
                    alpumLiveData.value = response.body()!!
                  //  Log.d("hjtgyfyfgt",""+alpumLiveData)
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Alpum>, t: Throwable) {
              //  Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<AlpumItem>> {
        return alpumLiveData
    }
}