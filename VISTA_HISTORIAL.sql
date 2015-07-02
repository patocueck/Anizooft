CREATE VIEW VW_HISTORIAL
AS select due.rutdue�o, CONCAT(CONCAT(due.nombre, ' '), due.APELLIDO) as NOMBRE_DUENO, mas.idmascota, mas.nombre, ate.fechahora, ate.IDATENCION, emp.RUTEMPLEADO as RUT_EMPLEADO, CONCAT(CONCAT(emp.nombre, ' '), emp.APELLIDO) as NOMBRE_EMPLEADO  from MASCOTA mas
join DUE�O due on due.rutdue�o = mas."RUTDUE�O"
join ATENCION ate on ate.IDMASCOTA = mas.idmascota
join PARTICIPACION part on part.IDATENCION = ate.IDATENCION
join EMPLEADO emp on emp.rutempleado = part.RUTEMPLEADO;

SELECT * FROM VW_HISTORIAL;