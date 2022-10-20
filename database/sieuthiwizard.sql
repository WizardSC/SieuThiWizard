-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 29, 2022 lúc 05:31 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sieuthiwizard`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaHD` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MaHD`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('HD01', 'SP01', 'Mì nấu MAXKEY Hương Vị Kim Chi', 10, 6000, 6000),
('HD01', 'SP02', 'Mì nấu MAXKEY Hương Vị Hải Sản', 10, 5900, 59000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietpn`
--

CREATE TABLE `chitietpn` (
  `MaPN` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietpn`
--

INSERT INTO `chitietpn` (`MaPN`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('PN01', 'SP01', 'Mì nấu MAXKEY Hương Vị Kim Chi', 10, 4400, 44000),
('PN01', 'SP02', 'Mì nấu MAXKEY Hương Vị Hải Sản', 10, 4500, 45000),
('PN02', 'SP03', 'Bún Hằng Nga - Bún Bò Huế', 20, 3500, 70000),
('PN02', 'SP04', 'Bún Hằng Nga - Bún Giò Heo', 50, 4500, 225000),
('PN02', 'SP05', 'Bún Hằng Nga - Bún Mắm', 50, 4500, 225000),
('PN02', 'SP06', 'Bún Hằng Nga - Bún Tôm Chua Cay', 50, 3500, 175000),
('PN03', 'SP07', 'Bánh hỗn hợp hộp thiếc Goody 908 gam', 10, 15000, 150000),
('PN03', 'SP23', 'Mặt Nạ Sữa Chua Dâu Vedette 120Ml', 25, 10000, 250000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaKH` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNV` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayLap` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('HD01', 'KH03', 'NV04', '28/05/2022', 113050);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` char(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ho` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgaySinh` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoHD` int(10) NOT NULL,
  `IMG` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SoDT`, `SoHD`, `IMG`) VALUES
('KH01', 'So', 'Junghwan', '18/02/2005', 'Nam', 'South Korea', '18022005', 0, 'Junghwan.jpg'),
('KH03', 'Watanabe', 'Haruto', '05/04/2004', 'Nam', 'South Korea', '05042004', 1, 'Haruto.jpg'),
('KH04', 'Son', 'Dongwoon', '06/06/1991', 'Nam', 'South Korea', '06061991', 0, 'Dongwoon.jpg'),
('KH05', 'Kwak', 'Aaron', '21/05/1993', 'Nam', 'USA', '21051993', 0, 'Aaron.jpg'),
('KH06', 'Kim', 'Jonghyun', '08/06/1995', 'Nam', 'South Korea', '08061995', 0, ''),
('KH07', 'Kang', 'Dongho', '21/07/1995', 'Nam', 'South Korea', '21071995', 0, ''),
('KH08', 'Hwang', 'Minhyun', '09/08/1995', 'Nam', 'South Korea', '09081995', 0, 'null'),
('KH09', 'Choi', 'Mingi', '03/11/1995', 'Nam', 'South Korea', '03111995', 0, 'null'),
('KH10', 'Kim', 'Jisoo', '03/01/1995', 'Nữ', 'South Korea', '03011995', 0, 'Jisoo.jpg'),
('KH11', 'Kim', 'Jennie', '16/01/1996', 'Nữ', 'South Korea', '16011996', 0, 'Jennie.jpg'),
('KH12', 'Park', 'Chaeyoung', '11/02/1997', 'Nữ', 'New Zealand', '11021997', 0, 'Chaeyoung.jpg'),
('KH13', 'Manobal', 'Lalisa', '27/03/1997', 'Nữ', 'Thailand', '27031997', 0, 'Lalisa.jpg'),
('KH14', 'Park', 'Bom', '24/03/1984', 'Nữ', 'South Korea', '24031984', 0, 'Bom.jpg'),
('KH15', 'Park', 'Sandara', '12/11/1984', 'Nữ', 'South Korea', '12111984', 0, 'Sandara.jpg'),
('KH16', 'Lee', 'Chaelim', '26/02/1991', 'Nữ', 'South Korea', '26021991', 0, 'Chaelim.jpg'),
('KH17', 'Gong', 'Minzy', '18/01/1994', 'Nữ', 'South Korea', '18011994', 0, 'Minzy.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenKM` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PhanTramKM` int(11) NOT NULL,
  `DieuKien` int(20) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `PhanTramKM`, `DieuKien`, `NgayBatDau`, `NgayKetThuc`) VALUES
('KM01', 'Hè Nóng Bức - Giảm Ngay 10%', 10, 250000, '2022-05-15', '2022-05-24'),
('KM02', 'Hè Nóng Bức - Giảm Ngay 12%', 12, 500000, '2022-05-15', '2022-05-24'),
('KM03', 'Hè Nóng Bức - Giảm Ngay 15%', 12, 1000000, '2022-05-15', '2022-05-24'),
('KM04', 'Tết Thiếu Nhi - Giảm Ngay 5%', 5, 100000, '2022-05-24', '2022-06-02'),
('KM05', 'Tết Thiếu Nhi - Giảm Ngay 10%', 10, 500000, '2022-05-24', '2022-06-02'),
('KM06', 'Con Ve Kêu E E (Giảm sốc 8%)', 8, 200000, '2022-06-03', '2022-06-12'),
('KM07', 'Con Ve Kêu E E (Giảm sốc 10%)', 10, 600000, '2022-06-03', '2022-06-12'),
('KM08', 'Con Ve Kêu E E (Giảm sốc 12%)', 12, 800000, '2022-06-03', '2022-06-12'),
('KM09', 'Giải Nhiệt Ngày Hè - Giảm Ngay 5%', 5, 100000, '2022-06-13', '2022-06-24'),
('KM10', 'Giải Nhiệt Ngày Hè - Giảm Ngay 10%', 10, 200000, '2022-06-13', '2022-06-24'),
('KM11', 'Giải Nhiệt Ngày Hè - Giảm Ngay 13%', 13, 600000, '2022-06-13', '2022-06-24');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MaLoai` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenLoai` char(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`) VALUES
('L01', 'Thực phẩm'),
('L02', 'Bánh kẹo'),
('L03', 'Hóa phẩm'),
('L04', 'Mỹ phẩm'),
('L05', 'Đồ uống'),
('L06', 'Giấy'),
('L07', 'Mẹ và Bé'),
('L08', 'Dệt may, Thời trang'),
('L09', 'Văn phòng phẩm'),
('L10', 'Đồ chơi'),
('L11', 'Sữa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNCC` char(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoFAX` char(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDT`, `SoFAX`) VALUES
('NCC01', 'Vinamilk', 'Vietnam', '0123456789', '0439276181'),
('NCC02', 'Vissan', 'Vietnam', '0345678910', '0439676182'),
('NCC03', 'KeyGroup', 'Vietnam', '0315523162', '0315857697'),
('NCC04', 'Acecook', 'Vietnam', '0345796789', '0317464821'),
('NCC05', 'Vifon', 'Vietnam', '0385245837', '0482425231'),
('NCC06', 'Vedette', 'Vietnam', '0385245143', '0512414842'),
('NCC07', 'Kinh Đô', 'Vietnam', '0534228413', '0132357235'),
('NCC08', 'Bibica', 'Vietnam', '0534228231', '0523484824'),
('NCC09', 'Chợ An Đông', 'Vietnam', '0283833513', '0283145232'),
('NCC10', 'Chợ Bến Thành', 'Vietnam', '0283829927', '0283324725'),
('NCC11', 'Suntory PepsiCo', 'Vietnam', '0813242523', '0345678424'),
('NCC12', 'Công ty CP TM Phú Thái', 'Vietnam', '0912182662', '9778080697'),
('NCC13', 'Công ty TNHH Hàng tiêu dùng HORECO', 'Vietnam', '0906730366', '0938777397'),
('NCC14', 'Công ty CP TP Á Châu', 'Vietnam', '0274371288', '0274374342'),
('NCC15', 'Công Ty TNHH DV XNK Thiên Kim', 'Vietnam', '0969265339', '0982430768');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ho` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgaySinh` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Luong` int(20) NOT NULL,
  `IMG` char(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SoDT`, `Luong`, `IMG`) VALUES
('NV01', 'Seo', 'Eunkwang', '22/11/1990', 'Nam', 'South Korea', '22111990', 0, 'Eunkwang.jpg'),
('NV02', 'Lee', 'Minhyuk', '29/11/1990', 'Nam', 'South Korea', '29111990', 0, 'Minhyuk.jpg'),
('NV03', 'Shin', 'Peniel', '10/03/1993', 'Nam', 'USA', '10031993', 0, 'Peniel.jpg'),
('NV04', 'Jung', 'Ilhoon', '04/10/1994', 'Nam', 'South Korea', '04101994', 500000, 'Ilhoon.jpg'),
('NV05', 'Lee', 'Changsub', '26/02/1991', 'Nam', 'South Korea', '26021991', 0, 'Changsub.jpg'),
('NV06', 'Yook', 'Sungjae', '02/05/1995', 'Nam', 'South Korea', '02051995', 0, 'Sungjae.jpg'),
('NV07', 'Im', 'Hyunsik', '07/03/1992', 'Nam', 'South Korea', '07031992', 0, 'Hyunsik.jpg'),
('NV08', 'Kim', 'Dami', '09/04/1995', 'Nữ', 'South Korea', '09041995', 0, 'Dami.jpg'),
('NV09', 'Choi', 'Woosik', '26/03/1990', 'Nam', 'South Korea', '26031990', 0, 'Woosik.jpg'),
('NV10', 'Roh', 'Jeongeui', '31/07/2001', 'Nữ', 'South Korea', '31072001', 0, 'Jeongeui.jpg'),
('NV11', 'Kim', 'Sungcheol', '31/12/1991', 'Nam', 'South Korea', '31121991', 0, 'Sungcheol.jpg'),
('NV12', 'Trần Thùy', 'Chi', '04/05/1990', 'Nữ', 'Vietnam', '04051990', 0, 'Chi.jpg'),
('NV13', 'Chi', 'Pu', '14/06/1993', 'Nữ', 'Vietnam', '14061993', 0, 'Pu.jpg'),
('NV14', 'Jeon', 'Soyeon', '26/08/1998', 'Nữ', 'South Korea', '26081998', 0, 'Soyeon.jpg'),
('NV15', 'Cho', 'Miyeon', '31/01/1997', 'Nữ', 'South Korea', '31011997', 0, 'Miyeon.jpg'),
('NV16', 'Yontararak', 'Minnie', '23/10/1997', 'Nữ', 'Thailand', '23101997', 0, 'Minnie.jpg'),
('NV17', 'Song', 'Yuqi', '23/09/1999', 'Nữ', 'China', '23091999', 0, 'Yuqi.jpg'),
('NV18', 'Yeh', 'Shuhua', '06/01/2000', 'Nữ', 'Taiwan', '06012000', 0, 'Shuhua.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MaNSX` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNSX` char(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MaNSX`, `TenNSX`) VALUES
('NSX01', 'Vinamilk'),
('NSX02', 'Acecook'),
('NSX03', 'Vissan'),
('NSX04', 'VIFON'),
('NSX05', 'Suntory PepsiCo'),
('NSX06', 'Tân Hiệp Phát'),
('NSX07', 'Jomo'),
('NSX08', 'Vedette'),
('NSX09', 'Kao Việt Nam'),
('NSX10', 'Kinh Đô'),
('NSX11', 'Bibica'),
('NSX12', 'Thiên Long'),
('NSX13', 'P&G'),
('NSX14', 'TH True Milk'),
('NSX15', 'Dutch Lady'),
('NSX16', 'Chương Dương'),
('NSX17', 'Galetine');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNCC` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNV` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayLap` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('PN01', 'NCC04', 'NV06', '28/05/2022', 89000),
('PN02', 'NCC04', 'NV07', '21/05/2022', 695000),
('PN03', 'NCC05', 'NV10', '28/05/2022', 400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` char(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `DonViTinh` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNSX` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMG` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `SoLuong`, `DonGia`, `DonViTinh`, `MaLoai`, `MaNSX`, `IMG`) VALUES
('SP01', 'Mì nấu MAXKEY Hương Vị Kim Chi', 0, 6000, 'Gói', 'L01', 'NSX02', 'SP01.jpg'),
('SP02', 'Mì nấu MAXKEY Hương Vị Hải Sản', 0, 5900, 'Gói', 'L01', 'NSX02', 'SP02.jpg'),
('SP03', 'Bún Hằng Nga - Bún Bò Huế', 20, 7100, 'Gói', 'L01', 'NSX02', 'SP03.jpg'),
('SP04', 'Bún Hằng Nga - Bún Giò Heo', 50, 7200, 'Gói', 'L01', 'NSX02', 'SP04.jpg'),
('SP05', 'Bún Hằng Nga - Bún Mắm', 50, 7500, 'Gói', 'L01', 'NSX02', 'SP05.jpg'),
('SP06', 'Bún Hằng Nga - Bún Tôm Chua Cay', 50, 7000, 'Gói', 'L01', 'NSX02', 'SP06.jpg'),
('SP07', 'Bánh hỗn hợp hộp thiếc Goody 908 gam', 10, 190000, 'Hộp', 'L02', 'NSX11', 'SP07.jpg'),
('SP08', 'Kẹo Cheery hộp nhựa Tròn 150 gam', 0, 35000, 'Hộp', 'L02', 'NSX11', 'SP08.jpg'),
('SP09', 'Bánh Goody Chips Dừa 300 gam', 0, 27000, 'Hộp', 'L02', 'NSX11', 'SP09.jpg'),
('SP10', 'Bánh Goody Chip Điều 300 gam', 0, 26000, 'Hộp', 'L02', 'NSX11', 'SP10.jpg'),
('SP11', 'Bánh Goody Chip Nho 300 gam', 0, 25000, 'Hộp', 'L02', 'NSX11', 'SP11.jpg'),
('SP12', 'Bánh Goody Chip Sôcôla 300 gam', 0, 27500, 'Hộp', 'L02', 'NSX11', 'SP12.jpg'),
('SP13', 'Mì Đệ Nhất Tôm Chua Cay', 0, 7300, 'Gói', 'L01', 'NSX02', 'sp13.jpg'),
('SP14', 'Mì Đệ Nhất Thịt Bằm', 0, 7400, 'Gói', 'L01', 'NSX02', 'SP14.jpg'),
('SP15', 'Nước tăng lực Sting 320ml', 0, 9300, 'Lon', 'L05', 'NSX05', 'SP15.jpg'),
('SP16', 'Nước tăng lực Sting hương dâu tây đỏ 320ml', 0, 10600, 'Lon', 'L05', 'NSX05', 'SP16.jpg'),
('SP17', 'MIRINDA vị Cam', 0, 5000, 'Lon', 'L05', 'NSX05', 'SP17.jpg'),
('SP18', 'MIRINDA vị Soda Kem', 0, 7000, 'Lon', 'L05', 'NSX05', 'SP18.jpg'),
('SP19', 'MIRINDA vị Xá Xị', 0, 5500, 'Lon', 'L05', 'NSX05', 'SP19.jpg'),
('SP20', 'Gel Lột Mũi Than Hoạt Tính Vedette 50Ml', 0, 48250, 'Tuýp', 'L04', 'NSX08', 'SP20.jpg'),
('SP21', 'Mặt Nạ Lột Nhẹ Mật Ong Vedette 50Ml', 0, 48000, 'Tuýp', 'L04', 'NSX08', 'SP21.jpg'),
('SP22', 'Mặt Nạ Thiên Nhiên Dâu Vedette 22Ml', 0, 14500, 'Gói', 'L04', 'NSX08', 'SP22.jpg'),
('SP23', 'Mặt Nạ Sữa Chua Dâu Vedette 120Ml', 25, 67000, 'Hũ', 'L04', 'NSX08', 'SP23.jpg'),
('SP24', 'Nước tinh khiết Aquafina 500ml', 0, 5000, 'Chai', 'L05', 'NSX05', 'SP24.jpg'),
('SP25', 'Bút bi TL-097', 0, 4000, 'Cây', 'L09', 'NSX12', 'SP25.jpg'),
('SP26', 'Bút Lông Kim BeeBee mực Đỏ', 0, 7500, 'Cây', 'L09', 'NSX12', 'SP26.jpg'),
('SP27', 'Bút Lông Kim BeeBee mực Đen', 0, 8000, 'Cây', 'L09', 'NSX12', 'SP27.jpg'),
('SP28', 'Bút Lông Kim BeeBee mực Xanh', 0, 7000, 'Cây', 'L09', 'NSX12', 'SP28.jpg'),
('SP29', 'Nước giặt Ariel Matic giữ màu 3.25kg', 0, 191000, 'Túi', 'L03', 'NSX13', 'SP29.jpg'),
('SP30', 'Nước giặt Ariel hương Downy 2.15L', 0, 136000, 'Túi', 'L03', 'NSX13', 'SP30.jpg'),
('SP31', 'Nước giặt Ariel dịu nhẹ hương sả', 0, 109900, 'Túi', 'L03', 'NSX13', 'SP31.jpg'),
('SP32', 'Nước giặt Ariel Đậm Đặc 3.6kg', 0, 152300, 'Túi', 'L03', 'NSX13', 'SP32.jpg'),
('SP33', 'Nước giặt Ariel khử mùi ẩm mốc 2.15L', 0, 136000, 'Túi', 'L03', 'NSX13', 'SP33.jpg'),
('SP34', 'Nước giặt Ariel hương Oải hương 3.1L', 0, 166000, 'Túi', 'L03', 'NSX13', 'SP34.jpg'),
('SP35', 'Thùng 48 hộp sữa tươi tiệt trùng ít đường TH true MILK 180ml', 0, 390000, 'Thùng', 'L11', 'NSX14', 'SP35.jpg'),
('SP36', 'Thùng 48 hộp sữa tươi có đường Vinamilk 180ml', 0, 330000, 'Thùng', 'L11', 'NSX01', 'SP36.jpg'),
('SP37', 'Lốc 4 hộp sữa tươi có đường Vinamilk 180ml', 0, 30800, 'Lốc', 'L11', 'NSX01', 'SP37.jpg'),
('SP38', 'Thùng 48 hộp sữa tiệt trùng ít đường Dutch Lady Cao Khoẻ 170ml', 0, 262000, 'Thùng', 'L11', 'NSX15', 'SP38.jpg'),
('SP39', 'Thùng 48 hộp sữa tiệt trùng hương dâu Dutch Lady 110ml', 0, 215000, 'Thùng', 'L11', 'NSX15', 'SP39.jpg'),
('SP40', 'Thùng 48 hộp sữa tươi tiệt trùng có đường Dutch Lady 110ml', 0, 228000, 'Thùng', 'L11', 'NSX15', 'SP40.jpg'),
('SP41', 'Lốc 4 hộp sữa tiệt trùng có đường Dutch Lady 110ml', 0, 20000, 'Lốc', 'L11', 'NSX15', 'SP41.jpg'),
('SP42', 'Mì Jomo vị xốt bò hầm gói 78g', 0, 5500, 'Gói', 'L01', 'NSX07', 'SP42.jpg'),
('SP43', 'Mì Jomo vị tôm chua cay gói 80g', 0, 5600, 'Gói', 'L01', 'NSX07', 'SP43.jpg'),
('SP44', 'Mì Jomo vị sườn hầm măng chua gói 80g', 0, 5600, 'Gói', 'L01', 'NSX07', 'SP44.jpg'),
('SP45', '6 lon nước ngọt 7 Up vị chanh 320ml', 0, 46000, 'Lốc', 'L05', 'NSX05', 'SP45.jpg'),
('SP46', 'Combo 2 chai nước ngọt 7 Up vị chanh 1.5 lít', 0, 40000, 'Lô', 'L05', 'NSX05', 'SP46.jpg'),
('SP47', '6 lon nước ngọt Pepsi Cola 320ml', 0, 57800, 'Lốc', 'L05', 'NSX05', 'SP47.jpg'),
('SP48', '6 lon nước ngọt Pepsi không calo 320ml', 0, 60000, 'Lốc', 'L05', 'NSX05', 'SP48.jpg'),
('SP49', 'Kẹo sữa vị dâu Galatine gói 100g', 0, 29500, 'Gói', 'L02', 'NSX17', 'SP49.jpg'),
('SP50', 'Kẹo sữa Galatine gói 100g', 0, 29500, 'Gói', 'L02', 'NSX17', 'SP50.jpg'),
('SP51', 'Kẹo sữa vị socola Galatine gói 100g', 0, 31000, 'Gói', 'L02', 'NSX17', 'SP51.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNV` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenDangNhap` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MatKhau` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Quyen` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TrangThai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaNV`, `TenDangNhap`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
('NV01', 'admin', 'admin', 'Admin', 1),
('NV02', 'user1', '123456', 'Nhân viên', 1),
('NV03', 'user2', '123456', 'Nhân viên', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaHD`,`MaSP`),
  ADD KEY `FK_CTHD` (`MaSP`);

--
-- Chỉ mục cho bảng `chitietpn`
--
ALTER TABLE `chitietpn`
  ADD PRIMARY KEY (`MaPN`,`MaSP`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FK_HD` (`MaKH`),
  ADD KEY `FK_HD_1` (`MaNV`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MaNSX`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK_SP` (`MaLoai`),
  ADD KEY `FK_SP_1` (`MaNSX`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaNV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `FK_CTHD` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`),
  ADD CONSTRAINT `FK_CTHD_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HD` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `FK_HD_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_SP` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`),
  ADD CONSTRAINT `FK_SP_1` FOREIGN KEY (`MaNSX`) REFERENCES `nhasanxuat` (`MaNSX`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
