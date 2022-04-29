package Library;

import AuditService.Audit;
import BookInfo.Author;
import BookInfo.Book;
import BookInfo.Domain;
import BookInfo.Language;
import Readers.ReaderB;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    private String libraryName;
    private TreeMap<String, List<Book>> libraryBooks;
    private List<ReaderB> readers;

    Administrator adm = new Administrator();


    public Library() {
    }

    public Library(String libraryName, TreeMap<String, List<Book>> libraryBooks, List<ReaderB> readers) {
        this.libraryName = libraryName;
        this.libraryBooks = libraryBooks;
        this.readers = readers;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public TreeMap<String, List<Book>> getLibraryBooks() {
        return libraryBooks;
    }

    public List<ReaderB> getReaders() {
        return readers;
    }


//add new reader

    public void addReader() {
        System.out.println("Adauga un cititor nou: ");
        Scanner input = new Scanner(System.in);
        System.out.print("Reader Id: ");
        String id = input.nextLine();
        int id1 = Integer.parseInt(id);
        System.out.print("Reader Name: ");
        String name = input.nextLine();
        System.out.print("Reader Address: ");
        String address = input.nextLine();
        System.out.print("Reader Email: ");
        String email = input.nextLine();
        System.out.print("Reader Phone: ");
        String phone = input.nextLine();
        System.out.print("Reader Birth date: ");
        String birth = input.nextLine();
        Date birth1 = null;
        try {
            birth1 = new SimpleDateFormat("dd.MM.yyyy").parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Number of borrowed books: ");
        String borbooks = input.nextLine();
        int borbooks1 = Integer.parseInt(borbooks);
        ReaderB newReader = new ReaderB(id1, name, address, email, phone, birth1, borbooks1);
        readers.add(newReader);
        //
        System.out.println(readers.get(readers.size() - 1).toString());
        //
        System.out.println("Reader added");
    }


    //add new book

    public void addBook() {
        System.out.println("Adauga o carte noua: ");
        Scanner input = new Scanner(System.in);
        System.out.print("Book Isbn: ");
        String isbn = input.nextLine();
        int isbn1 = Integer.parseInt(isbn);
        System.out.print("Book Title: ");
        String title = input.nextLine();
        System.out.print("Pages Number: ");
        String pages = input.nextLine();
        int pages1 = Integer.parseInt(pages);
        System.out.print("Language: ");
        String language = input.nextLine();
        Language language1 = adm.strTolang(language);
        System.out.print("Author: ");
        String author = input.nextLine();
        Author author1 = adm.strToAuth(author);
        System.out.print("Apparition Date: ");
        String appdate = input.nextLine();
        Date appdate1 = null;
        try {
            appdate1 = new SimpleDateFormat("dd.MM.yyyy").parse(appdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Domain: ");
        String domain = input.nextLine();
        Domain domain1 = adm.strTodom(domain);
        Book newBook = new Book(isbn1, title, pages1, language1, author1, appdate1, domain1);
        if (!libraryBooks.containsKey(newBook.getDomain().getDomainName()))
            libraryBooks.put(newBook.getDomain().getDomainName(), new ArrayList<Book>());
        libraryBooks.get(newBook.getDomain().getDomainName()).add(newBook);
        System.out.println("Book added");
    }


    //print library's readers

    public void printReaders() {
        System.out.println("Cititorii librariei sunt: ");
        for (int i = 0; i < readers.size(); i++)
            System.out.println(readers.get(i).toString());
    }


    //print library's books from 1 specific domain (SF in this case)

    public void printBooksFromDomain() {
        System.out.println("Cartile din domeniul SF sunt: ");
        for (int i = 0; i < libraryBooks.get("SF").size(); i++)
            System.out.println(libraryBooks.get("SF").get(i).toString());
    }


    //print library's book from 1 specific author

    public void printBooksFromAuthor(String a) {
        System.out.println("Cartile scrise de Mihai Eminescu: ");
        for(Map.Entry<String, List <Book>> entry : libraryBooks.entrySet()) {
            for(Book book : entry.getValue())
            {
                if(book.getAuthor().getAuthorName().equals(a))
                    System.out.println(book);
            }
        }

    }


    //delete reader

    public void deleteReader(String name){
        System.out.println("Sterge un cititor: ");
        for(int i = 0; i < readers.size(); i++)
        {
            if(readers.get(i).getReaderName().equals(name))
            {
                readers.remove(readers.get(i));
                System.out.println("Reader deleted");
            }
        }
    }

    //print books in one specific language

    public void printBooksInLanguage(String cod) {
        System.out.println("Cartile scrise in engleza: ");
        for(Map.Entry<String, List <Book>> entry : libraryBooks.entrySet()) {
            for(Book book : entry.getValue())
            {
                if(book.getLanguage().getLanguageCode().equals(cod))
                    System.out.println(book);
            }
        }

    }


    //print books from one specific year

    public void printBooksFromYear(String d) {
        System.out.println("Cartile aparute la data 02.04.1883: ");
        for(Map.Entry<String, List <Book>> entry : libraryBooks.entrySet()) {
            for(Book book : entry.getValue())
            {
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                if(df.format(book.getApparitionDate()).equals(d))
                    System.out.println(book);
            }
        }

    }



    public void printAuthors(){
        System.out.println("Autorii librariei sunt: ");
        HashSet<String> set = new HashSet<String>();
        for(Map.Entry<String, List <Book>> entry : libraryBooks.entrySet()) {
            for(Book book : entry.getValue())
            {
                set.add(book.getAuthor().getAuthorName());
            }
        }
        System.out.println(set);
    }


}


