package com.dsckiet.mvvmtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.AlteredCharSequence.make
import android.text.BoringLayout.make
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsckiet.mvvmtask.Viewmodel.MainViewModel
import com.dsckiet.mvvmtask.Viewmodel.MainViewModelFactory
import com.dsckiet.mvvmtask.databinding.ActivityMainBinding
import com.dsckiet.mvvmtask.repository.Repository
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make
import com.google.android.material.snackbar.SnackbarContentLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val feedAdapter:FeedAdapter by lazy{FeedAdapter(this)}
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       val recview = findViewById<RecyclerView>(R.id.rec_view)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getFeed(this)
        viewModel.myResponse.observe(this, Observer {
            feedAdapter.setStateWiseTracker(it.articles!!)
            Log.d("BOLTy","success"+it.toString())

        })
        recview.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recview.adapter = feedAdapter

        binding.deleteall.setOnClickListener {
            Toast.makeText(this,"Delete Button Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.open.setOnClickListener {
            Toast.makeText(this,"Open Button Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.barcode.setOnClickListener {
            Toast.makeText(this,"Barcode Card Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.bookmark.setOnClickListener {
            Toast.makeText(this,"Bookmark Card Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.download.setOnClickListener {
            Toast.makeText(this,"Download Card Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.wifi.setOnClickListener {
            Toast.makeText(this,"No connection Card Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.more.setOnClickListener {
            Toast.makeText(this,"More Card Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.closeall.setOnClickListener {
            Toast.makeText(this,"Close All Button Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.showall.setOnClickListener {
            Toast.makeText(this,"Show All Button Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.circle10.setOnClickListener {
            Toast.makeText(this,"10 Button Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.circleadd.setOnClickListener {
            Toast.makeText(this,"Add Button Clicked",Toast.LENGTH_SHORT).show()
        }


    }
}