import java.util.Scanner;

public class BarrenMoor {

    //protected int[][] infiniteGreySwamp = new int[20][20];
    protected boolean endgame = true;

    public boolean checkIfWin(Player p, Treasure t, Compass c){
        System.out.println("The dial reads "+c.calculateDistance(t,p)+"m");
        if(Math.abs(p.getyPostion()-t.getyPostion())+ Math.abs(p.getxPostion()-t.getxPostion()) ==0){
            p.win = true;
            this.endgame = true;
            System.out.println("You see a box sitting on the plain.   Its filled with treasure!  You win!");
            System.out.println("The End!");
        }

        return p.isWin();
    }

    public void startGame(Player p, Treasure t, Compass c){
//        for(int i=0; i< infiniteGreySwamp.length; i++){
//            int[] row = new int[20];
//            for(int j=0; j< row.length; j++){
//                row[j] = j;
//            }
//            infiniteGreySwamp[i] = row;
//        }

        this.endgame = false;
        System.out.println("You awaken to find yourself in a barren moor!");
        Scanner myScanner  = new Scanner(System.in);
        String command;
        while(!endgame){
            command = myScanner.next();
            switch (command.toLowerCase()){
                case "look":
                    p.look();
                    break;
                case "north":
                    p.goNorth();
                    checkIfWin(p,t,c);
                    break;
                case "south":
                    p.goSouth();
                    checkIfWin(p,t,c);
                    break;
                case "west":
                    p.goWest();
                    checkIfWin(p,t,c);
                    break;
                case "east":
                    p.goEast();
                    checkIfWin(p,t,c);
                    break;
                case "quit":
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
        Player p = new Player("saber", 12, 10);
        Compass c = new Compass();
        Treasure t = new Treasure(14, 19);
        myGame.startGame(p, t, c);
    }

}
