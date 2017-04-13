import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Matrix {
    // Let's say that a 2d matrix is a List of rows,
    // where each row contains a List of columns/integers
    List<List<Integer>> mat = null;

    // Some helper functions for the constructor
    private List<String> splitRows(String s) {
        return Arrays.asList(s.split("\\n"));
    }
    private List<String> splitColumns(String s) {
        return Arrays.asList(s.split("\\s"));
    }
    private List<Integer> makeIntList(List<String> ls) {
        return ls.stream()
                 .map(Integer::new)
                 .collect(Collectors.toList());
    }

    public Matrix(String s) {
        mat = splitRows(s).stream()
                          .map(s2 -> makeIntList(splitColumns(s2)))
                          .collect(Collectors.toList());
    }

    public int getRowsCount() {
        return mat.size();
    }

    public int getColumnsCount() {
        return mat.get(0).size();
    }

    public int[] getRow(int r) {
        return mat.get(r).stream()
                         .mapToInt(Integer::intValue)
                         .toArray();
    }

    public int[] getColumn(int c) {
        return mat.stream()
                  .mapToInt(r -> r.get(c).intValue())
                  .toArray();
    }
}

/*
// For reference: an imperative version.
public class MatrixWithArray {

    private int[][] mat = null;

    public Matrix(String s) {
        String[] rows = s.split("\\n");
        int nbrows = rows.length;

        mat = new int[nbrows][];
        for (int i = 0; i < nbrows; i++) {
            String[] columns = rows[i].split("\\s");
            int nbcols = columns.length;

            mat[i] = new int[nbcols];

            for (int j = 0; j < nbcols; j++) {
                mat[i][j] = new Integer(columns[j]);
            }
        }
    }

    public int getRowsCount() {
        return mat.length;
    }

    public int getColumnsCount() {
        return mat[0].length;
    }

    public int[] getRow(int r) {
        return mat[r];
    }

    public int[] getColumn(int c) {
        int[] col = new int[this.getRowsCount()];
        for (int i = 0; i < this.getRowsCount(); i++) {
            col[i] = mat[i][c];
        }
        return col;
    }

}
*/

