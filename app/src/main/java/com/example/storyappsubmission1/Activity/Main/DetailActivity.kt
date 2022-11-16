package com.example.storyappsubmission1.Activity.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.storyappsubmission1.Activity.Start.LoginActivity
import com.example.storyappsubmission1.R
import com.example.storyappsubmission1.databinding.ActivityDetailBinding
import com.storyappsubmission1.Data.Response.ListStoryR
import com.storyappsubmission1.ViewModel.StoryVM


class DetailActivity : AppCompatActivity() {

    private lateinit var  ListStory: ListStoryR
    private lateinit var binding: ActivityDetailBinding
    private lateinit var StoryVM: StoryVM

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ListStory = intent.getParcelableExtra<ListStoryR>(STORIES) as ListStoryR
        binding.apply {
            tvDetailName.text = ListStory.name
            tvDetailPost.text = ListStory.post
            tvDetailDescription.text = ListStory.description
        }
        Glide.with(applicationContext)
            .load(ListStory.photoUrl)
            .into(binding.ivDetailPhoto)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                StoryVM.deleteUser()
                val i = Intent(this, LoginActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
    companion object {
        const val STORIES = "stories"
    }
}