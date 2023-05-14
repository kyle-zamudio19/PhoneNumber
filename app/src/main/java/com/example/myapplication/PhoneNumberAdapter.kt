package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemPhoneNumberBinding

class PhoneNumberAdapter(
    private val phoneNumberList: List<PhoneNumber>
) : RecyclerView.Adapter<PhoneNumberAdapter.PhoneNumberViewHolder>(){

    private var phoneNumbers = listOf<PhoneNumber>()

    inner class PhoneNumberViewHolder(private val binding: ItemPhoneNumberBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(phoneNumber: PhoneNumber) {
                    binding.phoneNumber = phoneNumber
                    binding.shapeableImageView.setImageResource(R.drawable.ic_person)
                    phoneNumber.imageUri?.let {
                        Glide.with(binding.root.context)
                            .load(it)
                            .placeholder(R.drawable.ic_person)
                            .error(R.drawable.ic_person)
                            .into(binding.shapeableImageView)
                    }

                    binding.tvName.text = phoneNumber.name
                    binding.tvPhoneNumber.text = phoneNumber.number.toString()

                    binding.executePendingBindings()
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneNumberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhoneNumberBinding.inflate(inflater, parent, false)
        return PhoneNumberViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return phoneNumbers.size
    }

    override fun onBindViewHolder(holder: PhoneNumberViewHolder, position: Int) {
        holder.bind(phoneNumberList[position])
    }
}