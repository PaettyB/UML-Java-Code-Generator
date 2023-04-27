package de.paettyb.umlEditor.ui;

interface IButton {
    boolean handleEvent(int a, int b);
}

public class Button implements IButton{

    private int x,y;
    private int width = 40, height = 20;
    private String label;

    Runnable callback;

    public Button(String Label, int x, int y, Runnable callback){
        this.label = label;
        this.x = x;
        this.y = y;
        this.callback = callback;
    }

    public boolean handleEvent(int mouseX, int mouseY){
        if (mouseX >= x && mouseX <= x+width && mouseY >= y && mouseY <= y + height){
            try {
                callback.run();
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
