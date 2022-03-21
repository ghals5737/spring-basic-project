package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
public class User {

    @NotBlank
    private String name;
    @Min(value = 0)
    private int age;
//    @Email
//    private String email;
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
//    private String phoneNumber;
//    @YearMonth
//    private String reqYearMonth;
    @Valid
    private List<Car> cars;

//    @AssertTrue(message = "yyyyMM 의 형식에 맞지 않습니다.")
//    public boolean isReqYearMonthValidation(){
//
//        try{
//            LocalDate localDate=LocalDate.parse(reqYearMonth+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        }catch (Exception e){
//            return false;
//        }
//        return true;
//    }
}
