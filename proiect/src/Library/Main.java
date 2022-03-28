package Library;

import java.io.*;
import java.text.ParseException;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws ParseException {
        Administrator admin = new Administrator();

        Library library = new Library(admin.libName(), admin.treeMapBooks(), admin.readers());

        System.out.println("Numele librariei este: " + library.getLibraryName() + '\n');
        System.out.println("--------------------------");

        System.out.println("Adauga un cititor nou: ");
        library.addReader();
        System.out.println("...........................");
        System.out.println(library.getReaders().get(library.getReaders().size() - 1).toString());
        System.out.println("---------------------------");

        System.out.println("Adauga o carte noua: ");
        library.addBook();
        System.out.println("--------------------------------");

        System.out.println("Cititorii librariei sunt: ");
        library.printReaders();
        System.out.println("------------------------------------");

        System.out.println("Cartile din domeniul SF sunt: ");
        library.printBooksFromDomain();
        System.out.println("------------------------------------");

        System.out.println("Sterge un cititor: ");
        library.deleteReader("Popa Anda");
        System.out.println("------------------------------------");

        System.out.println("Cartile scrise de Mihai Eminescu: ");
        library.printBooksFromAuthor("Mihai Eminescu");
        System.out.println("--------------------------------------");

        System.out.println("Cartile scrise in engleza: ");
        library.printBooksInLanguage("en");
        System.out.println("-------------------------------------");

        System.out.println("Cartile aparute la data 02.04.1883: ");
        library.printBooksFromYear("02.04.1883");
        System.out.println("--------------------------------------");

        System.out.println("Autorii librariei sunt: ");
        library.printAuthors();
        System.out.println("---------------------------------------");

    }
}

