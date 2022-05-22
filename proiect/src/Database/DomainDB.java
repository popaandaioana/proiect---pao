package Database;

import BookInfo.Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class DomainDB {
    Connection connection;

    public DomainDB(Connection connection) {
        this.connection = connection;
    }

    public List<Domain> read(){
        List<Domain> domainList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM domains");
            while(result.next()) {
                Domain current = new Domain(result);
                domainList.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return domainList;
    }

    public void create(Domain domain){
        try{
            String query = "INSERT INTO domains (domainId, domainName, recommandedAge) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, domain.getDomainId());
            preparedStmt.setString(2, domain.getDomainName());
            preparedStmt.setInt(3, domain.getRecommandedAge());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(Domain domain){
        try{
            String query = "DELETE FROM domains WHERE domainId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, domain.getDomainId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}

