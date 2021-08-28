package com.example.assessment




import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET ("posts")
    fun getPosts(): Call<List<Posts>>

    @GET ("posts/{postId}")
    fun getPost(@Path("postId")id:Int):Call<Posts>



}