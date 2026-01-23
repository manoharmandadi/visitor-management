package in.mandadi.practice.spring.service;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.data.VisitorRepository;
import in.mandadi.practice.spring.dto.VisitorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService{

    Logger logger = LoggerFactory.getLogger(VisitorServiceImpl.class);

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public void saveVisit(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    @Override
    public VisitorDto getVisitorCount() {
        long totalVisitorCount = visitorRepository.count();
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT );
        long todayVisitorCount = visitorRepository.countByVisitTimeGreaterThan(dateTime);
        VisitorDto dto = new VisitorDto(totalVisitorCount, todayVisitorCount);
        return dto;
    }

    @Override
    public List<Visitor> getVisitors() {
        logger.info("Fetch all visitors from DB.");
        return visitorRepository.findAll();
    }
}
