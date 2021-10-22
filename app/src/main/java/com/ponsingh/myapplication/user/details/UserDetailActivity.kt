package com.ponsingh.myapplication.user.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ponsingh.myapplication.databinding.UserDetailActivityBinding

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = UserDetailActivityBinding.inflate(layoutInflater)
        val toolbar=binding.toolbar2
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this, ViewModelFactory(
                application,
                intent.getIntExtra("id", 0)
            )
        ).get(UserDetailViewModel::class.java)
        setContentView(binding.root)
        viewModel.detail.observe(this, Observer {
            binding.model = it

        })
        viewModel.error.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                viewModel.error.value = null
            }

        })
        binding.tvPhone.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + binding.model?.phone)
            startActivity(dialIntent)
        }
        binding.tvEmail.setOnClickListener {
            binding.model?.let {model->
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:${model.email}")
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }


}