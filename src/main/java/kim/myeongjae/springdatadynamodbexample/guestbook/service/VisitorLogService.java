package kim.myeongjae.springdatadynamodbexample.guestbook.service;

import javax.validation.constraints.NotNull;

import kim.myeongjae.springdatadynamodbexample.guestbook.domain.VisitorLog;
import kim.myeongjae.springdatadynamodbexample.guestbook.domain.VisitorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorLogService {
    private VisitorLogRepository visitorLogRepository;

    @Autowired
    public VisitorLogService(@NotNull VisitorLogRepository visitorLogRepository) {
        this.visitorLogRepository = visitorLogRepository;
    }

    public VisitorLog createVisitorLog(final VisitorLog comment) {
        return visitorLogRepository.save(comment);
    }
}
