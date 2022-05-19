package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.BaseSearchableSpinner;
import mirea.manproject.computerhelper.R;

public class ComponentParameterViewHolder extends RecyclerView.ViewHolder{
    public TextView componentParameterName;
    public BaseSearchableSpinner spinner;

    public ComponentParameterViewHolder(@NonNull View itemView) {
        super(itemView);
        componentParameterName = itemView.findViewById(R.id.component_parameter_name);
        spinner = itemView.findViewById(R.id.spinner);

        String arr[] = { "1111", "2222222222222222rtgyhjksdcvfbgnhmj,.sdbfgnmhjm,222", "3", "1", "2", "3","1", "2", "3","1", "2", "3","1", "2", "3","1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                itemView.getContext(), R.layout.spinner_item_selection, R.id.spinner_item, arr);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
    }
}