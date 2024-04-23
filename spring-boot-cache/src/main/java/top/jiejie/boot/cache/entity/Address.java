package top.jiejie.boot.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {
    private static final long serialVersionUID = -3368889280284213396L;
    private String province;
    private String city;
}
