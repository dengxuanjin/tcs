package com.hngc.tcs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class win extends JFrame {
    JPanel jp1=new JPanel();
    JTextField jt1;
    JPasswordField jt2;
    JLabel jl1,jl2;
    JButton jb1;
    jlter jlter1 = new jlter(this);         //创建一个jlter对象(实现Mouselistener接口或者继承MouseadAdpater的类
    JLabel jl3=new JLabel("                 注册账号");
//    初始化登录窗口
    public win(){
        setSize(500,400);
        setLocationRelativeTo(this);
        setLayout(null);
//        setUndecorated(true);
        ImageIcon img = new ImageIcon("C:\\Users\\邓\\Pictures\\Camera Roll\\1.jpg");
        JLabel j1= new JLabel(img);
        j1.setBounds(0,0,480,250);
        add(j1);
        intn();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
//    添加组件
    public void intn(){

//        初始化组件
        jt1 = new JTextField(40);
        jt2 = new JPasswordField(40);
//        jt1.setSize(400,60);
        jl1 = new JLabel("账号:");
        jl2 = new JLabel("密码:");
        jb1 = new JButton("登录");
        jb1.addMouseListener(jlter1);
        jp1.setLayout(null);
//      设置字体
        jl1.setFont(new Font("宋体",Font.BOLD,15));
        jl2.setFont(new Font("宋体",Font.BOLD,15));
        jb1.setFont(new Font("宋体",Font.BOLD,15));
        jt1.setFont(new Font("宋体",Font.BOLD,15));
        jt2.setFont(new Font("宋体",Font.BOLD,15));
//      设置大小位置
        jl1.setBounds(40,15,60,40);
        jl2.setBounds(40,50,60,40);
        jt1.setBounds(80,20,250,30);
        jt2.setBounds(80,55,250,30);
        jb1.setBounds(350,20,100,45);
//      添加组件
        jp1.add(jl1);
        jp1.add(jt1);
        jp1.add(jl2);
        jp1.add(jt2);
        jp1.add(jb1);
        jl3.setFont(new Font("楷体",Font.BOLD,15));
//        为注册按钮添加监听器(匿名内部类）
        jl3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Enroll enroll = new Enroll();
                dispose();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jl3.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jl3.setForeground(Color.RED);
            }
        });
        jl3.setBounds(215,60,250,45);
        jp1.add(jl3);
        jp1.setBounds(0,250,480,140);
        add(jp1);
    }
}
//之前的数据库操作
//    public static void jdbctest(String account,String password1) throws ClassNotFoundException, SQLException {
//        Connection con = null;
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=GMT";
//        String user = "root";
//        String password = "123456";
//        ResultSet rs = null;
//        Statement sql = null;
//        try {
//            con = DriverManager.getConnection(url, user, password);
//            sql = con.createStatement();
//            rs = sql.executeQuery("select * from sh_goods");
//            while (rs.next()) {
//                if (rs.getString(1).equals(account)&&rs.getString(2).equals(password1)) {
//                    System.out.println("登录成功");
//                    break;
//                }
//            }
//            if (rs.next() == false){
//                System.out.println("账号或者密码错误");
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            rs.close();
//            sql.close();
//            con.close();
//        }
//    }
