package Library;

import AuditService.Audit;
import Singleton.LibrarySingleton;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LibrarySingleton libSing = LibrarySingleton.getInstance();

        Audit audit = new Audit();

        System.out.println("Choose an action: 0 = end, 1 = add reader, 2 = add book, 3 = print readers, 4 = print SF books, 5 = del reader, 6 = print Mihai Eminescu's books, 7 = print english books," + '\n' + "8 = print 02.04.1883 books, 9 = print authors, 10 = print lib's name");
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
        }

    }
}

