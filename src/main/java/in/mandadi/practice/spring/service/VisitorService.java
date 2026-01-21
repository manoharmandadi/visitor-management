package in.mandadi.practice.spring.service;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.dto.VisitorDto;

import java.time.LocalDateTime;

public interface VisitorService {

    public void saveVisit(Visitor visitor);

    public VisitorDto getVisitors();
}
