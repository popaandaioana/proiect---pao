package Readers;

import java.util.*;

public class ReaderB {
    protected int readerId;
    protected String readerName;
    protected String readerAdress;
    protected String readerEmail;
    protected String readerPhone;
    protected Date readerBirthDate;
    protected int numberBorrowedBooks;

    public ReaderB(){}

    public ReaderB(int readerId, String readerName, String readerAdress, String readerEmail, String readerPhone, Date readerBirthDate, int numberBorrowedBooks) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerAdress = readerAdress;
        this.readerEmail = readerEmail;
        this.readerPhone = readerPhone;
        this.readerBirthDate = readerBirthDate;
        this.numberBorrowedBooks = numberBorrowedBooks;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public String getReaderAdress() {
        return readerAdress;
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
                "readerAdress=" + readerAdress + '\n' +
                "readerEmail=" + readerEmail + '\n' +
                "readerPhone=" + readerPhone + '\n' +
                "readerBirthDate=" + readerBirthDate + '\n' +
                "numberBorrowedBooks=" + numberBorrowedBooks + '\n';
    }


}
