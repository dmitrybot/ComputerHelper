package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Component;

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

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    holder.itemView.getContext(), R.layout.spinner_item_selection, R.id.spinner_item, component.getVariants());
            holder.spinner.setAdapter(adapter);
            if (component.getPickedVariant() != null) holder.spinner.setSelection(component.getVariants().indexOf(component.getPickedVariant()));
        }
    }

    @Override
    public int getItemCount() {
        return components.size();
    }
}
