package mirea.manproject.computerhelper.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.JsonUtils;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.recyclerviewadapters.FunctionCardRecyclerViewAdapter;
import mirea.manproject.computerhelper.recyclerviewadapters.FunctionItemDecoration;
import mirea.manproject.computerhelper.models.Function;
import mirea.manproject.computerhelper.viewmodel.FunctionViewModel;
import mirea.manproject.computerhelper.viewmodel.MenuViewModel;

public class MenuFragment extends Fragment {

    private List<Function> functions = new ArrayList();
    private MenuViewModel vm;
    FunctionCardRecyclerViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = new ViewModelProvider(this).get(MenuViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));


        vm.getFunctionsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Function>>() {
            @Override
            public void onChanged(@Nullable final List<Function> functions) {
                adapter = new FunctionCardRecyclerViewAdapter(functions);
                recyclerView.setAdapter(adapter);
            }
        });

        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new FunctionItemDecoration(largePadding, smallPadding));

        return view;
    }
}