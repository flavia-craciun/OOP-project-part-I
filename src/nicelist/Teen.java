package nicelist;

import input.ChildInput;

public final class Teen extends Child {
    public Teen(final ChildInput child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        Double totalNiceScore = 1.0;
        for (Double niceScore : getNiceScoreHistory()) {
            totalNiceScore *= niceScore;
        }
        double averageScore = Math.pow(totalNiceScore, 1.0 / getNiceScoreHistory().size());
        super.setAverageScore(averageScore);
    }
}
