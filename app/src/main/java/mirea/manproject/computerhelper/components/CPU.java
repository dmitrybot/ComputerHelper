package mirea.manproject.computerhelper.components;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.R;

public class CPU extends Component{

    public CPU(){}
    public CPU(String name) {
        super(name);
        setIcon(R.drawable.cpu_icon);
        List<ComponentParameter> componentParameterList = new ArrayList<>();
        componentParameterList.add(new Rate());
        componentParameterList.add(new Developer());
        setComponentPatameters(componentParameterList);
    }

}
