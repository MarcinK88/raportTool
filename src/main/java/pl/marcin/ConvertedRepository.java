package pl.marcin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvertedRepository extends JpaRepository<Converted, Long> {

    List<Converted> findByRequestStatus(String status);
    List<Converted> findByRegion(String region);
    List<Converted> findByBa(String ba);
    List<Converted> findByRequester(String requester);
    List<Converted> findByComments(String comments);
}
