import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> teamList = new ArrayList<>();

        teamList.add("Galatasaray");
        teamList.add("Besiktas");
        teamList.add("Fenerbahce");
        teamList.add("Basaksehir");
        teamList.add("Trabzonspor");

        FixtureGenrator fixtureGenrator = new FixtureGenrator();

        fixtureGenrator.generateFixture(teamList);
    }
}
