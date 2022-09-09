package com.codegym.repository;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    @Query(value = "SELECT \n" +
//            "    kh.customer_name AS customer_name,\n" +
//            "    hd.id AS id,\n" +
//            "    dv.name_service AS name_service,\n" +
//            "    hd.start_date AS start_date,\n" +
//            "    hd.end_date AS end_date,\n" +
//            "    deposit,\n" +
//            "    SUM(dv.cost + ifnull(quantity * dvdk.cost,0)) AS totalMoney\n" +
//            "FROM\n" +
//            "    customer kh\n" +
//            "        JOIN\n" +
//            "    customer_type lk ON lk.id = kh.id\n" +
//            "        LEFT JOIN\n" +
//            "    contract hd ON hd.customer_id = kh.id\n" +
//            "        LEFT JOIN\n" +
//            "    facility dv ON hd.facility_id = dv.id\n" +
//            "        LEFT JOIN\n" +
//            "    contract_detail hdct ON hd.id = hdct.contract_id\n" +
//            "        LEFT JOIN\n" +
//            "    attach_facility dvdk ON hdct.attach_facility_id = dvdk.id\n" +
//            "GROUP BY hd.id;\n", nativeQuery = true,
//            countQuery = "select count(*) from(SELECT \n" +
//                    "    kh.customer_name AS customer_name,\n" +
//                    "    hd.id AS id,\n" +
//                    "    dv.name_service AS name_service,\n" +
//                    "    hd.start_date AS start_date,\n" +
//                    "    hd.end_date AS end_date,\n" +
//                    "    deposit,\n" +
//                    "    SUM(dv.cost + ifnull(quantity * dvdk.cost,0)) AS totalMoney\n" +
//                    "FROM\n" +
//                    "    customer kh\n" +
//                    "        JOIN\n" +
//                    "    customer_type lk ON lk.id = kh.id\n" +
//                    "        LEFT JOIN\n" +
//                    "    contract hd ON hd.customer_id = kh.id\n" +
//                    "        LEFT JOIN\n" +
//                    "    facility dv ON hd.facility_id = dv.id\n" +
//                    "        LEFT JOIN\n" +
//                    "    contract_detail hdct ON hd.id = hdct.contract_id\n" +
//                    "        LEFT JOIN\n" +
//                    "    attach_facility dvdk ON hdct.attach_facility_id = dvdk.id\n" +
//                    "GROUP BY hd.id;\n) contract ")
//    Page<Contract> findAll(Pageable pageable);

    @Query(value = " select func_tinh_tien(:id)", nativeQuery = true)
    Double findTotalMoney(@Param("id") Integer id);

    @Query(value = "select * from contract where `status` = 0", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);
}
