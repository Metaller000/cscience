package ru.metaller.cscience.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.metaller.cscience.controllers.reader.Reader;
import ru.metaller.cscience.controllers.reader.classes.PDFReader;

import java.util.Locale;

@Controller
public class HomePage {
    Reader startText = new PDFReader();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        model.addAttribute("start_text", startText.read("resources/pdf/"));
        model.addAttribute("enter", "ВХОД");
        return "start";
    }
}
