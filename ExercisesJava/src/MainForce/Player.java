package MainForce;

public class Player implements Comparable<Player> {

    private String name;
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
