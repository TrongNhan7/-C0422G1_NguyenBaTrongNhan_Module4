package com.codegym.repository;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value="SELECT \n" +
            "    af.id ,\n" +
            "    af.cost ,\n" +
            "    af.name ,\n" +
            "    af.status_facility,\n" +
            "    unit\n" +
            "FROM\n" +
            "   attach_facility af\n" +
            "        JOIN\n" +
            "    contract_detail cd ON af.id = cd.attach_facility_id\n" +
            "        JOIN\n" +
            "    contract c ON cd.contract_id = c.id\n" +
            "    where c.id = :id",nativeQuery = true)
    List<AttachFacility> findAllByIdContract(@Param("id") Integer id);

}
