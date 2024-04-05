CREATE TABLE check_ins (
       id INTEGER NOT NULL PRIMARY KEY IDENTITY,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       attendee_id VARCHAR(255) NOT NULL,


       CONSTRAINT check_ins_attendees_id_fkey FOREIGN KEY (attendee_id) REFERENCES attendees (id) ON DELETE RESTRICT ON UPDATE CASCADE
--    ON DELETE RESTRICT -> para nao deixar deletar  um evento que ja tenha participantes.
--     On UPDATE CASCADE -> caso haja uma alteracao(update) na tabela eventos deve se refletir aqui nessa tabela
--     DEFAULT CURRENT_TIMESTAMP -> caso nao seja informado coloca a data actual o sistema
);