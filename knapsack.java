
public class Knapsack {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt(); // number of items
    int W = scanner.nextInt(); // capacity of knapsack

    int[] weights = new int[n];
    int[] values = new int[n];

    for (int i = 0; i < n; i++) {
      weights[i] = scanner.nextInt(); // weight of item i
      values[i] = scanner.nextInt(); // value of item i
    }

    // Create a table to store the results of subproblems
    int[][] K = new int[n + 1][W + 1];

    // Initialize the table
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
        if (i == 0 || j == 0) {
          K[i][j] = 0;
        } else if (weights[i - 1] <= j) {
          K[i][j] = Math.max(values[i - 1] + K[i - 1][j - weights[i - 1]], K[i - 1][j]);
        } else {
          K[i][j] = K[i - 1][j];
        }
      }
    }

    // Print the maximum value that can be stored in the knapsack
    System.out.println(K[n][W]);
  }
}
