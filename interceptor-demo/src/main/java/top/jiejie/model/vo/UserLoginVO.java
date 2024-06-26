package top.jiejie.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Schema(description = "⽤户登录vo")
public class UserLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8212240698099812005L;
    @Schema(description = "⽤户ID")
    private Integer id;
    @Schema(description = "⼿机号")
    private String phone;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "令牌")
    private String accessToken;
}