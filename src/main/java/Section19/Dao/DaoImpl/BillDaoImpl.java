package Section19.Dao.DaoImpl;

import Section19.Dao.BillDao;
import Section19.Dao.JDBCConnect;
import Section19.Model.Bill;
import Section19.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {
    private Connection connect = JDBCConnect.getConnection();

    @Override
    public void muaHang(Bill bill) {
        String sql = "INSERT INTO Bill (idbill,quantity, price, idproduct, buydate) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, bill.getQuantity());
            preparedStatement.setInt(2, bill.getQuantity());
            preparedStatement.setInt(3, bill.getPrice());
            preparedStatement.setInt(4, bill.getIdProduct());
            preparedStatement.setString(5, bill.getBuyDate());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Bill> search(String fromDate, String toDate) {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bill WHERE buydate BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setString(1, fromDate);
            preparedStatement.setString(2, toDate);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bills.add(new Bill(
                        rs.getInt("idbill"),
                        rs.getInt("quantity"),
                        rs.getInt("price"),
                        rs.getInt("idproduct"),
                        rs.getString("buydate")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

}
