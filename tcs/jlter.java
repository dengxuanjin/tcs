package com.hngc.tcs;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class jlter extends MouseAdapter {
//    获取初始面板的对象
    win pre;
    public jlter(win pre){
        this.pre = pre;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
//        判断输入框中的值不为为空
        if(!(pre.jt1.getText().equals(""))&&!(String.valueOf(pre.jt2.getPassword()).equals(""))){
            try {
//                通过Main的静态jdbctest方法打开数据库
                Main.jdbctest(pre.jt1.getText(),String.valueOf(pre.jt2.getPassword()),"",true,pre);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if (pre.jt1.getText().equals("")){
                System.out.println("账号不能为空");
//                提示用户输入不能为空
            JOptionPane.showMessageDialog(pre,"账号不能为空","账号不能为空",JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("密码不能为空");
            JOptionPane.showMessageDialog(pre,"密码不能为空","密码不能为空",JOptionPane.WARNING_MESSAGE);
        }
    }
}
