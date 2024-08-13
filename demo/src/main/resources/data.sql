INSERT INTO machine (current_state, quantity, current_department, current_area) VALUES 
('PRODUCTION', 100, 'PRODUCTION', 'A'),
('MALFUNCTION', 200, 'EQUIPMENT', 'B'),
('MAINTENANCE', 300, 'TESTING', 'C'),
('IDLE', 100, 'ENGINEER', 'D');

INSERT INTO human (department, current_area) VALUES 
('PRODUCTION', 'A'),
('EQUIPMENT', 'B'),
('TESTING', 'C'),
('ENGINEER', 'D');
