package com.hngc.tcs;
import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
public class Main {
//    属性
    static win w;
    static String thisname ="";//           用户名
//    方法e
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        w = new win();          //登录窗口入口


//        Enroll enroll = new Enroll();
//        EnrollFinish enrollFainish = new EnrollFinish("123","adas");
//        equalslgnoreCase不区分大小写比较
//        tcsplay tcs = new tcsplay();
    }




    public static void jdbctest(String account,String password1,String name,Boolean pangduan,win pre) throws ClassNotFoundException, SQLException {
        Connection con = null;
//        初始化jar包
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=GMT";        //位置
        String user = "root";                                                                   //权限
        String password = "123456";                                                             //密码
        ResultSet rs = null;                            //迭代输出对象
        PreparedStatement sql = null;                   //预处理sql语句
        int txt = 1;
        try {
            con = DriverManager.getConnection(url, user, password);
//            pangduan == false 则会添加数据也就是注册
            if(!pangduan){
                pre.dispose();
                sql = con.prepareStatement("insert into sh_goods  values(?,?,?)");              //?通配符
                sql.setString(1,account);                                              //1列
                sql.setString(2,password1);                                            //2列
                sql.setString(3,name);                                                 //3列
                int i = sql.executeUpdate();                                                        //执行预处理的sql语句
                sql = con.prepareStatement("select * from sh_goods");
                rs = sql.executeQuery();                                                            //获取数据库数据
            while (rs.next()) {
                System.out.printf("%s\t%s\n",rs.getObject(1),rs.getObject(2));
            }
            }else{
//                pangduan == true 判断数据库中是否存在用户在登录窗口输入的账号密码
                sql = con.prepareStatement("select * from sh_goods");
                rs = sql.executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(account)&&rs.getString(2).equals(password1)) {
//                        存在则进入游戏
                        pre.dispose();
                        thisname = rs.getString(3);
                        tcsplay t1=new tcsplay();
                        JOptionPane.showMessageDialog(t1,"开始游戏(点击蛇头开始移动'w''a''s'd'每次开始有一次保护阶段可多吃一个食物)","开始",JOptionPane.WARNING_MESSAGE);
                        String i = JOptionPane.showInputDialog(t1,"输入1不可穿墙0可穿墙(默认为可穿墙)","设置",JOptionPane.WARNING_MESSAGE);
                        try{
                            t1.test = Integer.parseInt(i);
                        }catch (Exception e){
                            System.out.println("没输入默认0");
                            JOptionPane.showMessageDialog(t1,"设置为默认0","注意",JOptionPane.WARNING_MESSAGE);
                        }
//                        设置在数据库中找到了值之后的事
                        txt = 0;
                        break;
                    }
                }
                if (txt == 1){
//                    if text == 1 则说明数据库中没有相同的，提示用户重新输入
                    System.out.println("账号或者密码错误");
                    JOptionPane.showMessageDialog(w,"密码错误","账号或者密码错误，请重新输入:",JOptionPane.WARNING_MESSAGE);
                    w.jt2.setText("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null)rs.close();
            if(sql!=null)sql.close();
            if(con!=null)con.close();
        }
    }
}
