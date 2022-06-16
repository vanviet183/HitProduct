package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.applications.commons.AuthenticationProvider;
import com.hit.hitproduct.domains.dtos.UserDto;
import com.hit.hitproduct.domains.entities.Bill;
import com.hit.hitproduct.domains.entities.User;
import com.hit.hitproduct.domains.entities.Voucher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService {

    List<User> getListUser();

    User getUserById(Long id);

    User registerUser(UserDto userDto);

    User updateUser(Long id, UserDto userDto);

    TrueFalseResponse deleteUserById(Long id);

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User setAvatar(Long id, MultipartFile multipartFile);

    User save(User user);

    void createNewUserAfterOAuthLoginSuccess(String email, String name, AuthenticationProvider provider);

    void updateUserAfterOAuthLoginSuccess(User user, String name, AuthenticationProvider provider);

    List<Voucher> getListVoucher(Long idUser);

    List<Bill> getBillsOfUser(Long id);
}
