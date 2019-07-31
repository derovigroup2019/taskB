package by.derovi.group2019b;

import java.util.*;

public class Dialog {
    private Scanner scanner;
    private Map<String, Command> commands;
    public static Dialog instance = null;

    public static void main(String[] args) {
        instance = new Dialog();
        instance.start();
    }

    public Dialog() {
        commands = new HashMap<>();
        scanner = new Scanner(System.in);
        registerCommands();
    }

    public void start() {
        System.out.println("Print \"help\" to see all available commands!");
        while(true) {
            String[] commandArgs = scanner.nextLine().split(" ");
            if(commands.containsKey(commandArgs[0].toLowerCase())) {
                Command command = commands.get(commandArgs[0].toLowerCase());
                if(command.getArgsCount() + 1 != commandArgs.length) {
                    System.out.println("Invalid number of arguments!\nExample: " + command.getDescription());
                    continue;
                }
                try {
                    String[] args = new String[command.getArgsCount()];
                    for(int idx = 0; idx < args.length; ++ idx)
                        args[idx] = commandArgs[idx + 1];
                    command.execute(args);
                } catch (CommandArgumentsException ex) {
                    System.out.println(ex.getMessage());
                }
            } else
                System.out.println("Command not found, print \"help\" to see all available commands!");
        }
    }

    private void registerCommands() {
        commands.put("help", new CommandHelp());
        commands.put("firstpoint", new CommandFirstPoint());
        commands.put("secondpoint", new CommandSecondPoint());
        commands.put("thirdpoint", new CommandThirdPoint());
        commands.put("fifthpoint1", new CommandFifthPoint1());
        commands.put("fifthpoint2", new CommandFifthPoint2());
        commands.put("modified", new CommandModified());
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
