package mirea.manproject.computerhelper;

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

import mirea.manproject.computerhelper.components.CPU;
import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.components.ComponentParameter;
import mirea.manproject.computerhelper.components.Socket;
import mirea.manproject.computerhelper.models.Function;
import mirea.manproject.computerhelper.recyclerviewadapters.ConfigurationRecyclerViewAdapter;
import mirea.manproject.computerhelper.recyclerviewadapters.ResultRecyclerViewAdapter;
import mirea.manproject.computerhelper.viewmodel.ResultViewModel;

public class ResultFragment extends Fragment {

    private List<ComponentParameter> configurationParameters = new ArrayList<>();
    private List<Component> components = new ArrayList<>();
    private ResultViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configurationParameters.add(new Socket(R.string.rate_name, "260Gh"));
        configurationParameters.add(new Socket(R.string.rate_name, "360Gh"));
        configurationParameters.add(new Socket(R.string.rate_name, "460Gh"));
        configurationParameters.add(new Socket(R.string.rate_name, "560Gh"));
        configurationParameters.add(new Socket(R.string.rate_name, "660Gh"));
        configurationParameters.add(new Socket(R.string.rate_name, "760Gh"));

        components.add(new CPU("Процессор", "Лучший по цене"));
        components.add(new CPU("Процессор"));
        components.add(new CPU("Процессор"));

        vm = new ViewModelProvider(this).get(ResultViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView fuction_name = view.findViewById(R.id.function_name);
        TextView function_text = view.findViewById(R.id.function_text);

        vm.getFunctionLiveData().observe(getViewLifecycleOwner(), new Observer<Function>() {
            @Override
            public void onChanged(@Nullable final Function function) {
                fuction_name.setText(function.getName());
                function_text.setText(function.getText());
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_configuration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        ConfigurationRecyclerViewAdapter adapter = new ConfigurationRecyclerViewAdapter(configurationParameters);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = view.findViewById(R.id.recycler_view_result);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        ResultRecyclerViewAdapter adapter2 = new ResultRecyclerViewAdapter(components);
        recyclerView2.setAdapter(adapter2);

        return view;
    }
}