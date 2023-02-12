package pojo;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllureResultsPOJO {

    FilePOJO[] results;


}
