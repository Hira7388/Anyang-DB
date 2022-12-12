package mainSearchgui.balsu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import mainSearchgui.*;
import mainSearchgui.balsu.*;

public class orders extends JPanel {
    public c_main mainf;
    String delbarcode = "";
    public orders(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\발주GUI.png").getImage());
        setLayout(null);
        String stock = "";
        String pname = "";
        String count = "";
        String barcode = "";
        this.add(imagegui);

        makecon kcon = new makecon();
        String MenuBar[] = { "메인", "재고관리", "시재점검", "상품", "입고", "폐기" };
        String[] header = {"barcode", "product_name", "count"
                , "price", "mainclass"};

        setSize(imagegui.getDim());
        setPreferredSize(new Dimension(imagegui.getDim()));

        JComboBox Main_back = new JComboBox<String>(MenuBar);
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(Color.WHITE);
//        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));

        JLabel stocktablename = new JLabel("재고 테이블");
        stocktablename.setLocation(200+10, 100+60);
        stocktablename.setFont(new Font("고딕",Font.BOLD, 17));
        stocktablename.setSize(720,20);

        JLabel wearingtablename = new JLabel("발주 테이블");
        wearingtablename.setFont(new Font("고딕",Font.BOLD, 17));
        wearingtablename.setLocation(200+10, 340+60);
        wearingtablename.setSize(720,20);

        String [][] data = makecon.readData();
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable StockTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(StockTable);

        scrollPane.setLocation(200+10, 130+60);
        scrollPane.setSize(720, 200);

/////////////////////////////////////
        DefaultTableModel model1 = new DefaultTableModel();
        JTable table2 = new JTable(model1);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        scrollPane2.setLocation(200+10, 370+60);
        scrollPane2.setSize(720, 200);

        JButton searchbtn = new JButton("조회");
        searchbtn.setLocation(20+10,160+60);
        searchbtn.setSize(150,40);
        searchbtn.setFont(new Font("고딕", Font.BOLD, 21));
        searchbtn.setBackground(new Color(240, 240, 240));
        JButton allretouchbtn = new JButton("일괄삭제");
        allretouchbtn.setLocation(20+10,210+60);
        allretouchbtn.setSize(150,40);
        allretouchbtn.setFont(new Font("고딕", Font.BOLD, 21));
        allretouchbtn.setBackground(new Color(240, 240, 240));
        JButton retouchbtn = new JButton("삭제");
        retouchbtn.setLocation(20+10,260+60);
        retouchbtn.setSize(150,40);
        retouchbtn.setFont(new Font("고딕", Font.BOLD, 21));
        retouchbtn.setBackground(new Color(240, 240, 240));

        JButton btn = new JButton("취소");
        btn.setLocation(20+10, 600+60);
        btn.setSize(100, 20);
        btn.setFont(new Font("고딕", Font.BOLD, 13));
        btn.setBackground(new Color(240, 240, 240));
        JButton btn1 = new JButton("검색");
        btn1.setLocation(130+10, 600+60);
        btn1.setSize(100, 20);
        btn1.setBackground(new Color(240, 240, 240));
        btn1.setFont(new Font("고딕", Font.BOLD, 13));
        btn1.addActionListener(new MyActionListener());
        JButton btn3 = new JButton("주간 수입");
        btn3.setLocation(240+10, 600+60);
        btn3.setSize(100, 20);
        btn3.addActionListener(new MyActionListener2());
        btn3.setFont(new Font("고딕", Font.BOLD, 13));
        btn3.setBackground(new Color(240, 240, 240));
        JButton btn2 = new JButton("확정");
        btn2.setLocation(830, 600+60);
        btn2.setSize(100, 20);
        btn2.setBackground(new Color(240, 240, 240));
        btn2.setFont(new Font("고딕", Font.BOLD, 13));

        imagegui.add(Main_back);
        imagegui.add(searchbtn);
        imagegui.add(allretouchbtn);
        imagegui.add(retouchbtn);

        imagegui.add(scrollPane);
        imagegui.add(scrollPane2);
        imagegui.add(stocktablename);
        imagegui.add(wearingtablename);
        imagegui.add(btn);
        imagegui.add(btn1);
        imagegui.add(btn2);
        imagegui.add(btn3);

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

        btn2.addActionListener(new ActionListener() { // 확정 버튼
            public void actionPerformed(ActionEvent e) {
                makecon.moveconf();
            }
        });

        searchbtn.addActionListener(new ActionListener() { // 검색 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.InquireData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

        retouchbtn.addActionListener(new ActionListener() { // 삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.deleteData(delbarcode);
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

        StockTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String product[] = new String[6];
                String test = "";
                int row = StockTable.getSelectedRow();
                int col = StockTable.getSelectedColumn();
                for (int i=0;i< StockTable.getColumnCount();i++){
                    product[i] = String.valueOf(StockTable.getModel().getValueAt(row,i));
                    System.out.println(product[i]);
                }
                delbarcode = product[0];

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

        allretouchbtn.addActionListener(new ActionListener() { // 일괄삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.alldeleteData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

    }

    //public static void main(String[] args) {
    //    new order();
    //}
}

class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        search sr = new search();
        sr.testfuc();
    }
}

class MyActionListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        WeeklyIncome gr = new WeeklyIncome();
        gr.fc();
    }
}

/*
class MyActionListenersearch implements ActionListener {
    public  void actionPerformed(ActionEvent e) {

        ArrayList<Data> arr = new ArrayList<Data>();


        // 전체 출력
        for (int i = 0; i < arr.size(); i++) {

        }
    }
}*/


/*
        DefaultMutableTreeNode open = new DefaultMutableTreeNode("열기");
        DefaultMutableTreeNode room = new DefaultMutableTreeNode("바구니");
        DefaultMutableTreeNode op = new DefaultMutableTreeNode("발주 옵션");
        DefaultMutableTreeNode cha = new DefaultMutableTreeNode("발주 수정");
        DefaultMutableTreeNode rm = new DefaultMutableTreeNode("발주 삭제");
        DefaultMutableTreeNode get = new DefaultMutableTreeNode("바구니 추가");

        open.add(room);
        open.add(op);
        op.add(cha);
        op.add(rm);
        op.add(get);
        JTree jt = new JTree(open);
        jt.setLocation(20, 160);
        jt.setSize(170, 420);

        c0.add(jt);
        myGUI.add(c0);
        */