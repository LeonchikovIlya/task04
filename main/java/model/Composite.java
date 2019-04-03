package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Composite implements Component {

    private List<Component> partsList;

    public Composite() {
        this.partsList = new ArrayList<>();
    }

    public void addComponent(Component component) {

        if (component != null) {
            partsList.add(component);
        }
    }

    public List<Component> getChild(){
        return partsList;
    }

    public int size() {
        return partsList.size();
    }

    public void removeComponent(Component component) {
         partsList.remove(component);
    }

    public Component getComponent(int index) {
          return partsList.get(index);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Component comp : partsList){
            builder.append(comp);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Composite composite = (Composite) o;
        return partsList.equals(composite.partsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partsList);
    }
}
