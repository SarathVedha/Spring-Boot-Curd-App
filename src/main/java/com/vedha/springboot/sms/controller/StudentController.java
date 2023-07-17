package com.vedha.springboot.sms.controller;

import com.vedha.springboot.sms.dto.StudentDTO;
import com.vedha.springboot.sms.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/student"})
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = {"/"})
    public String reDirect(Model model) {

        return "redirect:student/all";
    }

    // http://localhost:8080/student/all
    @GetMapping(value = {"/all"})
    public String allStudents(Model model) {

        List<StudentDTO> allStudents = studentService.getAllStudents();

        model.addAttribute("Students", allStudents);

        return "students";
    }

    // http://localhost:8080/student/new
    @GetMapping("/new")
    public String newStudent(Model model) {

        StudentDTO studentDTO = new StudentDTO();

        model.addAttribute("student", studentDTO);

        return "create-student";
    }

    // http:localhost:8080/student/save
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                              BindingResult bindingResult,
                              Model model
    ) {

        String page = "";
        if (bindingResult.hasErrors()) {

            model.addAttribute("student", studentDTO);
            page = "create-student";
        }else {

            studentService.saveStudent(studentDTO);
            page = "redirect:/student/all";
        }

        return page;
    }

    // http://localhost:8080/student/edit/1
    @GetMapping("/edit/{studentId}")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model) {

        StudentDTO studentById = studentService.getStudentById(studentId);

        model.addAttribute("student", studentById);

        return "update-student";
    }

    // http://localhost:8080/student/update/1
    @PostMapping("/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                Model model,
                                BindingResult bindingResult) {

        studentDTO.setStudentId(studentId);
        String page = "";
        if (bindingResult.hasErrors()) {

            model.addAttribute("student", studentDTO);
            page = "update-student";

        }else {

            studentService.updateStudent(studentDTO);
            page = "redirect:/student/all";
        }

        return page;
    }

    // http://localhost:8080/student/delete/1
    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {

        studentService.deleteStudent(studentId);

        return "redirect:/student/all";
    }

    // http:localhost:8080/view/1
    @GetMapping("/view/{studentId}")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {

        StudentDTO studentById = studentService.getStudentById(studentId);
        model.addAttribute("student", studentById);

        return "view-student";
    }
}
