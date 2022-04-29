package BookInfo;

public class Language {
    private String languageCode;
    private String languageName;

    public Language(){}

    public Language(String languageCode, String languageName){
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

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
