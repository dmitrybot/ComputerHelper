package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;

public class ResultParameterViewHolder extends RecyclerView.ViewHolder{
    public TextView propertyName;
    public TextView propertyValue;


    public ResultParameterViewHolder(@NonNull View itemView) {
        super(itemView);
        propertyName = itemView.findViewById(R.id.property_name);
        propertyValue = itemView.findViewById(R.id.property_value);
    }
}