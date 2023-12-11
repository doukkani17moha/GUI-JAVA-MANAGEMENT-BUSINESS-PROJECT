-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 11, 2023 at 05:48 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionentreprise`
--

-- --------------------------------------------------------

--
-- Table structure for table `achat`
--

CREATE TABLE `achat` (
  `id` int(11) NOT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idProduit` int(11) DEFAULT NULL,
  `dateachat` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `achat`
--

INSERT INTO `achat` (`id`, `idClient`, `idProduit`, `dateachat`, `status`) VALUES
(1, 1001, 2, '2023-12-15', 'Payment Pending'),
(2, 1002, 1, '2023-12-16', 'Payment Received'),
(3, 1001, 3, '2023-12-17', 'Payment Processing'),
(46, 1001, 1, '2023-01-15', 'Payment Received'),
(47, 1002, 2, '2023-02-20', 'Payment Pending'),
(48, 1005, 3, '2023-03-25', 'Payment Received'),
(49, 1004, 17, '2023-04-10', 'Payment Pending'),
(50, 1005, 18, '2023-05-05', 'Payment Received'),
(51, 1006, 19, '2023-06-15', 'Payment Pending'),
(52, 1007, 20, '2023-07-20', 'Payment Received'),
(53, 1008, 21, '2023-08-25', 'Payment Pending'),
(54, 1009, 22, '2023-09-10', 'Payment Received'),
(55, 1010, 23, '2023-10-05', 'Payment Pending'),
(56, 1011, 24, '2023-11-15', 'Payment Received'),
(57, 1012, 25, '2023-12-20', 'Payment Pending'),
(58, 1013, 27, '2024-01-25', 'Payment Received'),
(59, 1014, 28, '2024-02-10', 'Payment Pending'),
(60, 1015, 30, '2024-03-05', 'Payment Received'),
(62, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `achat_view`
-- (See below for the actual view)
--
CREATE TABLE `achat_view` (
`id_achat` int(11)
,`client_full_name` varchar(511)
,`product_name` varchar(255)
,`dateachat` date
,`status` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `email`) VALUES
(1001, 'John', 'Doe', 'john.doe@example.com'),
(1002, 'Jane', 'Smith', 'jane.smith@example.com'),
(1004, 'Smith', 'John', 'john.smith@example.com'),
(1005, 'Johnson', 'Emily', 'emily.johnson@example.com'),
(1006, 'Williams', 'Michael', 'michael.williams@example.com'),
(1007, 'Jones', 'Jessica', 'jessica.jones@example.com'),
(1008, 'Brown', 'Christopher', 'christopher.brown@example.com'),
(1009, 'Davis', 'Ashley', 'ashley.davis@example.com'),
(1010, 'Miller', 'Matthew', 'matthew.miller@example.com'),
(1011, 'Moore', 'Amanda', 'amanda.moore@example.com'),
(1012, 'Wilson', 'Nicholas', 'nicholas.wilson@example.com'),
(1013, 'Taylor', 'Jessica', 'jessica.taylor@example.com'),
(1014, 'Anderson', 'Ryan', 'ryan.anderson@example.com'),
(1015, 'Thomas', 'Sarah', 'sarah.thomas@example.com'),
(1016, 'Jackson', 'David', 'david.jackson@example.com'),
(1017, 'White', 'Olivia', 'olivia.white@example.com'),
(1018, 'Harris', 'Andrew', 'andrew.harris@example.com'),
(1020, 'hhhhhhh', 'fff', 'jjj');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `salaire` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `salaire`) VALUES
(1, 'Mohamed', 'Doukkani', '50000'),
(2, 'Ali', 'Robai', '35000'),
(3, 'Habiba', 'Tahiri', '20000'),
(8, 'Johnson', 'Robert', '60000.00'),
(9, 'Smith', 'Jennifer', '55000.00'),
(10, 'Williams', 'Daniel', '62000.00'),
(11, 'Jones', 'Linda', '58000.00'),
(12, 'Davis', 'Michael', '63000.00'),
(13, 'Taylor', 'Susan', '57000.00'),
(14, 'Anderson', 'Karen', '59000.00'),
(15, 'Brown', 'William', '61000.00'),
(16, 'Miller', 'Jessica', '54000.00'),
(17, 'Moore', 'Brian', '60000.00'),
(18, 'Wilson', 'Megan', '56000.00'),
(19, 'Jackson', 'Christopher', '62000.00'),
(20, 'Thomas', 'Laura', '58000.00'),
(21, 'White', 'Patrick', '59000.00'),
(22, 'Harris', 'Emily', '57000.00');

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` varchar(255) DEFAULT NULL,
  `employe_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `prix`, `employe_name`) VALUES
(1, 'Product A', '20.99', 'Mohamed Doukkani'),
(2, 'Product B', '15.5', 'Ali Robai'),
(3, 'Product C', '30.99', 'Habiba Tahiri'),
(16, 'Laptop', '1200.00', 'Robert Johnson'),
(17, 'Smartphone', '800.00', 'Jennifer Smith'),
(18, 'TV', '1500.00', 'Daniel Williams'),
(19, 'Headphones', '100.00', 'Linda Jones'),
(20, 'Tablet', '500.00', 'Michael Davis'),
(21, 'Camera', '700.00', 'Susan Taylor'),
(22, 'Printer', '300.00', 'Karen Anderson'),
(23, 'Mouse', '20.00', 'William Brown'),
(24, 'Keyboard', '30.00', 'Jessica Miller'),
(25, 'Monitor', '400.00', 'Brian Moore'),
(26, 'Speaker', '50.00', 'Megan Wilson'),
(27, 'External Hard Drive', '80.00', 'Christopher Jackson'),
(28, 'Router', '60.00', 'Laura Thomas'),
(29, 'Desk Chair', '150.00', 'Patrick White'),
(30, 'Desk Lamp', '25.00', 'Emily Harris');

-- --------------------------------------------------------

--
-- Structure for view `achat_view`
--
DROP TABLE IF EXISTS `achat_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `achat_view`  AS SELECT `a`.`id` AS `id_achat`, concat(`c`.`nom`,' ',`c`.`prenom`) AS `client_full_name`, `p`.`nom` AS `product_name`, `a`.`dateachat` AS `dateachat`, `a`.`status` AS `status` FROM ((`achat` `a` join `client` `c` on(`a`.`idClient` = `c`.`id`)) join `produit` `p` on(`a`.`idProduit` = `p`.`id`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_achat_client` (`idClient`),
  ADD KEY `fk_achat_produit` (`idProduit`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1021;

--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `fk_achat_client` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `fk_achat_produit` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
