package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepositoy studentRepositoy;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    SessionRepository sessionRepository;

    @RequestMapping("/addStudents")
    public String addStudents()
    {
        Student s = new Student("0203773","Brandon", "Gatling" ,"2028345998" ,"1721 October Drive");
        studentRepositoy.save(s);

        s = new Student("0203443","Jacob", "Harris" ,"2028345998" ,"1721 June Drive");
        studentRepositoy.save(s);

        s = new Student("0203993","David", "Wolf" ,"2028345998" ,"1721 July Drive");
        studentRepositoy.save(s);

        return "redirect:/add";
    }

    @RequestMapping("/addCourses")
    public String addCourses()
    {
        Course c = new Course("Calculus","4545");
        courseRepository.save(c);

        c = new Course("English","2323");
        courseRepository.save(c);

        c = new Course("Biology","4343");
        courseRepository.save(c);

        return "redirect:/add";
    }

    @RequestMapping("/savecourse")
    public String saveCourse(@ModelAttribute("theCourse")Course course, BindingResult result)
    {
        courseRepository.save(course);
        return "redirect:/";
    }

    @RequestMapping("/addcoursewithform")
    public String addCourseWithDropDown(Model model)
    {
        model.addAttribute("theCourse", new Course("",""));
        model.addAttribute("allstudents", studentRepositoy.findAll());
        return "addcourse";
    }


    @RequestMapping("/savestudent")
    public String saveStudent(@ModelAttribute("theStudent")Student student, BindingResult result)
    {
        studentRepositoy.save(student);
        return "redirect:/";
    }

    @RequestMapping("/addstudentwithform")
    public String addStudentWithDropWith(Model model)
    {
        model.addAttribute("theStudent", new Student());
        model.addAttribute("allcourses", courseRepository.findAll());
        return "addstudent";
    }

    @RequestMapping("/saveenrollment")
    public  String saveEnrollment(@ModelAttribute("theEnrollment")Enrollment enrollment, BindingResult result)
    {
        enrollmentRepository.save(enrollment);
        return "redirect:/";
    }

    @RequestMapping("/addenrollmentwithform")
    public String addEnrollmentWithDropWith(Model model)
    {
        model.addAttribute("theEnrollment", new Enrollment());
        model.addAttribute("allstudents", studentRepositoy.findAll());
        return "addenrollment";
    }

    @RequestMapping("/savesession")
    public String saveSession (@ModelAttribute("theSession") Session session, BindingResult result)
    {
        sessionRepository.save(session);
        return "redirect:/";
    }

    @RequestMapping("/addsessionwithform")
    public String addSessionWithDropWith(Model model)
    {
        model.addAttribute("theSession", new Session());
        model.addAttribute("allcourses", courseRepository.findAll());
        return "addsession";
    }




}
