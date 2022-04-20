package mirea.manproject.computerhelper.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import mirea.manproject.computerhelper.DI.ServiceLocator;
import mirea.manproject.computerhelper.FunctionRepository;
import mirea.manproject.computerhelper.MainActivity;
import mirea.manproject.computerhelper.models.Function;

public class MenuViewModel extends ViewModel {

    FunctionRepository functionRepository;

    private MutableLiveData<List<Function>> functionsMutableLiveData;

    public MenuViewModel(){
        functionRepository = ServiceLocator.getInstance().functionRepository;
        functionsMutableLiveData = functionRepository.getFunctions();
    }

    public LiveData<List<Function>> getFunctionsLiveData() {
        return functionsMutableLiveData;
    }
}
