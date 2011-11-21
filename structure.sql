-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Vert: 127.0.0.1
-- Generert den: 27. Okt, 2011 08:45 AM
-- Tjenerversjon: 5.5.9
-- PHP-Versjon: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `prosjekt1`
--

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `addresses`
--

CREATE TABLE IF NOT EXISTS `addresses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(255) NOT NULL,
  `houseNumber` int(10) unsigned NOT NULL,
  `houseLetter` char(1) NOT NULL,
  `zipcode` varchar(12) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` char(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `ordered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `due` timestamp NULL DEFAULT NULL,
  `delivered` timestamp NULL DEFAULT NULL,
  `products` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `levering` tinyint(1) NOT NULL,
  `kort` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `price` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

INSERT INTO `products` (`id`, `name`, `description`, `price`) VALUES
(1, 'Margharita', 'Ost, tomatsaus og basilikum', '100'),
(2, 'Vesuvio', 'Tomat, ost og skinke', '115'),
(3, 'Milano', 'Tomat, ost og pepperoni', '115'),
(4, 'Gabagol', 'Tomat, ost, peanøttsmørr, ostepop, gummibjørner', '150'),
(5, 'Trondheim spesial', 'Tomat, ost, biff, løk, mais, ananas og chillisaus', '132'),
(6, 'Capriciosa', 'Tomat, ost, skinke, sjampinjong', '130'),
(7, 'Maffiosa', 'Tomat, ost, kebabkjøtt, løk og hvitløkssaus', '130'),
(8, 'Grozzo', 'Tomat, ost, skinke, biff, pepperoni, kylling og løk', '140'),
(9, 'Calzone', 'Tomat, ost, kylling, pesto, mozzarella', '130'),
(10, 'Cola', 'Drikkevare', '20'),
(11, 'Fanta', 'Drikkevare', '20'),
(12, 'Sprite', 'Drikkevare', '20'),
(13, 'Cola-Zero', 'Drikkevare', '20'),
(14, 'BonAqua', 'Drikkevare', '15'),
(15, 'Vann', 'Drikkevare', '10');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address_id` int(10) unsigned NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


ALTER TABLE  `users` ADD UNIQUE (`phone`);
ALTER TABLE  `orders` ADD COLUMN `levering` TINYINT(1);
ALTER TABLE  `orders` ADD COLUMN `kort` TINYINT(1);
