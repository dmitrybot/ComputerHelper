package mirea.manproject.computerhelper.components;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.R;

public class GPU extends Component{

    public GPU(){}
    public GPU(String name) {
        super(name);
        setIcon(R.drawable.gpu_icon);
        List<ComponentParameter> componentParameterList = new ArrayList<>();
        componentParameterList.add(new Socket(R.string.manufacturer_name, "460Gh"));
        componentParameterList.add(new Socket(R.string.videomemory_name, "560Gh"));
        setComponentPatameters(componentParameterList);
    }
}
