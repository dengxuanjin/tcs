package com.hngc.tcs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnrollFinish extends JFrame {
//    初始化 注册成功信息
    JLabel jl1 = new JLabel("您的账号密码为:"),jl2=new JLabel("账号:"),jl3=new JLabel("密码:"),jname = new JLabel("用户名:");
    JLabel jl4,jl5,jl6;
    JButton jButton = new JButton("返回");
    public EnrollFinish(String account ,String password,String name) {
        setName("注册成功");
        setBackground(Color.CYAN);
        jl4 = new JLabel(account);
        jl5 = new JLabel(password);
        jl6 = new JLabel(name);
//        设置大小位置
        setSize(500, 400);
        setLocationRelativeTo(this);
        jl1.setBounds(0,0,400,50);
        jl2.setBounds(70,100,400,65);
        jl3.setBounds(70,160,400,65);
        jname.setBounds(70,40,400,65);
        jl4.setBounds(150,100,400,65);//account
        jl5.setBounds(150,160,400,65);//password
        jl6.setBounds(160,40,400,65);//name
        jButton.setBounds(130,265,200,60);
//          设置字体样式大小
        jl1.setFont(new Font("楷体",Font.BOLD,30));
        jl2.setFont(new Font("宋体",Font.BOLD,25));
        jl3.setFont(new Font("宋体",Font.BOLD,25));
        jl4.setFont(new Font("宋体",Font.BOLD,25));
        jl5.setFont(new Font("宋体",Font.BOLD,25));
        jl6.setFont(new Font("宋体",Font.BOLD,25));
        jname.setFont(new Font("宋体",Font.BOLD,25));
        jButton.setFont(new Font("楷体",Font.BOLD,25));
//        添加监听事件
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new win();
            }
        });
//        添加组件
        add(jl1);
        add(jl2);
        add(jl3);
        add(jl4);
        add(jl5);
        add(jl6);
        add(jname);
        add(jButton);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

