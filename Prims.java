/**
 * Created by Davorin on 4/14/2017.
 */
public class Prims {
    private int [] nearest;
    private int [] distance;
    private int vNear;


    public Prims (int[][] arr, int start){
        int [] nearest = new int [arr.length];
        int [] distance = new int [arr.length];

        for (int i = 0; i < arr.length; i++){
            nearest[i] = start;
        }

        for (int i = 0; i < arr.length; i++){
            distance[i] = arr[start][i];
        }

        print(nearest, distance);

        int iterations = arr.length - 1;
        while (iterations != 0) {
            vNear = findVnear(distance);
            for (int i = 0; i < arr.length; i++) {
                if (vNear == i){
                    distance[i] = 0;
                }
                else if ((arr[vNear][i] < distance[i])) {
                    nearest[i] = vNear;
                    distance[i] = arr[vNear][i];
                }

            }

            System.out.println();
            print(nearest, distance);
            iterations--;
        }
    }


    public int findVnear(int [] d){
        int smallest;
        int toReturn;
        int i = 0;

        while (d[i] == 0){
            i++;
        }
        smallest = d[i];
        toReturn = i;

        for (i = toReturn; i < d.length; i++){
            if ((d[i] < smallest) && (d[i] != 0)){
                smallest = d[i];
                toReturn = i;
            }
        }
    return toReturn;
    }

    public void print(int [] n, int [] d){

       /* for (int i = 0; i < n.length; i++){
            System.out.print(i + "  ");
        }
        */
        System.out.println();

        System.out.print("Nearest:  ");
        for (int i = 0; i < n.length; i++){
            System.out.print(n[i] + "  ");
        }
        System.out.println();

        System.out.print("Distance: ");
        for (int i = 0; i < d.length; i++){
            System.out.print(d[i] + "  ");
        }

    }

    public static void main(String [] args){
        int [][] a =  { {0, 10, 15, 999, 999, 12},
                        {10, 0, 20, 999, 13, 9},
                        {15, 20, 0, 18, 8, 999},
                        {999, 999, 18, 0, 999, 10},
                        {999, 13, 8, 999, 0, 8},
                        {12, 9, 999, 10, 8, 0}};

        Prims prims = new Prims(a, 0);

    }
}
