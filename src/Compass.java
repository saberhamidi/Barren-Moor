public class Compass {

    public int calculateDistance(Treasure treasure, Player player){
        int distance = Math.abs(player.getyPostion()-treasure.getyPostion())+ Math.abs(player.getxPostion()-treasure.getxPostion());
        return distance;
    }
}
