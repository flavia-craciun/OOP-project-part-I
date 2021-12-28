import enums.Category;
import enums.Cities;

import java.util.List;

public abstract class Child {
    private int id; // make final
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> giftsPreferences;

    public Child() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public abstract Double getAverageScore();

    public final class Baby extends Child {
        @Override
        public Double getAverageScore() {
            return 10D;
        }
    }

    public final class Kid extends Child {
        @Override
        public Double getAverageScore() {
            return niceScore; // pt runda initiala (altfel, media aritmetica)
        }
    }

    public final class Teen extends Child {
        @Override
        public Double getAverageScore() {
            return niceScore; // pt runda initiala (altfel, media ponderata)
        }
    }

    public final class YoungAdult extends Child {
        @Override
        public Double getAverageScore() {
            return null; //
        }
    }
}
