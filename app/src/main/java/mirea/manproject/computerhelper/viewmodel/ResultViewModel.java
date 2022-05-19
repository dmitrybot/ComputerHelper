package mirea.manproject.computerhelper.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.network.Network;
import mirea.manproject.computerhelper.repository.ComponentsRepository;
import mirea.manproject.computerhelper.repository.FunctionRepository;
import mirea.manproject.computerhelper.models.Function;

public class ResultViewModel extends ViewModel {

    FunctionRepository functionRepository;
    ComponentsRepository componentsRepository;

    private MutableLiveData<Function> functionMutableLiveData;
    private MutableLiveData<List<Component>> componentsMutableLiveData;

    public LiveData<Function> getFunctionLiveData() {
        return functionMutableLiveData;
    }

    public LiveData<List<Component>> getComponents(){
        return componentsMutableLiveData;
    }


    public ResultViewModel(){
        functionRepository = ServiceLocator.getInstance().getFunctionRepository();
        functionMutableLiveData = functionRepository.getFunction();
        componentsRepository = ServiceLocator.getInstance().getComponentsRepository();
        componentsMutableLiveData = componentsRepository.getComponentsLiveData();
    }

    public void goToFunctionFragment(){
        ServiceLocator.getInstance().goToFunctionFragment();
    }
}