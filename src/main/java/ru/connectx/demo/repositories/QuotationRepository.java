package ru.connectx.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.connectx.demo.model.Event;
import ru.connectx.demo.model.Quotation;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Integer> {

//    @Query("select q from Quotation q where q.nameQuotation=:nameQuotation")
//    Quotation findQuotationByName(String nameQuotation);
    Quotation findQuotationById(Integer id);
}
