INSERT INTO tb_user (name, email, password) VALUES ('Ana Brown', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Ação');
INSERT INTO tb_genre (name) VALUES ('Ficção');
INSERT INTO tb_genre (name) VALUES ('Drama');

INSERT INTO tb_movie (img_url, sub_title, synopsis, title, year, genre_id) VALUES ('imagem.jpg','Top gun','imagine uma synopsis aqui','Top gun: Maverick', 2022, 1);
INSERT INTO tb_movie (img_url, sub_title, synopsis, title, year, genre_id) VALUES ('imagem.jpg','Tinker bell','imagine uma synopsis aqui','Tinker bell: O segredo das fadas', 2008, 2);
INSERT INTO tb_movie (img_url, sub_title, synopsis, title, year, genre_id) VALUES ('imagem.jpg','Nada de novo no fronte','imagine uma synopsis aqui','Nada de novo no fronte', 2022, 3);

INSERT INTO tb_review (text, review_id, user_id) VALUES ('Estou sem palavras', 1, 2);
INSERT INTO tb_review (text, review_id, user_id) VALUES ('Excelente para assistir com a familia', 2, 1);