package de.paettyb.umlEditor.uml;

import javax.swing.*;
import java.awt.*;

public class ClassAddDialogue extends JFrame {

    public ClassAddDialogue() {
        setTitle("Add Class");
        setSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        add(new TextField());
        add(new Button("Submit"));
        setVisible(true);
    }
    
}
