package calcul.web.controller;

import calcul.core.service.CalculService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@RequestMapping("")
@Controller
public class CalculController {

        private static final Logger LOGGER = LoggerFactory.getLogger(CalculController.class);

        //@Inject
        //private CalculService calculService;

}
