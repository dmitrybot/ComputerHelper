package mirea.manproject.computerhelper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ComponentParameterViewHolder extends RecyclerView.ViewHolder{
    public TextView componentParameterName;

    public ComponentParameterViewHolder(@NonNull View itemView) {
        super(itemView);
        componentParameterName = itemView.findViewById(R.id.component_parameter_name);
    }
}