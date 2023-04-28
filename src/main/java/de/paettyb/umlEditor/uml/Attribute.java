package de.paettyb.umlEditor.uml;

public class Attribute {
    
    public String type;
    public String name;
    public String visibility;
    
    public Attribute(String visibility, String type, String name) {
        this.type = type;
        this.name = name;
        this.visibility = visibility;
    }
}
