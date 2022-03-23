package mirea.manproject.computerhelper.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Function;

public class FunctionCardRecyclerViewAdapter extends RecyclerView.Adapter<FunctionCardViewHolder>{

    private List<Function> functions;

    FunctionCardRecyclerViewAdapter(List<Function> functions) {
        this.functions = functions;
    }

    @NonNull
    @Override
    public FunctionCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.function_card, parent, false);
        return new FunctionCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionCardViewHolder holder, int position) {
        if (functions != null && position < functions.size()) {
            Function function = functions.get(position);
            holder.functionTitle.setText(function.getTitle());
            if (function.getImage() != 0) holder.functionImage.setImageResource(function.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return functions.size();
    }
}
