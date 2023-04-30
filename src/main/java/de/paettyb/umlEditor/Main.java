package de.paettyb.umlEditor;

import de.paettyb.engine.Engine;
import de.paettyb.engine.ui.CanvasButton;
import de.paettyb.umlEditor.uml.Diagram;

import java.awt.*;

public class Main extends Engine {
    
    private final Diagram diagram = new Diagram(this);
    private final CanvasButton addClass = new CanvasButton("New Class", 10, 10, diagram::addClass);
    private final CanvasButton  addArrow = new CanvasButton("New Arrow", 10, 60, diagram::addArrow);
    
    public Main(String name, int width, int height) {
        super(name, width, height);
    }
    
    public static void main(String[] args) {
        Main main = new Main("UML Editor", 1280, 720);
        main.start();
    }
    
    @Override
    public void tick() {
        addClass.update();
        addArrow.update();
        diagram.update();
    }
    
    @Override
    public void render(Graphics g) {
        addClass.render(g);
        addArrow.render(g);
        diagram.render(g);
    }
}