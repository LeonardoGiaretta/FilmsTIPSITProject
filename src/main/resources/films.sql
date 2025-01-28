-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 28, 2025 alle 20:24
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `films`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `films`
--

CREATE TABLE `films` (
  `IDFilms` int(11) NOT NULL,
  `IDRegista` int(11) NOT NULL,
  `Titolo` varchar(255) NOT NULL,
  `Durata` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `films`
--

INSERT INTO `films` (`IDFilms`, `IDRegista`, `Titolo`, `Durata`) VALUES
(1, 1, 'Jurassic Park', '127 min'),
(2, 1, 'Salvate il soldato Ryan', '169 min'),
(3, 2, 'Oppenheimer', '180 min'),
(4, 3, 'Django Unchained', '165 min'),
(5, 3, 'Bastardi senza gloria', '153 min');

-- --------------------------------------------------------

--
-- Struttura della tabella `registi`
--

CREATE TABLE `registi` (
  `IDRegista` int(11) NOT NULL,
  `Nome` varchar(255) NOT NULL,
  `Cognome` varchar(255) NOT NULL,
  `Nascita` varchar(255) NOT NULL,
  `Direzioni` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `registi`
--

INSERT INTO `registi` (`IDRegista`, `Nome`, `Cognome`, `Nascita`, `Direzioni`) VALUES
(1, 'Steven', 'Spielberg', '18 dicembre 1946', 'Duel, Lo squalo, Incontri ravvicinati del terzo tipo, 1941 - Allarme a Hollywood, I predatori dell\'arca perduta, E.T. l\'extra-terrestre, Indiana Jones e il tempio maledetto, Il colore viola, L\'impero del sole, Indiana Jones e l\'ultima crociata, Hook - Capitan Uncino, Jurassic Park, Schindler\'s List, Il mondo perduto - Jurassic Park, Amistad, Salvate il soldato Ryan, A.I. Intelligenza artificiale, Minority Report, Prova a prendermi, The Terminal, Munich, Indiana Jones e il regno del teschio di cristallo, War Horse, Lincoln, Il ponte delle spie, Il GGG - Il grande gigante gentile, The Post, Ready Player One, West Side Story, The Fabelmans'),
(2, 'Christopher ', 'Nolan', '30 luglio 1970', 'Following, Memento, Insomnia, Batman Begins, The Prestige, Il cavaliere oscuro, Inception, Il cavaliere oscuro - Il ritorno, Interstellar, Dunkirk, Tenet, Oppenheimer'),
(3, 'Quentin ', 'Tarantino', ' 27 marzo 1963', 'Le iene, Pulp Fiction, Jackie Brown, Kill Bill: Volume 1, Kill Bill: Volume 2, Grindhouse - A prova di morte, Bastardi senza gloria, Django Unchained, The Hateful Eight, C\'era una volta a... Hollywood');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`IDFilms`),
  ADD KEY `Index` (`IDRegista`);

--
-- Indici per le tabelle `registi`
--
ALTER TABLE `registi`
  ADD PRIMARY KEY (`IDRegista`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `films`
--
ALTER TABLE `films`
  MODIFY `IDFilms` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `registi`
--
ALTER TABLE `registi`
  MODIFY `IDRegista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `films`
--
ALTER TABLE `films`
  ADD CONSTRAINT `films_ibfk_1` FOREIGN KEY (`IDRegista`) REFERENCES `registi` (`IDRegista`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
