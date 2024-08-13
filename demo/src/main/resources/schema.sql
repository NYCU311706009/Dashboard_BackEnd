CREATE TABLE machine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    current_state VARCHAR(20) NOT NULL,
    quantity INT NOT NULL,
    current_department VARCHAR(20) NOT NULL,
    current_area VARCHAR(20) NOT NULL
);
CREATE TABLE human (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department VARCHAR(20) NOT NULL,
    current_area VARCHAR(20) NOT NULL
);