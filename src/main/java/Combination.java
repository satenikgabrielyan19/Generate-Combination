import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combination {

    public List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        backtrack(combinations, n, k, lists, 1);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, int n, int k,
                           List<Integer> combination, int start) {

        if (k == 0) {
            combinations.add(new ArrayList<>(combination));
            return;

        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            backtrack(combinations, n, k - 1, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }



    public void generateCombinationIterative(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        ArrayList<Integer> combination = new ArrayList();

        for (int i = 1; i <= k; i++) {
            combination.add(i);
        }

        combinations.add(new ArrayList<>(combination));

        for (int j = 1; j <= k; j++) {
            for (int i = k + 1 - j + 1; i <= n - j + 1; i++) {
                for (int m = 0; m < j; m++) {
                    combination.remove(combination.size() - 1);
                }
                for (int m = 0; m < j; m++) {
                    combination.add(i + m);
                }
                combinations.add(new ArrayList<>(combination));
            }
        }

        System.out.println(combinations);
    }


    public static void main(String[] args) {
        Combination c = new Combination();
        System.out.println(c.generateCombinations(7, 4));
        c.generateCombinationIterative(5, 3);


    }
}
