package subpanel;

import mainSearchgui.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_inbound extends JPanel {
    public c_main mainf;

    public c_inbound(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\입고GUI.png").getImage());
        setLayout(null);
        setSize(imagegui.getDim());
        setPreferredSize(new Dimension(imagegui.getDim()));
        add(imagegui);

        String MenuBar[] = { "메인", "시재점검", "재고관리", "상품", "발주", "폐기" };
        String[] header = { "barcode", "product_name", "count", "price"
                , "maindass" };

        JComboBox Main_back = new JComboBox<String>(MenuBar);
//        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(new Color(240, 240, 240));

        JButton Confirmation_Button = new JButton("확정");
        Confirmation_Button.setFont(new Font("고딕", Font.BOLD, 21));
//        Confirmation_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Confirmation_Button.setBackground(new Color(240, 240, 240));
        Confirmation_Button.setBounds(40+8, 520+56, 120, 41);

        JButton reference_Button = new JButton("조회");
        reference_Button.setFont(new Font("고딕", Font.BOLD, 21));
//        reference_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        reference_Button.setBackground(new Color(240, 240, 240));
        reference_Button.setBounds(220+8, 520+56, 120, 41);

        JPanel inv_table = new JPanel();
        inv_table.setLayout(null);
        inv_table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        inv_table.setBackground(Color.WHITE);
        inv_table.setBounds(40+8, 101+56, 867, 396);

        String [][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable cash = new JTable(model);
        JScrollPane cash_scroll = new JScrollPane(cash);

        cash.setRowHeight(25);
        cash.getTableHeader().setReorderingAllowed(false);
        cash.getTableHeader().setResizingAllowed(false);
        cash_scroll.setBorder(new LineBorder(Color.GRAY, 2));
        cash_scroll.setFont(new Font("고딕", Font.PLAIN, 20));
        cash_scroll.setBounds(12, 10, 843, 374);

        // ------------------- 버튼 이벤트
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

        reference_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String search = inv_mng_searchtext.getText();
                DefaultTableModel model = new DefaultTableModel(makecone.readData_inbound(),header);
                cash.setModel(model);
            }
        });

        Confirmation_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                for(int i = 1; i <= cash.getRowCount(); i++) {
                    Object barcode = cash.getValueAt(i,1);
                    Object name = cash.getValueAt(i,2);
                    Object count = cash.getValueAt(i,3);
                    Object price = cash.getValueAt(i,4);
                    Object main_class = cash.getValueAt(i,5);

                    inbound_data data = new inbound_data();
                    data.setBarcode(String.valueOf(barcode));
                    data.setProduct_name(String.valueOf(name));
                    data.setCount(String.valueOf(count));
                    data.setPrice(String.valueOf(price));
                    data.setMain_class(String.valueOf(main_class));

                    makecone.insertData_inbound(data);
                }
            }
        });

        // ------------------- 재고관리 패널 추가
//        imagegui.add(title);
        imagegui.add(Main_back);
        imagegui.add(inv_table);
//        Inv_Mng_Panel.add(inv_mng_DataAccess);
        imagegui.add(Confirmation_Button);
        imagegui.add(reference_Button);
        inv_table.add(cash_scroll);
    } // ------------------- 재고관리 패널 종료 -------------------
}
