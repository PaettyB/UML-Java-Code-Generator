package de.paettyb.umlEditor.uml;

import de.paettyb.engine.input.MouseManager;
import de.paettyb.engine.ui.DragBox;

import java.awt.*;
import java.util.ArrayList;

public class ClassContainer extends DragBox {
    
    private ClassObject classObject;
    private final Font classNameFont = new Font("Arial", Font.BOLD, 15);
    private final Font attribFont = new Font("Arial", Font.PLAIN, 13);
    
    private int padding = 5;
    private int classNameHeight = 0;
    private int attribHeight = 0;
    
    
    public ClassContainer(String className) {
        super(MouseManager.mouseX - 50, MouseManager.mouseY - 25, 100, 50);
        classObject = new ClassObject(className, new ArrayList<>(), new ArrayList<>());
        this.fixedToMouse = true;
        setAction(this::openEditWindow);
    }
    
    public void openEditWindow() {
        ClassEditDialogue ced = new ClassEditDialogue(this, classObject.name, classObject.attributes, classObject.methods);
    }
    
    public void setClass(ClassObject classObject) {
        this.classObject = classObject;
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
        
        height = 6 * padding + classNameHeight + attribHeight * (classObject.attributes.size() + classObject.methods.size());
        
        for (String s : classObject.attributes) {
            g.setFont(attribFont);
            if (g.getFontMetrics().stringWidth(s) + 2 * padding > width)
                width = g.getFontMetrics().stringWidth(s) + 2 * padding;
        }
        
        for (String s : classObject.methods) {
            g.setFont(attribFont);
            if (g.getFontMetrics().stringWidth(s) + 2 * padding > width)
                width = g.getFontMetrics().stringWidth(s) + 2 * padding;
        }
        
        super.render(g);
        
        g.setFont(classNameFont);
        int classNameWidth = g.getFontMetrics().stringWidth(classObject.name);
        g.setColor(Color.BLACK);
        g.drawString(classObject.name, (int) (x + width * 0.5 - classNameWidth * 0.5), y + classNameHeight + padding);
        
        int firstLineY = y + 2 * padding + classNameHeight;
        g.drawLine(x, firstLineY, x + width - 1, firstLineY);
        
        g.setFont(attribFont);
        
        for (int i = 0; i < classObject.attributes.size(); i++) {
            g.drawString(classObject.attributes.get(i), x + padding, firstLineY + padding + (i + 1) * attribHeight);
        }
        
        int secondLineY = firstLineY + classObject.attributes.size() * attribHeight + padding * 2;
        g.drawLine(x, secondLineY, x + width - 1, secondLineY);
        
        for (int i = 0; i < classObject.methods.size(); i++) {
            g.drawString(classObject.methods.get(i), x + padding, secondLineY + padding + (i + 1) * attribHeight);
        }
    }
    
    public void addAttribute(String s) {
        classObject.attributes.add(s);
    }
    
    public void addMethod(String s) {
        classObject.attributes.add(s);
    }
    
    public String getClassName() {
        return classObject.name;
    }
    
    public void setClassName(String className) {
        this.classObject.name = className;
    }
    
    public ArrayList<String> getAttributes() {
        return classObject.attributes;
    }
    
    public ArrayList<String> getMethods() {
        return classObject.methods;
    }
    
    public int getPadding() {
        return padding;
    }
    
    public void setPadding(int padding) {
        this.padding = padding;
    }
}
