package com.example.trial.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.R;
import com.example.trial.models.Todo;

import java.util.List;

public class AdapterTodo extends RecyclerView.Adapter<AdapterTodo.TodoViewHolder> {
    private List<Todo> todoList;

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView userId;
        public TextView id;
        public TextView title;
        public RadioButton completed;

        public TodoViewHolder(View v) {
            super(v);
            userId = v.findViewById(R.id.userId);
            id = v.findViewById(R.id.id);
            title = v.findViewById(R.id.title);
            completed = v.findViewById(R.id.completed);
        }
    }

    public AdapterTodo(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.userId.setText("UserId: " + todo.getUserId());
        holder.id.setText("Id: " + todo.getId());
        holder.title.setText("Title: " + todo.getTitle());
        holder.completed.setChecked(todo.isCompleted());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}