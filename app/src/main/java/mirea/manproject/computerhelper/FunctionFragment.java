package mirea.manproject.computerhelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.CPU;
import mirea.manproject.computerhelper.recyclerviewadapters.ComponentListRecyclerViewAdapter;
import mirea.manproject.computerhelper.models.Function;
import mirea.manproject.computerhelper.recyclerviewadapters.FunctionCardRecyclerViewAdapter;
import mirea.manproject.computerhelper.viewmodel.FunctionViewModel;

public class FunctionFragment extends Fragment {

    private Button make;
    private FunctionViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = new ViewModelProvider(this).get(FunctionViewModel.class);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_function, container, false);
        TextView fuction_name = view.findViewById(R.id.function_name);
        TextView function_text = view.findViewById(R.id.function_text);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),
                1, GridLayoutManager.VERTICAL, false));

        vm.getFunctionLiveData().observe(getViewLifecycleOwner(), new Observer<Function>() {
            @Override
            public void onChanged(@Nullable final Function function) {
                fuction_name.setText(function.getName());
                function_text.setText(function.getText());
                ComponentListRecyclerViewAdapter adapter = new ComponentListRecyclerViewAdapter(function.getComponentList());
                recyclerView.setAdapter(adapter);
            }
        });

        make = view.findViewById(R.id.make);

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vm.goToResultFragment();
                vm.setCompponent(new CPU("Процессор"), 2);
            }
        });

        return view;
    }
}
