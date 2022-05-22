package BookInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Language {
    private String languageCode;
    private String languageName;

    public Language(){}

    public Language(String languageCode, String languageName){
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    //***************
    public Language(ResultSet in) throws SQLException {
        this.languageCode = in.getString("languageCode");
        this.languageName = in.getString("languageName");
    }

    public void read(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Language Code: ");
        this.languageCode = scanner.nextLine();
        System.out.println("Language Name: ");
        this.languageName = scanner.nextLine();
    }
    //*************

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {

        return "languageCode=" + languageCode + '\n' +
                "languageName=" + languageName + '\n';
    }


}