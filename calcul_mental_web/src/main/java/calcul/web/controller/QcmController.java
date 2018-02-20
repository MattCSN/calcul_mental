package calcul.web.controller;

import calcul.core.service.QcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class QcmController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QcmController.class);

    @Inject
    private QcmService qcmService;
}
