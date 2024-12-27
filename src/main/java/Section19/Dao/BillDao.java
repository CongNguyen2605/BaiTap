package Section19.Dao;

import Section19.Model.Bill;

import java.util.List;

public interface BillDao {
    void muaHang(Bill bill);
    List<Bill> search(String fromDate,String toDate);
}
