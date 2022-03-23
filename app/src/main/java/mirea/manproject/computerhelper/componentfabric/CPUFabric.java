package mirea.manproject.computerhelper.componentfabric;

import mirea.manproject.computerhelper.components.CPU;
import mirea.manproject.computerhelper.components.Component;

public class CPUFabric implements ComponentFabric{
    @Override
    public Component createComponent() {
        return new CPU();
    }
}
