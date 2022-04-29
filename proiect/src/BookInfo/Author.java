package BookInfo;

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
