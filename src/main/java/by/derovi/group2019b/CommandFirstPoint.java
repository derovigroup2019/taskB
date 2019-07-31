package by.derovi.group2019b;

public class CommandFirstPoint extends Command {
    CommandFirstPoint() {
        super("firstPoint", "firstPoint <output count> <way 0/1> - first point solution command.", 2, "First argument must be an integer.");
    }

    private boolean check1(int n) {
        for(int x = 8; x < n; ++ x) {
            if(n % x == 0)
                return true;
        }
        return false;
    }

    private int minimalPrimeDivisor(int n) {
        for(int i = 2; i * i <= n; ++ i)
            if(n % i == 0)
                return i;
        return n;
    }

    private boolean check2(int n) {
        return (n / minimalPrimeDivisor(n) > 7);
    }

    @Override
    public void execute(String[] args) throws CommandArgumentsException {
        int outputCount = 0;
        try {
            outputCount = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            throw new CommandArgumentsException(getHeader());
        }
        boolean way = args[1].equals("0"), alreadyPrinted = false;
        System.out.println("\n========= First point " + Integer.toString(way ? 2 : 1) + "  solution =========");
        for(int current = 1; outputCount > 0; ++ current) {
            boolean good = way ? check2(current) : check1(current);
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