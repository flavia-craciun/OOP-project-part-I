package input;

import enums.Cities;

import java.util.List;

public class InitialData {
    private List<ChildInput> children;
    private List<Gifts> santaGiftsList;
    private List<Cities> santaCitiesList;

    public List<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(List<ChildInput> children) {
        this.children = children;
    }

    public List<Gifts> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<Gifts> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public List<Cities> getSantaCitiesList() {
        return santaCitiesList;
    }

    public void setSantaCitiesList(List<Cities> santaCitiesList) {
        this.santaCitiesList = santaCitiesList;
    }
}
