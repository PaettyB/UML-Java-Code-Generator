package de.paettyb.umlEditor.uml;

import java.awt.*;
import java.util.ArrayList;

public class Diagramm {
    
    private ArrayList<ClassContainer> classes = new ArrayList<>();
    
    public void update(){
        for(ClassContainer c : classes){
            c.update();
        }
    }
    
    public void render(Graphics g) {
        for(ClassContainer c : classes){
            c.render(g);
        }
    }
    
    public void addClass(){
        classes.add(new ClassContainer("Test", 200,200));
    }
}
