package mirea.manproject.computerhelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mirea.manproject.computerhelper.menu.FunctionCardRecyclerViewAdapter;
import mirea.manproject.computerhelper.menu.FunctionItemDecoration;
import mirea.manproject.computerhelper.models.Function;

public class FunctionFragment extends Fragment {

    private Integer position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_function, container, false);
        Function function = MainActivity.getInstance().getFunction(position);
        TextView fuction_name = view.findViewById(R.id.function_name);
        TextView function_text = view.findViewById(R.id.function_text);
        fuction_name.setText(function.getName());
        function_text.setText(function.getText());

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        //recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        ComponentListRecyclerViewAdapter adapter = new ComponentListRecyclerViewAdapter(function.getComponentList());

        recyclerView.setAdapter(adapter);
        /*int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new FunctionItemDecoration(largePadding, smallPadding));*/

        return view;
    }
}
