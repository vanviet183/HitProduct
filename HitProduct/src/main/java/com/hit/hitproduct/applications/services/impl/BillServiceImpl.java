package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.repositories.BillRepository;
import com.hit.hitproduct.applications.repositories.UserRepository;
import com.hit.hitproduct.applications.services.BillService;
import com.hit.hitproduct.applications.services.EmailSenderService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.BillDto;
import com.hit.hitproduct.domains.entities.Bill;
import com.hit.hitproduct.domains.entities.DetailBill;
import com.hit.hitproduct.domains.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        checkBillException(bill);
        return bill.get();
    }

    @Override
    public Bill createBill(Long idUser, BillDto billDto, List<DetailBill> detailBills) throws MessagingException {
        Optional<User> user = userRepository.findById(idUser);
        checkUserException(user);
        Bill bill = modelMapper.map(billDto, Bill.class);

        bill.setUser(user.get());
        bill.setDetailBills(detailBills);
        emailSenderService.sendHtmlEmail(bill.getEmail(), "Hit Sneaker Shop With Love");
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Long id, BillDto billDto) {
        Optional<Bill> bill = billRepository.findById(id);
        checkBillException(bill);
        modelMapper.map(billDto, bill.get());
        return billRepository.save(bill.get());
    }

    @Override
    public TrueFalseResponse deleteBill(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        checkBillException(bill);
        billRepository.deleteById(id);
        return new TrueFalseResponse(true);
    }

    private void checkUserException(Optional<User> user) {
        if(user.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

    private void checkBillException(Optional<Bill> bill) {
        if(bill.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
    }

}
