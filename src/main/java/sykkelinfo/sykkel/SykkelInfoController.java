package sykkelinfo.sykkel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class SykkelInfoController {
    private final SykkelInfoService sykkelInfoService;

    @Autowired
    public SykkelInfoController(SykkelInfoService sykkelInfoService) {
        this.sykkelInfoService = sykkelInfoService;
    }


    @RequestMapping(value = "sykkelstatus", method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("sykkelstatus/list");
        mav.addObject("sykkeler", sykkelInfoService.hentSykkelStativStatus());
        return mav;
    }

}
