public class Compass {

    public int calculateDistance(Treasure t, Player p){
        int distance = Math.abs(p.getyPostion()-t.getyPostion())+ Math.abs(p.getxPostion()-t.getxPostion());
        return distance;
    }
}
