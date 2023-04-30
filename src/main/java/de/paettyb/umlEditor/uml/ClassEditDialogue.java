package de.paettyb.umlEditor.uml;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClassEditDialogue extends JFrame {
    
    private final JPanel panel = new JPanel();
    
    private static final Dimension methDim = new Dimension(150, 25);
    private static final Dimension space = new Dimension(0, 5);
    
    private final JTextField classNameField;
    private final ArrayList<JTextField> attribFields = new ArrayList<>();
    private final ArrayList<JTextField> methodFields = new ArrayList<>();
    
    public ClassEditDialogue(ClassContainer classContainer, String className, List<String> attributes, List<String> methods) {
        BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setPreferredSize(new Dimension(400, 500));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(layout);
        setTitle("Edit Class");
        setLocationRelativeTo(null);
        
        JPanel panelOne = new JPanel();
        
        panelOne.add(new JLabel("Class Name"));
        
        classNameField = new JTextField(className);
        classNameField.setPreferredSize(new Dimension(300, 30));
        panelOne.add(classNameField);
        
        
        JPanel panelTwo = new JPanel();
        JScrollPane scroll1 = new JScrollPane(panelTwo);
        panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.PAGE_AXIS));
        JButton attribAdd = new JButton("Add");
        attribAdd.addActionListener((e) -> addItem(panelTwo, scroll1, attribFields));
        attribAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (String a : attributes) {
            JTextField field = new JTextField(a);
            field.setMaximumSize(methDim);
            attribFields.add(field);
            panelTwo.add(field);
            panelTwo.add(Box.createRigidArea(space));
        }
        panelTwo.add(attribAdd);
        panelTwo.add(Box.createRigidArea(new Dimension(0, 30)));
        
        JPanel panelThree = new JPanel();
        JScrollPane scroll2 = new JScrollPane(panelThree);
        panelThree.setLayout(new BoxLayout(panelThree, BoxLayout.PAGE_AXIS));
        JButton methodAdd = new JButton("Add");
        methodAdd.addActionListener((e) -> addItem(panelThree, scroll2, methodFields));
        methodAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (String m : methods) {
            JTextField field = new JTextField(m);
            field.setMaximumSize(methDim);
            methodFields.add(field);
            panelThree.add(field);
            panelThree.add(Box.createRigidArea(space));
        }
        panelThree.add(methodAdd);
        panelThree.add(Box.createRigidArea(new Dimension(0, 30)));
        
        panel.add(panelOne);
        panel.add(scroll1);
        panel.add(scroll2);
        JButton submit = new JButton("Submit");
        submit.addActionListener((e) -> submit(classContainer));
        panel.add(submit);
        
        add(panel);
        setVisible(true);
        setAlwaysOnTop(true);
        setResizable(false);
        pack();
    }
    
    public void addItem(JPanel panel, JScrollPane scroll, List<JTextField> list) {
        JTextField field = new JTextField();
        field.setMaximumSize(methDim);
        list.add(field);
        panel.add(field, panel.getComponentCount() - 2);
        panel.add(Box.createRigidArea(space), panel.getComponentCount() - 2);
        
        panel.revalidate();
        scroll.getVerticalScrollBar().updateUI();
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    }
    
    public void submit(ClassContainer classContainer) {
        ArrayList<String> attribs = new ArrayList<>();
        ArrayList<String> methods = new ArrayList<>();
        for (JTextField field : attribFields) {
            attribs.add(field.getText());
        }
        
        for (JTextField field : methodFields) {
            methods.add(field.getText());
        }
        dispose();
        classContainer.setClass(new ClassObject(classNameField.getText(), attribs, methods));
    }
    
    public static void main(String[] args) {
        new ClassEditDialogue(null, "Test", List.of("Test", "A"), List.of("Methods()", "A"));
    }
}
