package mirea.manproject.computerhelper.components;

public abstract class ComponentParameter {

    int name;

    public ComponentParameter(){}

    public ComponentParameter(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
