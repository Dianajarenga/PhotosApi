package com.example.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var data: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }
    fun getPosts(){
        data=findViewById(R.id.rvPhotos)
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java) //instance of retrofit
        val request = retrofit.getPosts() //request is made here
        request.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful){
                    var postsList =response.body()!!
                    var postAdapter=PostsRvAdapter(postsList,baseContext)
                    data.adapter=postAdapter
                    data.layoutManager= LinearLayoutManager(baseContext)

                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()

            }
        })
    }
}
