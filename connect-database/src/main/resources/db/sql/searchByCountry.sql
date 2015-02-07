SELECT e.* 
FROM Employees e 

INNER JOIN Departments d 
ON (e.department_id = d.department_id) 

INNER JOIN Locations l 
ON (d.location_id = l.location_id) 

INNER JOIN Countries c 
ON (l.country_id = c.country_id) 

WHERE LOWER(c.country_name) LIKE ? 