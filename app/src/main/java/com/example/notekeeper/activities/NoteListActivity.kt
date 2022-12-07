package com.example.notekeeper.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.DataManager
import com.example.notekeeper.activities.MainActivity
import com.example.notekeeper.adapters.NoteRecyclerAdapter
import com.example.notekeeper.databinding.ActivityNoteListBinding
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        listItems.layoutManager = LinearLayoutManager(this)//associates a layout manager with our recycler view
        listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes)//connects the NoteRecyclerAdapter class to the RecyclerView
    }

    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
    }
}