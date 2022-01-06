package com.example.dars_35

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dars_35.api.Api
import com.example.dars_35.databinding.ActivityGalleryBinding
import com.example.dars_35.model.PhotoModel
import com.example.dars_35.model.PostModel
import com.example.dars_35.view.ImageAdapter
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GalleryActivity : AppCompatActivity() {
    lateinit var binding: ActivityGalleryBinding

    @Inject
    lateinit var api: Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.app.appComponent.inject(this)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .client(OkHttpClient.Builder().build())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val api = retrofit.create(Api::class.java)
        binding.recyclerView.layoutManager = GridLayoutManager(this@GalleryActivity, 2)

        api.getPhotos().enqueue(object: Callback<List<PhotoModel>> {

            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
                binding.recyclerView.adapter = ImageAdapter(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {

            }

        })


    }
}