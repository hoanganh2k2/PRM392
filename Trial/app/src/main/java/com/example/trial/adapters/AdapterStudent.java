package com.example.trial.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.R;
import com.example.trial.models.Student;

import java.util.List;

public class AdapterStudent extends
        RecyclerView.Adapter<AdapterStudent.StudentViewHolder>{
    private List<Student> studentList;
    public static class StudentViewHolder extends
            RecyclerView.ViewHolder {
        public TextView StudentIdTV;
        public TextView StudentNameTV;
        public TextView StudentEmailTV;
        public StudentViewHolder(View itemView) {
            super(itemView);
            StudentIdTV = itemView.findViewById(R.id.StudentIdTV);
            StudentNameTV =
                    itemView.findViewById(R.id.StudentNameTV);
            StudentEmailTV =
                    itemView.findViewById(R.id.StudentEmailTV);
        }
    }
    public AdapterStudent(List<Student>studentList){
        this.studentList = studentList;
    }
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,
                        parent, false);
        return new StudentViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(StudentViewHolder holder, int
            position) {
        Student currentStudent = studentList.get(position);
        holder.StudentIdTV.setText(currentStudent.getId());
        holder.StudentNameTV.setText(currentStudent.getName());
        holder.StudentEmailTV.setText(currentStudent.getEmail());
    }
    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
