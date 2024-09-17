DROP TABLE IF EXISTS machine_record;
DROP TABLE IF EXISTS machine;
DROP TABLE IF EXISTS human;


CREATE TABLE machine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    current_state VARCHAR(20) NOT NULL,
    current_department VARCHAR(20) NOT NULL,
    current_area VARCHAR(20) NOT NULL
);
CREATE TABLE human (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department VARCHAR(20) NOT NULL
);
CREATE TABLE machine_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    record_date DATE,
    quantity INT,
    machine_id BIGINT,
    CONSTRAINT fk_machine FOREIGN KEY (machine_id) REFERENCES machine(id)
);