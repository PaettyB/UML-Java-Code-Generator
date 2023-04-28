package de.paettyb.umlEditor.uml;

import de.paettyb.engine.ui.DragBox;

import java.awt.*;
import java.util.ArrayList;

public class ClassContainer extends DragBox {
    
    private String className;
    private final Font classNameFont = new Font("Arial", Font.BOLD, 15);
    private final Font attribFont = new Font("Arial", Font.PLAIN, 13);
    
    private int padding = 5;
    private int classNameHeight = 0;
    private int attribHeight = 0;
    
    private ArrayList<String> attributes = new ArrayList<>();
    private ArrayList<String> methods = new ArrayList<>();
    
    public ClassContainer(String className, int x, int y) {
        super(x, y, 100, 50);
        this.className = className;
    }
    
    
    //TODO: OPTIMIZE SIZE CALCULATION AFTER CHANGES
    @Override
    public void render(Graphics g) {
        if (classNameHeight == 0) {
            g.setFont(classNameFont);
            classNameHeight = g.getFontMetrics().getAscent();
            g.setFont(attribFont);
            attribHeight = g.getFontMetrics().getAscent();
        }
        
        height = 6 * padding + classNameHeight + attribHeight * (attributes.size() + methods.size());
        
        for(String s : attributes){
            g.setFont(attribFont);
            if(g.getFontMetrics().stringWidth(s) + 2*padding > width)
                width = g.getFontMetrics().stringWidth(s) + 2*padding;
        }
    
        for(String s : methods){
            g.setFont(attribFont);
            if(g.getFontMetrics().stringWidth(s) + 2*padding > width)
                width = g.getFontMetrics().stringWidth(s) + 2*padding;
        }
        
        super.render(g);
        
        g.setFont(classNameFont);
        int classNameWidth = g.getFontMetrics().stringWidth(className);
        g.setColor(Color.BLACK);
        g.drawString(className, (int) (x + width * 0.5 - classNameWidth * 0.5), y + classNameHeight + padding);
        
        int firstLineY = y + 2 * padding + classNameHeight;
        g.drawLine(x, firstLineY, x + width-1, firstLineY);
        
        g.setFont(attribFont);
        
        for (int i = 0; i < attributes.size(); i++) {
            g.drawString(attributes.get(i), x + padding, firstLineY + padding + (i + 1) * attribHeight);
        }
        
        int secondLineY = firstLineY + attributes.size() * attribHeight + padding*2;
        g.drawLine(x, secondLineY, x + width-1, secondLineY);
    
        for (int i = 0; i < methods.size(); i++) {
            g.drawString(methods.get(i), x + padding, secondLineY + padding + (i + 1) * attribHeight);
        }
    }
    
    public void addAttribute(String s) {
        attributes.add(s);
    }
    
    public void addMethod(String s) {
        methods.add(s);
    }
    
}
