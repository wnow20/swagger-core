package io.swagger.v3.plugin.maven.petstore.petstore.parameter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class RepeatableParametersResource {
    @Path("/repeatableparameter")
    @POST
    @Parameter(in = ParameterIn.PATH, name = "subscriptionId", required = true,
            schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class), style = ParameterStyle.SIMPLE)
    @Parameter(in = ParameterIn.QUERY, name = "formId", required = true,
            example = "Example")
    @Parameter(in = ParameterIn.QUERY, name = "explodeFalse", required = true, explode = Explode.FALSE,
            schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class))
    @Parameter(in = ParameterIn.QUERY, name = "explodeTrue", required = true, explode = Explode.TRUE,
            schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class))
    @Parameter(in = ParameterIn.QUERY, name = "explodeAvoiding", required = true, explode = Explode.TRUE,
            schema = @Schema(
                    type = "int",
                    format = "id",
                    description = "the generated id",
                    accessMode = Schema.AccessMode.READ_ONLY
            ))
    @Parameter(in = ParameterIn.QUERY, name = "arrayParameter", required = true, explode = Explode.TRUE,
            array = @ArraySchema(maxItems = 10, minItems = 1,
                    schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class),
                    uniqueItems = true
            )
            ,
            schema = @Schema(
                    type = "int",
                    format = "id",
                    description = "the generated id",
                    accessMode = Schema.AccessMode.READ_ONLY),
            content = @Content(schema = @Schema(type = "number",
                    description = "the generated id",
                    accessMode = Schema.AccessMode.READ_ONLY))
    )
    @Parameter(in = ParameterIn.QUERY, name = "arrayParameterImplementation", required = true, explode = Explode.TRUE,
            array = @ArraySchema(maxItems = 10, minItems = 1,
                    schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class),
                    uniqueItems = true
            )
    )
    @Parameter(in = ParameterIn.QUERY, name = "arrayParameterImplementation2", required = true, explode = Explode.TRUE,
            schema = @Schema(implementation = ParametersResource.SubscriptionResponse.class))
    @Operation(
            operationId = "subscribe",
            description = "subscribes a client to updates relevant to the requestor's account, as " +
                    "identified by the input token.  The supplied url will be used as the delivery address for response payloads",
            responses = {
                    @ApiResponse(
                            description = "test description", content = @Content(
                            mediaType = "*/*",
                            schema =
                            @Schema(
                                    implementation = ParametersResource.SubscriptionResponse.class)
                    ))
            })
    @Consumes({"application/json", "application/xml"})
    public ParametersResource.SubscriptionResponse subscribe() {
        return null;
    }

    static class SubscriptionResponse {
        public String subscriptionId;
    }
}

