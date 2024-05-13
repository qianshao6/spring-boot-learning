package top.jiejie.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Schema(description = "⽤户信息vo")
public class UserInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8212240698099812005L;
    @Schema(description = "⽤户ID")
    private Integer id;
    @Schema(description = "⼿机号")
    private String phone;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "个签")
    private String sign;
    @Schema(description = "⽣⽇")
    private LocalDate birthday;
}
