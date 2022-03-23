package mirea.manproject.computerhelper.components;

import java.util.List;

public abstract class Component {

    private int icon;
    private String name;
    private List<ComponentParameter> componentPatameters;

    public Component() {
    }

    public Component(String name) {
        this.name = name;
    }

    public Component(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public Component(int icon, String name, List<ComponentParameter> componentPatameters) {
        this.icon = icon;
        this.name = name;
        this.componentPatameters = componentPatameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public List<ComponentParameter> getComponentPatameters() {
        return componentPatameters;
    }

    public void setComponentPatameters(List<ComponentParameter> componentPatameters) {
        this.componentPatameters = componentPatameters;
    }
}
