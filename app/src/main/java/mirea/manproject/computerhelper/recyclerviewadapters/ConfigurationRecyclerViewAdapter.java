package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.ComponentParameter;

public class ConfigurationRecyclerViewAdapter extends RecyclerView.Adapter<ConfigurationViewHolder>{

    private List<ComponentParameter> configurationParameters;

    public ConfigurationRecyclerViewAdapter(List<ComponentParameter> configurationParameters) {
        this.configurationParameters = configurationParameters;
    }

    @NonNull
    @Override
    public ConfigurationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.configuration_item, parent, false);
        return new ConfigurationViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfigurationViewHolder holder, int position) {
        if (configurationParameters != null && position < configurationParameters.size()) {
            ComponentParameter configurationParameter = configurationParameters.get(position);
            holder.propertyName.setText(configurationParameter.getName());
            holder.propertyValue.setText(configurationParameter.getValue());
        }
    }

    @Override
    public int getItemCount() {
        return configurationParameters.size();
    }
}
