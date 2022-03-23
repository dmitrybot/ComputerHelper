package mirea.manproject.computerhelper.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Function;

public class MenuFragment extends Fragment {

    List<Function> functions = new ArrayList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        functions = MainActivity.getInstance().getFunctions();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        FunctionCardRecyclerViewAdapter adapter = new FunctionCardRecyclerViewAdapter(functions);

        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new FunctionItemDecoration(largePadding, smallPadding));

        return view;
    }

    /*public void Click(View v){
        System.out.println("12345678765432345");
        //int position = getAdapterPosition();
        //if (position != RecyclerView.NO_POSITION) {
        MainActivity.getInstance().goToFunctionFragment(1);

    }*/
}