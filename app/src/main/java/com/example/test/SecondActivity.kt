package com.example.test

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.test.adapter.CustomSpinnerAdapter
import com.example.test.adapter.SecondaryAdapter
import com.example.test.databinding.ActivitySecondBinding
import com.example.test.models.PostListResponseItem
import com.example.test.models.StateList
import com.example.test.network.ResponseState
import com.example.test.network.RetrofitClient
import com.example.test.repository.MainRepository
import com.example.test.viewmodel.SecondaryViewmodel
import com.example.test.viewmodelfactory.MainViewmodelFactory

class SecondActivity : AppCompatActivity() {
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var secondaryViewmodel: SecondaryViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  val sample_data=3123123
        val data1=StateList(null,null)

        val data = arrayListOf(
            StateList(11231, "State 1"),
            StateList(212312, "State 2"),
            StateList(3123123, "State 3")
        )

        val adapter = CustomSpinnerAdapter(this, data)
        binding.spiiner.adapter = adapter


        val matchingIndex = data.indexOfFirst { it.id == data1.id }

        if (matchingIndex != -1) {
            binding.spiiner.setSelection(matchingIndex + 1) // +1 to adjust for the hint
        }

        binding.spiiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0) {
                    val selectedItem = data[position - 1]
                    Toast.makeText(applicationContext, "Selected: ${selectedItem.State} (ID: ${selectedItem.id})", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }



        /* val repository = MainRepository(RetrofitClient.apiInterface)
         secondaryViewmodel =
             ViewModelProvider(
                 this,
                 MainViewmodelFactory(repository)
             )[SecondaryViewmodel::class.java]
         secondaryViewmodel.getPostList()*/
      /*  secondaryViewmodel.postList.observe(this) { itemlist ->

            when (itemlist) {
                is ResponseState.Success -> {
                    val result = itemlist.data
                    binding.recyclerlist.apply {
                        adapter = SecondaryAdapter(result as ArrayList<PostListResponseItem>)
                        addItemDecoration(
                            DividerItemDecoration(
                                this@SecondActivity,
                                DividerItemDecoration.VERTICAL
                            )
                        )
                    }
                }

                is ResponseState.Error -> {
                    val errorMsg = itemlist.message
                    Log.e("roshan", errorMsg)
                }

                ResponseState.Loading -> {
                    Toast.makeText(this@SecondActivity, "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        }*/

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}