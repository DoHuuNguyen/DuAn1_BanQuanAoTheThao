-- QLSV.dbo.lophoc definition

-- Drop table

-- DROP TABLE QLSV.dbo.lophoc;

CREATE TABLE QLSV.dbo.lophoc (
	ma_lop int IDENTITY(1,1) NOT NULL,
	ten_lop varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__lophoc__0B8BCDEE79A063C9 PRIMARY KEY (ma_lop)
);


-- QLSV.dbo.sinhvien definition

-- Drop table

-- DROP TABLE QLSV.dbo.sinhvien;

CREATE TABLE QLSV.dbo.sinhvien (
	ma_sinh_vien int IDENTITY(1,1) NOT NULL,
	ten_sinh_vien varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	dia_chi varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	ma_lop int NULL,
	CONSTRAINT PK__sinhvien__A8B3B5564CD72C3C PRIMARY KEY (ma_sinh_vien),
	CONSTRAINT FK__sinhvien__ma_lop__398D8EEE FOREIGN KEY (ma_lop) REFERENCES QLSV.dbo.lophoc(ma_lop)
);

INSERT INTO QLSV.dbo.lophoc (ten_lop) VALUES
	 (N'UDPM'),
	 (N'WEB');

INSERT INTO QLSV.dbo.sinhvien (ten_sinh_vien,dia_chi,ma_lop) VALUES
	 (N'Dang Quang Minh',N'Ha Noi',1),
	 (N'Pham Gia Khanh',N'Tuyen Quang',1),
	 (N'Nguyen Van C',N'Lang Son',1),
	 (N'Tran Tuan Phong',N'Ha Noi',2),
	 (N'Nguyen Anh Dung',N'Tay Nguyen',2),
	 (N'Nguyen Van Son',N'Thai Nguyen',1),
	 (N'Duong Tiet Son',N'Ha Noi',1),
	 (N'Duong Tiet Son',N'Ha Noi1',2);