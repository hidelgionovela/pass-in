CREATE TABLE attendees (
       id VARCHAR(255) NOT NULL PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       event_id VARCHAR(255) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

       CONSTRAINT attendees_event_id_fkey FOREIGN KEY (event_id) REFERENCES events (id) ON DELETE RESTRICT ON UPDATE CASCADE
--    ON DELETE RESTRICT -> para nao deixar deletar  um evento que ja tenha participantes.
--     On UPDATE CASCADE -> caso haja uma alteracao(update) na tabela eventos deve se refletir aqui nessa tabela
--     DEFAULT CURRENT_TIMESTAMP -> caso nao seja informado coloca a data actual o sistema
);