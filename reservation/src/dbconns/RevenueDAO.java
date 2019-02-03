package dbconns;

import java.util.List;

import beans.Revenue;

public interface RevenueDAO {
	public boolean update(int rvnID, String rvnName, int rvnNum, double rvnPrice);
	public List<Revenue> getall();
	public int findprice(int rvnID);
}
