-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 10 Sty 2020, 10:31
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `chinczyk`
--

DELIMITER $$
--
-- Procedury
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodaj_wynik` (IN `p_nazwa_gracza` CHAR(255), IN `p_wynik` INT(8))  BEGIN
	INSERT INTO wynik_gry(data, nazwa_gracza, wynik) VALUES (CURRENT_DATE, p_nazwa_gracza, p_wynik);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `usun` (`p_id_wyniku` INT(8))  BEGIN 
	DELETE FROM wynik_gry WHERE wynik_gry.id_wyniku = p_id_wyniku;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `wyswietl_gracza` (IN `p_nazwa_gracza` CHAR(255))  BEGIN
    SELECT * FROM wynik_gry WHERE wynik_gry.nazwa_gracza = p_nazwa_gracza ORDER BY wynik_gry.data;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `wyswietl_top` ()  BEGIN
	SELECT * FROM wynik_gry ORDER BY wynik_gry.wynik DESC;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wynik_gry`
--

CREATE TABLE `wynik_gry` (
  `id_wyniku` int(8) NOT NULL,
  `data` date NOT NULL,
  `nazwa_gracza` char(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wynik` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Zrzut danych tabeli `wynik_gry`
--

INSERT INTO `wynik_gry` (`id_wyniku`, `data`, `nazwa_gracza`, `wynik`) VALUES
(26, '2019-12-12', 'czerwony', 1000),
(27, '2019-12-12', 'czerwony', 1000),
(28, '2019-12-12', 'czerwony', 321213),
(29, '2019-12-12', 'czerwony', 145423213),
(32, '2019-12-12', 'czerwony', 235435432),
(34, '2019-12-12', 'czerwony', 34545321),
(35, '2019-12-12', 'czerwony', 2145123),
(37, '2019-12-12', 'zielony', 1322312),
(38, '2019-12-12', 'zielony', 4123213),
(40, '2019-12-12', 'zielony', 1041200),
(41, '2019-12-12', 'zielony', 10123200),
(42, '2019-12-12', 'zielony', 1023100),
(43, '2019-12-12', 'zielony', 1021300),
(44, '2019-12-12', 'zielony', 1001140),
(46, '2019-12-12', 'zielony', 10421300),
(48, '2019-12-12', 'zolty', 344343),
(49, '2019-12-12', 'zolty', 343244),
(50, '2019-12-12', 'zolty', 233234),
(52, '2019-12-12', 'zolty', 534343),
(53, '2019-12-12', 'zolty', 53443),
(54, '2019-12-12', 'zolty', 235321),
(55, '2019-12-12', 'zolty', 3434443),
(56, '2019-12-12', 'zolty', 43552),
(57, '2019-12-12', 'fioletowy', 34352),
(59, '2019-12-12', 'fioletowy', 10322300),
(62, '2019-12-12', 'fioletowy', 321312),
(63, '2019-12-12', 'fioletowy', 23131),
(64, '2019-12-12', 'fioletowy', 213121),
(65, '2019-12-12', 'fioletowy', 4213123),
(66, '2019-12-12', 'fioletowy', 321321),
(67, '2019-12-12', 'różowy', 21332131),
(68, '2019-12-12', 'różowy', 1237),
(69, '2019-12-12', 'różowy', 21313),
(70, '2019-12-12', 'różowy', 21313),
(71, '2019-12-12', 'różowy', 567765),
(72, '2019-12-12', 'różowy', 57657),
(73, '2019-12-12', 'różowy', 10322300),
(74, '2019-12-12', 'różowy', 756765),
(76, '2019-12-12', 'różowy', 321312),
(77, '2019-12-12', 'różowy', 23131),
(78, '2019-12-12', 'różowy', 5343),
(79, '2019-12-12', 'różowy', 765765),
(80, '2019-12-12', 'różowy', 321321),
(81, '2019-12-12', 'różowy', 6534543),
(83, '2019-12-12', 'różowy', 53437),
(84, '2019-12-12', 'różowy', 5376),
(88, '2019-12-12', 'Czarny', 10000000),
(89, '2019-12-12', 'Czarny', 10000000);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `wynik_gry`
--
ALTER TABLE `wynik_gry`
  ADD PRIMARY KEY (`id_wyniku`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `wynik_gry`
--
ALTER TABLE `wynik_gry`
  MODIFY `id_wyniku` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
