package com.example.daggerretrofitapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerretrofitapp.R
import com.example.daggerretrofitapp.di.MyApplication
import com.example.daggerretrofitapp.model.User
import com.example.daggerretrofitapp.viewmodel.MyViewModel
import com.example.daggerretrofitapp.viewmodel.OnClickItemListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnClickItemListener {
    private lateinit var viewModel: MyViewModel
    private lateinit var recView: RecyclerView
    private lateinit var btnLoad: FloatingActionButton

    private lateinit var userListLiveData: MutableLiveData<MutableList<User>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this, viewmodelFactory)[MyViewModel::class.java]
        viewModel = MyViewModel(this)
        val appComponent = (application as MyApplication).appComponent
        appComponent.injectActivity(viewModel)

        recView = findViewById(R.id.rvUserList)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = MyAdapter(this, viewModel.getUserList(), this)

        userListLiveData = viewModel.getUserListLiveData()
        val observer = Observer<MutableList<User>>{ newList ->
            recView.adapter = MyAdapter(this, newList, this)
        }
        userListLiveData.observe(this, observer)

        btnLoad = findViewById(R.id.btnLoad)
        btnLoad.setOnClickListener{
            viewModel.getUsersFromURL(20)
        }
    }

    override fun onItemClick(position: Int) {
        val dialog = DialogDetail(viewModel.getUserList()[position])
        dialog.show(supportFragmentManager, "dialog_detail")
    }
}