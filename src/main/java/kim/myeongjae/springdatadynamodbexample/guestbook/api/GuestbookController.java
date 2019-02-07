package kim.myeongjae.springdatadynamodbexample.guestbook.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import kim.myeongjae.springdatadynamodbexample.guestbook.api.dto.VisitorLogDto;
import kim.myeongjae.springdatadynamodbexample.guestbook.domain.VisitorLog;
import kim.myeongjae.springdatadynamodbexample.guestbook.service.VisitorLogService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guestbook")
public class GuestbookController {

    @NotNull
    private VisitorLogService visitorLogService;
    private ModelMapper modelMapper;

    public GuestbookController(@NotNull VisitorLogService visitorLogService) {
        this.visitorLogService = visitorLogService;
        this.modelMapper = new ModelMapper();
    }

    /**
     * POST /visitor-logs.
     * @param requestDto {'memberId', 'name', 'content'}
     * @return created VisitorLog
     */
    @PostMapping("/visitor-logs")
    public VisitorLogDto create(@RequestBody @Valid final VisitorLogDto requestDto) {
        VisitorLog newVisitorLog = new VisitorLog(requestDto.getName(), requestDto.getContent());

        VisitorLog visitorLog = visitorLogService.createVisitorLog(newVisitorLog);

        return modelMapper.map(visitorLog, VisitorLogDto.class);
    }
}
