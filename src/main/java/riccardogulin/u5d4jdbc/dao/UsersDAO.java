package riccardogulin.u5d4jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import riccardogulin.u5d4jdbc.entities.User;

@Repository // Specializzazione di @Component
public class UsersDAO implements IUsersDAO {

	@Autowired
	private JdbcTemplate jdbcT;

	@Override
	public void save(User user) {
		String sql = "INSERT INTO users (name, surname, email) VALUES (?, ?, ?)";
		jdbcT.update(sql, user.getName(), user.getSurname(), user.getEmail());

	}

	@Override
	public int findByIdAndUpdate(int id, User user) {
		String sql = "UPDATE users SET name=?, surname=?, email=? WHERE id=?";
		return jdbcT.update(sql, user.getName(), user.getSurname(), user.getEmail(), id);
		
	}

	@Override
	public int findByIdAndDelete(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		return jdbcT.update(sql, id);
		
	}

	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbcT.queryForObject(sql, new UsersRowMapper(), id);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		return jdbcT.query(sql, new UsersRowMapper());
	}

	@Override
	public int count() {
		String sql = "SELECT COUNT(*) FROM users";

		return jdbcT.queryForObject(sql, Integer.class);
	}

}
