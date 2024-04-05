CREATE INDEX events_slug_key ON events(slug);
CREATE INDEX attendees_event_id_key ON attendees(event_id, email);
CREATE INDEX check_ins_id_key ON check_ins(attendee_id);