package de.paettyb.umlEditor.ui;

public class Button{

    private int x,y;
    private int width = 40, height = 20;
    private String label;

    Runnable callback;

    public Button(String label, int x, int y, Runnable callback){
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
