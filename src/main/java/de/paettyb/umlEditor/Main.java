package de.paettyb.umlEditor;

import de.paettyb.engine.Engine;
import de.paettyb.engine.ui.CanvasButton;
import de.paettyb.umlEditor.uml.ClassAddDialogue;
import de.paettyb.umlEditor.uml.Diagramm;

import java.awt.*;

public class Main extends Engine {
    
    private Diagramm diagramm = new Diagramm();
    private CanvasButton b = new CanvasButton("New Class", 50, 50, this::openCreateDialogue);
    
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
        diagramm.update();
    }
    
    @Override
    public void render(Graphics g) {
        b.render(g);
        diagramm.render(g);
    }
    
    private void openCreateDialogue() {
        ClassAddDialogue dialogue = new ClassAddDialogue();
    }
}