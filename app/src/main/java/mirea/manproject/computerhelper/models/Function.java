package mirea.manproject.computerhelper.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Function {

    private int position;
    private int title = 2131755072;
    private int text = 2131755072;
    private int name = 2131755072;
    private int image = 0;
    List<Component> componentList = new ArrayList<>();

    public Function() {
    }

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

    public Function(int title, int text, int name, int image, int position, List<Component> componentList) {
        this.title = title;
        this.text = text;
        this.name = name;
        this.image = image;
        this.position = position;
        this.componentList = componentList;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public Component getComponent(int position){
        return componentList.get(position);
    }

    @Override
    public String toString() {
        return "Function{" +
                "title=" + title +
                ", text=" + text +
                ", name=" + name +
                ", image=" + image +
                ", componentList=" + componentList +
                '}';
    }
}