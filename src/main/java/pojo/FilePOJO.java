package pojo;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonAlias;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FilePOJO {

    @JsonProperty("file_name")
    String fileName;

    @JsonProperty("content_base64")
    String contentBase64;
}
