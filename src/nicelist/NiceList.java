package nicelist;

import java.util.ArrayList;
import java.util.List;

public class NiceList {
    List<AnnualChildren> annualChildren = new ArrayList<>();

    public List<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public void addAnnualNiceChildren (AnnualChildren niceChildren) {
        annualChildren.add(niceChildren);
    }

    public static class AnnualChildren {
        private List<Child> children = new ArrayList<>();

        public List<Child> getChildren() {
            return children;
        }

        public void setChildren(List<Child> children) {
            this.children = children;
        }

        public void addToNiceList (Child niceChild) {
            children.add(niceChild);
        }
    }
}
