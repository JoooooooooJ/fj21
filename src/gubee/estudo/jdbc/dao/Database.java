package gubee.estudo.jdbc.dao;
import java.util.List;

public interface Database<T> {
	
	public void add(Object obj);
	
	public void remove(Object obj);
	
	public void update(Object obj);
	
	public List<T> getList();

}
