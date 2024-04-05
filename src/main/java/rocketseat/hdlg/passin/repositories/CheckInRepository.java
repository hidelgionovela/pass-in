package rocketseat.hdlg.passin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.hdlg.passin.domain.checkIn.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
//    Optional<CheckIn> findByAttendeeId(String attendeeId);

}