use master
go
Drop database DuAn1_BanQuanAoSport
go
create database DuAn1_BanQuanAoSport
go
use  DuAn1_BanQuanAoSport
go
create table MonTheThao
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[MonTheThao] VALUES ('BD',N'Bóng Đá' ,NULL ,NULL,1)
INSERT INTO [dbo].[MonTheThao] VALUES ('BC',N'Bóng Chuyền' ,NULL ,NULL,1)
INSERT INTO [dbo].[MonTheThao] VALUES ('CL',N'Cầu Lông' ,NULL ,NULL,1)
go
create table MauSac
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[MauSac] VALUES('ms1',N'Đỏ',NULL,NULL,1)
INSERT INTO [dbo].[MauSac] VALUES('ms2',N'vàng',NULL,NULL,1)
INSERT INTO [dbo].[MauSac] VALUES('ms3',N'Đen Ánh Đỏ formula',NULL,NULL,1)
go
create table Size
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Size NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[Size] VALUES ('s1','L',NULL,NULL,1)
INSERT INTO [dbo].[Size] VALUES ('s2','S',NULL,NULL,1)
INSERT INTO [dbo].[Size] VALUES ('s3','XL',NULL,NULL,1)
go
create table ChiTietSanPham
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) not null,
	Ten nvarchar(max) not null,
	IdMonTheThao int not null FOREIGN KEY REFERENCES MonTheThao(Id),
	IdMauSac int not null FOREIGN KEY REFERENCES MauSac(Id),
	IdSize int not null FOREIGN KEY REFERENCES Size(Id),
	Gia int,
        soLuong int,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP1',1,1,3,50000,50,NULL,NULL,1)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP3',1,2,1,70000,10,NULL,NULL,1)
INSERT INTO [dbo].[ChiTietSanPham] VALUES('SP2',2,1,2,55000,100,NULL,NULL,1)
go
CREATE TABLE ChucVu(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE, 
	TrangThai bit
) 
INSERT INTO [dbo].[ChucVu] VALUES('QL','ADMIN',NULL,NULL,1)
INSERT INTO [dbo].[ChucVu] VALUES('NV',N'Nhân Viên Bán Hàng',NULL,NULL,1)
go
CREATE TABLE NguoiDung(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT NOT NULL,
	NgaySinh DATE NOT NULL,
	Email VARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(MAX),
	IdChucVu int NOT NULL FOREIGN KEY REFERENCES dbo.ChucVu(Id),
	Anh varchar(max),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
INSERT INTO [dbo].[NguoiDung] VALUES('NV1',N'Đỗ Hữu Nguyện',1,'2003-06-14','nguyen@gmail.com',N'Tuyên Quang',1,NULL,NULL,NULL,1)
go
CREATE TABLE HinhThucThanhToan(
	Id int identity(1,1) PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit not null
)
INSERT INTO [dbo].[HinhThucThanhToan] VALUES ('HT1',N'Chuyển Khoản',NULL,NULL,1)
INSERT INTO [dbo].[HinhThucThanhToan] VALUES ('HT2',N'Tiền Mặt',NULL,NULL,1)
INSERT INTO [dbo].[HinhThucThanhToan] VALUES ('HT3',N'Quẹt Thẻ',NULL,NULL,1)
go
CREATE TABLE HoaDon(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IDNguoiDung int NOT NULL FOREIGN KEY REFERENCES dbo.NguoiDung(Id),
	IDHinhThucThanhToan int NOT NULL FOREIGN KEY REFERENCES dbo.HinhThucThanhToan(Id),
	NgayMua DATE NOT NULL,
	Sdt VARCHAR(10) NULL,
	DiaChi NVARCHAR(MAX),
	TongTien bigint null,
	TinhTrang BIT
)
INSERT INTO [dbo].[HoaDon] VALUES('HD1',1,2,'2022-1-27','0123123123',NULL,10000,1)
INSERT INTO [dbo].[HoaDon] VALUES('H2',1,2,'2022-2-27','0123123123',NULL,100000,1)
INSERT INTO [dbo].[HoaDon] VALUES('7261',1,2,'2022-3-27','0123123123',NULL,100000,1)
INSERT INTO [dbo].[HoaDon] VALUES('31243',1,2,'2022-4-27','0123123123',NULL,10000,1)
INSERT INTO [dbo].[HoaDon] VALUES('2523',1,2,'2022-5-27','0123123123',NULL,10000,1)
INSERT INTO [dbo].[HoaDon] VALUES('1231',1,2,'2022-6-27','0123123123',NULL,167896,1)
INSERT INTO [dbo].[HoaDon] VALUES('34653',1,2,'2022-7-27','0123123123',NULL,178967,1)
INSERT INTO [dbo].[HoaDon] VALUES('12431',1,2,'2022-8-27','0123123123',NULL,1796789,1)
INSERT INTO [dbo].[HoaDon] VALUES('HD5321',1,2,'2022-9-27','0123123123',NULL,18978797,1)
INSERT INTO [dbo].[HoaDon] VALUES('2342',1,2,'2022-10-27','0123123123',NULL,1897891)
INSERT INTO [dbo].[HoaDon] VALUES('6435',1,2,'2022-11-27','0123123123',NULL,17978,1)
INSERT INTO [dbo].[HoaDon] VALUES('1231',1,2,'2022-12-27','0123123123',NULL,178978,1)
INSERT INTO [dbo].[HoaDon] VALUES('53463',1,2,'2022-1-27','0123123123',NULL,187977,1)
INSERT INTO [dbo].[HoaDon] VALUES('563',1,2,'2022-3-27','0123123123',NULL,178978,1)
INSERT INTO [dbo].[HoaDon] VALUES('HD143211',1,2,'2022-4-27','0123123123',NULL,17899,1)
INSERT INTO [dbo].[HoaDon] VALUES('1341234',1,2,'2022-1-27','0123123123',NULL,187978,1)
INSERT INTO [dbo].[HoaDon] VALUES('345',1,2,'2022-6-27','0123123123',NULL,1789789,1)
INSERT INTO [dbo].[HoaDon] VALUES('4652',1,2,'2022-11-27','0123123123',NULL,17897,1)
INSERT INTO [dbo].[HoaDon] VALUES('2342',1,2,'2022-11-27','0123123123',NULL,1789777,1)
go
CREATE TABLE HoaDonChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdHoaDon int FOREIGN KEY REFERENCES dbo.HoaDon(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSanPham(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)
CREATE TABLE GioHang(
	Id int identity(1,1) PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	NgayTao DATE NOT NULL,
	TrangThai BIT not null 
)
CREATE TABLE GioHangChiTiet(
	Id int identity(1,1) PRIMARY KEY,
	IdGioHang int FOREIGN KEY REFERENCES dbo.GioHang(Id) NOT NULL,
	IdSanPham int FOREIGN KEY REFERENCES dbo.ChiTietSanPham(Id) NOT NULL,
	SoLuong INT NOT NULL,
	DonGia BIGINT NOT NULL,
	ThanhTien BIGINT NOT NULL,
	TrangThai bit not null
)
CREATE TABLE Account(
	Id int identity(1,1) PRIMARY KEY,
	UserName NVARCHAR(50) NOT NULL,
	Pass NVARCHAR(18) not null,
	IdNguoiDung int FOREIGN KEY REFERENCES dbo.NguoiDung(Id) NOT NULL,
	TrangThai int
)
INSERT INTO [dbo].[Account] VALUES('nguyen@gmail.com','1',1,1)