package de.paettyb.umlEditor.uml;

import java.util.ArrayList;

public class ClassObject {
    
    public String name;
    public ArrayList<String> attributes;
    public ArrayList<String> methods;
    
    public ClassObject(String name, ArrayList<String> attributes, ArrayList<String> methods) {
        this.name = name;
        this.attributes = attributes;
        this.methods = methods;
    }
}
