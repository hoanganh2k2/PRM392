package com.example.exercise13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercise13.Models.Course;

import java.util.List;

public class CourseAdapter extends
        RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<Course> courseList;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,
                        parent,false);
        return new CourseViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course currentCourse = courseList.get(position);
        holder.textViewId.setText(currentCourse.getId());
        holder.textViewName.setText(currentCourse.getName());
        holder.textViewDesc.setText(currentCourse.getDescription());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onEditClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public static class CourseViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewId;
        public TextView textViewName;
        public TextView textViewDesc;
        public ImageButton editButton;
        public ImageButton deleteButton;
        public CourseViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_id);
            textViewName = itemView.findViewById(R.id.text_name);
            textViewDesc = itemView.findViewById(R.id.text_desc);
            editButton = itemView.findViewById(R.id.button_edit);
            deleteButton = itemView.findViewById(R.id.button_delete);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener != null){
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            editButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener != null){
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEditClick(position);
                        }
                    }
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener != null){
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
    public CourseAdapter(List<Course> courseList){
        this.courseList = courseList;
    }
}
