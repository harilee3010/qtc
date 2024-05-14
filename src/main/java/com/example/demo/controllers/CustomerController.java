package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private CustomerRepository customerRepository;

    @GetMapping("/get-next-employee-id")
    @ResponseBody
    public String getNextEmployeeId(@RequestParam("chucVu") String chucVu) {
        String convert = "";
        if(chucVu.equals("nhan-vien"))
            convert = "Nhân viên";
        if(chucVu.equals("cong-tac-vien"))
            convert = "Cộng tác viên";
        if(chucVu.equals("sinh-vien-thuc-tap"))
            convert = "Sinh viên thực tập";
        // Thực hiện truy vấn để đếm số lượng nhân viên theo chức vụ từ cơ sở dữ liệu
        String sql = "select COUNT(*) as dem from qlnv.customers where position = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, convert);

        // Nếu không có bản ghi nào, trả về "1" làm số tiếp theo
        if (count == null) {
            return "mysql méo ăn";
        }
        // Trả về số lượng nhân viên hiện có + 1 dưới dạng chuỗi
        return String.valueOf(count + 1);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers/get-next-employee-id";
    }

}
