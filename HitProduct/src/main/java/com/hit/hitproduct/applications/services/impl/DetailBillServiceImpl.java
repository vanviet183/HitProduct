package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.repositories.BillRepository;
import com.hit.hitproduct.applications.repositories.DetailBillRepository;
import com.hit.hitproduct.applications.repositories.ProductRepository;
import com.hit.hitproduct.applications.repositories.UserRepository;
import com.hit.hitproduct.applications.services.DetailBillService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.DetailBillDto;
import com.hit.hitproduct.domains.entities.Bill;
import com.hit.hitproduct.domains.entities.DetailBill;
import com.hit.hitproduct.domains.entities.Product;
import com.hit.hitproduct.domains.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailBillServiceImpl implements DetailBillService {

    @Autowired
    DetailBillRepository detailBillRepository;

    @Autowired
    BillRepository billRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DetailBill> getDetailBills() {
        return detailBillRepository.findAll();
    }

    @Override
    public DetailBill getDetailBillById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        checkBillException(bill);
        return detailBillRepository.findByBill_Id(id);
    }

//    @Override
//    public DetailBill createDetailBill(DetailBillDto detailBillDto) {
//        return createOrUpdate(new DetailBill(), detailBillDto);
//    }

//    @Override
//    public DetailBill createDetailBill(Long idBill, Long idProduct, DetailBillDto detailBillDto) {
//        return createOrUpdate(idBill, idProduct, new DetailBill(), detailBillDto);
//    }

    @Override
    public DetailBill createDetailBill(Long idUser, Long idProduct, DetailBillDto detailBillDto) {
        Optional<User> user = userRepository.findById(idUser);
        checkUserException(user);
        Optional<Product> product = productRepository.findById(idProduct);
        checkProductException(product);
        DetailBill detailBill = modelMapper.map(detailBillDto, DetailBill.class);

        detailBill.setUser(user.get());
        detailBill.setProduct(product.get());

        return detailBillRepository.save(detailBill);
    }

    @Override
    public List<DetailBill> getListProductInCart(Long idUser) {
        return detailBillRepository.findByUser_IdAndBillFalse(idUser);
    }

    @Override
    public DetailBill updateDetailBill(Long id, DetailBillDto detailBillDto) {
        Optional<DetailBill> detailBill = detailBillRepository.findById(id);
        checkDetailBillException(detailBill);
        modelMapper.map(detailBillDto, detailBill.get());
        return detailBillRepository.save(detailBill.get());
    }

//    @Override
//    public DetailBill pay(Long id, BillDto billDto) {
//        Optional<DetailBill> detailBill = detailBillRepository.findById(id);
//        checkDetailBillException(detailBill);
//
//        Bill bill = modelMapper.map(billDto, Bill.class);
//        billRepository.save(bill);
//        detailBill.get().setBill(bill);
//        return detailBillRepository.save(detailBill.get());
//    }

    @Override
    public TrueFalseResponse deleteDetailBill(Long idBill) {
        Optional<Bill> bill = billRepository.findById(idBill);
        checkBillException(bill);
        billRepository.deleteById(idBill);
        return new TrueFalseResponse(true);
    }

    private void checkBillException(Optional<Bill> bill) {
        if(bill.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkUserException(Optional<User> user) {
        if(user.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkProductException(Optional<Product> product) {
        if(product.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkDetailBillException(Optional<DetailBill> detailBill) {
        if(detailBill.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }
}
