package nicelist;

import nicelist.rounds.AnnualChildren;

import java.util.ArrayList;
import java.util.List;

public final class NiceList {
    private List<AnnualChildren> annualChildren = new ArrayList<>();

    public List<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final List<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public void addAnnualNiceChildren(final AnnualChildren niceChildren) {
        annualChildren.add(niceChildren);
    }

}
