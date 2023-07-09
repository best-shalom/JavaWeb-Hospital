use hospital
CREATE TABLE patients (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Password VARCHAR(255),
    Gender VARCHAR(10),
    Age INT,
    Email VARCHAR(255),
    DateOfBirth DATE
);
