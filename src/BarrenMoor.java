import java.util.Scanner;

public class BarrenMoor {

    protected boolean endgame = true;

    public boolean checkIfWin(Player player, Treasure treasure, Compass compass){
        System.out.println("The dial reads "+compass.calculateDistance(treasure,player)+"m");
        if(Math.abs(player.getyPostion()-treasure.getyPostion())+ Math.abs(player.getxPostion()-treasure.getxPostion()) ==0){
            player.win = true;
            this.endgame = true;
            System.out.println("You see a box sitting on the plain.   Its filled with treasure!  You win!");
            System.out.println("The End!");
        }

        return player.isWin();
    }

    public void startGame(){
        Player player = new Player("saber", (int) (Math.random()*20), (int) (Math.random()*20));
        Compass compass = new Compass();
        Treasure treasure = new Treasure((int) (Math.random()*20), (int) (Math.random()*20));

        this.endgame = false;
        System.out.println("You awaken to find yourself in a barren moor!");
        Scanner myScanner  = new Scanner(System.in);
        String command;
        while(!endgame){
            command = myScanner.next();
            switch (command.toLowerCase()){
                case "look":
                    player.look();
                    break;
                case "north":
                    player.goNorth();
                    checkIfWin(player,treasure,compass);
                    break;
                case "south":
                    player.goSouth();
                    checkIfWin(player,treasure,compass);
                    break;
                case "west":
                    player.goWest();
                    checkIfWin(player,treasure,compass);
                    break;
                case "east":
                    player.goEast();
                    checkIfWin(player,treasure,compass);
                    break;
                case "quit":
                    endgame = true;
                    System.out.println("The game ended, treasure not found! hence no win!");
                    break;
                default:
                    System.out.println("The command couldn'treasure be recognised. Acceptable commands are: look, north, south, west, east, quit");
            }
        }

    }

    public static void main(String[] args){
        BarrenMoor myGame = new BarrenMoor();
        myGame.startGame();
    }

}
