package calcul.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.pw04.entity.Student;
import yncrea.pw04.service.StudentService;

import javax.inject.Inject;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Inject
    private StudentService studentService;

    @RequestMapping("/list")
    public String getListOfStudents(ModelMap model){
        LOGGER.debug("J'affiche la liste des étudiants");
        final List<Student> all = studentService.findAllWithCourses();
        model.addAttribute("students",all);
        return "studentsList";
    }

    @RequestMapping("/form")
    public String getForm(ModelMap model){
        model.addAttribute("student",new Student());
        return "studentForm";
    }

    @RequestMapping(path = "/form",method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/list";
    }

    @RequestMapping("/{id:\\d+}/delete")
    public String deleteStudent(@PathVariable("id")long id){
        studentService.deleteStudent(id);
        return "redirect:../list";
    }

}
