package com.aqsoft.cleanmvvm.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.aqsoft.cleanmvvm.R
import com.aqsoft.cleanmvvm.databinding.FragmentListBinding
import com.aqsoft.cleanmvvm.domain.model.Item
import com.aqsoft.cleanmvvm.ui.main.OnMainCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() ,OnListAdapterListener{

    companion object {
        var FRAGMENT_NAME= ListFragment::class.java.name
        @JvmStatic
        fun newInstance() = ListFragment().apply {
            arguments=Bundle().apply {  }
        }
    }
    private lateinit var fragmentListBinding: FragmentListBinding
    private val viewModel: ListsViewModel by viewModels()
    private var adapter: ListAdapter? = null
    private var mCallback: OnMainCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ListAdapter(this)
        viewModel.loadData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list,container,false)
        fragmentListBinding.listsViewModel=viewModel
        fragmentListBinding.itemsRecyclerView.adapter=adapter

        viewModel.isLoaded.observe(
            viewLifecycleOwner,
            Observer {
                it.let {
                    visibility ->
                    fragmentListBinding.itemsProgressBar.visibility= if(visibility) View.GONE else View.VISIBLE
                }
            }
        )
        viewModel.listReceivedLiveData.observe(
            viewLifecycleOwner,
            Observer {
                it.let {
                    initRecyclerView(it)
                }
            }
        )

        return fragmentListBinding.root
    }
    fun initRecyclerView(items: List<Item>){
        adapter?.addData(items)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun itemClicked(item: Item) {
        mCallback?.navigateItemDetails(item)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnMainCallback){
            mCallback=context
        }else{
            throw java.lang.ClassCastException(context.toString() + "must implement OnMainCallBack method")
        }
    }

    override fun onDetach() {
        super.onDetach()
        adapter=null
        mCallback=null
    }
}