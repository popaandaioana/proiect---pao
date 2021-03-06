package BookInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Author {
    private int authorId;
    private String authorName;
    private float authorRating;

    public Author(){
    }

    public Author(int authorId, String authorName, float authorRating) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorRating = authorRating;
    }

    //***************
    public Author(ResultSet in) throws SQLException {
        this.authorId = in.getInt("authorId");
        this.authorName = in.getString("authorName");
        this.authorRating = in.getFloat("authorRating");
    }

    public void read(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Author Id: ");
        this.authorId = Integer.parseInt(scanner.nextLine());
        System.out.println("Author Name: ");
        this.authorName = scanner.nextLine();
        System.out.println("Author Rating: ");
        this.authorRating = Float.parseFloat(scanner.nextLine());
    }
    //*************

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public float getAuthorRating() {
        return authorRating;
    }


    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorRating(float authorRating) {
        this.authorRating = authorRating;
    }

    @Override
    public String toString() {

        return "authorId=" + authorId + '\n' +
                "authorName=" + authorName + '\n' +
                "authorRating=" + authorRating + '\n';
    }

}