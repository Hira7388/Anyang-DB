package subpanel;

import mainSearchgui.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class c_pettycash extends JPanel {
    public c_main mainf;
    public int numresult;
    public final int c_r = 100000;
    public c_pettycash(c_main mainf) {
        this.mainf = mainf;
        ImagePanel imagegui = new ImagePanel(new ImageIcon("F:\\22년 2학기\\소공 조별과제\\java_imagesource\\시재점검GUI.png").getImage());
        setLayout(null);
        setSize(imagegui.getDim());
        setPreferredSize(new Dimension(imagegui.getDim()));
        this.add(imagegui);

        String MenuBar[] = { "메인", "재고관리", "상품", "입고", "발주", "폐기" };
        String header[] = { "권종", "수량", "금액" };
        String Cash[] = { "50,000원", "10,000원", "5,000원 ", "1,000원 ", "500원 ", "100원 ", "50원 ", "10원 " };

        // ------------------- 시재점검 패널 선언
        JComboBox Main_back = new JComboBox<String>(MenuBar);
        Main_back.setBounds(854, 40, 80, 40);
        Main_back.setBackground(Color.WHITE);
//        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));

//        JLabel title = new JLabel(" 시재점검");
//        title.setFont(new Font("고딕", Font.BOLD, 40));
//        title.setBounds(5, 5, 200, 50);
//        title.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JButton P_C_Button = new JButton("시재점검");
        P_C_Button.setFont(new Font("고딕", Font.BOLD, 21));
//        P_C_Button.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        P_C_Button.setBackground(new Color(240, 240, 240));
        P_C_Button.setBounds(172+23, 520+56, 130, 41);

        JButton P_C_DataFailed = new JButton("취소");
        P_C_DataFailed.setFont(new Font("고딕", Font.BOLD, 21));
//        P_C_DataFailed.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        P_C_DataFailed.setBackground(new Color(240, 240, 240));
        P_C_DataFailed.setBounds(633, 520+56, 130, 41);

        // ------------------- 왼쪽 패널
        JPanel Pos_cash = new JPanel();
        Pos_cash.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Pos_cash.setBackground(Color.white);
        Pos_cash.setBounds(40+8, 101+56, 426, 396);
        Pos_cash.setLayout(null);

        JPanel cash = new JPanel();
        cash.setLayout(new GridLayout(9,3));
        cash.setBounds(12,10,401,304);
        cash.setBackground(Color.WHITE);

        JLabel Option[] = new JLabel[3];
        JLabel Bills[] = new JLabel[8];
        JTextField Bills_num[] = new JTextField[8];
        JLabel Bills_result[] = new JLabel[8];

        for (int i = 0; i < Option.length; i++) {
            Option[i] = new JLabel(header[i]);
            Option[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            Option[i].setFont(new Font("Dialog", Font.BOLD, 17));
            Option[i].setHorizontalAlignment(SwingConstants.CENTER);
            cash.add(Option[i]);
        }
        for (int i = 0; i < Bills.length; i++) {
            Bills[i] = new JLabel(Cash[i]);
            Bills[i].setOpaque(true);
            Bills[i].setFont(new Font("Dialog", Font.PLAIN, 17));
            Bills[i].setBackground(new Color(240, 240, 240));
            Bills[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            Bills[i].setHorizontalAlignment(SwingConstants.RIGHT);
            cash.add(Bills[i]);
            Bills_num[i] = new JTextField("");
            Bills_num[i].setFont(new Font("Dialog", Font.BOLD, 17));
            Bills_num[i].setBackground(new Color(240, 240, 240));
            Bills_num[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            Bills_num[i].setHorizontalAlignment(SwingConstants.RIGHT);
//            Bills_num[i].addActionListener(new Keys());
            cash.add(Bills_num[i]);
            Bills_result[i] = new JLabel("0");
            Bills_result[i].setOpaque(true);
            Bills_result[i].setBackground(new Color(240, 240, 240));
            Bills_result[i].setFont(new Font("Dialog", Font.BOLD, 17));
            Bills_result[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            Bills_result[i].setHorizontalAlignment(SwingConstants.RIGHT);
            cash.add(Bills_result[i]);
        }

        JTextField cash_sumtext = new JTextField();
        cash_sumtext.setBounds(238, 334, 116, 32);
        cash_sumtext.setFont(new Font("Dialog", Font.BOLD, 24));
        cash_sumtext.setBorder(null);
        cash_sumtext.setColumns(10);

        JLabel cash_sum = new JLabel("실현금 :");
        cash_sum.setOpaque(true);
        cash_sum.setBorder(null);
        cash_sum.setBackground(Color.WHITE);
        cash_sum.setFont(new Font("고딕", Font.BOLD, 24));
        cash_sum.setBounds(132, 334, 93, 32);
        cash_sum.setHorizontalAlignment(JLabel.RIGHT);

        int j;
        final int[] sr = new int[1];
        for (j = 0; j < Bills.length; j++) {
            int finalJ = j;
            Bills_num[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String num = Bills_num[finalJ].getText();
                    int to = Integer.parseInt(num);
                    numresult = 0;
                    switch (finalJ) {
                        case 0 :
                            int result = to * 50000;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 1 :
                            result = to * 10000;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 2 :
                            result = to * 5000;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 3 :
                            result = to * 1000;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 4 :
                            result = to * 500;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 5 :
                            result = to * 100;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 6 :
                            result = to * 50;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                        case 7 :
                            result = to * 10;
                            Bills_result[finalJ].setText(String.valueOf(result));
                            break;
                    }

                    for(int i = 0; i < Bills_result.length; i++) {
                        numresult += Integer.parseInt(Bills_result[i].getText());
                    }
                    cash_sumtext.setText(String.valueOf(numresult));
                    sr[0] = numresult;
                }
            });
        }

        // ------------------- 오른쪽 패널
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        result.setBackground(Color.white);
        result.setBounds(476+8, 101+56, 426, 396);
        result.setLayout(null);

        JLabel cash_res = new JLabel("영업준비금  ");
        cash_res.setFont(new Font("Dialog", Font.BOLD, 17));
        cash_res.setHorizontalAlignment(JLabel.RIGHT);
        cash_res.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        cash_res.setBounds(12, 106, 187, 46);

        JLabel pos_cash = new JLabel("POS 계산상 현금  ");
        pos_cash.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_cash.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_cash.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_cash.setBounds(12, 150, 187, 46);

        JLabel pos_cash_result = new JLabel("입력하신 현금  ");
        pos_cash_result.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_cash_result.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_cash_result.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_cash_result.setBounds(12, 194, 187, 46);

        JLabel pos_result = new JLabel("차액  ");
        pos_result.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_result.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_result.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_result.setBounds(12, 238, 187, 46);

        JLabel cash_res_1 = new JLabel("");
        cash_res_1.setHorizontalAlignment(SwingConstants.RIGHT);
        cash_res_1.setFont(new Font("Dialog", Font.BOLD, 17));
        cash_res_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        cash_res_1.setBounds(197, 106, 217, 46);

        JLabel pos_cash_1 = new JLabel("");
        pos_cash_1.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_cash_1.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_cash_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_cash_1.setBounds(197, 150, 217, 46);

        JLabel pos_cash_result_1 = new JLabel("");
        pos_cash_result_1.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_cash_result_1.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_cash_result_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_cash_result_1.setBounds(197, 194, 217, 46);

        JLabel pos_result_1 = new JLabel("");
        pos_result_1.setHorizontalAlignment(SwingConstants.RIGHT);
        pos_result_1.setFont(new Font("Dialog", Font.BOLD, 17));
        pos_result_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        pos_result_1.setBounds(197, 238, 217, 46);

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

        P_C_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cash_res_1.setText(String.valueOf(c_r));
                pos_cash_1.setText(makecone.readData_productcash()); // db값
                pos_cash_result_1.setText(String.valueOf(numresult));
                int num = Integer.parseInt(cash_res_1.getText()) + Integer.parseInt(pos_cash_result_1.getText()) - Integer.parseInt(pos_cash_1.getText());
                pos_result_1.setText(String.valueOf(num));
            }
        });

        P_C_DataFailed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < Bills_num.length; i++) {
                    Bills_num[i].setText("");
                    Bills_result[i].setText("0");
                    cash_sumtext.setText("");
                }
                cash_res_1.setText("");
                pos_cash_1.setText("");
                pos_cash_result_1.setText("");
                pos_result_1.setText("");
            }
        });
        // ------------------- 시재점검 패널 추가
//        imagegui.add(title);
        imagegui.add(Pos_cash);
        imagegui.add(Main_back);
        imagegui.add(Pos_cash);
        imagegui.add(P_C_Button);
        imagegui.add(result);
        imagegui.add(P_C_DataFailed);

//        Pos_cash.add(cash_scroll);
        Pos_cash.add(cash);
        Pos_cash.add(cash_sum);
        Pos_cash.add(cash_sumtext);

        result.add(cash_res);
        result.add(pos_cash);
        result.add(pos_cash_result);
        result.add(pos_result);
        result.add(cash_res_1);
        result.add(pos_cash_1);
        result.add(pos_cash_result_1);
        result.add(pos_result_1);
    }
}
