package mirea.manproject.computerhelper.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import mirea.manproject.computerhelper.models.Component;
import mirea.manproject.computerhelper.models.Function;

public class ComponentsRepository {

    private MutableLiveData<List<Component>> componentsLiveData = new MutableLiveData<>();

    public ComponentsRepository(){

    }

    public MutableLiveData<List<Component>> getComponentsLiveData() {
        return componentsLiveData;
    }

    public void setComponentsLiveData(List<Component> components) {
        this.componentsLiveData.setValue(components);
    }
}
