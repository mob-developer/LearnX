package ir.mk.learnx.quiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import ir.mk.learnx.R;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.ViewHolder> {
    private String[] dataSet;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Button button;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.lesson_name);
            button = (Button) itemView.findViewById(R.id.watch_lesson_button);
            context = itemView.getContext();


        }

    }


    @NotNull
    @Override
    public QuizListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.lesson_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull QuizListAdapter.ViewHolder holder, int position) {
        holder.textView.setText(dataSet[position]);
        holder.itemView.findViewById(R.id.watch_lesson_button).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), QuestionActivity.class);
            holder.button.getContext().startActivity(intent);
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
