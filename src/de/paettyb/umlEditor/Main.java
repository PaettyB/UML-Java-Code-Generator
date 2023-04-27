package de.paettyb.umlEditor;

import de.keygalp.engine.Engine;

import java.awt.*;
import de.paettyb.umlEditor.ui.Button;

public class Main extends Engine {
    public Main(String name, int width, int height) {
        super(name, width, height);
        Button b = new Button("Test", 50,50, () -> System.out.println("Test"));
        b.handleEvent(55,55);
    }

    public static void main(String[] args) {
        Main main = new Main("UML Editor", 1280, 720);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}