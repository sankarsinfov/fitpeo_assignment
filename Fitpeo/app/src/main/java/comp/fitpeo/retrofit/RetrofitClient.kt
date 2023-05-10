package comp.fitpeo.retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import yesinfovee.apps.tamilcalendar.BuildConfig

object RetrofitClient {

    //const val MainServer = "https://jsonplaceholder.typicode.com/"

    val api : ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
