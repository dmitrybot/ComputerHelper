package mirea.manproject.computerhelper.models;

import java.util.List;

import mirea.manproject.computerhelper.components.Component;

public class Function {

    private int title;
    private int text;
    private int name;
    private int image = 0;
    List<Component> componentList;

    public Function(int title) {
        this.title = title;
    }

    public Function(int title, int image) {
        this.title = title;
        this.image = image;
    }

    public Function(int title, int text, int name, int image) {
        this.title = title;
        this.text = text;
        this.name = name;
        this.image = image;
    }

    public Function(int title, int text, int name, int image, List<Component> componentList) {
        this.title = title;
        this.text = text;
        this.name = name;
        this.image = image;
        this.componentList = componentList;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public void setComponent(Component component, int position){
        componentList.set(position, component);
    }
}
