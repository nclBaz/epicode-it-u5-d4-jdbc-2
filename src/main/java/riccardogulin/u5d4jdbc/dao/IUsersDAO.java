package riccardogulin.u5d4jdbc.dao;

import java.util.List;

import riccardogulin.u5d4jdbc.entities.User;

public interface IUsersDAO {
	public void save(User user);

	public int findByIdAndUpdate(int id, User user);

	public int findByIdAndDelete(int id);

	public User findById(int id);

	public List<User> findAll();

	public int count();
}
