use case_study_module4;

delimiter $$
create function func_tinh_tien (id int)
returns int
deterministic
begin
	declare result int;
SELECT 
    SUM(dv.cost + ifnull(quantity * dvdk.cost,0)) into result
FROM
    customer kh
        JOIN
    customer_type lk ON lk.id = kh.id
        LEFT JOIN
    contract hd ON hd.customer_id = kh.id
        LEFT JOIN
    facility dv ON hd.facility_id = dv.id
        LEFT JOIN
    contract_detail hdct ON hd.id = hdct.contract_id
        LEFT JOIN
    attach_facility dvdk ON hdct.attach_facility_id = dvdk.id
    where hd.id = id
GROUP BY hd.id;
return result;
end $$
delimiter ;

SELECT func_tinh_tien(9);