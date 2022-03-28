package Library;

public class Domain {
    private int domainId;
    private String domainName;
    private int recommandedAge;

    public Domain(){}

    public Domain(int domainId, String domainName, int recommandedAge){
        this.domainId = domainId;
        this.domainName = domainName;
        this.recommandedAge = recommandedAge;
    }

    public int getDomainId() {
        return domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public int getRecommandedAge() {
        return recommandedAge;
    }

    public void setDomainId(int domainId){
        this.domainId = domainId;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public void setRecommandedAge(int recommandedAge) {
        this.recommandedAge = recommandedAge;
    }

}
