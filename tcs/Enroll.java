package com.hngc.tcs;
import javax.swing.*;
import java.awt.*;

public class Enroll extends JFrame {
    //属性
    JLabel jl1 = new JLabel("注册");
    JPasswordField jpf1,jpf2;           //两个密码框
    JLabel jl2,jl3;
    JButton jb1 = new JButton("返回"),jb2 = new JButton("注册");
    jter2 j1 =new jter2(this);              //创建一个jlter2对象(实现Mouselistener接口或者继承MouseadAdpater的类
//    初始化注册窗口
    public Enroll() {
        setName("注册");
        setSize(500, 400);
        setLocationRelativeTo(this);            //设置初始化居中显示
        jl1.setBounds(210,0,100,50);
        jl1.setFont(new Font("楷体",Font.BOLD,35));           //设置字体大小样式
        add(jl1);
        visi();
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
//    添加组件
    public void visi(){
//        初始化组件
        jpf1 = new JPasswordField(35);
        jpf2 = new JPasswordField(35);
        jl2 = new JLabel("请输入你需要密码:");
        jl3 = new JLabel("请再次输入密码:");
        jpf1.setBounds(175,100,300,45);
        jpf2.setBounds(175,170,300,45);
        jpf1.setFont(new Font("",Font.BOLD,22));
        jpf2.setFont(new Font("",Font.BOLD,22));
//          设置大小，位置
        jl2.setBounds(20,100,300,50);
        jl3.setBounds(20,170,300,50);
        jl2.setFont(new Font("楷体",Font.BOLD,17));
        jl3.setFont(new Font("楷体",Font.BOLD,17));
        jb1.setBounds(100,250,100,60);
        jb2.setBounds(250,250,100,60);
//          设置监听器
        jb1.addMouseListener(j1);
        jb2.addMouseListener(j1);
        add(jl2);
        add(jpf1);
        add(jl3);
        add(jpf2);
        add(jb1);
        add(jb2);
    }

}
