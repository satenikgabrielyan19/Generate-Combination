import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateCombination {
    public void printAllGeneratedCombination(int n, int k) {
        int[] combination = new int[k];
        for (int i = 0; i < combination.length; i++) {
            combination[i] = i + 1;
        }
        while (true) {
            for (int value : combination) {
                System.out.print(value + " ");
            }
            System.out.println();

            int j = -1;
            for (int i = k - 1; i >= 0; i--) {
                if (combination[i] <= n - k + i) {
                    combination[i] += 1;
                    j = i;
                    break;
                }
            }
            if (j == -1) {
                break;
            }
            for (int i = j + 1; i < k; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }
    }

    public void generateCombinations(int n, int k) {
        List<Integer> combination = new ArrayList<>();
        backtrack(n, k, combination, 1);

    }

    private void backtrack(int n, int k,
                           List<Integer> combination, int start) {

        if (k == 0) {
            System.out.println(new ArrayList<>(combination));
            return;

        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            backtrack(n, k - 1, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateCombination g = new GenerateCombination();
        g.printAllGeneratedCombination(5, 3);
        System.out.println("------------------------------------");
        g.generateCombinations(5, 3);
    }
}
