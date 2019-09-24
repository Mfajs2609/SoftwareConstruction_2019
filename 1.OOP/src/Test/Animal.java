package Test;

public class Animal extends Kingdom  {

    public String eat(String[] food) {
        return "feces";
    }

    @Override
    public void being() {
        System.out.println("I am Alive!");
    }
}
