package nicelist;

import input.ChildInput;

public class AgeRangeFactory {
    public enum AgeRange {
            Baby, Kid, Teen, YoungAdult
        }
        public static Child chooseRange(AgeRange childAgeRange, ChildInput child) {
            switch (childAgeRange) {
                case Baby: return new Baby(child);
                case Kid: return new Kid(child);
                case Teen: return new Teen(child);
                case YoungAdult: return new YoungAdult(child);
            }
            throw new IllegalArgumentException("Specified age range category " + childAgeRange + " is not recognized.");
        }
}
