package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetCategoryPojo {

    private Integer id;
    private String name;

    public PetCategoryPojo() {
    }

    public PetCategoryPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetCategoryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
