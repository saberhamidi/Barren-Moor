public class Player {

    protected String name;
    protected int xPostion;
    protected int yPostion;
    protected boolean win = false;

    public Player(String name, int xPostion, int yPostion) {
        this.name = name;
        this.xPostion = xPostion;
        this.yPostion = yPostion;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxPostion() {
        return xPostion;
    }

    public void setxPostion(int xPostion) {
        this.xPostion = xPostion;
    }

    public int getyPostion() {
        return yPostion;
    }

    public void setyPostion(int yPostion) {
        this.yPostion = yPostion;
    }

    public int goNorth(){
        this.setyPostion(this.getyPostion()-1);
        System.out.println("Moved north by 1 steps!");
        return this.getyPostion();
    }

    public int goSouth(){
        this.setyPostion(this.getyPostion()+1);
        System.out.println("Moved south by 1 steps!");
        return this.getyPostion();
    }

    public int goEast(){
        this.setxPostion(this.getxPostion()+1); ;
        System.out.println("Moved east by 1 steps!");
        return getxPostion();

    }

    public int goWest(){
        this.setxPostion(this.getxPostion()-1); ;
        System.out.println("Moved west by 1 steps!");
        return getxPostion();

    }

    public void look(){
        System.out.println("Grey foggy clouds float oppressively close to you");
        System.out.println("reflected in the murky grey water which reaches up your shins.");
        System.out.println("Some black plants barely poke out of the shallow water.");
    }

}
