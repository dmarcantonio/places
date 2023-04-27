package com.dma.places.boundary.dto;

import com.dma.places.domain.TestObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestObjectDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;
    private double longitude;
    private double latitude;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String imageUrl = "https://cdn4.iconfinder.com/data/icons/small-n-flat/24/map-marker-128.png";
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private double[] coordinates;

    public TestObjectDTO(int id, double longitude, double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * This constructor is essential for the transformation between Point and latitude and longitude
     * @param object
     */
    public TestObjectDTO(TestObject object) {
        this.id = object.getId();
        this.latitude = object.getCoordinate().getX();
        this.longitude = object.getCoordinate().getY();
        this.coordinates = new double[]{this.longitude, this.latitude};
    }
}
