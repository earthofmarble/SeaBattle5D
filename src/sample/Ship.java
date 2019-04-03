package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class Ship {

    int xPos;
    int yPos;
    int length;
    Direction direction;
    boolean isAlive;
    ArrayList<Position> shipBlocksArrayList;


    public Ship(int xPos, int yPos, int length, Direction direction, boolean isAlive, ArrayList<Position> shipBlocksArrayList){
        this.xPos=xPos;
        this.yPos=yPos;
        this.length=length;
        this.direction=direction;
        this.isAlive=isAlive;
        this.shipBlocksArrayList=shipBlocksArrayList;
    }




    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }

    public ArrayList<Position> getShipBlocksArrayList() {
                return shipBlocksArrayList;
    }
}
