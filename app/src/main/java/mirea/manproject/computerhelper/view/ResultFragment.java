package mirea.manproject.computerhelper.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;
import mirea.manproject.computerhelper.recyclerviewadapters.ConfigurationRecyclerViewAdapter;
import mirea.manproject.computerhelper.recyclerviewadapters.ResultRecyclerViewAdapter;
import mirea.manproject.computerhelper.viewmodel.ResultViewModel;

public class ResultFragment extends Fragment {

    private ResultViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = new ViewModelProvider(this).get(ResultViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView fuction_name = view.findViewById(R.id.function_name);
        TextView function_text = view.findViewById(R.id.function_text);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_configuration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));

        RecyclerView recyclerView2 = view.findViewById(R.id.recycler_view_result);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));

        view.findViewById(R.id.make).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.goToFunctionFragment();
            }
        });

        vm.getFunctionLiveData().observe(getViewLifecycleOwner(), new Observer<Function>() {
            @Override
            public void onChanged(@Nullable final Function function) {
                fuction_name.setText(function.getName());
                function_text.setText(function.getText());

                ConfigurationRecyclerViewAdapter adapter = new ConfigurationRecyclerViewAdapter(function.getComponentList());
                recyclerView.setAdapter(adapter);
            }
        });

        vm.getComponents().observe(getViewLifecycleOwner(), new Observer<List<Component>>() {
            @Override
            public void onChanged(@Nullable final List<Component> components) {
                ResultRecyclerViewAdapter adapter2 = new ResultRecyclerViewAdapter(components);
                recyclerView2.setAdapter(adapter2);
            }
        });

        return view;
    }
}