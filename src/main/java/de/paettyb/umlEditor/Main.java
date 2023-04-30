package de.paettyb.umlEditor;

import de.paettyb.engine.Engine;
import de.paettyb.engine.ui.CanvasButton;
import de.paettyb.umlEditor.uml.Diagram;

import java.awt.*;

public class Main extends Engine {
    
    private Diagram diagram = new Diagram();
    private CanvasButton b = new CanvasButton("New Class", 50, 50, () -> diagram.addClass());
    
    public Main(String name, int width, int height) {
        super(name, width, height);
    }
    
    public static void main(String[] args) {
        Main main = new Main("UML Editor", 1280, 720);
        main.start();
    }
    
    @Override
    public void tick() {
        b.update();
        diagram.update();
    }
    
    @Override
    public void render(Graphics g) {
        b.render(g);
        diagram.render(g);
    }
}