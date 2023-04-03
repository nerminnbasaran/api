package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Petpojo {


    private String status;

    public Petpojo() {
    }

    public Petpojo(String status) {

        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Petpojo{" +
                "status='" + status + '\'' +
                '}';
    }



}
