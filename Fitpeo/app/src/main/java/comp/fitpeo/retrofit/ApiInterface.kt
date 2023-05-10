package comp.fitpeo.retrofit

import comp.fitpeo.model.Alpum
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("photos")
    fun getServices() : Call<Alpum>


}