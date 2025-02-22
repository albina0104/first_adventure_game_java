package adventure_game;

import java.util.ArrayList;
import java.util.List;

public class PathChooser {
    private static final List<ActionChoice> choices = new ArrayList<>();
    private static final List<Room> rooms = new ArrayList<>();

    static {
        choices.add(new ActionChoice(
                "check what you can do here",
                player -> {
                    System.out.println("You have plenty things to do here!");
                    player.getLocation().printChoices();
                    ActionChoice choice = (ActionChoice) player.getLocation().chooseAction();
                    choice.doAction(player);
                }
        ));
        choices.add(new ActionChoice(
                "go to another room",
                player -> {
                    System.out.println("---Which room would you like to go to?---");
                    printRooms();
                    player.setLocation(chooseRoom());
                }
        ));

        rooms.add(new Bedroom());
        rooms.add(new Kitchen());
    }

    public static List<ActionChoice> getChoices() {
        return choices;
    }

    public static void printChoices() {
        ChoiceHelper.printChoices(choices);
    }

    public static ActionChoice chooseAction() {
        return (ActionChoice) ChoiceHelper.makeChoice(choices);
    }


    private static void printRooms() {
        ChoiceHelper.printChoices(rooms);
    }
    private static Room chooseRoom() {
        return (Room) ChoiceHelper.makeChoice(rooms);
    }
}
