package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.Component;

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<ResultViewHolder>{

    private List<Component> components;

    public ResultRecyclerViewAdapter(List<Component> components) {
        this.components = components;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        return new ResultViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        if (components != null && position < components.size()) {
            Component component = components.get(position);
            if (component.getRecomendation() != null){
                holder.recomendation.setText(component.getRecomendation());
                holder.recomendation.setVisibility(View.VISIBLE);
            }
            holder.title.setText(component.getName());
            ResultParameterRecyclerViewAdapter adapter = new ResultParameterRecyclerViewAdapter(component.getComponentPatameters());

            holder.recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return components.size();
    }
}