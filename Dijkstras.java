/**
 * Created by Davorin on 4/14/2017.
 */
public class Dijkstras {
    private int [][] w;
    private int s;
    private int [] touch;
    private int [] length;
    private int vNear;

    public Dijkstras (int [][] weights, int source){
        w = weights;
        s = source;

        int [] touch = new int [weights.length];
        int [] length = new int [weights.length];

        for (int i = 0; i < weights.length; i++){
            touch[i] = source;
        }

        for (int i = 0; i < weights.length; i++){
            length[i] = weights[source][i];
        }

        print(touch, length);
        System.out.println();

        int iterations = weights.length - 1;
        while (iterations != 0) {
            vNear = findVnear(length);
            for (int i = 0; i < w.length; i++) {
                //if (length[vNear] + w[vNear][i] < length[i]) {
                if (length[vNear] + w[vNear][i] < length[i]) {
                    length[i] = length[vNear] + w[vNear][i];
                    touch[i] = vNear;
                }
                length[vNear] = 0;
            }

            print(touch, length);
            System.out.println();
            iterations--;
        }
    }

    public int findVnear(int [] l){
        int smallest;
        int toReturn;
        int i = 0;

        while (l[i] == 0){
            i++;
        }
        smallest = l[i];
        toReturn = i;

        for (i = toReturn; i < l.length; i++){
            if ((l[i] < smallest) && (l[i] != 0)){
                smallest = l[i];
                toReturn = i;
            }
        }
        return toReturn;
    }

    public void print(int [] t, int [] l){


        System.out.println();

        System.out.print("Touch:  ");
        for (int i = 0; i < t.length; i++){
            System.out.print(t[i] + "  ");
        }
        System.out.println();

        System.out.print("Length: ");
        for (int i = 0; i < l.length; i++){
            System.out.print(l[i] + "  ");
        }

    }

    public static void main(String [] args){
        int [][] a =  { {0, 70, 40, 60, 10},
                {999, 20, 999, 999, 999},
                {999, 20, 0, 50, 999},
                {999, 30, 999, 0, 999},
                {999, 999, 999, 10, 0}};

        Dijkstras dijkstras = new Dijkstras(a, 0);
    }
}
