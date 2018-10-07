USE taunt;
CREATE TABLE CDC ( 
idCDC INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
typeCDC VARCHAR(100),
dureeCDC int,
nomLicence VARCHAR(100),
typeLicence VARCHAR(100),
FOREIGN KEY (refLicence) REFERENCES Licences (refLicence),
FOREIGN KEY (refExpert) REFERENCES Experts(refExpert)
);