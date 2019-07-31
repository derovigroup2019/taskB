package by.derovi.group2019b;

public class CommandFifthPoint1 extends CommandSecondPoint {
    CommandFifthPoint1() {
        super("fifthPoint1", "fifthPoint1 <output count> <level count (k value)> - second point solution for two clocks command.", 2, "\n========= Second point solution for two clocks =========");
    }

    @Override
    boolean check(int n, int levelCount) {
        int cnt = 0;
        for(int x = 8; x < n; ++ x) {
            int pw = pow(x, levelCount - 1, n);
            if(pw == 0)
                return false;
            if(n % pw == 0) {
                ++ cnt;
                if(cnt == 2)
                    return true;
            }
        }
        return false;
    }
}
