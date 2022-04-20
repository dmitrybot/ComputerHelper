package mirea.manproject.computerhelper.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.FunctionRepository;
import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.models.Function;

public class FunctionViewModel extends ViewModel {

    FunctionRepository functionRepository;

    private MutableLiveData<Function> functionMutableLiveData;

    public LiveData<Function> getFunctionLiveData() {
        return functionMutableLiveData;
    }

    public FunctionViewModel(){
        functionRepository = ServiceLocator.getInstance().functionRepository;
        functionMutableLiveData = functionRepository.getFunction();
    }

    public void setCompponent(Component component, int position){
        Function function = functionMutableLiveData.getValue();
        function.setComponent(component, position);
        functionMutableLiveData.setValue(function);
    }

    public void goToResultFragment(){
        ServiceLocator.getInstance().goToResultFragment();
    }
}