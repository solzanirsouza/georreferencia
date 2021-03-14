package souza.solzanir.georreferencia.model.vo;

import java.math.BigDecimal;

public class GeocodeVO {

    private BigDecimal latitude;
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public GeocodeVO setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public GeocodeVO setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }
}
