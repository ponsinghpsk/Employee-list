package com.ponsingh.myapplication.user.list

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ponsingh.myapplication.R
import com.ponsingh.myapplication.databinding.UserListActivityBinding
import com.ponsingh.myapplication.user.details.UserDetailActivity

class UserListActivity : AppCompatActivity(), UserClickListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = UserListActivityBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(UserListViewModel::class.java)
        setContentView(binding.root)
        binding.rvList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel.listdata.observe(this, Observer {
            binding.rvList.adapter = UserListAdapter(it, this)
        })
        viewModel.error.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                viewModel.error.value = null
            }
        })
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, UserDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)

    }

    override fun onEmailClick(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:${email}")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}