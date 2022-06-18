package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter= TodoAdapter(mutableListOf())

        toDoRec.adapter = todoAdapter
        toDoRec.layoutManager =LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val todoTitle=txtTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                txtTitle.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }


    }
}