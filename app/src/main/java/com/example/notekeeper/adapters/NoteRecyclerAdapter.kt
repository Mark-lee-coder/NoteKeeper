package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.NOTE_POSITION
import com.example.notekeeper.NoteInfo
import com.example.notekeeper.R
import com.example.notekeeper.activities.MainActivity

//kotlin uses : instead of extends keyword
class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) : RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]//gets the position of the note passed
        holder.textCourse?.text = note.course?.title//displays the course using the title of the course
        holder.textTitle?.text = note.title//displays the note title
        holder.notePosition = position//our holder will always know the position of the note it is currently associated with
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    /**inner class can access the MainActivity class and use its properties such as context*/
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse: TextView? = itemView.findViewById(R.id.textCourse)
        val textTitle: TextView? = itemView.findViewById(R.id.textTitle)
        var notePosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)//passes the position of the note to be displayed
                context.startActivity(intent)
            }
        }
    }
}