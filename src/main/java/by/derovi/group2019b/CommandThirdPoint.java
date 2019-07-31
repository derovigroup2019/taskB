package by.derovi.group2019b;

public class CommandThirdPoint extends Command {
    CommandThirdPoint() {
        super("thirdPoint", "thirdPoint <output count> <level count (k value)> - third point solution command.", 2,"\n========= Third point solution =========");
    }

    CommandThirdPoint(String name, String description, int argsCount, String header) {
        super(name, description, argsCount, header);
    }

    int pow(int a, int b, int limit) {
        int ans = 1;
        for(int i = 1; i <= b; ++ i) {
            ans *= a;
            if(ans > limit)
                return ans;
        }
        return ans;
    }

    boolean check(int n, int levelCount) {
        for(int x = 8; x < n; ++ x) {
            int pw = pow(x, levelCount - 1, n);
            int rem = n % pw;
            for(int lvl = levelCount - 2; lvl >= 0; -- lvl) {
                int pw2 = pow(x, lvl, n);
                if(rem >= pw2 * (x / 2)) {
                    rem -= pw2 * (x / 2);
                }
            }
            if(rem == 0)
                return true;
        }
        return false;
    }

    @Override
    public void execute(String[] args) throws CommandArgumentsException {
        int outputCount = 0, levelCount = 0;
        try {
            outputCount = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            throw new CommandArgumentsException("First argument must be an integer.");
        }
        try {
            levelCount = Integer.parseInt(args[1]);
        } catch (Exception ex) {
            throw new CommandArgumentsException("Second argument must be an integer.");
        }
        boolean alreadyPrinted = false;
        System.out.println(getHeader());
        for(int current = 1; outputCount > 0; ++ current) {
            boolean good = check(current, levelCount);
            if(!good)
                continue;
            if(alreadyPrinted) {
                System.out.print(", ");
            } else alreadyPrinted = true;
            System.out.print(current);
            -- outputCount;
        }
        System.out.println('.');
    }
}
