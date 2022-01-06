package com.example.dars_35

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dars_35.api.Api
import com.example.dars_35.databinding.ActivityMainBinding
import com.example.dars_35.model.PostModel
import com.example.dars_35.view.PostAdapter
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.app.appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabGallery.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .client(OkHttpClient.Builder().build())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

//        val api = retrofit.create(Api::class.java)


        api.getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.recyclerView.adapter = PostAdapter(response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}