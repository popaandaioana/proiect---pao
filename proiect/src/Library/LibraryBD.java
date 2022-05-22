package Library;


import BookInfo.Author;
import BookInfo.Domain;
import BookInfo.Language;
import Database.AuthorDB;
import Database.DomainDB;
import Database.LanguageDB;
import Database.ReaderDB;
import Readers.ReaderB;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class LibraryBD {
    List<Author> authorList = new ArrayList<>();
    List<Domain> domainList = new ArrayList<>();
    List<Language> languageList = new ArrayList<>();
    List<ReaderB> readerList = new ArrayList<>();

    private AuthorDB AuthorDataB;
    private DomainDB DomainDataB;
    private LanguageDB LanguageDataB;
    private ReaderDB ReaderDataB;

    public LibraryBD(AuthorDB _AuthorDataB, DomainDB _DomainDataB, LanguageDB _LanguageDataB, ReaderDB _ReaderDataB) {
        AuthorDataB = _AuthorDataB;
        DomainDataB = _DomainDataB;
        LanguageDataB = _LanguageDataB;
        ReaderDataB = _ReaderDataB;
    }

    public LibraryBD() {
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Domain> getDomainList() {
        return domainList;
    }

    public void setDomainList(List<Domain> domainList) {
        this.domainList = domainList;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<ReaderB> getReaderList() {
        return readerList;
    }

    public void setReaderList(List<ReaderB> readerList) {
        this.readerList = readerList;
    }

    public void add_author(Scanner in) throws ParseException {
        Author a = new Author();
        a.read(in);
        authorList.add(a);
        AuthorDataB.create(a);
    }

    public void add_domain(Scanner in) throws ParseException {
        Domain d = new Domain();
        d.read(in);
        domainList.add(d);
        DomainDataB.create(d);
    }

    public void add_language(Scanner in) throws ParseException {
        Language l = new Language();
        l.read(in);
        languageList.add(l);
        LanguageDataB.create(l);
    }

    public void add_reader(Scanner in) throws ParseException {
        ReaderB r = new ReaderB();
        r.read(in);
        readerList.add(r);
        ReaderDataB.create(r);
    }

    public void print_authors() {
        for (int i = 0; i < authorList.size(); i++) {
            System.out.println(authorList.get(i));
            System.out.println("\n\n");
        }
    }

    public void print_domains() {
        for (int i = 0; i < domainList.size(); i++) {
            System.out.println(domainList.get(i));
            System.out.println("\n\n");
        }
    }

    public void print_languages() {
        for (int i = 0; i < languageList.size(); i++) {
            System.out.println(languageList.get(i));
            System.out.println("\n\n");
        }
    }

    public void print_readers() {
        for (int i = 0; i < readerList.size(); i++) {
            System.out.println(readerList.get(i));
            System.out.println("\n\n");
        }
    }


}