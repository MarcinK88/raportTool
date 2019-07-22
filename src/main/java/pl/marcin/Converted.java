package pl.marcin;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="converted")
public class Converted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "`Request ID`")
    private String requestId;
    @Column(name = "`Request type`")
    private String requestType;
    @Column(name = "`Certificate name`")
    private String certificateName;
    @Column(name = "`Domain total number/tag`")
    private String domainTotalNumberTag;
    @Column(name = "`Request owner`")
    private String requestOwner;
    @Column(name = "`Request contributor`")
    private String requestContributor;
    @Column(name = "`Request status`")
    private String requestStatus;
    private int year;
    @Column(name = "`Open date`")
    private Date openDate;
    @Column(name = "`Open CW`")
    private Integer openCw;
    @Column(name = "`Open month`")
    private String openMonth;
    @Column(name = "`Close date`")
    @Nullable
    private Date closeDate;
    @Column(name = "`Close CW`")
    private Integer closeCw;
    @Column(name = "`Close month`")
    private String closeMonth;
    @Column(name = "`Resolution Time (in days)`")
    private Integer resolutionTimeInDays;
    private String region;
    private String ba;
    private String size;
    @Column(name = "`Provider name`")
    private String providerName;
    @Column(name = "`Provider Ref.NO`")
    private String providerRefNo;
    private String requester;
    private String comments;

    public Converted() {
    }

    public Converted(String requestId, String requestType, String certificateName, String domainTotalNumberTag, String requestOwner, String requestContributor, String requestStatus, int year, Date openDate, Integer openCw, String openMonth, Date closeDate, Integer closeCw, String closeMonth, Integer resolutionTimeInDays, String region, String ba, String size, String providerName, String providerRefNo, String requester, String comments) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.certificateName = certificateName;
        this.domainTotalNumberTag = domainTotalNumberTag;
        this.requestOwner = requestOwner;
        this.requestContributor = requestContributor;
        this.requestStatus = requestStatus;
        this.year = year;
        this.openDate = openDate;
        this.openCw = openCw;
        this.openMonth = openMonth;
        this.closeDate = closeDate;
        this.closeCw = closeCw;
        this.closeMonth = closeMonth;
        this.resolutionTimeInDays = resolutionTimeInDays;
        this.region = region;
        this.ba = ba;
        this.size = size;
        this.providerName = providerName;
        this.providerRefNo = providerRefNo;
        this.requester = requester;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getDomainTotalNumberTag() {
        return domainTotalNumberTag;
    }

    public void setDomainTotalNumberTag(String domainTotalNumberTag) {
        this.domainTotalNumberTag = domainTotalNumberTag;
    }

    public String getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(String requestOwner) {
        this.requestOwner = requestOwner;
    }

    public String getRequestContributor() {
        return requestContributor;
    }

    public void setRequestContributor(String requestContributor) {
        this.requestContributor = requestContributor;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Integer getOpenCw() {
        return openCw;
    }

    public void setOpenCw(Integer openCw) {
        this.openCw = openCw;
    }

    public String getOpenMonth() {
        return openMonth;
    }

    public void setOpenMonth(String openMonth) {
        this.openMonth = openMonth;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getCloseCw() {
        return closeCw;
    }

    public void setCloseCw(Integer closeCw) {
        this.closeCw = closeCw;
    }

    public String getCloseMonth() {
        return closeMonth;
    }

    public void setCloseMonth(String closeMonth) {
        this.closeMonth = closeMonth;
    }

    public Integer getResolutionTimeInDays() {
        return resolutionTimeInDays;
    }

    public void setResolutionTimeInDays(Integer resolutionTimeInDays) {
        this.resolutionTimeInDays = resolutionTimeInDays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderRefNo() {
        return providerRefNo;
    }

    public void setProviderRefNo(String providerRefNo) {
        this.providerRefNo = providerRefNo;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
