package entity.lazy;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company2")
public class Company2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "company",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Model2> models = new ArrayList<>();


   public static Company2 of(String name) {
       Company2 company = new Company2();
       company.name = name;
       return company;
   }

    public void addModel(Model2 model) {
        this.models.add(model);
    }

    public List<Model2> getModels() {
        return models;
    }

    public void setModels(List<Model2> models) {
        this.models = models;
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
        Company2 company = (Company2) o;
        return id == company.id && Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Company2{" +
                "name='" + name + '\'' +
                '}';
    }
}
