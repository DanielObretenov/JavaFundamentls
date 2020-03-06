package MainForce;

public class Player implements Comparable<Player> {

    String name;
    public Player(String name)
    {
        this.name=name;
    }

    public String GetName(){
        return this.name;
    }

    @Override
    public int compareTo(Player p) {
       return GetName().compareTo(p.GetName());
    }
}
