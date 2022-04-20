package mirea.manproject.computerhelper.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.FunctionRepository;
import mirea.manproject.computerhelper.R;
import mirea.manproject.computerhelper.models.Function;

public class ResultViewModel extends ViewModel {

    FunctionRepository functionRepository;

    private MutableLiveData<Function> functionMutableLiveData;

    public LiveData<Function> getFunctionLiveData() {
        return functionMutableLiveData;
    }

    public ResultViewModel(){
        functionRepository = ServiceLocator.getInstance().functionRepository;
        functionMutableLiveData = functionRepository.getFunction();
    }
}