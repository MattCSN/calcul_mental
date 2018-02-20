package calcul.web.controller;

import calcul.core.entity.Calcul;
import calcul.core.service.CalculService;
import calcul.core.service.impl.CalculServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
public class CalculController {

        private static final Logger LOGGER = LoggerFactory.getLogger(CalculController.class);

        @Inject
        private CalculService calculService;

}
