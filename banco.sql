CREATE TABLE `sessao` (
  `idSessao` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `profissao` varchar(50) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `ataque` int(11) DEFAULT NULL,
  `defesa` int(11) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  CONSTRAINT `unq_nome` UNIQUE (`nome`)
) ENGINE=InnoDB;
