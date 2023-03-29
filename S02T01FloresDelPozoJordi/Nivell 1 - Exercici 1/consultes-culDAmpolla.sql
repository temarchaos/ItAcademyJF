-- Llista el total de factures d'un client/a en un període determinat.
SELECT * FROM factures WHERE `vendes_clients_idClients` = 1 AND `dataVenda` BETWEEN '2023-01-01' AND '2023-03-31';
-- Llista els diferents models d'ulleres que ha venut un empleat/da durant un any.
SELECT ulleres.idUlleres, ulleres.marca FROM ulleres JOIN factures ON ulleres.idUlleres = factures.ulleres_idUlleres WHERE `vendes_empleats_idEmpleats` = 1 AND factures.dataVenda BETWEEN '2023-01-01' AND '2023-12-31';
-- Llista els diferents proveïdors que han subministrat ulleres venudes amb èxit per l'òptica.
SELECT proveidors.idProveidor, proveidors.nom FROM proveidors JOIN factures ON proveidors.idProveidor = factures.ulleres_proveidors_idProveidor;