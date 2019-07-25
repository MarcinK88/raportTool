package pl.marcin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ConvertedRepository extends JpaRepository<Converted, Long> {

    List<Converted> findByRequestStatus(String status);
    List<Converted> findByRegion(String region);
    List<Converted> findByBa(String ba);
    List<Converted> findByRequester(String requester);
    List<Converted> findByComments(String comments);
    @Query(value="select COUNT(*) from converted where `Request type` = ?1 AND YEAR(`Open date`) = ?2 AND MONTH(`Open date`) = ?3", nativeQuery = true)
    int countByRequestTypeAndOpenDateStartsWith(String requestType, int year, int month);

    @Query(value="select COUNT(*) from converted where `BA` = ?1 AND YEAR(`Open date`) = ?2 AND MONTH(`Open date`) = ?3", nativeQuery = true)
    int countRequestPerBa(String ba, int year, int month);

    @Query(value="select COUNT(*) from converted where `Region` = ?1 AND YEAR(`Open date`) = ?2 AND MONTH(`Open date`) = ?3", nativeQuery = true)
    int countRequestPerRegion(String region, int year, int month);

    @Query(value = "select COUNT(*) from converted where `Request type` = ?1 AND `Open date` >= ?2 AND `Open date` < ?3", nativeQuery = true)
    int countRequestPerType(String type, Date begin, Date end);

    @Query(value = "select ROUND(AVG(`Resolution Time (in days)`),1) from converted where `Open date` >= ?1 and `Open date` < ?2", nativeQuery = true)
    double kpi1(Date begin, Date end);

    @Query(value = "select ROUND(( (select COUNT(*) from converted where `Request status` = \"closed\" AND `Resolution Time (in days)` = 1 AND `Open date` >= ?1 and `Open date` < ?2) * 100 / (select COUNT(*) from converted where `Request status` = \"closed\" AND `Resolution Time (in days)` is not null AND `Open date` >= ?1 and `Open date` < ?2)),1)", nativeQuery = true)
    double kpi2(Date begin, Date end);

    @Query(value = "select ROUND(AVG(`Resolution Time (in days)`),1) from converted where `Request type` = ?1 AND `Open date` >= ?2 and `Open date` < ?3", nativeQuery = true)
    double kpi3(String type, Date begin, Date end);

}
