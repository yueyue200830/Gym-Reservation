package dbconns;

import java.util.List;

public interface OrderDAO {
	public List<String> getall();
	public List<String> usergetall(int usrID);
	public int[][] available(int rvnID, String rvnDate);
	public boolean add(int usrID, String ordName, int rvnID, int rvnRoom,String ordPhone, double ordPrice, String rvnDate, int rvnTime);
	public boolean delete(int ordID);
}
