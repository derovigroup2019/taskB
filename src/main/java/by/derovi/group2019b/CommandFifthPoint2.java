package by.derovi.group2019b;

public class CommandFifthPoint2 extends CommandThirdPoint {
    CommandFifthPoint2() {
        super("fifthPoint2", "fifthPoint2 <output count> <level count (k value)> - third point solution for two clocks command.", 2,"\n========= Third point solution for two clocks =========");
    }

    @Override
    boolean check(int n, int levelCount) {
        int cnt = 0;
        for(int x = 8; x < n; ++ x) {
            int pw = pow(x, levelCount - 1, n);
            int rem = n % pw;
            for(int lvl = levelCount - 2; lvl >= 0; -- lvl) {
                int pw2 = pow(x, lvl, n);
                if(rem >= pw2 * (x / 2)) {
                    rem -= pw2 * (x / 2);
                }
            }
            if(rem == 0) {
                ++ cnt;
                if(cnt == 2)
                    return true;
            }
        }
        return false;
    }
}
