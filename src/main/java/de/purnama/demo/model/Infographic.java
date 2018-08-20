package de.purnama.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * @author Arthur Purnama (arthur@purnama.de)
 */
@Entity
public class Infographic {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @Version
    @Column(columnDefinition = "bigint default 0")
    private Long  version;

    @ManyToOne
    private CivilService civilService;

    @Column
    private String description;

    @Column
    private String resource;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public CivilService getCivilService() {
        return civilService;
    }

    public void setCivilService(CivilService civilService) {
        this.civilService = civilService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}