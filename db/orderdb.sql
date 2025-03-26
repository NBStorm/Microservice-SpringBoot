-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 26, 2025 lúc 10:46 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `orderdb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details`
--

CREATE TABLE `order_details` (
  `id` bigint(20) NOT NULL,
  `total_amount` bigint(20) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_details`
--

INSERT INTO `order_details` (`id`, `total_amount`, `order_date`, `status`, `product_id`, `quantity`) VALUES
(1, 1200, '2025-03-21 08:01:56.000000', 'CREATED', 1, 1),
(2, 1200, '2025-03-21 08:48:41.000000', 'CREATED', 1, 1),
(52, 1200, '2025-03-26 04:24:47.000000', 'CREATED', 1, 1),
(102, 1200, '2025-03-26 05:14:01.000000', 'CREATED', 6, 1),
(152, 1200, '2025-03-26 05:15:39.000000', 'CREATED', 6, 1),
(153, 1200, '2025-03-26 05:20:26.000000', 'CREATED', 6, 1),
(202, 1200, '2025-03-26 05:25:28.000000', 'CREATED', 6, 1),
(203, 1200, '2025-03-26 05:28:38.000000', 'CREATED', 6, 1),
(204, 6000, '2025-03-26 05:33:31.000000', 'CREATED', 6, 5),
(252, 1200, '2025-03-26 05:36:57.000000', 'CREATED', 6, 1),
(253, 1200, '2025-03-26 05:39:14.000000', 'CREATED', 6, 1),
(302, 1200, '2025-03-26 05:47:13.000000', 'CREATED', 6, 1),
(352, 1200, '2025-03-26 05:52:54.000000', 'CREATED', 6, 1),
(402, 1200, '2025-03-26 06:02:08.000000', 'CREATED', 6, 1),
(452, 1200, '2025-03-26 06:07:50.000000', 'CREATED', 6, 1),
(453, 1200, '2025-03-26 06:10:42.000000', 'CREATED', 6, 1),
(502, 1200, '2025-03-26 06:15:03.000000', 'CREATED', 6, 1),
(552, 1200, '2025-03-26 06:19:48.000000', 'CREATED', 6, 1),
(553, 1200, '2025-03-26 06:21:47.000000', 'CREATED', 6, 1),
(602, 1200, '2025-03-26 06:26:23.000000', 'CREATED', 6, 1),
(603, 1200, '2025-03-26 06:30:16.000000', 'CREATED', 6, 1),
(652, 1200, '2025-03-26 06:38:09.000000', 'CREATED', 6, 1),
(702, 1200, '2025-03-26 06:41:53.000000', 'CREATED', 6, 1),
(752, 1200, '2025-03-26 07:00:03.000000', 'CREATED', 6, 1),
(802, 1200, '2025-03-26 07:02:34.000000', 'CREATED', 6, 1),
(803, 1200, '2025-03-26 07:40:57.000000', 'CREATED', 6, 1),
(852, 1200, '2025-03-26 07:42:52.000000', 'PLACED', 6, 1),
(902, 1200, '2025-03-26 08:27:02.000000', 'PLACED', 6, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details_seq`
--

CREATE TABLE `order_details_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_details_seq`
--

INSERT INTO `order_details_seq` (`next_val`) VALUES
(1001);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
