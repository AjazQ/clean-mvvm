package com.aqsoft.cleanmvvm.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.aqsoft.cleanmvvm.R
import com.aqsoft.cleanmvvm.databinding.HolderItemBinding
import com.aqsoft.cleanmvvm.domain.model.Item

class ListAdapter(val mListener: OnListAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val items : MutableList<Item> = ArrayList()
    fun addData(list: List<Item>){
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),R.layout.holder_item, parent,false)
        return ItemViewHolder(holderItemBinding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).onBind(getItem(position))
    }
    private fun getItem(position: Int):Item
    {
        return items[position]
    }
    override fun getItemCount(): Int {
        return items.size
    }
    inner class ItemViewHolder(
        private val dataBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(dataBinding.root){
        fun onBind(item: Item){
            val holderItemBinding= dataBinding as HolderItemBinding
            val itemViewModel=ListViewModel(item)
            holderItemBinding.listViewModel=itemViewModel
            itemView.setOnClickListener{
                mListener.itemClicked(item)
            }
        }
    }
}