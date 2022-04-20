package mirea.manproject.computerhelper.recyclerviewadapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;

public class ResultViewHolder extends RecyclerView.ViewHolder{
    public TextView recomendation;
    public TextView title;
    public RecyclerView recyclerView;

    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);
        recomendation = itemView.findViewById(R.id.recomendation);
        recomendation.setVisibility(View.GONE);
        title = itemView.findViewById(R.id.function_name);
        recyclerView = itemView.findViewById(R.id.recycler_view_in);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, GridLayoutManager.VERTICAL, false));
    }
}
