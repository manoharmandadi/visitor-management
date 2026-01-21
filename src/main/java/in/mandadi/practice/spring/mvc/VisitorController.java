package in.mandadi.practice.spring.mvc;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.dto.VisitorDto;
import in.mandadi.practice.spring.service.VisitorService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/visit")
public class VisitorController {

    Logger logger = LoggerFactory.getLogger(VisitorController.class);

    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public VisitorDto recordVisit(HttpServletRequest servletRequest){
        logger.info(LocalDateTime.now() +" : Visitor from "+servletRequest.getRemoteAddr()+" visited");
        Visitor visit = new Visitor();
        visit.setIp(servletRequest.getRemoteAddr());
        visit.setDetails(servletRequest.getRemoteUser());
        visit.setVisitTime(LocalDateTime.now());
        visitorService.saveVisit(visit);

        VisitorDto dto = visitorService.getVisitors();

        return dto;
    }
}
