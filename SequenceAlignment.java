/**
 * Created by Davorin on 3/14/2017.
 */
public class SequenceAlignment {
    int [][] mygraph;
    String x;
    String y;
    int gp;
    int mp;


    public Alignment (String xs, String ys, int gap, int mmp){
        x = xs;
        y = ys;
        gp = gap;
        mp = mmp;

        //Setup 2-D array, and set the bottom right corner to 0.
        int [][] graph = new int[x.length() + 1][y.length() + 1];
        graph [x.length()][y.length()] = 0;

        //Setup the bottom row, and then the right column.
        for (int i = y.length() - 1; i > -1; i--){
            graph [x.length()][i] = graph [x.length()][i + 1] + gp;
        }

        for (int i = x.length() - 1; i > -1; i--){
            graph [i][y.length()] = graph [i + 1][y.length()] + gp;
        }

        //fill in the rest of the table
        for (int i = x.length() - 1; i > -1; i--){
            for (int j = y.length() - 1; j > -1; j--){
                int diag = graph [i + 1][j + 1];
                    if (x.charAt(i) != y.charAt(j))
                        diag = diag + mp;
                int right = graph [i][j + 1] + gp;
                int bottom = graph [i + 1][j] + gp;
                if (diag <= right && diag <= bottom)
                    graph [i][j] = diag;
                else if (bottom <= right)
                    graph [i][j] = bottom;
                else
                    graph [i][j] = right;
            }
        }

        mygraph = graph;

    }

    public void print() {
        for (int i = 0; i < mygraph.length; i++) {
            for (int j = 0; j < mygraph[i].length; j++) {
                if (mygraph[i][j] >= -2)
                    System.out.print("   " + mygraph[i][j]);
            }
            System.out.println();
        }

    }
}
