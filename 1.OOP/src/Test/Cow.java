package Test;

import java.util.Random;

public class Cow implements SoundGenerator {


    public String eat(String[] food) {
        return "Test.Cow dung";
    }


    public String sound(String toSay) {
        return toSay;
    }


    @Override
    public String sound() {
        String[] cowSounds = new String[5];

        cowSounds[0] = "Mooo";
        cowSounds[1] = "moooooo";
        cowSounds[2] = "mOO";
        cowSounds[3] = "muuuuuuuuu";
        cowSounds[4] = "Mooouuu";

        int upToTimes = new Random().nextInt(8);

        String cowSays = "";

        for (int i = 0; i < upToTimes + 1; i++) {
            int index = new Random().nextInt(5);

            cowSays += cowSounds[index];
        }
        return cowSays;
    }
}
