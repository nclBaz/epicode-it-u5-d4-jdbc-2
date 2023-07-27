package riccardogulin.u5d4jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import riccardogulin.u5d4jdbc.entities.User;

public class UsersRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Metodo utilizzato ogni qualvolta io vada a leggere righe dal db
		// Serve per mappare ogni riga in un oggetto di tipo User
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String email = rs.getString("email");
		return new User(id, name, surname, email);
	}

}
