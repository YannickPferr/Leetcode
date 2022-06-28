package other.easy;

/**
 * Problem: 997. Find the Town Judge
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsfind-the-town-judge
 */
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n];
        for (int[] t : trust) {
            people[t[1] - 1]++;
            people[t[0] - 1]--;
        }

        for (int i = 0; i < people.length; i++) {
            int person = people[i];
            if (person == n - 1)
                return i + 1;
        }

        return -1;
    }
}