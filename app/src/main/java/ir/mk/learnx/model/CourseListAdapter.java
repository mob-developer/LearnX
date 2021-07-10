package ir.mk.learnx.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.teach.CourseListActivity;
import ir.mk.learnx.teach.SubCourseListActivity;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
        private ArrayList<CourseList> listdata;

        // RecyclerView recyclerView;
        public CourseListAdapter(ArrayList<CourseList> listdata) {
            this.listdata = listdata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem = layoutInflater.inflate(R.layout.course_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final CourseList current = listdata.get(position);
            holder.bind(current.getTitle(),current.getProgress(),current.getImageId());
            holder.itemView.setOnClickListener(v -> {
//                Toast.makeText(v.getContext(), ""+current.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent((CourseListActivity)v.getContext(), SubCourseListActivity.class);
                intent.putExtra("courseId",current.getId());
                ((CourseListActivity)v.getContext()).startActivity(intent);
            });
//            holder.deleteItemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                Toast.makeText(view.getContext(), "click on item: " + current.getId(), Toast.LENGTH_SHORT).show();
//                    BookmarkRoomDatabase database = Room.databaseBuilder(view.getContext(),BookmarkRoomDatabase.class,"bookmarkDB").allowMainThreadQueries().build();
//                    BookmarkDao bookmarkDao = database.bookmarkDao();
//                    bookmarkDao.delete(current.getId());
//                    Toast.makeText(view.getContext(), "deleted!", Toast.LENGTH_SHORT).show();
//                    ((BookmarkActivity)view.getContext()).recreate();
//                }
//            });
        }


        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView titleItemView;
            private final TextView progressItemView;
            private final ImageView imageItemView;

            private ViewHolder(View itemView) {
                super(itemView);
                titleItemView = itemView.findViewById(R.id.course_list_item_title);
                progressItemView = itemView.findViewById(R.id.course_list_item_progress);
                imageItemView = itemView.findViewById(R.id.course_list_item_image);
            }
            public void bind(String title,String progress,int imageId) {
                titleItemView.setText(title);
                progressItemView.setText(progress);
                if (imageId!=0) {
                    if (imageId == -1){
                        imageItemView.setImageResource(R.drawable.ic_baseline_school_24_green);
                    }else{
                        imageItemView.setImageResource(imageId);
                    }
                }
            }

        }
    }

