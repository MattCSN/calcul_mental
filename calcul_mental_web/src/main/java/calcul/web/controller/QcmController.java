package calcul.web.controller;

import calcul.core.entity.Qcm;
import calcul.core.service.QcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@RequestMapping("/calculator")
@Controller
public class QcmController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QcmController.class);

    @Inject
    private QcmService qcmService;


    @RequestMapping("/")
    public Qcm getQCM(){
        LOGGER.debug("Je vais chercher un QCM");
        Qcm qcm= new Qcm();
        return qcm;
    }
}
