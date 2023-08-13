import java.util.*;

public class FixtureGenrator {

    Random random = new Random();

    public FixtureGenrator() {
    }


    public void generateFixture(ArrayList<String> teamList) {
        List<String> firstMatches = new ArrayList<>();
        List<String> secondMatches = new ArrayList<>();
        if (teamList.size() % 2 == 1) {
            teamList.add("Bay");
        }
        int matchCount = (teamList.size() * teamList.size() - 1) / 2;
        int matchesPerRound = teamList.size() / 2;
        int count = 0;
        ArrayList<String> teamListClone = new ArrayList<>(teamList);
        while (matchCount > 0) {
            String teamHome = teamListClone.get(random.nextInt(teamListClone.size()));
            String awayHome = teamListClone.get(random.nextInt(teamListClone.size()));

            if (!teamHome.equalsIgnoreCase(awayHome) && !firstMatches.contains(teamHome + " vs " + awayHome)) {
                firstMatches.add(teamHome + " vs " + awayHome);
                secondMatches.add(awayHome + " vs " + teamHome);
                teamListClone.remove(teamHome);
                teamListClone.remove(awayHome);
                matchCount--;
                count++;
                if(count % matchesPerRound == 0) {
                    teamListClone = new ArrayList<>(teamList);
                }
            }
        }
        firstMatches.addAll(secondMatches);
        printFixture(firstMatches,matchesPerRound);
    }

    private void printFixture(List<String> matches, int matchesPerRound) {
        int round = 1;
        for(int i = 0; i < matches.size(); i++) {
            if(i % matchesPerRound == 0) {
                System.out.println("-------------------------");
                System.out.println("Round " + round);
                round++;
            }
            System.out.println(matches.get(i));
        }
    }

}
