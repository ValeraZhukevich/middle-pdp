package pojo;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonAlias;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FilePOJO {

    String file_name;

    String content_base64;
}
