package pl.marcin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConvertedRepository extends JpaRepository<Converted, Long> {

    List<Converted> findByRequestStatus(String status);
    List<Converted> findByRegion(String region);
    List<Converted> findByBa(String ba);
    List<Converted> findByRequester(String requester);
    List<Converted> findByComments(String comments);
    @Query(value="select COUNT(*) from converted where `Request type` = ?1 AND YEAR(`Open date`) = ?2 AND MONTH(`Open date`) = ?3", nativeQuery = true)
    int countByRequestTypeAndOpenDateStartsWith(String requestType, int year, int month);

}
