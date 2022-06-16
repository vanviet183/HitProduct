package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.DetailBillDto;
import com.hit.hitproduct.domains.entities.DetailBill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailBillService {

    List<DetailBill> getDetailBills();

    DetailBill getDetailBillById(Long id);

    DetailBill createDetailBill(Long idUser, Long idProduct, DetailBillDto detailBillDto);

    List<DetailBill> getListProductInCart(Long idUser);

    DetailBill updateDetailBill(Long id, DetailBillDto detailBillDto);

    TrueFalseResponse deleteDetailBill(Long id);
}
