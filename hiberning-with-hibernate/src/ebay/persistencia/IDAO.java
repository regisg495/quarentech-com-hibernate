package ebay.persistencia;

import java.util.List;

public interface IDAO <T> {
	
	public void save(T object);
	
	public T load(int id);
	
	public List<T> loadAll();
	
	public void delete(T object);

}
