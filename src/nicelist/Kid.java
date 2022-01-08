package nicelist;

import input.ChildInput;

import java.util.stream.Collectors;

public final class Kid extends Child {
    public Kid(final ChildInput child) {
        super(child);
    }

    @Override
    public void calculateAverageScore() {
        Double totalNiceScore = getNiceScoreHistory().stream()
                .collect(Collectors.summingDouble(Double::doubleValue));
        Double averageScore = totalNiceScore / getNiceScoreHistory().size();
        super.setAverageScore(averageScore);
    }
}
