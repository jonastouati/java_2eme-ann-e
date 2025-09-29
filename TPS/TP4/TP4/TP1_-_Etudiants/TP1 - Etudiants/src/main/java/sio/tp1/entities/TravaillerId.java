package sio.tp1.entities;

//import javax.persistence.Column;
//import javax.persistence.Embeddable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TravaillerId implements java.io.Serializable {
    private static final long serialVersionUID = -8106687496942457862L;
    @Column(name = "codeEmploye", nullable = false)
    private Integer codeEmploye;

    @Column(name = "codeRayon", nullable = false)
    private Integer codeRayon;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Integer getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(Integer codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public Integer getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(Integer codeRayon) {
        this.codeRayon = codeRayon;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravaillerId entity = (TravaillerId) o;
        return Objects.equals(this.date, entity.date) &&
                Objects.equals(this.codeEmploye, entity.codeEmploye) &&
                Objects.equals(this.codeRayon, entity.codeRayon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, codeEmploye, codeRayon);
    }

}