package MainForce;

import java.util.*;
import java.util.regex.Matcher;

public class MainForce {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String ,Team> teams = new HashMap<>();
        String input;

        String text = "Dani+Debi";
        String text2 = text.replaceAll("\\+", " ");

        System.out.println(text2);

        while (!"Lumpawaroo".equals(input=sc.nextLine())){


            if (input.split("\\|").length>1){
                String [] inputArray = input.split("\\|");
                String teamName = inputArray[0].trim();
                String playerName = inputArray[1].trim();
                Player p = new Player(playerName);
                if (teams.containsKey(teamName)){
                    teams.get(teamName).addPlayer(p);
                }
                else{
                    CreateTeam(teamName, p, teams);
                }
            }
            else if (input.split("->").length>1){
                String [] inputArray = input.split("->");
                String playerName = inputArray[0].trim();
                String teamName = inputArray[1].trim();
                Player p = new Player(playerName);
                if (teams.containsKey(teamName)){

                    for (Map.Entry<String,Team>teamEntry : teams.entrySet()) {

                        if (!teamEntry.getKey().equals(teamName)) {
                            for (Player pl: teamEntry.getValue().GetPlayerList()) {
                                String curName = pl.GetName();
                                String curTeamName = teamEntry.getKey();
                                if (curName.equals(playerName)){
                                    teams.get(curTeamName).removePlayer(pl);
                                    break;
                                }
                            }
                        }
                    }
                    teams.get(teamName).addPlayer(p);
                    System.out.printf("%s joins the %s side%n", p.GetName(),teamName);
                }
                else {
                    CreateTeam(teamName, p, teams);
                }
            }

        }

        List<Team> sortedTeams = new ArrayList<Team>();



        for (Map.Entry<String,Team> team: teams.entrySet()) {
            sortedTeams.add(team.getValue());
        }
        sortedTeams.sort((o1, o2) -> {
            int value1 = o2.playerListSize().compareTo(o1.playerListSize());
            int value2 = o1.getTeamName().compareTo(o2.getTeamName());
            if (value1 == 0) {
                return value2;
            }
            return value1;
        });



        for (Team team: sortedTeams) {
            if (team.GetPlayerList().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", team.getTeamName(), team.GetPlayerList().size());
                List<Player> sortedPlayers = team.GetPlayerList();
                Collections.sort(sortedPlayers);
                for (Player p : sortedPlayers) {
                    System.out.printf("! %s%n", p.GetName());
                }
            }
        }
    }
    public static void CreateTeam(String teamName, Player p, Map<String,Team> teams){
        Team team = new Team(teamName);
        team.setPlayerList();
        team.addPlayer(p);
        team.setName(teamName);
        teams.put(teamName,team);
    }
}
