package subpanel;

import mainSearchgui.*;
import mainSearchgui.balsu.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_stock extends JPanel {
    public c_main mainf;

    public c_stock(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\재고관리GUI.png").getImage());
        this.setLayout(null);
        this.setSize(imagegui.getDim());
        this.setPreferredSize(new Dimension(imagegui.getDim()));
        this.add(imagegui);

        String MenuBar[] = { "메인", "시재점검", "상품", "입고", "발주", "폐기" };
        String[] header = { "barcode", "product_name", "count", "price", "mainclass" };

        // ------------------- 재고관리 패널 선언
        JComboBox Main_back = new JComboBox<String>(MenuBar);
//        Main_back.setBorder(UIManager.getBorder("ScrollPane.border"));
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(Color.WHITE);

//        JLabel title = new JLabel(" 재고관리");
//        title.setFont(new Font("고딕", Font.BOLD, 40));
//        title.setBounds(5, 5, 200, 50);
//        title.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

//        JButton inv_mng_DataAccess = new JButton("확정");
//        inv_mng_DataAccess.setFont(new Font("고딕", Font.BOLD, 21));
//        inv_mng_DataAccess.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
//        inv_mng_DataAccess.setBackground(Color.WHITE);
//        inv_mng_DataAccess.setBounds(40, 520, 120, 41);

        JButton inv_mng_DataReset = new JButton("리셋");
        inv_mng_DataReset.setFont(new Font("고딕", Font.BOLD, 21));
//        inv_mng_DataReset.setBorder(UIManager.getBorder("ScrollPane.border"));
        inv_mng_DataReset.setBackground(new Color(240, 240, 240));
        inv_mng_DataReset.setBounds(278+8, 520+60, 120, 41);

        JButton inv_mng_search = new JButton("검색");
        inv_mng_search.setFont(new Font("고딕", Font.BOLD, 21));
//        inv_mng_search.setBorder(UIManager.getBorder("ScrollPane.border"));
        inv_mng_search.setBackground(new Color(240, 240, 240));
        inv_mng_search.setBounds(408+8, 520+60, 120, 41);

        JTextField inv_mng_searchtext = new JTextField("");
        inv_mng_searchtext.setHorizontalAlignment(SwingConstants.RIGHT);
        inv_mng_searchtext.setFont(new Font("Dialog", Font.BOLD, 17));
        inv_mng_searchtext.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        inv_mng_searchtext.setBackground(new Color(240, 240, 240));
        inv_mng_searchtext.setBounds(527+8, 520+60, 379, 41);

        JPanel inv_table = new JPanel();
        inv_table.setLayout(null);
        inv_table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        inv_table.setBackground(Color.WHITE);
        inv_table.setBounds(40+8, 101+56, 867, 396);

        String [][] data = makecone.readData_stock();
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

        inv_mng_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search = inv_mng_searchtext.getText();
                DefaultTableModel model = new DefaultTableModel(makecone.searchData_stock(search),header);
                cash.setModel(model);
            }
        });

        inv_mng_DataReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                DefaultTableModel model = new DefaultTableModel(makecone.readData_stock(),header);
                inv_mng_searchtext.setText("");
                cash.setModel(model);
            }
        });

        // ------------------- 재고관리 패널 추가
//        imagegui.add(title);
        imagegui.add(Main_back);
        imagegui.add(inv_table);
//        Inv_Mng_Panel.add(inv_mng_DataAccess);
        imagegui.add(inv_mng_DataReset);
        imagegui.add(inv_mng_search);
        imagegui.add(inv_mng_searchtext);
        inv_table.add(cash_scroll);
    } // ------------------- 재고관리 패널 종료 -------------------
}
