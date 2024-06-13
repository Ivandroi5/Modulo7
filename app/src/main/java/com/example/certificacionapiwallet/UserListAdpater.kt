package com.example.certificacionapiwallet

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.certificacionapiwallet.data.model.User
import com.example.certificacionapiwallet.databinding.UserListItemBinding
import com.squareup.picasso.Picasso

class UserListAdpater : RecyclerView.Adapter< UserListAdpater.UserViewHolder>(){
    lateinit var onItemClickListener: ((User)->Unit)

    var users = mutableListOf<User>()
        set (value){
            field =value
            this.notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdpater.UserViewHolder {
        val bindingItem =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(bindingItem)    }

    override fun onBindViewHolder(holder: UserListAdpater.UserViewHolder, position: Int) {
        val user: User = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
return users.size
    }
inner class UserViewHolder(private var bindingItem: UserListItemBinding)
    : RecyclerView.ViewHolder(bindingItem.root){
        fun bind(user: User){
            with(user){
                Picasso.get().load(imagenLink.toString()).into(bindingItem.imageContact)
                bindingItem.nameContact.text = nombre.toString()
                bindingItem.countryContact.text = pais.toString()
                bindingItem.balance.text= saldo.toString()
            }
            bindingItem.root.setOnClickListener{
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(user)
                else
                    Log.e ("Adapter", "onItemClick not initialized")
            }
        }
    }

}