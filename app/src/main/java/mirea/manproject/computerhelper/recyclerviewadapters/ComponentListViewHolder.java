package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;

public class ComponentListViewHolder extends RecyclerView.ViewHolder{
    public ImageView componentImage;
    public TextView componentName;
    public RecyclerView recyclerView;

    public ComponentListViewHolder(@NonNull View itemView) {
        super(itemView);
        componentName = itemView.findViewById(R.id.component_name);
        componentImage = itemView.findViewById(R.id.component_icon);
        recyclerView = itemView.findViewById(R.id.recycler_view_in);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, GridLayoutManager.VERTICAL, false));
    }
}
