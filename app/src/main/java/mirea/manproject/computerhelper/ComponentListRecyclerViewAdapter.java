package mirea.manproject.computerhelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.componentfabric.ComponentFabric;
import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.components.ComponentParameter;
import mirea.manproject.computerhelper.menu.FunctionCardRecyclerViewAdapter;
import mirea.manproject.computerhelper.menu.FunctionCardViewHolder;
import mirea.manproject.computerhelper.menu.FunctionItemDecoration;
import mirea.manproject.computerhelper.models.Function;

public class ComponentListRecyclerViewAdapter extends RecyclerView.Adapter<ComponentViewHolder>{

    private List<Component> components;

    ComponentListRecyclerViewAdapter(List<Component> components) {
        this.components = components;
    }

    @NonNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item, parent, false);
        return new ComponentViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentViewHolder holder, int position) {
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
