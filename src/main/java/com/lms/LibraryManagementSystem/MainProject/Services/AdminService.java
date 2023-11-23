package com.lms.LibraryManagementSystem.MainProject.Services;

import com.lms.LibraryManagementSystem.MainProject.Dtos.AdminDto;
import com.lms.LibraryManagementSystem.MainProject.entity.Admin;
import com.lms.LibraryManagementSystem.MainProject.repositories.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminService
{
    @Autowired
    private AdminRepository adminRepository;
  @Autowired
    private ModelMapper modelMapper;

    public void createAdmin(AdminDto adminDto)
    {
        Admin admin = modelMapper.map(adminDto,Admin.class);
        adminRepository.save(admin);

    }
    public List<AdminDto>getALlAdmins()
    {
        List<Admin> admins= adminRepository.findAll();
        return admins.stream().map(admin->modelMapper.map(admin,AdminDto.class)).collect(Collectors.toList());
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
            // Update the fields of the retrieved admin entity with the DTO's data
            admin.setAdminAddress(adminDto.getAdminAddress());
            admin.setAdminDoB(adminDto.getAdminDoB());
            admin.setAdminEmail(adminDto.getAdminEmail());
            admin.setPhoneNo(adminDto.getPhoneNo());

            // Save the updated entity
            adminRepository.save(admin);

            // Return the updated DTO or any response as needed
            return modelMapper.map(admin, AdminDto.class);
        } else {
            throw new RuntimeException("The Admin with ID: " + AdminId+ " is not found");
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
