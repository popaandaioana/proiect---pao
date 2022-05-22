package Database;

import Readers.ReaderB;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class ReaderDB {
    Connection connection;

    public ReaderDB(Connection connection) {
        this.connection = connection;
    }

    public List<ReaderB> read(){
        List<ReaderB> readerList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM readers");
            while(result.next()) {
                ReaderB current = new ReaderB(result);
                readerList.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return readerList;
    }

    public void create(ReaderB reader){
        try{
            String query = "INSERT INTO readers (readerId, readerName, readerAdress, readerEmail, readerPhone, readerBirthDate, numberBorrowedBooks) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, reader.getReaderId());
            preparedStmt.setString(2, reader.getReaderName());
            preparedStmt.setString(3, reader.getReaderAdress());
            preparedStmt.setString(4, reader.getReaderEmail());
            preparedStmt.setString(5, reader.getReaderPhone());
            preparedStmt.setDate(6, (Date) reader.getReaderBirthDate());
            preparedStmt.setInt(7, reader.getNumberBorrowedBooks());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void delete(ReaderB reader){
        try{
            String query = "DELETE FROM readers WHERE readerId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, reader.getReaderId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}



