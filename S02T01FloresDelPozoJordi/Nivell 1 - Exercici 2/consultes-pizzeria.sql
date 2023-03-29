-- Llista quants productes de categoria 'Begudes' s'han venut en una determinada localitat.
SELECT COUNT(*) as totalBegudesVenudes
FROM productes p
JOIN productes_has_comandes phc ON p.idProductes = phc.productes_idProductes
JOIN comandes c ON phc.comandes_idComandes = c.idComandes
JOIN clients cl ON c.clients_idClients = cl.idClients
WHERE p.categories_idCategories = 3 AND cl.localitat = 'Hoover';

-- Llista quantes comandes ha efectuat un determinat empleat/da.
SELECT COUNT(*) as totalComandesRealitzades
FROM comandes c
WHERE c.empleats_idEmpleats = 2;