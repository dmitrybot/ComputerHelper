package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.Component;

public class ComponentListRecyclerViewAdapter extends RecyclerView.Adapter<ComponentListViewHolder>{

    private List<Component> components;

    public ComponentListRecyclerViewAdapter(List<Component> components) {
        this.components = components;
    }

    @NonNull
    @Override
    public ComponentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item, parent, false);
        return new ComponentListViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentListViewHolder holder, int position) {
        if (components != null && position < components.size()) {
            Component component = components.get(position);
            holder.componentName.setText(component.getName());
            holder.componentImage.setImageResource(component.getIcon());
            ComponentParameterRecyclerViewAdapter adapter = new ComponentParameterRecyclerViewAdapter(component.getComponentPatameters());

            holder.recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return components.size();
    }
}
