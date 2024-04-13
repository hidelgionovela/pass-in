package rocketseat.hdlg.passin.dto.attendee;

import java.util.List;
public record AttendeesListResponseDTO (List<AttendeeDetails> attendees) {
    public static record AttendeeBadgeResponseDTO(AttendeeBadgeDTO badge) {

    }
}
