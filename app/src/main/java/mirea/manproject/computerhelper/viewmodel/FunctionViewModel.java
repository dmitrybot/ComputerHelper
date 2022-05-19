package mirea.manproject.computerhelper.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.network.Network;
import mirea.manproject.computerhelper.repository.FunctionRepository;
import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;

public class FunctionViewModel extends ViewModel {

    FunctionRepository functionRepository;
    Network network;

    private MutableLiveData<Function> functionMutableLiveData;

    public LiveData<Function> getFunctionLiveData() {
        return functionMutableLiveData;
    }

    public FunctionViewModel(){
        functionRepository = ServiceLocator.getInstance().getFunctionRepository();
        functionMutableLiveData = functionRepository.getFunction();
        network = ServiceLocator.getInstance().getNetwork();
        //System.out.println(functionMutableLiveData.getValue());
    }

    public void setCompponent(Component component, int position){
        Function function = functionMutableLiveData.getValue();
        function.setComponent(component, position);
        functionMutableLiveData.setValue(function);
    }

    public void loadComponents(){
    }

    public void goToResultFragment(){
        if (functionMutableLiveData.getValue().getComponentList().stream().noneMatch(a -> a.getPickedVariant() == null)) {
            network.getComponents(functionMutableLiveData.getValue());
            ServiceLocator.getInstance().goToResultFragment();
        }
    }
}