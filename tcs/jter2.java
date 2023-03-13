package com.hngc.tcs;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;

public class jter2 extends MouseAdapter {
    Enroll enroll = null;

    public jter2(Enroll enroll) {
        this.enroll = enroll;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        String sname=String.valueOf(e.getSource());
//        int idex =sname.indexOf("返回");
//        if (idex!=-1){
//        String s = sname.substring(idex,idex+2);
//        判断用户点击了那个按钮
        if (e.getSource() == enroll.jb1){
            System.out.println("返回");
            enroll.setVisible(false);           //隐藏当前窗口
            win w = new win();                  //打开登录窗口
        } else{
//            获得在注册密码时的密码
            String s1 = new String(enroll.jpf1.getPassword());
            String s2 = new String(enroll.jpf2.getPassword());
            if(s1.equals(s2)&&(!s1.equals("")&&(!s2.equals("")))) {
                try {
//                    提醒用户输入用户名
                    String name = JOptionPane.showInputDialog(enroll,"用户名","请输入您的用户名",JOptionPane.WARNING_MESSAGE);
                    System.out.println("注册成功");
//                    初始化账号(此处还未做判断数据库重复的账号判断）
                    String s3 = String.valueOf(new Random().nextInt()%1000000000+1000000000);
                    Main.jdbctest(s3,s1,name,false,new win());
                    enroll.dispose();
//                    显示注册成功窗口
                    new EnrollFinish(s3,s1,name);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else if(!s1.equals(s2))
//                提示用户输入不一致
                JOptionPane.showMessageDialog(enroll,"两次输入不同","两次输入不一致",JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(enroll,"输入出错","两次输入为空请输入密码",JOptionPane.WARNING_MESSAGE);
        }
    }
}