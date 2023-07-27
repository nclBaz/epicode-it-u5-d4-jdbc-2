package riccardogulin.u5d4jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import riccardogulin.u5d4jdbc.dao.UsersDAO;
import riccardogulin.u5d4jdbc.entities.User;

@Component
@Slf4j
public class UsersRunner implements CommandLineRunner {

	@Autowired // Spring hai un Bean di tipo UsersDAO nel tuo "scatolone" (application
				// context)?
	private UsersDAO uDAO;

	@Override
	public void run(String... args) throws Exception {
		User aldo = User.builder().name("Aldo").surname("Baglio").email("aldo@baglio.it").build();
		// User aldo = new User("Aldo", "Baglio", "aldo@baglio.it");

		// uDAO.save(aldo);

		int numeroModificati = uDAO.findByIdAndUpdate(2, aldo);
		log.info("Numero cancellati: " + numeroModificati);

		int numeroCancellati = uDAO.findByIdAndDelete(2);
		log.info("Numero cancellati: " + numeroCancellati);

		log.info("Count --> " + uDAO.count());

		log.info(uDAO.findById(3).toString());

		uDAO.findAll().forEach(user -> log.info(user.toString()));
	}

}
