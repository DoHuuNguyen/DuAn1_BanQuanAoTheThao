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
create table MauSac
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
create table Size
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) NOT NULL,
	Size NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
create table ChiTietSanPham
(
	Id int identity(1,1) PRIMARY KEY NOT NULL,
	Ma NVARCHAR(10) not null,
	IdMonTheThao int not null FOREIGN KEY REFERENCES MonTheThao(Id),
	IdMauSac int not null FOREIGN KEY REFERENCES MauSac(Id),
	IdSize int not null FOREIGN KEY REFERENCES Size(Id),
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit
)
CREATE TABLE ChucVu(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgayThem DATE,
	NgaySua DATE, 
	TrangThai bit
) 
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
CREATE TABLE HinhThucThanhToan(
	Id int identity(1,1) PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	Ten NVARCHAR(30) NOT NULL,
	NgayThem DATE,
	NgaySua DATE,
	TrangThai bit not null
)
CREATE TABLE HoaDon(
	Id int identity(1,1) NOT NULL PRIMARY KEY,
	Ma NVARCHAR(10) NOT NULL,
	IDNguoiDung int NOT NULL FOREIGN KEY REFERENCES dbo.NguoiDung(Id),
	IDHinhThucThanhToan int NOT NULL FOREIGN KEY REFERENCES dbo.HinhThucThanhToan(Id),
	NgayMua DATE NOT NULL,
	Sdt VARCHAR(10) NOT NULL,
	DiaChi NVARCHAR(MAX),
	TongTien bigint not null,
	TinhTrang BIT
)
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