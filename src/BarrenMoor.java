import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BarrenMoor {

    protected int[][] infiniteGreySwamp = new int[20][20];
    protected Map<String, Integer> currentPostion = new HashMap<String, Integer>();
    protected Map<String, Integer> treasurePostion = new HashMap<String, Integer>();
    protected boolean win = false;
    protected boolean endgame = true;

    public void look(){
        System.out.println("Grey foggy clouds float oppressively close to you");
        System.out.println("reflected in the murky grey water which reaches up your shins.");
        System.out.println("Some black plants barely poke out of the shallow water.");
    }

    public int calculateDistance(){
        int distance = Math.abs(currentPostion.get("column")-treasurePostion.get("column"))+ Math.abs(currentPostion.get("row")-treasurePostion.get("row"));
        return distance;
    }

    public boolean checkIfWin(){
        if(Math.abs(currentPostion.get("column")-treasurePostion.get("column"))+ Math.abs(currentPostion.get("row")-treasurePostion.get("row"))==0){
            this.win = true;
            this.endgame = true;
            System.out.println("You see a box sitting on the plain.   Its filled with treasure!  You win!");
            System.out.println("The End!");
        }

        return win;
    }

    public int goNorth(){
        this.currentPostion.put("column", currentPostion.get("column")-1);
        System.out.println("Moved north by 5 steps!");
        System.out.println("The dial reads "+calculateDistance()+"m");
        checkIfWin();
        return currentPostion.get("column");
    }

    public int goSouth(){
        this.currentPostion.put("column", currentPostion.get("column")+1);
        System.out.println("Moved south by 5 steps!");
        System.out.println("The dial reads "+calculateDistance()+"m");
        checkIfWin();
        return currentPostion.get("column");
    }

    public int goEast(){
        this.currentPostion.put("row", currentPostion.get("row")+1);
        System.out.println("Moved east by 5 steps!");
        System.out.println("The dial reads "+calculateDistance()+"m");
        checkIfWin();
        return currentPostion.get("row");

    }

    public int goWest(){
        this.currentPostion.put("row", currentPostion.get("row")-1);
        System.out.println("Moved east by 5 steps!");
        System.out.println("The dial reads "+calculateDistance()+"m");
        checkIfWin();
        return currentPostion.get("row");

    }

    public void startGame(){
        for(int i=0; i< infiniteGreySwamp.length; i++){
            int[] row = new int[20];
            for(int j=0; j< row.length; j++){
                row[j] = j;
            }
            infiniteGreySwamp[i] = row;
        }

        currentPostion.put("row", (int) (Math.random()*20));
        currentPostion.put("column", (int) (Math.random()*20));
        treasurePostion.put("row", (int) (Math.random()*20));
        treasurePostion.put("column", (int) (Math.random()*20));

        this.endgame = false;
        System.out.println("You awaken to find yourself in a barren moor!");
        Scanner myScanner  = new Scanner(System.in);
        String command;
        while(!endgame){
            command = myScanner.next();
            switch (command.toLowerCase()){
                case "look":
                    look();
                    break;
                case "north":
                    goNorth();
                    break;
                case "south":
                    goSouth();
                    break;
                case "west":
                    goWest();
                    break;
                case "east":
                    goEast();
                    break;
                case "end":
                    endgame = true;
                    System.out.println("The game ended, treasure not found! hence no win!");
                    break;
                default:
                    System.out.println("The command couldn't be recognised. Acceptable commands are: look, north, south, west, east, quit");
            }
        }

    }

    public static void main(String[] args){

        BarrenMoor myGame = new BarrenMoor();
        myGame.startGame();
    }

}
