package other.easy;

/**
 * Problem: 551. Student Attendance Record I
 * Difficulty: Easy
 * Link: https://leetcode.com/problemsstudent-attendance-record-i
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countA++;
                if (countA >= 2)
                    return false;
            } else if (c == 'L')
                if (i - 1 >= 0 && s.charAt(i - 1) == 'L' && i - 2 >= 0 && s.charAt(i - 2) == 'L')
                    return false;
        }

        return true;
    }
}