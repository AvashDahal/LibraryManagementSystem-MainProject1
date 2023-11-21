package com.lms.LibraryManagementSystem.MainProject.Services;

import com.lms.LibraryManagementSystem.MainProject.Dtos.AdminDto;
import com.lms.LibraryManagementSystem.MainProject.entity.Admin;
import com.lms.LibraryManagementSystem.MainProject.repositories.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService
{
    private AdminRepository adminRepository;
    private AdminDto adminDto;
    private ModelMapper modelMapper;

    public void createAdmin(AdminDto adminDto)
    {
        Admin admin = modelMapper.map(adminDto,Admin.class);
        adminRepository.save(admin);

    }
    public List<AdminDto>getALlAdmins()
    {
        List<Admin> admins= adminRepository.findAll();
        return admins.stream().map(admin->modelMapper.map(admins,AdminDto.class)).collect(Collectors.toList());
     /*   List<AdminDto>adminDtos= new ArrayList<>();
        for (Admin admin: admins)
        {
            AdminDto adminDto = new AdminDto();
            adminDto.setAdminAddress(admin.getAdminAddress());
            adminDto.setAdminDoB(admin.getAdminDoB());
            adminDto.setAdminEmail(admin.getAdminEmail());
            adminDtos.add(adminDto);


        }

        return  adminDto
*/
    }
    public AdminDto getAdminById(int AdminId)
    {
        Optional<Admin> optionalAdmin= adminRepository.findById(AdminId);

        if (optionalAdmin.isPresent())
        {
            Admin admin = optionalAdmin.get();
            AdminDto adminDto = modelMapper.map(admin,AdminDto.class);
           /* AdminDto adminDto1= new AdminDto();
            adminDto1.setAdminId(admin.getAdminId());
            adminDto1.setAdminEmail(admin.getAdminEmail());
            adminDto1.setAdminDoB(admin.getAdminDoB());
            adminDto1.setAdminAddress(admin.getAdminAddress());*/
            return adminDto;
        }
        else
        {
            throw new RuntimeException("The Admin of AdminId: "+AdminId+"is not found");
        }


    }
    public AdminDto updateAdminById(int AdminId,AdminDto adminDto)
    {
        Optional<Admin>optionalAdmin=adminRepository.findById(AdminId);
        if (optionalAdmin.isPresent())
        {
            Admin admin = optionalAdmin.get();
            modelMapper.map(adminDto,admin);
            adminRepository.save(admin);
            AdminDto updatedAdminDto= modelMapper.map(admin,AdminDto.class);
            return updatedAdminDto;


        }
        else
        {
            throw new RuntimeException("The Admin of :"+AdminId+"is not found");
        }

    }
    public void deleteAdminById(int AdminId)
    {
        Optional<Admin>optionalAdmin=adminRepository.findById(AdminId);
        if (optionalAdmin.isPresent())
        {
            Admin admin=optionalAdmin.get();
            adminRepository.delete(admin);
        }
        else
        {
            throw new RuntimeException("The Admin of Admin Id :"+AdminId+"is not found");
        }
    }


}
