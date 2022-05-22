package Database;

import BookInfo.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class AuthorDB {
    Connection connection;

    public AuthorDB(Connection connection) {
        this.connection = connection;
    }

    public List<Author> read(){
        List<Author> authorList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM authors");
            while(result.next()) {
                Author current = new Author(result);
                authorList.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return authorList;
    }

    public void create(Author author){
        try{
            String query = "INSERT INTO authors (authorId, authorName, authorRating) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, author.getAuthorId());
            preparedStmt.setString(2, author.getAuthorName());
            preparedStmt.setFloat(3, author.getAuthorRating());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(Author author){
        try{
            String query = "DELETE FROM authors WHERE authorId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, author.getAuthorId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
