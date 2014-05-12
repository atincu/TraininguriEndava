select d.coddepartament as "Cod Departament", max(s.salariu) as "Salariu maxim"
from departament d, salariat s
where d.coddepartament = s.coddepartament and d.denumiredepartament like "T%" 
group by d.coddepartament
having count(s.MarcaSalariat) > 30