INSERT INTO port ("name",capacity) VALUES
	 ('Дальний',5),
	 ('Солнечный',10),
	 ('Восточный',7);

INSERT INTO ship ("name",port_id,status) VALUES
	 ('Проворный',1,'PORT'),
	 ('Санта Мария',1,'PORT'),
	 ('Туман',1,'PORT'),
	 ('Буря',1,'PORT'),
	 ('Сказочный',1,'PORT'),
	 ('Грозный',2,'PORT'),
	 ('Восток',2,'PORT'),
	 ('Кудесник',3,'PORT'),
	 ('Арктика',NULL,'SEA'),
	 ('Москва',3,'PORT');