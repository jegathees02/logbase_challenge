package reviews;

public class Review {
    private double starValue;
    private String comment;

    public Review(double starValue, String comment) {
        this.starValue = starValue;
        this.comment = comment;
    }
    public Review() {
        
    }
    public double getStarValue() {
        return starValue;
    }
    public void setStarValue(double starValue) {
        this.starValue = starValue;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
