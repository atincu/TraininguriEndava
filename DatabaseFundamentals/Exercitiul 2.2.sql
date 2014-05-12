select d.denumiredepartament, max(s.salariu)
from salariat s, departament d
where d.coddepartament = s.coddepartament
group by d.coddepartament