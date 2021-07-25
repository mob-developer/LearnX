package ir.mk.learnx.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.model.SubCourseList;
import ir.mk.learnx.teach.LoadingLearn;
import ir.mk.learnx.teach.SubCourseListActivity;



public class SubCourseListAdapter extends RecyclerView.Adapter<SubCourseListAdapter.ViewHolder> {
    private final ArrayList<SubCourseList> listData;

    // RecyclerView recyclerView;
    public SubCourseListAdapter(ArrayList<SubCourseList> listData) {
        this.listData = listData;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.sub_course_list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SubCourseList current = listData.get(position);
        holder.bind(current.getTitle(),current.getProgress(),current.getImageId());
        holder.itemView.setOnClickListener(v -> {
//            Toast.makeText(v.getContext(), ""+current.getId(), Toast.LENGTH_SHORT).show();

            Intent intent0 = new Intent((SubCourseListActivity)v.getContext(), LoadingLearn.class);
            intent0.putExtra("lesson",current.getLesson());
            intent0.putExtra("courseId",current.getCourseId());
            intent0.putExtra("subCourseId",current.getId());
            v.getContext().startActivity(intent0);
        });
    }



    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleItemView;
        private final TextView progressItemView;
        private final ImageView imageItemView;

        private ViewHolder(View itemView) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.sub_course_list_item_title);
            progressItemView = itemView.findViewById(R.id.sub_course_list_item_progress);
            imageItemView = itemView.findViewById(R.id.sub_course_list_item_image);
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

