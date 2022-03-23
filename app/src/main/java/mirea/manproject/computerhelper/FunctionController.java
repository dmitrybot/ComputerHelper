package mirea.manproject.computerhelper;

import java.util.ArrayList;
import java.util.List;

import mirea.manproject.computerhelper.components.CPU;
import mirea.manproject.computerhelper.components.Component;
import mirea.manproject.computerhelper.components.GPU;
import mirea.manproject.computerhelper.models.Function;

public class FunctionController {

    private List<Function> functions = new ArrayList();

    public void generateFunctions(){
        List<Component> components = new ArrayList<>();
        components.add(new CPU("Процессор"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));
        components.add(new GPU("Видеокарта"));


        functions.add(new Function(R.string.battery_title, R.string.battery_text, R.string.battery_name, R.drawable.battery, components));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
        functions.add(new Function(R.string.function_title));
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public Function getFunction(int position){
        return functions.get(position);
    }
}
