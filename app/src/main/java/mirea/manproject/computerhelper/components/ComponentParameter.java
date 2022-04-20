package mirea.manproject.computerhelper.components;

public abstract class ComponentParameter {

    int name;
    String value;

    public ComponentParameter(){}

    public ComponentParameter(int name) {
        this.name = name;
    }

    public ComponentParameter(int name, String value) {
        this.name = name;
        this.value = value;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
