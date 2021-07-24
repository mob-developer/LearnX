package ir.mk.learnx.quiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import ir.mk.learnx.R;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private String[] dataSet;

    @NonNull
    @NotNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.option_button, parent, false);
        QuestionAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull QuestionAdapter.ViewHolder holder, int position) {
        holder.button.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.option_button);
        }
    }

    public QuestionAdapter(String[] myDataset) {
        dataSet = myDataset;

    }
}
