package in.mandadi.practice.spring.mvc;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.dto.VisitorDto;
import in.mandadi.practice.spring.service.VisitorService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitorController {

    Logger logger = LoggerFactory.getLogger(VisitorController.class);

    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public VisitorDto recordVisit(@RequestHeader HttpHeaders headers, HttpServletRequest servletRequest){
        logger.info(LocalDateTime.now() +" : Visitor from "+servletRequest.getRemoteAddr()+" visited");
        logger.debug("Using "+  headers.get("sec-ch-ua-platform")+" : "+headers.get("sec-ch-ua"));
        Visitor visit = new Visitor();
        visit.setIp(servletRequest.getRemoteAddr());
        visit.setDetails(headers.get("sec-ch-ua-platform")+" : "+headers.get("sec-ch-ua"));
        visit.setVisitTime(LocalDateTime.now());
        visitorService.saveVisit(visit);
        return visitorService.getVisitorCount();
    }

    @GetMapping
    public List<Visitor> getVisitors(){
        logger.info("Get Visitors api called." );
        return visitorService.getVisitors();
    }
}
