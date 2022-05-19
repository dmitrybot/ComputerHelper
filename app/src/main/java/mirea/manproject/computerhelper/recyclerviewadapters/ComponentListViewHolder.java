package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.BaseSearchableSpinner;
import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;

public class ComponentListViewHolder extends RecyclerView.ViewHolder{
    public ImageView componentImage;
    public TextView componentName;
    public BaseSearchableSpinner spinner;
    View view;

    public ComponentListViewHolder(@NonNull View itemView) {
        super(itemView);
        componentName = itemView.findViewById(R.id.component_name);
        componentImage = itemView.findViewById(R.id.component_icon);
        spinner = itemView.findViewById(R.id.spinner);
        view = itemView;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    ServiceLocator.getInstance().changeConfigurationComponent(position, selectedItemPosition);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
