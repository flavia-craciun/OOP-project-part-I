package input;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<Gifts> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Gifts> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Gifts> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
