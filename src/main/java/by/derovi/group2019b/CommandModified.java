package by.derovi.group2019b;

public class CommandModified extends Command {
    public CommandModified() {
        super("modified", "modified - solve modified problem", 0, "\n========= Modified problem =========");
    }

    private int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }

    private boolean check(Pair a, Pair b) {
        return ((a.m - b.m) % gcd(a.x, b.x) == 0);
    }

    @Override
    public void execute(String[] args) {
        System.out.println(getHeader());
        System.out.println("Print count of Chefs friends:");
        int count = Dialog.instance.getScanner().nextInt();
        System.out.println("Print X and M for all clocks:");
        Pair[] clocks = new Pair[count];
        for(int idx = 0; idx < count; ++ idx) {
            clocks[idx] = new Pair(Dialog.instance.getScanner().nextInt(), Dialog.instance.getScanner().nextInt());
        }
        boolean answer = true;
        for(int idx0 = 0; idx0 < count; ++ idx0) {
            for(int idx1 = idx0 + 1; idx1 < count; ++ idx1) {
                if(!check(clocks[idx0], clocks[idx1]))
                    answer = false;
            }
        }
        if(answer) {
            System.out.println("The answer exist!");
        } else {
            System.out.println("The answer doesn't exist");
        }
        System.out.println();
    }

    private class Pair {
        private int x, m;

        Pair(int x, int m) {
            this.x = x;
            this.m = m;
        }
    }
}
