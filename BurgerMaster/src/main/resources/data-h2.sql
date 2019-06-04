INSERT INTO USER (ID, EMAIL, PASSWORD, USERNAME) 
	VALUES (1, 'ivo.ivic@fer.hr', '$2a$10$NMA6zsuG/Xv75NzF4o3DkeyMWrinO5v4tVs0sTzKTIhXlhMri3a9.', 'ivo');
INSERT INTO USER (ID, EMAIL, PASSWORD, USERNAME) 
	VALUES (2, 'marko.markic@fer.hr', '$2a$10$NMA6zsuG/Xv75NzF4o3DkeyMWrinO5v4tVs0sTzKTIhXlhMri3a9.', 'marko');
INSERT INTO USER (ID, EMAIL, PASSWORD, USERNAME) 
	VALUES (3, 'ana.anic@fer.hr', '$2a$10$NMA6zsuG/Xv75NzF4o3DkeyMWrinO5v4tVs0sTzKTIhXlhMri3a9.', 'ana');
	
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (1, 'loodaSanjica', 2, 256);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (2, 'anaBanana', 5, 561);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (3, 'tomi45Bolek', 1, 68);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (4, 'ivek12pmf', 3, 317);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (5, 'evaTheKefa', 2, 288);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (6, 'tatYana', 1, 23);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (7, 'marko98', 5, 432);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (8, 'darko321', 2, 199);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (9, 'mislav123', 4, 311);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (10, 'ivanaeffzg', 1, 6);
INSERT INTO USER_STATS (ID, USERNAME, LEVEL, POINTS)
	VALUES (11, 'jelena', 4, 351);
	
INSERT INTO LEVEL (LEVEL, BURGER, DESCRIPTION, NAME, X, Y)
	VALUES (
		1, 
		'Cheeseburger', 
		'Start your burger making adventure in beautiful, but quiet Central Park! See if you can handle basic burgers and cheeseburgers.', 
		'Central Park', 
		231, 
		147
	);
	
INSERT INTO LEVEL (LEVEL, BURGER, DESCRIPTION, NAME, X, Y)
	VALUES (
		2, 
		'Mr. Tomato', 
		'Ready for more adventures in busier Lincoln Center? It always gets rough on days of performance. People, however, LOVE Mr. Tomato before AND after the show',
		'Lincoln Center',
		204,
		194
	);

INSERT INTO LEVEL (LEVEL, BURGER, DESCRIPTION, NAME, X, Y)
	VALUES (
		3, 
		'Royal', 
		'Not satisfied yet? Try making Royal in always crowded Grand Central Terminal without getting annoyed',
		'Grand Central Terminal',
		262,
		257
	);
	
INSERT INTO LEVEL (LEVEL, BURGER, DESCRIPTION, NAME, X, Y)
	VALUES (
		4, 
		'Onion Jam', 
		'What better combo than great concert in Madison Square Garden and Onion Jam? Even though people are everywhere, you get to listen concert for free!',
		'Madison Square Garden',
		226,
		291
	);
	
INSERT INTO LEVEL (LEVEL, BURGER, DESCRIPTION, NAME, X, Y)
	VALUES (
		5, 
		'Crispy Bacon', 
		'Wanna be on top of the world (Manhattan)? Become burger master chef in busy Wall Street. Business people hate to be waiting, but hey, if service is great, tips are awesome!',
		'Wall Street',
		256,
		449
	);