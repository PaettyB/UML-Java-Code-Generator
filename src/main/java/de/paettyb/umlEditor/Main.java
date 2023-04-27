package de.paettyb.umlEditor;

import java.awt.*;

import de.paettyb.engine.Engine;
import de.paettyb.umlEditor.ui.Button;

public class Main extends Engine {
    
    Button b = new Button("Test", 50, 50, () -> System.out.println("Test"));
    
    public Main(String name, int width, int height) {
        super(name, width, height);
        b.handleEvent(55, 55);
    }
    
    public static void main(String[] args) {
        Main main = new Main("UML Editor", 1280, 720);
        main.start();
    }
    
    @Override
    public void tick() {
    
    }
    
    @Override
    public void render(Graphics g) {
        b.render(g);
    }
}