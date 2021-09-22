package ro.mh.ebanks.converter;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ro.mh.ebanks.dto.AccountDto;

import ro.mh.ebanks.model.Account;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConverter {
    public AccountDto entityToDto(Account account) {

//		StudentDto dto = new StudentDto();
//		dto.setId(student.getId());
//		dto.setName(student.getName());
//		dto.setUsername(student.getUsername());
//		dto.setPassword(student.getPassword());
//		
//		return dto;

        ModelMapper mapper =new ModelMapper();
        AccountDto map = mapper.map(account, AccountDto.class);
        return map;

    }
    public  List<AccountDto> entityToDto(List<Account> accounts) {

        return	accounts.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }


    public Account dtoToEntity(AccountDto dto)
    {
//		Student st = new Student();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setPassword(dto.getPassword());
//		st.setUsername(dto.getUsername());
//		
//		return st;

        ModelMapper mapper = new ModelMapper();
        Account map = mapper.map(dto, Account.class);
        return map;
    }

    public List<Account> dtoToEntity(List<AccountDto> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
