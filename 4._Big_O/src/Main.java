import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> n = new ArrayList<>(){{

            add(7);
            add(5);
            add(2);
            add(12);
            add(4);
            add(8);
        }};

        /* Ex_1 */
        int y = 200 * 600;                  // O(1)
        int x = 800 *(700 / 200);           // O(1)
        System.out.println(x + y);          // O(1) + O(1) = O(1)

        /* Ex_2 */
        double r = 800 * Math.PI;           // O(1)

        n.forEach((number) -> {             //O(n)
            System.out.println(number);
        });
        //Total: O(n)


        /* Ex_3 */
        for (int i = 0; i < n.size(); i++){ // O(n)
            System.out.println(i);
            System.out.println(n.get(i));
        }
        //todo countdown in the list
        for (int i = n.size() -1; i > n.size(); i--); // O(n)
            System.out.println();
        // total: O(n) + O(n) = O(n)


        /* Ex_4 */
        for (int i = 0; i < n.size(); i++){ // O(n)
            for (int j = 0; j < n.size(); j++){ // O(n^2)
                System.out.println("How long");
            }
        }
        // total: O(n^2)


    }
}