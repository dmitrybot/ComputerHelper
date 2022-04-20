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
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        setComponentPatameters(componentParameterList);
    }
    public CPU(String name, String recomendation) {
        super(name, recomendation);
        setIcon(R.drawable.cpu_icon);
        List<ComponentParameter> componentParameterList = new ArrayList<>();
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        componentParameterList.add(new Socket(R.string.rate_name, "360Gh"));
        setComponentPatameters(componentParameterList);
    }

}
