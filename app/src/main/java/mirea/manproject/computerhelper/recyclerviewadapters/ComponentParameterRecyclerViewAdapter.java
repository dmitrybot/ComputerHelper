package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.ComponentParameter;

public class ComponentParameterRecyclerViewAdapter extends RecyclerView.Adapter<ComponentParameterViewHolder>{

    private List<ComponentParameter> componentParameters;

    ComponentParameterRecyclerViewAdapter(List<ComponentParameter> components) {
        this.componentParameters = components;
    }

    @NonNull
    @Override
    public ComponentParameterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_parameter_item, parent, false);
        return new ComponentParameterViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentParameterViewHolder holder, int position) {
        if (componentParameters != null && position < componentParameters.size()) {
            ComponentParameter componentParameter = componentParameters.get(position);
            holder.componentParameterName.setText(componentParameter.getName());
        }
    }

    @Override
    public int getItemCount() {
        return componentParameters.size();
    }
}