package de.paettyb.umlEditor.uml;

import de.paettyb.engine.input.MouseManager;
import de.paettyb.umlEditor.Main;

import java.awt.*;
import java.util.ArrayList;

public class Diagram {
    
    private ArrayList<ClassContainer> classes = new ArrayList<>();
    
    public static int addArrowStage = 0;
    private ClassContainer arrowStart = null, arrowEnd = null;
    private Main main;
    
    public Diagram(Main main) {
        this.main = main;
    }
    
    public void update(){
        for(ClassContainer c : classes){
            if(addArrowStage == 0){
                c.update();
            } else if(c.mouseIntersect() && MouseManager.keyWasReleased(1)) {
                if(addArrowStage == 1) {
                    c.setHighligted(true);
                    arrowStart = c;
                    addArrowStage = 2;
                } else if (addArrowStage == 2){
                    arrowStart.setHighligted(false);
                    addArrowStage = 0;
                    Arrow a = new Arrow(arrowStart, c);
                    arrowStart.addOutgoingArrow(a);
                    c.addIncomingArrow(a);
                    main.getDisplay().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        }
    }
    
    public void render(Graphics g) {
        for(ClassContainer c : classes){
            c.render(g);
        }
    }
    
    public void addClass(){
        classes.add(new ClassContainer("Class"));
    }
    
    public void addArrow() {
        addArrowStage = 1;
        main.getDisplay().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }
}
