package Library;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Administrator {
    public Administrator()
    {
    }


    public String libName() {
        String name = new String();
        File file = new File("inputName");
        try(Scanner scanner = new Scanner(file)){
            name = scanner.nextLine();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return name;
    }



    private static Book initBook(String infoBook) throws ParseException {
        int isbn;
        String bookTitle;
        int pageNumber;
        Language language;
        Author author;
        Date apparitionDate;
        Domain domain;

        String[] token = infoBook.split(",");

        isbn = Integer.parseInt(token[0]);
        bookTitle = token[1].substring(1);
        pageNumber = Integer.parseInt(token[2].substring(1));
        language = strTolang(token[3].substring(1));
        author = strToAuth(token[4].substring(1));
        apparitionDate = new SimpleDateFormat("dd.MM.yyyy").parse(token[5].substring(1));
        domain = strTodom(token[6].substring(1));

        Book b = new Book(isbn, bookTitle, pageNumber, language, author, apparitionDate, domain);
        return b;
    }



    public TreeMap<String, List<Book>> treeMapBooks() {
        TreeMap<String, List<Book>> treeMap = new TreeMap<>();
        File file = new File("Books.csv");
        try(Scanner scanner = new Scanner(file)){
             scanner.nextLine();
             while(scanner.hasNextLine()){
                 String currentLine = scanner.nextLine();
                 Book b = initBook(currentLine);
                 if(!treeMap.containsKey(b.getDomain().getDomainName()))
                     treeMap.put(b.getDomain().getDomainName(), new ArrayList<Book>());
                 treeMap.get(b.getDomain().getDomainName()).add(b);
             }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return treeMap;

    }

    public static Language strTolang(String tkn){
        Language language = new Language();
        File file = new File("Languages.csv");
        try(Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] token = currentLine.split(",");
                if(tkn.equals(token[0])) {
                    language.setLanguageCode(token[0]);
                    language.setLanguageName(token[1].substring(1));
                    return language;
                }
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return language;
    }




    public static Author strToAuth(String tkn){
        Author author = new Author();
        File file = new File("Authors.csv");
        try(Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] token = currentLine.split(",");
                if(tkn.equals(token[1].substring(1))) {
                    author.setAuthorId(Integer.parseInt(token[0]));
                    author.setAuthorName(token[1].substring(1));
                    author.setAuthorRating(Float.parseFloat(token[2].substring(1)));
                    return author;
                }
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return author;
    }


    public static Domain strTodom(String tkn){
        Domain domain = new Domain();
        File file = new File("Domains.csv");
        try(Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                String[] token = currentLine.split(",");
                if(tkn.equals(token[0])) {
                    domain.setDomainId(Integer.parseInt(token[0]));
                    domain.setDomainName(token[1].substring(1));
                    domain.setRecommandedAge(Integer.parseInt(token[2].substring(1)));
                    return domain;
                }
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return domain;
    }



    private static ReaderB initReader(String infoReader) throws ParseException {
        int readerId;
        String readerName;
        String readerAdress;
        String readerEmail;
        String readerPhone;
        Date readerBirthDate;
        int numberBorrowedBooks;

        String[] token = infoReader.split(",");

        readerId = Integer.parseInt(token[0]);
        readerName = token[1].substring(1);
        readerAdress = token[2].substring(1);
        readerEmail = token[3].substring(1);
        readerPhone = token[4].substring(1);
        readerBirthDate = new SimpleDateFormat("dd.MM.yyyy").parse(token[5].substring(1));
        numberBorrowedBooks = Integer.parseInt(token[6].substring(1));
        ReaderB r = new ReaderB(readerId, readerName, readerAdress, readerEmail, readerPhone, readerBirthDate, numberBorrowedBooks);
        return r;
    }


    public List<ReaderB> readers() {
        List <ReaderB> readersList = new ArrayList<>();
        File file = new File("Readers.csv");
        try(Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String curentLine = scanner.nextLine();
                ReaderB r = initReader(curentLine);
                readersList.add(r);
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return readersList;

    }
}
