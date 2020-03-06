package MainForce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Team  {
    String name;
    List<Player> players;
    public Team(String name){
        this.name = name;
    }
    public void setPlayerList(){
        this.players = new ArrayList<>();
    }
    public void addPlayer(Player p){
        this.players.add(p);
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Player> GetPlayerList(){
        return this.players;
    }
    public void removePlayer(Player p){
        this.players.remove(p);
    }
    public Integer playerListSize(){
        return this.players.size();

    }
    public String getTeamName(){
        return this.name;
    }


}
