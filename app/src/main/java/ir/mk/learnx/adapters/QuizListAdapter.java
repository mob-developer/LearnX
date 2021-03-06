package ir.mk.learnx.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.model.CourseList;
import ir.mk.learnx.quiz.QuizActivity;
import ir.mk.learnx.teach.SubCourseListActivity;


public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.ViewHolder> {
        private final ArrayList<CourseList> listData;


        public QuizListAdapter(ArrayList<CourseList> listData) {
            this.listData = listData;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem = layoutInflater.inflate(R.layout.quiz_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final CourseList current = listData.get(position);
            holder.bind(current.getTitle());
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), QuizActivity.class);
                intent.putExtra("lesson",current.getId());
                intent.putExtra("step",1);
                intent.putExtra("allStep",7);
                v.getContext().startActivity(intent);
            });

        }


        @Override
        public int getItemCount() {
            return listData.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView lessonName;

            private ViewHolder(@NotNull View itemView) {
                super(itemView);
                lessonName = (TextView) itemView.findViewById(R.id.lesson_name);

            }
            public void bind(String title) {
                lessonName.setText(title);
            }

        }
    }

