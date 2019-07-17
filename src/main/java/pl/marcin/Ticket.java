package pl.marcin;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="ticket")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private Date open_time;
    private String opened_by;
    private String assignment;
    private String status;
    private Date close_time;
    private String resolution_code;
    private String location;
    private String assignee_name;
    private String contact_name;
    private String company;
    private String brief_description;
    private String problem_status;
    private String request_type;
    private String product_type;
    private String resolved_by;
    private Date resolved_time;
    private String contact_service;
    private String tk_contact_fullname;
    private String tk_contact_email;
    private String tk_sap_company_full_name;
    private String tk_assignee_name_fullname;
    private String tk_contact_service_fullname;
    private String tk_callback_contact_ldap_ba;
    private String ba;
    private String tk_country_fullname;
    private String dim_regions_id;
    private String tk_company_id;

    public Ticket() {
    }

    public Ticket(long id, String number, Date open_time, String opened_by, String assignment, String status, Date close_time, String resolution_code, String location, String assignee_name, String contact_name, String company, String brief_description, String problem_status, String request_type, String product_type, String resolved_by, Date resolved_time, String contact_service, String tk_contact_fullname, String tk_contact_email, String tk_sap_company_full_name, String tk_assignee_name_fullname, String tk_contact_service_fullname, String tk_callback_contact_ldap_ba, String ba, String tk_country_fullname, String dim_regions_id, String tk_company_id) {
        this.id = id;
        this.number = number;
        this.open_time = open_time;
        this.opened_by = opened_by;
        this.assignment = assignment;
        this.status = status;
        this.close_time = close_time;
        this.resolution_code = resolution_code;
        this.location = location;
        this.assignee_name = assignee_name;
        this.contact_name = contact_name;
        this.company = company;
        this.brief_description = brief_description;
        this.problem_status = problem_status;
        this.request_type = request_type;
        this.product_type = product_type;
        this.resolved_by = resolved_by;
        this.resolved_time = resolved_time;
        this.contact_service = contact_service;
        this.tk_contact_fullname = tk_contact_fullname;
        this.tk_contact_email = tk_contact_email;
        this.tk_sap_company_full_name = tk_sap_company_full_name;
        this.tk_assignee_name_fullname = tk_assignee_name_fullname;
        this.tk_contact_service_fullname = tk_contact_service_fullname;
        this.tk_callback_contact_ldap_ba = tk_callback_contact_ldap_ba;
        this.ba = ba;
        this.tk_country_fullname = tk_country_fullname;
        this.dim_regions_id = dim_regions_id;
        this.tk_company_id = tk_company_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Date open_time) {
        this.open_time = open_time;
    }

    public String getOpened_by() {
        return opened_by;
    }

    public void setOpened_by(String opened_by) {
        this.opened_by = opened_by;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getClose_time() {
        return close_time;
    }

    public void setClose_time(Date close_time) {
        this.close_time = close_time;
    }

    public String getResolution_code() {
        return resolution_code;
    }

    public void setResolution_code(String resolution_code) {
        this.resolution_code = resolution_code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssignee_name() {
        return assignee_name;
    }

    public void setAssignee_name(String assignee_name) {
        this.assignee_name = assignee_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBrief_description() {
        return brief_description;
    }

    public void setBrief_description(String brief_description) {
        this.brief_description = brief_description;
    }

    public String getProblem_status() {
        return problem_status;
    }

    public void setProblem_status(String problem_status) {
        this.problem_status = problem_status;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getResolved_by() {
        return resolved_by;
    }

    public void setResolved_by(String resolved_by) {
        this.resolved_by = resolved_by;
    }

    public Date getResolved_time() {
        return resolved_time;
    }

    public void setResolved_time(Date resolved_time) {
        this.resolved_time = resolved_time;
    }

    public String getContact_service() {
        return contact_service;
    }

    public void setContact_service(String contact_service) {
        this.contact_service = contact_service;
    }

    public String getTk_contact_fullname() {
        return tk_contact_fullname;
    }

    public void setTk_contact_fullname(String tk_contact_fullname) {
        this.tk_contact_fullname = tk_contact_fullname;
    }

    public String getTk_contact_email() {
        return tk_contact_email;
    }

    public void setTk_contact_email(String tk_contact_email) {
        this.tk_contact_email = tk_contact_email;
    }

    public String getTk_sap_company_full_name() {
        return tk_sap_company_full_name;
    }

    public void setTk_sap_company_full_name(String tk_sap_company_full_name) {
        this.tk_sap_company_full_name = tk_sap_company_full_name;
    }

    public String getTk_assignee_name_fullname() {
        return tk_assignee_name_fullname;
    }

    public void setTk_assignee_name_fullname(String tk_assignee_name_fullname) {
        this.tk_assignee_name_fullname = tk_assignee_name_fullname;
    }

    public String getTk_contact_service_fullname() {
        return tk_contact_service_fullname;
    }

    public void setTk_contact_service_fullname(String tk_contact_service_fullname) {
        this.tk_contact_service_fullname = tk_contact_service_fullname;
    }

    public String getTk_callback_contact_ldap_ba() {
        return tk_callback_contact_ldap_ba;
    }

    public void setTk_callback_contact_ldap_ba(String tk_callback_contact_ldap_ba) {
        this.tk_callback_contact_ldap_ba = tk_callback_contact_ldap_ba;
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba;
    }

    public String getTk_country_fullname() {
        return tk_country_fullname;
    }

    public void setTk_country_fullname(String tk_country_fullname) {
        this.tk_country_fullname = tk_country_fullname;
    }

    public String getDim_regions_id() {
        return dim_regions_id;
    }

    public void setDim_regions_id(String dim_regions_id) {
        this.dim_regions_id = dim_regions_id;
    }

    public String getTk_company_id() {
        return tk_company_id;
    }

    public void setTk_company_id(String tk_company_id) {
        this.tk_company_id = tk_company_id;
    }
}
