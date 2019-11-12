import java.io.Serializable;

public class Chair implements Serializable {

    private static final long serialVersionUID = 1L;

    double size;
    boolean occupied;


    public Chair(double size, boolean occupied){
        this.size = size;
        this.occupied = occupied;
    }

    public void sit(){
        System.out.println("I'm beeing sat on...");
    }

}
