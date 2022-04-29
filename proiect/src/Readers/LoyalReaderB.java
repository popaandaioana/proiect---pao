package Readers;

import java.util.Date;

public class LoyalReaderB extends ReaderB {
    private int discount;

    public LoyalReaderB(){}

    public LoyalReaderB(int readerId, String readerName, String readerAdress, String readerEmail, String readerPhone, Date readerBirthDate, int numberBorrowedB, int discount){
        super(readerId, readerName, readerAdress, readerEmail, readerPhone, readerBirthDate, numberBorrowedB);
        this.discount = discount;
    }

    @Override
    public String toString()
    {
        return   super.toString() +
                "discount=" + discount + '\n';
    }

}

