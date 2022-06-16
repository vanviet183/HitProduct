package com.hit.hitproduct.adapter.web.v1.controllers;

import com.hit.hitproduct.adapter.web.base.VsResponseUtil;
import com.hit.hitproduct.applications.events.RegistrationCompleteEvent;
import com.hit.hitproduct.applications.services.PasswordResetTokenService;
import com.hit.hitproduct.applications.services.UserService;
import com.hit.hitproduct.applications.services.VerificationTokenService;
import com.hit.hitproduct.domains.dtos.UserDto;
import com.hit.hitproduct.domains.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("")
    public ResponseEntity<?> getUsers() {
//        return VsResponseUtil.ok(userService.getListUser());
        return ResponseEntity.ok().body(userService.getListUser());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
//        return VsResponseUtil.ok(userService.getUserById(id));
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/{id}/bills")
    public ResponseEntity<?> getBills(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(userService.getBillsOfUser(id));
    }

    @GetMapping("/{id}/vouchers")
    public ResponseEntity<?> getVouchersByUserId(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(userService.getListVoucher(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto, final HttpServletRequest request, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return VsResponseUtil.ok(bindingResult.getAllErrors().stream().map(i -> i.getDefaultMessage()));
        }

        User user = userService.registerUser(userDto);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return VsResponseUtil.ok(user);
    }

    @PostMapping("/{id}/avatar")
    public ResponseEntity<?> uploadAvatar(@PathVariable("id") Long id, @RequestParam("avatar") MultipartFile multipartFile) {
        return VsResponseUtil.ok(userService.setAvatar(id, multipartFile));
    }

    @PatchMapping("/{idAcc}")
    public ResponseEntity<?> updateUser(@PathVariable("idAcc") Long idAcc, @RequestBody UserDto userDto) {
        return VsResponseUtil.ok((userService.updateUser(idAcc, userDto)));
    }

    @DeleteMapping("/{idAcc}")
    public ResponseEntity<?> deleteUser(@PathVariable("idAcc") Long idAcc) {
        return VsResponseUtil.ok(userService.deleteUserById(idAcc));
    }

    private String applicationUrl(HttpServletRequest request) {
        return "https://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
