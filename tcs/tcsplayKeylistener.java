package com.hngc.tcs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class tcsplayKeylistener extends KeyAdapter {
    tcsplay tcs;

    public tcsplayKeylistener(tcsplay tcs) {
        this.tcs = tcs;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        tcs.fx = e.getKeyChar();
        //        判断按下的是哪一个键
        if (tcs.test == 0) {
            if (tcs.fx == 'd') {
                tcs.snakex += 30;
                tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
//            判断蛇是否超过边界
                if (tcs.snakex > 930) {
                    tcs.snakex = 0;
                    tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                }
            } else if (tcs.fx == 'a') {
                tcs.snakex -= 30;
                tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                if (tcs.snakex < 0) {
                    tcs.snakex = 930;
                    tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                }
            } else if (tcs.fx == 's') {
                tcs.snakey += 30;
                tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                if (tcs.snakey > 600) {
                    tcs.snakey = 0;
                    tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                }
            } else if (tcs.fx == 'w') {
                tcs.snakey -= 30;
                tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                if (tcs.snakey < 0) {
                    tcs.snakey = 600;
                    tcs.jButton[0].setLocation(tcs.snakex, tcs.snakey);
                }
            }
        }else{
            //        判断按下的是哪一个键
            if(tcs.fx == 'd'){
                tcs.snakex +=30;
                tcs.jButton[0].setLocation(tcs.snakex,tcs.snakey);
//            判断蛇是否超过边界
                if(tcs.snakex>930){
                    System.out.println("游戏结束");
                    JOptionPane.showMessageDialog(tcs,"创到墙了","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }else if(tcs.fx == 'a'){
                tcs.snakex -=30;
                tcs.jButton[0].setLocation(tcs.snakex,tcs.snakey);
                if(tcs.snakex<0){
                    JOptionPane.showMessageDialog(tcs,"创到墙了","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }else if(tcs.fx == 's'){
                tcs.snakey +=30;
                tcs.jButton[0].setLocation(tcs.snakex,tcs.snakey);
                if(tcs.snakey>600){
                    System.out.println("游戏结束");
                    JOptionPane.showMessageDialog(tcs,"创到墙了","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }else if (tcs.fx == 'w'){
                tcs.snakey -=30;
                tcs.jButton[0].setLocation(tcs.snakex,tcs.snakey);
                if(tcs.snakey<0){
                    System.out.println("游戏结束");
                    JOptionPane.showMessageDialog(tcs,"创到墙了","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }
        }
//        判断蛇是否咬到自己
        if(tcs.length>1) {
            for (int i = 1; i < tcs.length; i++) {
                if (tcs.jButton[0].getX() == tcs.jButton[i].getX() && tcs.jButton[0].getY() == tcs.jButton[i].getY()) {
                    JOptionPane.showMessageDialog(tcs,"不小心咬到了自己","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }
        }

//        判断蛇是否咬到自己
        if(tcs.length>1) {
            for (int i = 1; i < tcs.length; i++) {
                if (tcs.jButton[0].getX() == tcs.jButton[i].getX() && tcs.jButton[0].getY() == tcs.jButton[i].getY()) {
                    JOptionPane.showMessageDialog(tcs,"不小心咬到了自己","重新开始",JOptionPane.WARNING_MESSAGE);
                    replace();
                }
            }
        }
//        控制蛇是否吃到食物
        if(tcs.jButton[0].getX() == tcs.foodx&&tcs.jButton[0].getY() == tcs.foody){
            tcs.jButton[tcs.length] = new JButton();//为每个蛇后面添加尾
            tcs.jButton[tcs.length].setBounds(tcs.jButton[tcs.length-1].getX()-30,tcs.jButton[tcs.length-1].getY(),30,30);
            tcs.jButton[tcs.length].setEnabled(false);
            tcs.jPanel.add(tcs.jButton[tcs.length]);
            tcs.score += 1;//累加计算得分
            tcs.jLabel.setText("得分:"+String.valueOf(tcs.score));
            tcs.add(tcs.jLabel);
//            判断食物是否和蛇重合
            for(int j =0; j< tcs.length ;j++) {
//                if(tcs.jButton[0].getX()!= tcs.jButton[j].getX()&&tcs.jButton[0].getY() != tcs.jButton[j].getY())
                if(tcs.foodx == tcs.jButton[j].getX()&& tcs.foody == tcs.jButton[j].getY()) {
                    tcs.foodx = 30 + 30 * (new Random()).nextInt(29);
                    tcs.foody = 30 + 30 * (new Random()).nextInt(19);
                }
            }
            tcs.jButton1.setLocation(tcs.foodx,tcs.foody);
//            tcs.jButton1.setEnabled(false);
            tcs.length++;
        }
//       控制蛇移动
        for(int i =tcs.length-1;i>0;i--){
            tcs.jButton[i].setBounds(tcs.jButton[i-1].getX(),tcs.jButton[i-1].getY(),30,30);
        }
    }
//      重置游戏
    public void replace(){
        tcs.jPanel.setVisible(false);
        tcs.remove(tcs.jPanel);
        tcs.snakex = 0;
        tcs.snakey = 0;
        tcs.length = 1;
        tcs.score = 0;
        tcs.jLabel.setText("得分:"+String.valueOf(tcs.score));
        tcs.vjp();
    }
}
