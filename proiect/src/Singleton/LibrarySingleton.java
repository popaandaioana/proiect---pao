package Singleton;


import Library.*;

public class LibrarySingleton {
    private static LibrarySingleton single_instance = null;

    public Library library;

    private LibrarySingleton(){
        Administrator admin = new Administrator();
        library = new Library(admin.libName(), admin.treeMapBooks(), admin.readers());
    }

    public static LibrarySingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new LibrarySingleton();
        return single_instance;
    }

}
