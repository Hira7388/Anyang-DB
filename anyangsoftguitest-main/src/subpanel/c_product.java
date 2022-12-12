package subpanel;

import mainSearchgui.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_product extends JPanel {
    public c_main mainf;

    public c_product(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\판매내역GUI.png").getImage());
        setLayout(null);
        setSize(imagegui.getDim());
        setPreferredSize(new Dimension(imagegui.getDim()));
        this.add(imagegui);

        String MenuBar[] = { "메인", "시재점검", "재고관리", "입고", "발주", "폐기" };
        String[] header = { "barcode", "product_name", "count", "price" };

        // ------------------- 상품 패널 선언
        JComboBox Main_back = new JComboBox<String>(MenuBar);
//        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(Color.WHITE);

        JLabel title = new JLabel(" 상품");
        title.setFont(new Font("고딕", Font.BOLD, 40));
        title.setBounds(5, 5, 200, 50);
        title.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

//        JButton product_Reset = new JButton("리셋");
//        product_Reset.setFont(new Font("고딕", Font.BOLD, 21));
//        product_Reset.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
//        product_Reset.setBackground(new Color(240, 240, 240));
//        product_Reset.setBounds(278+8, 520+56, 120, 41);

        JButton product_Allcash = new JButton("총액");
        product_Allcash.setFont(new Font("고딕", Font.BOLD, 21));
//        product_search.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        product_Allcash.setBackground(new Color(240, 240, 240));
        product_Allcash.setBounds(650, 520+56, 120, 41);

        JTextField product_searchtext = new JTextField("");
        product_searchtext.setHorizontalAlignment(SwingConstants.RIGHT);
        product_searchtext.setFont(new Font("Dialog", Font.BOLD, 17));
        product_searchtext.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        product_searchtext.setBackground(new Color(240, 240, 240));
        product_searchtext.setBounds(769, 520+56, 146, 41);

        JPanel product_table = new JPanel();
        product_table.setLayout(null);
        product_table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        product_table.setBackground(Color.WHITE);
        product_table.setBounds(40+8, 101+56, 867, 396);

        String [][] data = makecone.readData_product();
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

//        product_Reset.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String search = product_searchtext.getText();
//                DefaultTableModel model = new DefaultTableModel(makecone.searchData_product(search),header);
//                cash.setModel(model);
//            }
//        });

        product_Allcash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                product_searchtext.setText(makecone.readData_productcash());

            }
        });

        // ------------------- 재고관리 패널 추가
//        this.add(title);
        imagegui.add(Main_back);
        imagegui.add(product_table);
//        Inv_Mng_Panel.add(inv_mng_DataAccess);
//        imagegui.add(product_Reset);
        imagegui.add(product_Allcash);
        imagegui.add(product_searchtext);
        product_table.add(cash_scroll);
    } // ------------------- 재고관리 패널 종료 -------------------
}
