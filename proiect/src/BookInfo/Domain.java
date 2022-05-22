package BookInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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

    //***************
    public Domain(ResultSet in) throws SQLException {
        this.domainId = in.getInt("domainId");
        this.domainName = in.getString("domainName");
        this.recommandedAge = in.getInt("recommandedAge");
    }

    public void read(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Domain Id: ");
        this.domainId = Integer.parseInt(scanner.nextLine());
        System.out.println("Domain Name: ");
        this.domainName = scanner.nextLine();
        System.out.println("Recommanded age: ");
        this.recommandedAge = Integer.parseInt(scanner.nextLine());
    }
    //*************

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

    @Override
    public String toString() {

        return "domainId=" + domainId + '\n' +
                "domainName=" + domainName + '\n' +
                "recommandedAge=" + recommandedAge + '\n';
    }

}