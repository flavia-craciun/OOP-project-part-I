package nicelist;

import common.Constants;
import input.ChildInput;

public final class Baby extends Child {
    public Baby(final ChildInput child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        super.setAverageScore(Constants.BABY_AVERAGE_SCORE);
    }
}
