import animals.*;
import ui.NurseryConsoleView;
import ui.NurseryController;
import ui.NurseryModel;
import ui.NurseryView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Pet, Set<String>> pets = new HashMap<>();
        Map<Pack, Set<String>> packs = new HashMap<>();

        NurseryController controller = new NurseryController(new NurseryModel(packs, pets), new NurseryConsoleView(new Scanner(System.in)));

        controller.run();
        
    }
}