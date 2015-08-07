package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

public class Arcanoid {

    private int width;
    private int height;

    private Ball ball;
    private Stand stand;

    ArrayList<Brick> bricks = new ArrayList<>();


    public Arcanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {return stand;}
    public void setStand(Stand stand) {this.stand = stand;}

    public ArrayList<Brick> getBricks() {return bricks;}
    public void setBricks(ArrayList<Brick> bricks) {this.bricks = bricks;}



    public static Arcanoid game;

    public static void main(String[] args) {


    }

    public void run(){}

    public void move(){}

}
