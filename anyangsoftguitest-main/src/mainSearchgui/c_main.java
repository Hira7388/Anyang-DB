package mainSearchgui;

import mainSearchgui.balsu.orders;
import subpanel.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import pacDisposal.*;

public class c_main extends JFrame {
    public mainGUI mainGUI = new mainGUI(null);
    public c_pettycash c_pettycash = new c_pettycash(null);
    public c_stock c_stock = new c_stock(null);
    public c_product c_product = new c_product(null);
    public c_inbound c_inbound = new c_inbound(null);
    public orders orders = new orders(null);
    public Disposal Disposal = new Disposal(null);
    // 재고관리 패널에서 사용
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        EventQueue.invokeLater(new Runnable () {
            public void run() {
                try {
                    new c_main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void change(String name) {
        if(name.equals("메인")) {
            mainGUI.setVisible(true);
            setTitle("메인");
        }
        else if(name.equals("시재점검")) {
            c_pettycash.setVisible(true);
            setTitle("시재점검");
        }
        else if(name.equals("재고관리")) {
            c_stock.setVisible(true);
            setTitle("재고관리");
        }
        else if(name.equals("상품")) {
            c_product.setVisible(true);
            setTitle("상품");
        }
        else if(name.equals("입고")) {
            c_inbound.setVisible(true);
            setTitle("입고");
        }
        else if(name.equals("발주")) {
            orders.setVisible(true);
            setTitle("발주");
        }
        else if(name.equals("폐기")) {
            Disposal.setVisible(true);
            setTitle("폐기");
        }
    }
    public c_main() {
        setTitle("메인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960+16, 720+39);
        setPreferredSize(new Dimension(960+16, 720+39));
        setLocationRelativeTo(null);
        setResizable(false);
        c_stock = new c_stock(this);
        c_pettycash = new c_pettycash(this);
        c_product = new c_product(this);
        c_inbound = new c_inbound(this);
        orders = new orders(this);
        Disposal = new Disposal(this);
        mainGUI = new mainGUI(this);


        getContentPane().add(mainGUI);
        getContentPane().add(c_stock);
        getContentPane().add(c_product);
        getContentPane().add(c_pettycash);
        getContentPane().add(c_inbound);
        getContentPane().add(orders);
        getContentPane().add(Disposal);
        c_stock.setVisible(false);
        c_product.setVisible(false);
        c_pettycash.setVisible(false);
        c_inbound.setVisible(false);
        orders.setVisible(false);
        Disposal.setVisible(false);
        setVisible(true);
    }
}
class mainGUI extends JPanel {
    public c_main mainf;
    public mainGUI(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\메인GUI.png").getImage());
        this.setLayout(null);
        this.setSize(imagegui.getDim());
        this.setPreferredSize(new Dimension(imagegui.getDim()));
        this.setVisible(true);
        this.add(imagegui);

        // 메인 패널 선언

        JButton Inbound_Button = new JButton("입고");
        Inbound_Button.setBounds(700, 180, 190, 150);
        Inbound_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Inbound_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        Inbound_Button.setForeground(Color.WHITE);
        Inbound_Button.setBackground(new Color(163, 189, 226));

        JButton orders_Button = new JButton("발주");
        orders_Button.setBounds(500, 180, 190, 150);
        orders_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        orders_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        orders_Button.setForeground(Color.WHITE);
        orders_Button.setBackground(new Color(163, 189, 226));

        JButton Product_Button = new JButton("판매내역");
        Product_Button.setBounds(500, 340, 190, 150);
        Product_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Product_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        Product_Button.setForeground(Color.WHITE);
        Product_Button.setBackground(new Color(163, 189, 226));

        JButton Disposal_Button = new JButton("폐기");
        Disposal_Button.setBounds(700, 340, 190, 150);
        Disposal_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Disposal_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        Disposal_Button.setForeground(Color.WHITE);
        Disposal_Button.setBackground(new Color(163, 189, 226));

        JButton Inv_Mng_Button = new JButton("재고관리");
        Inv_Mng_Button.setBounds(500, 500, 190, 150);
        Inv_Mng_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Inv_Mng_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        Inv_Mng_Button.setForeground(Color.WHITE);
        Inv_Mng_Button.setBackground(new Color(163, 189, 226));

        JButton P_C_Button = new JButton("시재점검");
        P_C_Button.setBounds(700, 500, 190, 150);
        P_C_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        P_C_Button.setFont(new Font("한컴 고딕", Font.BOLD, 38));
        P_C_Button.setForeground(Color.WHITE);
        P_C_Button.setBackground(new Color(163, 189, 226));


        // 버튼 이벤트
        P_C_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("시재점검");
            }
        });

        Inv_Mng_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("재고관리");
            }
        });

        Product_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("상품");
            }
        });

        Inbound_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("입고");
            }
        });

        orders_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("발주");
            }
        });

        Disposal_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                mainf.change("폐기");
            }
        });

        // 메인 패널 추가

        imagegui.add(P_C_Button);
        imagegui.add(Inv_Mng_Button);
        imagegui.add(Product_Button);
        imagegui.add(Inbound_Button);
        imagegui.add(orders_Button);
        imagegui.add(Disposal_Button);
//        imagegui.add(title);
        imagegui.setVisible(true);
    } // ------------------- 메인 패널 종료 -------------------
}