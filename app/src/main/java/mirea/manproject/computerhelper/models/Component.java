package mirea.manproject.computerhelper.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Component {

    private String name;
    private List<String> variants;
    private int icon;
    private String pickedVariant;
    private String recomendation;
    private List<ComponentParameter> componentParameters;

    public Component() {
    }

    public Component(String name) {
        this.name = name;
    }

    public Component(String name, String recomendation) {
        this.name = name;
        this.recomendation = recomendation;
    }

    public Component(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public Component(int icon, String name, List<ComponentParameter> componentPatameters) {
        this.icon = icon;
        this.name = name;
        this.componentParameters = componentPatameters;
    }

    public Component(int icon, String name, List<ComponentParameter> componentPatameters, List<String> variants) {
        this.icon = icon;
        this.name = name;
        this.componentParameters = componentPatameters;
        this.variants = variants;
    }

    public Component(String name, List<String> variants, int icon, String pickedVariant, String recomendation, List<ComponentParameter> componentParameters) {
        this.name = name;
        this.variants = variants;
        this.icon = icon;
        this.pickedVariant = pickedVariant;
        this.recomendation = recomendation;
        this.componentParameters = componentParameters;
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

    public List<ComponentParameter> getComponentParameters() {
        return componentParameters;
    }

    public void setComponentParameters(List<ComponentParameter> componentPatameters) {
        this.componentParameters = componentPatameters;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public String getPickedVariant() {
        return pickedVariant;
    }

    public void setPickedVariant(String pickedVariant) {
        this.pickedVariant = pickedVariant;
    }

    public void setPickedVariant(int variantPosition) {
        this.pickedVariant = variants.get(variantPosition);
    }



    public void addComponentParameter(ComponentParameter componentParameter){
        componentParameters.add(componentParameter);
    }

    @Override
    public String toString() {
        return "Component{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", componentPatameters=" + componentParameters +
                ", recomendation='" + recomendation + '\'' +
                ", variants=" + variants +
                ", title='" + pickedVariant + '\'' +
                '}';
    }
}
