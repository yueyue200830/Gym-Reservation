package dbconns;

import java.util.List;

import beans.News;

public interface NewsDAO {
	public List<News> getall();
	public boolean add(String newTitle, String newContent, String newPhoto);
	
}