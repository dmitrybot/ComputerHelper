package mirea.manproject.computerhelper.recyclerviewadapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;

public class FunctionCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView functionImage;
    public TextView functionTitle;

    public FunctionCardViewHolder(@NonNull View itemView) {
        super(itemView);
        functionImage = itemView.findViewById(R.id.function_image);
        functionTitle = itemView.findViewById(R.id.function_title);

        functionImage.setOnClickListener(this);
        functionTitle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            ServiceLocator.getInstance().goToFunctionFragment(position);
        }
    }
}