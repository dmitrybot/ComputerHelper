package mirea.manproject.computerhelper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.CPU;
import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.components.GPU;
import mirea.manproject.computerhelper.models.Function;
import mirea.manproject.computerhelper.viewmodel.FunctionViewModel;

public class FunctionRepository {

    private MutableLiveData<Function> currentFunction = new MutableLiveData<>();
    private MutableLiveData<List<Function>> functionsLiveData = new MutableLiveData<>();

    public FunctionRepository(){
        generateFunctions();
    }

    public void generateFunctions(){
        List<Function> functions = new ArrayList<>();
        List<Component> components = new ArrayList<>();
        components.add(new CPU("Процессор"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));


        functions.add(new Function(R.string.battery_title, R.string.battery_text, R.string.battery_name, R.drawable.battery, components));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));

        functionsLiveData.setValue(functions);
    }

    public void setCurrentFunction(int position) {
        this.currentFunction.setValue(functionsLiveData.getValue().get(position));
    }

    public void setCurrentFunction(Function function) {
        this.currentFunction.setValue(function);
    }

    public MutableLiveData<List<Function>> getFunctions() {
        return functionsLiveData;
    }

    public MutableLiveData<Function> getFunction(){
        return currentFunction;
    }
}
