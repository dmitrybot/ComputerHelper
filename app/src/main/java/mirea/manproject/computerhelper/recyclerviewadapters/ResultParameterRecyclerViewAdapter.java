package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.ComponentParameter;

public class ResultParameterRecyclerViewAdapter extends RecyclerView.Adapter<ResultParameterViewHolder>{

    private List<ComponentParameter> componentParameters;

    public ResultParameterRecyclerViewAdapter(List<ComponentParameter> componentParameters) {
        this.componentParameters = componentParameters;
    }

    @NonNull
    @Override
    public ResultParameterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_parameter_item, parent, false);
        return new ResultParameterViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultParameterViewHolder holder, int position) {
        if (componentParameters != null && position < componentParameters.size()) {
            ComponentParameter componentParameter = componentParameters.get(position);
            holder.propertyName.setText(componentParameter.getName());
            holder.propertyValue.setText(componentParameter.getValue());
        }
    }

    @Override
    public int getItemCount() {
        return componentParameters.size();
    }
}