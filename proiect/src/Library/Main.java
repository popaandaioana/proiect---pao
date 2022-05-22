package Library;


import Database.AuthorDB;
import Database.DomainDB;
import Database.LanguageDB;
import Database.ReaderDB;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class Main {

    //*************** deadline3 ******************8
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/proiect";
            String user = "root";
            String password = "";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public static void printAllOptions() {
        System.out.println("1 - Add author");
        System.out.println("2 - Add domain");
        System.out.println("3 - Add language");
        System.out.println("4 - Add reader");
        System.out.println("5 - Print authors");
        System.out.println("6 - Print domains");
        System.out.println("7 - Print languages");
        System.out.println("8 - Print readers");
        System.out.println("0 - END");
    }
    //*********************

    public static void main(String[] args) throws IOException {

        //LibrarySingleton libSing = LibrarySingleton.getInstance();

        //***************** for deadline 3 *******************
        boolean end = false;
        Connection connection = Main.getConnection();
        AuthorDB A = new AuthorDB(connection);
        DomainDB D = new DomainDB(connection);
        LanguageDB L = new LanguageDB(connection);
        ReaderDB R = new ReaderDB(connection);
        LibraryBD libraryBD = new LibraryBD(A, D, L, R);
        String[] corespondence = {"END", "add_author", "add_domain", "add_language", "add_reader"};
        Scanner in = new Scanner(System.in);
        while (!end) {
            System.out.println("Insert command: ");
            int command = -1;
            try {
                libraryBD.setAuthorList(A.read());
                libraryBD.setDomainList(D.read());
                libraryBD.setLanguageList(L.read());
                libraryBD.setReaderList(R.read());
                printAllOptions();
                command = in.nextInt();
                switch (command) {
                    case 1 -> libraryBD.add_author(in);
                    case 2 -> libraryBD.add_domain(in);
                    case 3 -> libraryBD.add_language(in);
                    case 4 -> libraryBD.add_reader(in);
                    case 5 -> libraryBD.print_authors();
                    case 6 -> libraryBD.print_domains();
                    case 7 -> libraryBD.print_languages();
                    case 8 -> libraryBD.print_readers();
                    case 0 -> end = true;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

             //D.delete(libraryBD.getDomainList().get(0));
            //*******************************

            //Audit audit = new Audit();

        /*System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
        Scanner keyboard = new Scanner(System.in);
        int opt = keyboard.nextInt();
        while(opt != 0)
            switch (opt){
                case 1:
                    audit.logAction("Add reader");
                    libSing.library.addReader();
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 2:
                    audit.logAction("Add book");
                    libSing.library.addBook();
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 3:
                    audit.logAction("Print readers");
                    libSing.library.printReaders();
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 4:
                    audit.logAction("Print SF books");
                    libSing.library.printBooksFromDomain();
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 5:
                    audit.logAction("Del reader");
                    libSing.library.deleteReader("Popa Anda");
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 6:
                    audit.logAction("Mihai Eminescu's books");
                    libSing.library.printBooksFromAuthor("Mihai Eminescu");
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 7:
                    audit.logAction("English books");
                    libSing.library.printBooksInLanguage("en");
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 8:
                    audit.logAction("02.04.1883 books");
                    libSing.library.printBooksFromYear("02.04.1883");
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 9:
                    audit.logAction("Print authors");
                    libSing.library.printAuthors();
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
                case 10:
                    audit.logAction("Print library's name");
                    System.out.println("Numele librariei este: " + libSing.library.getLibraryName() + '\n');
                    System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
                    keyboard = new Scanner(System.in);
                    opt = keyboard.nextInt();
                    break;
            }*/

        }
    }
}