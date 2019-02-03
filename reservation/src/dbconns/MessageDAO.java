package dbconns;

import java.util.List;
import beans.Message;

public interface MessageDAO {
	public List<Message> getall();
	public boolean add(String msgAuthor,String msgContent);
	public boolean publish(int msgID);
}
