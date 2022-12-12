package pacDisposal;


import mainSearchgui.balsu.makecon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import mainSearchgui.*;


public class Disposal extends JPanel{
    static String delbarcode = "";
    public c_main mainf;
    public Disposal(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\폐기GUI.png").getImage());
        disposalmakecon dmakecon = new disposalmakecon();
        String MenuBar[] = { "메인", "재고관리", "상품", "입고", "발주", "폐기" };
        String header[] = {"barcode","product_name","count","price","mainclass"}; // 프레임 생성
        setSize(960, 720);
        setLayout(null);

        JComboBox Main_back = new JComboBox<String>(MenuBar);
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(Color.WHITE);
        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        // 레이아웃 설정
        //frm.getContentPane().setLayout(null);

        // 버튼 생성
        JButton registrationbtn = new JButton("폐기 등록");
        JButton retouchbtn = new JButton("폐기 수정");
        JButton inquirebtn = new JButton("폐기 조회");
        JButton Confirmationbtn = new JButton("확정");

        registrationbtn.setFont(new Font("고딕", Font.BOLD, 21));
        retouchbtn.setFont(new Font("고딕", Font.BOLD, 21));
        inquirebtn.setFont(new Font("고딕", Font.BOLD, 21));
        Confirmationbtn.setFont(new Font("고딕", Font.BOLD, 21));

        registrationbtn.setBackground(new Color(240, 240, 240));
        retouchbtn.setBackground(new Color(240, 240, 240));
        inquirebtn.setBackground(new Color(240, 240, 240));
        Confirmationbtn.setBackground(new Color(240, 240, 240));

        DefaultTableModel model1 = new DefaultTableModel();
        JTable disposaltable = new JTable(model1);
        JScrollPane scrollPane1 = new JScrollPane(disposaltable);

        scrollPane1.setLocation(230, 160);
        scrollPane1.setSize(680,350);

        imagegui.add(scrollPane1);

        JLabel insertbarcode = new JLabel("바코드");
        insertbarcode.setSize(200,20);
        insertbarcode.setLocation(230,515);
        JLabel insertproductname = new JLabel("상품명");
        insertproductname.setSize(200,20);
        insertproductname.setLocation(470,515);
        JLabel insertcount = new JLabel("개수");
        insertcount.setSize(200,20);
        insertcount.setLocation(710,515);

        JTextField barcodefiled = new JTextField("");
        barcodefiled.setSize(200,40);
        barcodefiled.setLocation(230,540);
        barcodefiled.setBackground(new Color(240, 240, 240));
        JTextField productnamefiled = new JTextField("");
        productnamefiled.setSize(200,40);
        productnamefiled.setLocation(470,540);
        productnamefiled.setBackground(new Color(240, 240, 240));
        JTextField countfiled = new JTextField("");
        countfiled.setSize(200,40);
        countfiled.setLocation(710,540);
        countfiled.setBackground(new Color(240, 240, 240));


        // 버튼 위치와 크기 설정
        registrationbtn.setBounds(50, 200, 130, 50);
        retouchbtn.setBounds(50, 300, 130, 50);
        inquirebtn.setBounds(50, 400, 130, 50);
        Confirmationbtn.setBounds(410, 620, 120, 41);

        imagegui.add(Main_back);
        imagegui.add(registrationbtn);
        imagegui.add(retouchbtn);
        imagegui.add(inquirebtn);
        imagegui.add(Confirmationbtn);
        imagegui.add(insertbarcode);
        imagegui.add(insertproductname);
        imagegui.add(insertcount);
        imagegui.add(barcodefiled);
        imagegui.add(productnamefiled);
        imagegui.add(countfiled);
        add(imagegui);

        Main_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                String selectMenu = Main_back.getSelectedItem().toString();
                if (selectMenu.equals("메인")) {
                    setVisible(false);
                    mainf.change("메인");
                }
                else if (selectMenu.equals("시재점검")) {
                    setVisible(false);
                    mainf.change("시재점검");
                }
                else if (selectMenu.equals("재고관리")) {
                    setVisible(false);
                    mainf.change("재고관리");
                }
                else if (selectMenu.equals("상품")) {
                    setVisible(false);
                    mainf.change("상품");
                }
                else if (selectMenu.equals("입고")) {
                    setVisible(false);
                    mainf.change("입고");
                }
                else if (selectMenu.equals("폐기")) {
                    setVisible(false);
                    mainf.change("폐기");
                }
                else if (selectMenu.equals("발주")) {
                    setVisible(false);
                    mainf.change("발주");
                }
            }
        });

        Confirmationbtn.addActionListener(new ActionListener() { // 확정 버튼
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<disposaltable.getColumnCount();i++) {
                    String getbarcode = (String) disposaltable.getValueAt(i,0);
                    String getcount = (String) disposaltable.getValueAt(i,2);
                    System.out.println(getcount);
                    dmakecon.conf(getbarcode, getcount);
                }
            }
        });

        retouchbtn.addActionListener(new ActionListener() { // 일괄삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = dmakecon.alldeleteData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                disposaltable.setModel(model);
            }
        });


        disposaltable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String product = "";
                String test = "";
                int row = disposaltable.getSelectedRow();
                int col = disposaltable.getSelectedColumn();

                product = String.valueOf(disposaltable.getModel().getValueAt(row,0));
                System.out.println(product);
                delbarcode = product;
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });



        registrationbtn.addActionListener(new ActionListener() { //등록 버튼
            public void actionPerformed(ActionEvent e) {
                String dbarcode = barcodefiled.getText();
                String dproductname = productnamefiled.getText();
                String dcount = countfiled.getText();

                dmakecon.moveD(dbarcode, dcount);
            }
        });

        inquirebtn.addActionListener(new ActionListener() { // 조회 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = disposalmakecon.disposalInquireData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                disposaltable.setModel(model);
            }
        });
    }
}
