package nicelist;

import enums.Category;
import enums.Cities;
import input.ChildInput;
import input.Gifts;

import java.util.LinkedList;
import java.util.List;

public abstract class Child {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences = new LinkedList<>();
    private Double averageScore;
    private List<Double> niceScoreHistory = new LinkedList<>();
    private Double assignedBudget;
    private List<Gifts> receivedGifts = new LinkedList<>();

    public Child(final ChildInput child) {
        this.id = child.getId();
        this.age = child.getAge();
        this.firstName = child.getFirstName();
        this.lastName = child.getLastName();
        this.city = child.getCity();
        this.giftsPreferences.addAll(child.getGiftsPreferences());
        niceScoreHistory.add(child.getNiceScore());
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gifts> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Gifts> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public abstract void calculateAverageScore();
}
