package entity.lazy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model2")
public class Model2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Company2 company;


    public static Model2 of(String name, Company2 company) {
        Model2 model = new Model2();
        model.name = name;
        model.company = company;
        return model;
    }

    public Company2 getCompany() {
        return company;
    }

    public void setCompany(Company2 company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model2 model = (Model2) o;
        return id == model.id && Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Model2{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", company=" + company
                + '}';
    }
}
