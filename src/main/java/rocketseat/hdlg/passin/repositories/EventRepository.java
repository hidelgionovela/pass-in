package rocketseat.hdlg.passin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.hdlg.passin.domain.event.Event;

public interface EventRepository extends JpaRepository<Event, String> {

}
