package Readers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReaderB {
    protected int readerId;
    protected String readerName;
    protected String readerAddress;
    protected String readerEmail;
    protected String readerPhone;
    protected Date readerBirthDate;
    protected int numberBorrowedBooks;

    public ReaderB(){}

    public ReaderB(int readerId, String readerName, String readerAdress, String readerEmail, String readerPhone, Date readerBirthDate, int numberBorrowedBooks) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerAddress = readerAdress;
        this.readerEmail = readerEmail;
        this.readerPhone = readerPhone;
        this.readerBirthDate = readerBirthDate;
        this.numberBorrowedBooks = numberBorrowedBooks;
    }

    //***************
    public ReaderB(ResultSet in) throws SQLException {
        this.readerId = in.getInt("readerId");
        this.readerName = in.getString("readerName");
        this.readerAddress = in.getString("readerAddress");
        this.readerEmail = in.getString("readerEmail");
        this.readerPhone = in.getString("readerPhone");
        this.readerBirthDate = in.getDate("readerBirthDate");
        this.numberBorrowedBooks = in.getInt("numberBorrowedBooks");
    }

    public void read(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Reader Id: ");
        this.readerId = Integer.parseInt(scanner.nextLine());
        System.out.println("Reader Name: ");
        this.readerName = scanner.nextLine();
        System.out.println("Reader Address: ");
        this.readerAddress = scanner.nextLine();
        System.out.println("Reader Email: ");
        this.readerEmail = scanner.nextLine();
        System.out.println("Reader Phone: ");
        this.readerPhone = scanner.nextLine();
        System.out.println("Reader Birthday: ");
        String birth = scanner.nextLine();
        Date birth1 = null;
        try {
            birth1 = new SimpleDateFormat("dd.MM.yyyy").parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.readerBirthDate = birth1;
        System.out.println("Borrowed books: ");
        this.numberBorrowedBooks = Integer.parseInt(scanner.nextLine());


    }
    //*************

    public int getReaderId() {
        return readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public String getReaderAdress() {
        return readerAddress;
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public String getReaderPhone() {
        return readerPhone;
    }

    public Date getReaderBirthDate() {
        return readerBirthDate;
    }

    public int getNumberBorrowedBooks() {
        return numberBorrowedBooks;
    }

    public void setNumberBorrowedBooks(int numberBorrowedBooks) {
        this.numberBorrowedBooks = numberBorrowedBooks;
    }

    @Override
    public String toString() {
        return "readerId=" + readerId + '\n' +
                "readerName=" + readerName + '\n' +
                "readerAdress=" + readerAddress + '\n' +
                "readerEmail=" + readerEmail + '\n' +
                "readerPhone=" + readerPhone + '\n' +
                "readerBirthDate=" + readerBirthDate + '\n' +
                "numberBorrowedBooks=" + numberBorrowedBooks + '\n';
    }


}