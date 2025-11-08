package com.spring.boot.employees_emails.mapper;

import com.spring.boot.employees_emails.dto.EmailDto;
import com.spring.boot.employees_emails.model.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface EmailMapper {
    EmailDto toDto(Email email);
    Email toEntity(EmailDto dto);
}
