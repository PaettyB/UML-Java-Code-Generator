package de.paettyb.umlEditor.uml;

import de.paettyb.engine.utils.Vec2i;

import java.awt.*;

public class Arrow {

    private ClassContainer startNode, endNode;
    private Vec2i startPos;
    private Vec2i endPos;
    private int id;

    public Arrow(ClassContainer startNode, ClassContainer endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
        startPos = new Vec2i(0,0);
        endPos = new Vec2i(0,0);
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);
    }

    public ClassContainer getStartNode() {
        return startNode;
    }

    public void setStartNode(ClassContainer startNode) {
        this.startNode = startNode;
    }

    public ClassContainer getEndNode() {
        return endNode;
    }

    public void setEndNode(ClassContainer endNode) {
        this.endNode = endNode;
    }

    public Vec2i getStartPos() {
        return startPos;
    }

    public void setStartPos(Vec2i startPos) {
        this.startPos = startPos;
    }

    public Vec2i getEndPos() {
        return endPos;
    }

    public void setEndPos(Vec2i endPos) {
        this.endPos = endPos;
    }
}
