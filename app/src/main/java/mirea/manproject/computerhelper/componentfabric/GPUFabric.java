package mirea.manproject.computerhelper.componentfabric;

import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.components.GPU;

public class GPUFabric implements ComponentFabric{
    @Override
    public Component createComponent() {
        return new GPU();
    }
}
