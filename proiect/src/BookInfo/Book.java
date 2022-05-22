package BookInfo;

import java.util.*;


public class Book {
    private int isbn;
    private String bookTitle;
    private int pageNumber;
    private Language language;
    private Author author;
    private Date apparitionDate;
    private Domain domain;

    public Book(){

    }

    public Book(int isbn, String bookTitle, int pageNumber, Language language, Author author, Date apparitionDate, Domain domain){
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.pageNumber = pageNumber;
        this.language = language;
        this.author = author;
        this.apparitionDate = apparitionDate;
        this.domain = domain;
    }


    public int getIsbn() {
        return isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public Language getLanguage() {
        return language;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getApparitionDate() {
        return apparitionDate;
    }

    public Domain getDomain() {
        return domain;
    }

    @Override
    public String toString() {

         return "isbn=" + isbn + '\n' +
                "bookTitle=" + bookTitle + '\n' +
                "pageNumber=" + pageNumber + '\n' +
                 "language=" + language.getLanguageName() + '\n' +
                "author=" + author.getAuthorName() + '\n' +
                "apparitionDate=" + apparitionDate + '\n' +
                "domain=" + domain.getDomainName() + '\n';
    }

}
