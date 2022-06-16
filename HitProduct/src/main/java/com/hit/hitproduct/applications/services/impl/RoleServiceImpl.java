package com.hit.hitproduct.applications.services.impl;

import com.hit.hitproduct.applications.commons.ERole;
import com.hit.hitproduct.applications.repositories.RoleRepository;
import com.hit.hitproduct.applications.services.RoleService;
import com.hit.hitproduct.configs.exceptions.NotFoundException;
import com.hit.hitproduct.domains.dtos.RoleDto;
import com.hit.hitproduct.domains.entities.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Set<Role> getAllRole() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role findRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        checkRoleException(role);
        return role.get();
    }

    @Override
    public Role getRoleByName(ERole name) {
        Optional<Role> role = roleRepository.findByName(name);
        checkRoleException(role);
        return role.get();
    }

    @Override
    public Role createRole(RoleDto roleDto) {
        Optional<Role> role = roleRepository.findByName(roleDto.getName());
        if(role.isEmpty()) {
            return createOrUpdate(new Role(), roleDto);
        }
        throw new DuplicateFormatFlagsException("Duplicate!");
    }

    @Override
    public Role editRoleById(Long id, RoleDto roleDto) {
        Optional<Role> role = roleRepository.findById(id);
        checkRoleException(role);
        return createOrUpdate(role.get(), roleDto);
    }

    public Role createOrUpdate(Role role, RoleDto roleDto) {
            modelMapper.map(roleDto, role);
            return roleRepository.save(role);
    }

    @Override
    public String deleteRoleById(Long id) {
        roleRepository.deleteById(id);
        return "Delete Successfully";
    }

    private void checkRoleException(Optional<Role> role) {
        if (role.isEmpty()) {
            throw new NotFoundException("Not found!");
        }
    }
}
