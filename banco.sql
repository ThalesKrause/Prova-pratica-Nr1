/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



-- Copiando estrutura do banco de dados para empresa

CREATE DATABASE IF NOT EXISTS `empresa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `empresa`;

-- Copiando estrutura para tabela funcionario

CREATE TABLE IF NOT EXISTS `Funcionario` (
  `id` int(11) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela empresa.funcionario

INSERT INTO `funcionario` (`id`, `matricula`, `departamento`) VALUES
	(8, 'F001', 'TI');

-- Copiando estrutura para tabela pessoa

CREATE TABLE IF NOT EXISTS `Pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela pessoa

INSERT INTO `Pessoa` (`id`, `nome`, `email`) VALUES
	(8, 'João da Silva', 'joao@example.com');

-- Copiando estrutura para tabela projeto

CREATE TABLE IF NOT EXISTS `Projeto` (
  `id_projeto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_projeto` varchar(100) NOT NULL,
  `descricao` text DEFAULT NULL,
  `idFuncionario` int(11) NOT NULL,
  PRIMARY KEY (`id_projeto`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `projeto_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `Funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Copiando dados para a tabela projeto

INSERT INTO `Projeto` (`id_projeto`, `nome_projeto`, `descricao`, `idFuncionario`) VALUES
	(3, 'Sistema Interno', 'Desenvolvimento do novo sistema da empresa.', 8);


/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
