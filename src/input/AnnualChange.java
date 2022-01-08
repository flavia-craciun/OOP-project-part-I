package input;

import java.util.List;

public final class AnnualChange {
    private Double newSantaBudget;
    private List<Gifts> newGifts;
    private List<ChildInput> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<Gifts> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final List<Gifts> newGifts) {
        this.newGifts = newGifts;
    }

    public List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
