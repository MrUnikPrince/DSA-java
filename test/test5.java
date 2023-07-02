import java.util.Scanner;

public class mat{
    int [][] matrix;

    mat(int [][] mat)
    {
        matrix=mat;
    }

    public static mat add(mat a, mat b)
    {
        int n = a.matrix.length;
        int m = a.matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return new mat(result);
    }

    public static mat multiply(mat a, mat b)
    {
        int n = a.matrix.length;
        int m = b.matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < a.matrix[0].length; k++) {
                    sum += a.matrix[i][k] * b.matrix[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new mat(result);
    }

    public static mat transpose(mat m)
    {
        int n = m.matrix.length;
        int m_ = m.matrix[0].length;
        int[][] result = new int[m_][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m_; j++) {
                result[j][i] = m.matrix[i][j];
            }
        }
        return new mat(result);
    }

    public static mat rotate(mat m)
    {
        int n = m.matrix.length;
        int m_ = m.matrix[0].length;
        int[][] result = new int[m_][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m_; j++) {
                result[m_ - j - 1][i] = m.matrix[i][j];
            }
        }
        return new mat(result);
    }

    public void print()
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int operation = sc.nextInt();
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] mat1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
    }
}
