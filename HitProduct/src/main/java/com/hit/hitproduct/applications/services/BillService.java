package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.BillDto;
import com.hit.hitproduct.domains.entities.Bill;
import com.hit.hitproduct.domains.entities.DetailBill;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public interface BillService {

    List<Bill> getBills();

    Bill getBillById(Long id);

    Bill createBill(Long idUser, BillDto billDto, List<DetailBill> detailBills) throws MessagingException;

    Bill updateBill(Long id, BillDto billDto);

    TrueFalseResponse deleteBill(Long id);
}
