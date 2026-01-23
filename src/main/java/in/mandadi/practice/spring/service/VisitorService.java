package in.mandadi.practice.spring.service;

import in.mandadi.practice.spring.data.Visitor;
import in.mandadi.practice.spring.dto.VisitorDto;

import java.util.List;

public interface VisitorService {

    public void saveVisit(Visitor visitor);

    public VisitorDto getVisitorCount();

    public List<Visitor> getVisitors();
}
