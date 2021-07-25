package ir.mk.learnx.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import ir.mk.learnx.R;
import ir.mk.learnx.quiz.QuestionActivity;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.ViewHolder> {
    private String[] dataSet;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.lesson_name);
            context = itemView.getContext();
        }

    }


    @NotNull
    @Override
    public QuizListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.quiz_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull QuizListAdapter.ViewHolder holder, int position) {
        holder.textView.setText(dataSet[position]);
        holder.itemView.findViewById(R.id.lesson_card).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), QuestionActivity.class);
            holder.textView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }




    public QuizListAdapter(String[] myDataset) {
        dataSet = myDataset;
    }
}
