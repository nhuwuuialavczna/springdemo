CREATE TABLE TAIKHOAN (
  username          VARCHAR(100),
  password          VARCHAR(100),
  ten               NVARCHAR(100),
  diembaitap        INT,
  diemthuthach      INT,
  thoigiangianhap   VARCHAR(100),
  thanhtichthuthach VARCHAR(100),
  namsinh           VARCHAR(100),
  email             VARCHAR(1000),
  facebook          VARCHAR(1000),
  baitapdalam       NVARCHAR(2000),
  thuthachdalam     NVARCHAR(2000),
  gioithieu         NVARCHAR(1000),
  level             INT,
  loaithuthach      VARCHAR(100),
  thamgiathuthach   VARCHAR(1),
  role              VARCHAR(100),
  PRIMARY KEY (username)
);


CREATE TABLE BAINOP (
  mabaicode VARCHAR(100),
  username  VARCHAR(100),
  diem      INT,
  thoigian  VARCHAR(100),
  PRIMARY KEY (mabaicode, thoigian)
);

CREATE TABLE BAINOPTHUTHACH (
  macauhoi VARCHAR(100),
  username VARCHAR(100),
  soluong  INT,
  thoigian VARCHAR(100),
  PRIMARY KEY (macauhoi, thoigian)
);

CREATE TABLE MONTHUTHACH (
  mamonhoc  VARCHAR(100),
  tenmonhoc VARCHAR(100),
  PRIMARY KEY (mamonhoc)
);

CREATE TABLE CHEDOHAI (
  mamonhoc VARCHAR(100),
  thoigian VARCHAR(100),
  username VARCHAR(100),
  soluong  INT,
  PRIMARY KEY (thoigian),
  CONSTRAINT k20 FOREIGN KEY (username) REFERENCES TAIKHOAN (username)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE CHUONG (
  chuong    INT,
  tenchuong NVARCHAR(100),
  PRIMARY KEY (chuong)
);

CREATE TABLE THUTHACH (
  macauhoi  VARCHAR(100),
  cauhoi    NVARCHAR(3000),
  dapanA    VARCHAR(300),
  dapanB    VARCHAR(300),
  dapanC    VARCHAR(300),
  dapanD    VARCHAR(300),
  dapAnDung VARCHAR(300),
  mamonhoc  VARCHAR(100),
  thoigian  VARCHAR(100),
  level     INT,
  username  VARCHAR(100),
  PRIMARY KEY (macauhoi),
  CONSTRAINT k3 FOREIGN KEY (username) REFERENCES TAIKHOAN (username)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT k4 FOREIGN KEY (mamonhoc) REFERENCES MONTHUTHACH (mamonhoc)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE BINHLUAN (
  mabinhluan VARCHAR(100),
  username   VARCHAR(100),
  binhluan   NVARCHAR(1000),
  PRIMARY KEY (mabinhluan),
  CONSTRAINT k7 FOREIGN KEY (username) REFERENCES TAIKHOAN (username)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE TRALOIBINHLUAN (
  macautraloi VARCHAR(100),
  cautraloi   NVARCHAR(1000),
  mabinhluan  VARCHAR(100),
  username    VARCHAR(100),
  PRIMARY KEY (macautraloi),
  CONSTRAINT k8 FOREIGN KEY (mabinhluan) REFERENCES BINHLUAN (mabinhluan)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT k9 FOREIGN KEY (username) REFERENCES TAIKHOAN (username)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);


CREATE TABLE BAITAPCODE (
  mabaicode       VARCHAR(100),
  tenbaicode      NVARCHAR(300),
  noidung         NVARCHAR(3000),
  loaibai         VARCHAR(100),
  dulieutest      NVARCHAR(2000),
  dulieuoutput    VARCHAR(1000),
  inputvidu       NVARCHAR(1000),
  outputvidu      NVARCHAR(1000),
  thoigiangioihan INT,
  vietlaihammain  NVARCHAR(3000),
  interface       NVARCHAR(3000),
  superclass      NVARCHAR(3000),
  generic         NVARCHAR(3000),
  rangbuoc        VARCHAR(100),
  tenphuongthuc   VARCHAR(1000),
  danhsachthamso  VARCHAR(1000),
  thoigian        VARCHAR(100),
  thongtinthem    NVARCHAR(2000),
  mucdo           VARCHAR(100),
  kieutrave       VARCHAR(100),
  username        VARCHAR(100),
  PRIMARY KEY (mabaicode),
  CONSTRAINT k1 FOREIGN KEY (username) REFERENCES TAIKHOAN (username)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

