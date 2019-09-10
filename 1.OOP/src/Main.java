import java.util.Random;

public class Main {

    //Overiding
    //public static void main(String[]    args) {
    //      Cars cars = new Cars();


    //}


    //Overloading
    //public static void main(String[] args) {
    //    Sum s = new Sum();
    //    System.out.println(s.sum(5,5));
    //    System.out.println(s.sum(3,7,5));
    //}

    public static void main(String[] args) {
        //Cow funnySoundingCow = new Cow();
        //System.out.println(funnySoundingCow);



        // todo static binding, static polymorphism
        // todo happens at: compile time
        Cow firstCow = new Cow();

        System.out.println(firstCow.sound());
        System.out.println(firstCow.sound("Mooooooooooo Moooooo"));


        // todo dynamic binding, dynamic polymorphism
        // todo happens at: runtime
        String[] food = {"grass" , "hay" , "chicken" };
        System.out.println(firstCow.eat(food));

        Animal animal = new Animal();
        System.out.println(animal.eat(food));

        // todo superclass: Is-A-Relation
        // todo interface: Has-A-Relation


        //todo object polymorphism
        Animal cowAnimal = firstCow;
        Cow cowCow = firstCow;
        SoundGenerator cowSound = firstCow;

        cowAnimal.eat(food);
        cowCow.eat(food);
        cowSound.sound();
        //casting
        ((Cow) cowSound).eat(food);

        // todo no go, cant instantiate abstract classes
        //Kingdom kingdom = new Kingdom() {
        Kingdom kingdom = new Kingdom(){
            @Override
            public void being(){
                System.out.println("for all exsting beings");

            }
        };

    }
}

