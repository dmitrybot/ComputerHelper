package mirea.manproject.computerhelper.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;

public class FunctionRepository {

    private MutableLiveData<Function> currentFunction = new MutableLiveData<>();
    private MutableLiveData<List<Function>> functionsLiveData = new MutableLiveData<>();

    public FunctionRepository(){

    }

    public void generateFunctions(List<Function> functions){
        functionsLiveData.setValue(functions);
    }

    public void setCurrentFunction(int position) {
        this.currentFunction.setValue(functionsLiveData.getValue().get(position));
    }

    public void setCurrentFunction(Function function) {
        this.currentFunction.setValue(function);
    }

    public void setCurrentFunctionConfiguration(List<Component> components){
        Function f = currentFunction.getValue();
        f.setComponentList(components);
        currentFunction.setValue(f);
    }

    public MutableLiveData<List<Function>> getFunctions() {
        return functionsLiveData;
    }

    public MutableLiveData<Function> getFunction(){
        return currentFunction;
    }

    public void changeConfigurationComponent(int componentPosition, int variantPosition){
        Function f = currentFunction.getValue();
        Component component = f.getComponent(componentPosition);
        component.setPickedVariant(variantPosition);
    }
}
