package com.example.githubviewer.ui.users

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubviewer.core.models.UserDto
import com.example.githubviewer.databinding.UserItemBinding

class UsersAdapter(): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items = mutableListOf<UserDto>()
    var onClickItem: ((String) -> Unit)? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(UserItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateUsers(list: List<UserDto>?) {
        items.clear()
        list?.let {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class UsersViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            init {
                binding.root.setOnClickListener {
                    onClickItem?.invoke(items[adapterPosition].name)
                }
            }

            fun bind(item: UserDto) {
                Glide.with(context).load(item.avatarUrl).into(binding.imageUser)
                binding.tvName.text = item.name
                binding.tvIdNumber.text = item.id.toString()
            }
    }
}