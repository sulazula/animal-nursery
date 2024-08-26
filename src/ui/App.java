package ui;

import animals.Pack;
import animals.Pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    public void initialize() {
        Map<Pet, Set<String>> pets = new HashMap<>();
        Map<Pack, Set<String>> packs = new HashMap<>();
        NurseryController controller = new NurseryController(new NurseryModel(packs, pets), new NurseryConsoleView(new Scanner(System.in)));
        controller.run();
    }
}
