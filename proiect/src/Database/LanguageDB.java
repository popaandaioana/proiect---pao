package Database;

import BookInfo.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class LanguageDB {
    Connection connection;

    public LanguageDB(Connection connection) {
        this.connection = connection;
    }

    public List<Language> read(){
        List<Language> languageList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM languages");
            while(result.next()) {
                Language current = new Language(result);
                languageList.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return languageList;
    }

    public void create(Language language){
        try{
            String query = "INSERT INTO languages (languageCode, languageName) VALUES (?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, language.getLanguageCode());
            preparedStmt.setString(2, language.getLanguageName());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(Language language){
        try{
            String query = "DELETE FROM languages WHERE languageCode = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, language.getLanguageCode());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}


