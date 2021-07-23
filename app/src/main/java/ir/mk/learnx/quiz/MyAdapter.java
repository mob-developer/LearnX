package ir.mk.learnx.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import ir.mk.learnx.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] dataSet;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Button button;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.lesson_name);
            button = (Button) itemView.findViewById(R.id.watch_lesson_button);

        }
    }

    @NonNull
    @NotNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.lesson_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAdapter.ViewHolder holder, int position) {
        holder.textView.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


    public MyAdapter(String[] myDataset) {
        dataSet = myDataset;
    }
}
