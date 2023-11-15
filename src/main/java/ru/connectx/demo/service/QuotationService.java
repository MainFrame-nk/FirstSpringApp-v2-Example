package ru.connectx.demo.service;

import ru.connectx.demo.dto.QuotationDTO;
import ru.connectx.demo.model.Quotation;

import java.util.List;

public interface QuotationService {

    List<QuotationDTO> getAllQuotes();
//    Quotation getQuotationByName(String nameQuotation);
    QuotationDTO saveQuotation(QuotationDTO quotationDTO);
    Quotation getQuotationById(Integer id);
    void deleteQuotation(Integer id);
    QuotationDTO updateQuotation(QuotationDTO quotationDTO, Integer id);
}
