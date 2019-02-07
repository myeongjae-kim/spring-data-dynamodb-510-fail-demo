package kim.myeongjae.springdatadynamodbexample.guestbook.domain;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableScan
@EnableScanCount
public interface VisitorLogRepository extends PagingAndSortingRepository<VisitorLog, String> {
}
