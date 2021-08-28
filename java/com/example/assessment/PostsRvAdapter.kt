package com.example.assessment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PostsRvAdapter(var context: List<Posts>, var postList: Context):RecyclerView.Adapter<PostsRvAdapter.ViewHolderPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.view_photo,parent,false)
        return ViewHolderPost(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var  currentPost= postList[position]
        holder.tvUserId.text=currentPost.userId.toString()
        holder.tvId.text=currentPost.id.toString()
        holder.tvTitle.text=currentPost.title



}
class ViewHolderPost(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvUserId=itemView.findViewById<TextView>(R.id.tvName)
    var tvId=itemView.findViewById<TextView>(R.id.tvCaption)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvComments)

}

    override fun getItemCount(): Int {
        return postList.size   }
}