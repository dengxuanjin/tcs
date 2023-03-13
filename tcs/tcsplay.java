package com.hngc.tcs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tcsplay extends JFrame  {
    JFrame jthis  = this;           //指向自己的JFrame对象
    JPanel jPanel = null;           //充当一个画布
    int snakex =0,snakey =0;        //控制蛇头的位置
    int foodx,foody;                //控制食物的位置
    int score =  0;                 //控制分数
    int test = 0;                   //穿墙设置
//    顶行控制按钮
    JLabel jLabel = new JLabel("得分:0") ;
    JLabel jLabel1 = new JLabel("用户名:     "+Main.thisname) ;
    JButton jexit = new JButton("退出");
//    蛇头和蛇身用一个JButton数组代替
    JButton[] jButton = new JButton[100];
    JButton jButton1 = null;        //食物的按钮
    char fx;                        //存储从键盘上接收到的字符
    int length = 1;                 //计算蛇身有多长
    tcsplayKeylistener t2 =new tcsplayKeylistener(this);            //创建一个tcsplaykeylistener对象(实现keylistener接口或者继承keyadAdpater的类
//    初始化窗口
    public tcsplay(){
        setSize(990,670);
        setLocationRelativeTo(this);
        setLayout(null);
        setUndecorated(true);
        vjp();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
//    设置画布内的布局
    public void vjp(){
//        设置组件的位置和大小颜色
        jPanel = new JPanel();
        jButton[0] = new JButton();
        jPanel.setBackground(Color.BLACK);
        jPanel.setLayout(null);
        jPanel.setBounds(15,25,960,630);
        jButton[0].addKeyListener(t2);
        jButton1 = new JButton();
//        jButton[0].setEnabled(false);
        jButton1.setEnabled(false);
        startbody();
        jButton[0].setBounds(0,0,30,30);
        jButton1.setBounds(foodx,foody,30,30);
        jButton[0].setBackground(Color.red);
        jButton1.setBackground(Color.blue);
        jLabel.setBounds(0,0,150,20);
        jLabel1.setBounds(150,0,150,20);
        jexit.setBounds(300,0,150,20);
        jexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jthis.dispose();
            }
        });
//        添加组件
        add(jLabel);
        add(jLabel1);
        add(jexit);
        jPanel.add(jButton[0]);
        jPanel.add(jButton1);
        add(jPanel);
    }
//        设置食物位置
    public void startbody(){
        foodx =30 +30*(new Random()).nextInt(29);
        foody =30 +30*(new Random()).nextInt(19);
    }

//    protected void paintComponent(Graphics g) {
//        // 设置面板背景色
//        jPanel.setBackground(Color.white);
//        // 绘制游戏区域
//        g.fillRect(25, 50, 600, 575);
//        // 绘制蛇头
//        if (fx == 'w') {
//            Data.getUp().paintIcon(jPanel, g, snakex[0], snakey[0]);
//        } else if (fx == 's') {
//            Data.getDown().paintIcon(jPanel, g, snakex[0], snakey[0]);
//        } else if (fx == 'a'){
//            Data.getLeft().paintIcon(jPanel, g, snakex[0], snakey[0]);
//        } else if (fx == 'd')
//            Data.getRight().paintIcon(jPanel, g, snakex[0], snakey[0]);
//
//        // 绘制蛇的身体
//        for (int i = 1; i < length; i++) {
//            Data.getBody().paintIcon(jPanel, g, snakex[i], snakey[i]);
//        }
//        // 画食物
//        Data.getFood().paintIcon(jPanel, g, foodx, foody);
//        // 绘制局内游戏信息
//        g.setColor(Color.black);
//        g.setFont(new Font("宋体", Font.BOLD, 15));
//        g.drawString("长度：" + length, 25, 20);
//        g.drawString("分数：" + score, 25, 40);
//        // 绘制游戏暂停时的 提示信息
//        if (!isFail) {
//            g.setColor(Color.white);
//            g.setFont(new Font("楷体", Font.BOLD, 40));
//            g.drawString("按下空格开始游戏！", 125, 300);
//        }
//        // 绘制游戏失败时的 提示信息
//        if (isFail) {
//            g.setColor(Color.red);
//            g.setFont(new Font("楷体", Font.BOLD, 40));
//            g.drawString("失败，按下空格重新开始", 125, 300);
//        }
//        // 绘制游戏胜利时的 提示信息
//
//        if (isVictory) {
//            g.setColor(Color.red);
//            g.setFont(new Font("宋体", Font.BOLD, 35));
//            g.drawString("胜利，你是为数不多的天才", 125, 300);
//            g.drawString("按下空格重新开始新一轮游戏", 100, 350);
//        }
//    }
//
//    // 键盘监听事件，某个键按下执行方法
//    public void actionPerformed(ActionEvent e) {
//        if(!iskill&&!isFail&&!isVictory){
//        for(int i =snakex.length-1;i>0;i--){
//            snakex[i] = snakex[i-1];
//            snakey[i] = snakey[i-1];
//        }
//        if ( fx == 'w'){
//            snakey[0] = snakey[0] -30;
//            if(snakey[0] <=0 )
//                iskill=true;
//        } else if( fx == 's'){
//            snakey[0] = snakey[0] +30;
//            if(snakey[0] >= 600 )
//                iskill=true;
//        } else if(fx == 'a'){
//            snakex[0] = snakex[0] -30;
//            if(snakex[0] <=0 )
//                iskill=true;
//        } else if(fx == 'd'){
//            snakex[0] = snakex[0] +30;
//            if(snakex[0] >= 900 )
//                iskill=true;
//        }
//        }
//    }
}
