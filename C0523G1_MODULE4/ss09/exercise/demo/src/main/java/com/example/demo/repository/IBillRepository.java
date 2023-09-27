package com.example.demo.repository;

import com.example.demo.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IBillRepository extends JpaRepository<Bill,Integer> {

    @Query(value = "select * from Bill where code = :codeInput ", nativeQuery = true)
    Bill getBillByCode(@Param("codeInput") int codeInput);
}
