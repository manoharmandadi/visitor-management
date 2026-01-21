package in.mandadi.practice.spring.service;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.data.VisitorRepository;
import in.mandadi.practice.spring.dto.VisitorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class VisitorServiceImpl implements VisitorService{

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public void saveVisit(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    @Override
    public VisitorDto getVisitors() {
        long totalVisitorCount = visitorRepository.count();
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT );
        long todayVisitorCount = visitorRepository.countByVisitTimeGreaterThan(dateTime);
        VisitorDto dto = new VisitorDto(totalVisitorCount, todayVisitorCount);
        return dto;
    }
}
