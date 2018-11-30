package com.serjes.equiper.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Devices")
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "snumber")
    private String serialNumber;

    @Column(name = "inumber")
    private String inventoryNumber;

    @Column(name = "mounted")
    private Boolean mounted;

    @Column(name = "instock")
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "clocation_id")
    private Location currentLocation;

    @ManyToOne
    @JoinColumn(name = "plocation_id")
    private Location plannedLocation;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "discussion_id")
    private Set<Remark> discussion;

    public Device(String name, String model, String description, String serialNumber, String inventoryNumber,
                  Boolean mounted, Boolean inStock, Location currentLocation, Location plannedLocation,
                  Contract contract, String comment) {
        this.name = name;
        this.model = model;
        this.description = description;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.mounted = mounted;
        this.inStock = inStock;
        this.currentLocation = currentLocation;
        this.plannedLocation = plannedLocation;
        this.contract = contract;
        this.comment = comment;
    }
}
