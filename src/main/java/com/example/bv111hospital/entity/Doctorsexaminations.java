package com.example.bv111hospital;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Doctorsexaminations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_doctorsexaminations", nullable = false)
    private Integer idDoctorsexaminations;
    @Basic
    @Column(name = "EndTime", nullable = false)
    private Time endTime;
    @Basic
    @Column(name = "StartTime", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "deseases_id", nullable = false)
    private Integer deseasesId;
    @Basic
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;
    @Basic
    @Column(name = "examination_id", nullable = false)
    private Integer examinationId;
    @Basic
    @Column(name = "ward_id", nullable = false)
    private Integer wardId;
    @ManyToOne
    @JoinColumn(name = "deseases_id", referencedColumnName = "id_deseases", nullable = false)
    private Deseases deseasesByDeseasesId;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id_doctors", nullable = false)
    private Doctors doctorsByDoctorId;
    @ManyToOne
    @JoinColumn(name = "examination_id", referencedColumnName = "id_examinations", nullable = false)
    private Examinations examinationsByExaminationId;
    @ManyToOne
    @JoinColumn(name = "ward_id", referencedColumnName = "id_wards", nullable = false)
    private Wards wardsByWardId;

    public Integer getIdDoctorsexaminations() {
        return idDoctorsexaminations;
    }

    public void setIdDoctorsexaminations(Integer idDoctorsexaminations) {
        this.idDoctorsexaminations = idDoctorsexaminations;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Integer getDeseasesId() {
        return deseasesId;
    }

    public void setDeseasesId(Integer deseasesId) {
        this.deseasesId = deseasesId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctorsexaminations that = (Doctorsexaminations) o;

        if (idDoctorsexaminations != null ? !idDoctorsexaminations.equals(that.idDoctorsexaminations) : that.idDoctorsexaminations != null)
            return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (deseasesId != null ? !deseasesId.equals(that.deseasesId) : that.deseasesId != null) return false;
        if (doctorId != null ? !doctorId.equals(that.doctorId) : that.doctorId != null) return false;
        if (examinationId != null ? !examinationId.equals(that.examinationId) : that.examinationId != null)
            return false;
        if (wardId != null ? !wardId.equals(that.wardId) : that.wardId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDoctorsexaminations != null ? idDoctorsexaminations.hashCode() : 0;
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (deseasesId != null ? deseasesId.hashCode() : 0);
        result = 31 * result + (doctorId != null ? doctorId.hashCode() : 0);
        result = 31 * result + (examinationId != null ? examinationId.hashCode() : 0);
        result = 31 * result + (wardId != null ? wardId.hashCode() : 0);
        return result;
    }

    public Deseases getDeseasesByDeseasesId() {
        return deseasesByDeseasesId;
    }

    public void setDeseasesByDeseasesId(Deseases deseasesByDeseasesId) {
        this.deseasesByDeseasesId = deseasesByDeseasesId;
    }

    public Doctors getDoctorsByDoctorId() {
        return doctorsByDoctorId;
    }

    public void setDoctorsByDoctorId(Doctors doctorsByDoctorId) {
        this.doctorsByDoctorId = doctorsByDoctorId;
    }

    public Examinations getExaminationsByExaminationId() {
        return examinationsByExaminationId;
    }

    public void setExaminationsByExaminationId(Examinations examinationsByExaminationId) {
        this.examinationsByExaminationId = examinationsByExaminationId;
    }

    public Wards getWardsByWardId() {
        return wardsByWardId;
    }

    public void setWardsByWardId(Wards wardsByWardId) {
        this.wardsByWardId = wardsByWardId;
    }
}
