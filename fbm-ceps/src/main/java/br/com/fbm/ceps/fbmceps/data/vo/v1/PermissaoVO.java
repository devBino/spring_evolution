package br.com.fbm.ceps.fbmceps.data.vo.v1;

import java.io.Serializable;

public class PermissaoVO implements Serializable {
    
    private static final long serialVersionUID = 1l;

    private Long id;
    private String description;

    public PermissaoVO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
