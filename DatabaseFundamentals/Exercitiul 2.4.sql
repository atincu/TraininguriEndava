update salariat s
set s.salariu = 1.1 * s.salariu
where s.MarcaSalariat in (
			select s.MarcaSalariat
			from departament d
			where s.coddepartament = d.coddepartament
			group by d.CodDepartament
			having count(s.MarcaSalariat) = 1) 