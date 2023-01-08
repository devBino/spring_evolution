CREATE TABLE IF NOT EXISTS `tb_contato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(155) NOT NULL,
  `nome` varchar(155) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);