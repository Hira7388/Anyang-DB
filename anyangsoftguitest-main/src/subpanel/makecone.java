package subpanel;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class makecone {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    public static String url = "jdbc:mysql://127.0.0.1:3306/newmydb";
    public static String userName = "root";
    public static String password = "kji74335600@";
    public makecone() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch ( ClassNotFoundException e ) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public static void getConnection() {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt = conn.createStatement();
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }
    }
    public static void dbClose(){
        try{
            if(rs !=null)
                rs.close();
            if(stmt !=null)
                stmt.close();
            if(ps != null)
                ps.close();
        }catch(Exception e){
            System.out.println("tlqkf");
        }
    }
    public static void insertData(Pettycash_data data) {
        try {
            getConnection();
            String sql = "INSERT INTO cash(barcode, product_name, count, price) " + " VALUES(?, ?, ?, ?) ";
            // PrparedStatment객체 생성, 인자로 sql문이 주어짐
            ps = conn.prepareStatement(sql);

            System.out.println(data.cash_reserve);
            System.out.println(data.pos_cash);
            System.out.println(data.pos_cash_result);
            System.out.println(data.pos_result);

            ps.setString(1, data.cash_reserve);
            ps.setString(2, data.pos_cash);
            ps.setString(3, data.pos_cash_result);
            ps.setString(4, data.pos_result);// 개수라 하자
            // executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
    }

    public static void insertData_inbound(inbound_data data) {
        try {
            getConnection();
//            String sql = "INSERT INTO warehousing(barcode, product_name, count, price, mainclass) " + " VALUES(?, ?, ?, ?, ?)";
            // PrparedStatment객체 생성, 인자로 sql문이 주어짐
            String sql = "SELECT product_name, count FROM stock";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(rs.getString(1));
            int countresult = 0;
            int ct = 0;
            while(rs.next()) {
                if(rs.getString(1).equals(data.product_name)) {
                    countresult = Integer.valueOf(rs.getString(2)) + Integer.valueOf(data.count);
                    String sql2 = "UPDATE stock SET count="+countresult+"";
                    ps = conn.prepareStatement(sql2);
                    ps.executeUpdate();
                    ct++;
                    break;
                }
            }
            System.out.println(ct);
            if(ct != 0) {
                String sql3 = "INSERT INTO stock(barcode, product_name, count, price, mainclass)" + " VALUES(?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql3);
                ps.setString(1, data.barcode);
                ps.setString(2, data.product_name);
                ps.setString(3, data.count);
                ps.setString(4, data.price);
                ps.setString(5, data.main_class);

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
    }

    public static String[][] searchData_stock(String keyword) {
        ArrayList<String[]> arr = new ArrayList<>();
        System.out.println(keyword);

        try {
            getConnection();
            String sql = "SELECT * FROM stock WHERE product_name LIKE '%"+keyword+"%'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                arr.add(new String[] {
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][5];
            return arr.toArray(list);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(("연결 오류"));
            return null;
        } finally {
            dbClose();
        }
    }
    public static String[][] searchData_product(String keyword) {
        ArrayList<String[]> arr = new ArrayList<>();
        System.out.println(keyword);

        try {
            getConnection();
            String sql = "SELECT * FROM product WHERE product_name LIKE '%"+keyword+"%'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                arr.add(new String[] {
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][5];
            return arr.toArray(list);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(("연결 오류"));
            return null;
        } finally {
            dbClose();
        }
    }
    //opreating_reserve, total_cash
    public static String[][] readData() {
        try {
            String sql = "SELECT * FROM cash";
            getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<String[]> arr = new ArrayList<>();
            System.out.println(arr);
            // 받은 결과값을 출력
            while (rs.next()) {
                arr.add(new String[]{
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][7];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }

    public static String[][] readData_inbound() {
        try {
//            String sql = "SELECT * FROM warehousing";
            String sql = "SELECT * FROM newmydb.order";
            getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<String[]> arr = new ArrayList<>();
            System.out.println(arr);
            // 받은 결과값을 출력
            while (rs.next()) {
                arr.add(new String[]{
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][5];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }

    public static String[][] readData_product() {
        try {
//            String sql = "SELECT * FROM warehousing";
            String sql = "SELECT * FROM cash";
            getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<String[]> arr = new ArrayList<>();
            System.out.println(arr);
            // 받은 결과값을 출력
            while (rs.next()) {
                arr.add(new String[]{
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][4];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }
    public static String readData_productcash() {
        try {
//            String sql = "SELECT * FROM warehousing";
            String sql = "SELECT price FROM cash";
            getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            int cash_all = 0;
            // 받은 결과값을 출력
            while (rs.next()) {
                cash_all += Integer.valueOf(rs.getString(1));
            }
            return String.valueOf(cash_all);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }
    public static String[][] readData_stock() {
        try {
//            String sql = "SELECT * FROM warehousing";
            String sql = "SELECT * FROM stock";
            getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<String[]> arr = new ArrayList<>();
            System.out.println(arr);
            // 받은 결과값을 출력
            while (rs.next()) {
                arr.add(new String[]{
                        rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][5];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }

//    public static void main(String[] args) throws SQLException {
//        conn = DriverManager.getConnection(url, userName, password);
//        stmt = conn.createStatement();
//
//        String quer1 = "INSERT INTO cash VALUES (716,3841,429,31,436,3711,81)";
//        stmt.executeUpdate(quer1);
//    }
}
