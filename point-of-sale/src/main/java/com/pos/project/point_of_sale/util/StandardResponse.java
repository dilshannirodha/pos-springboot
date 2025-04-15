package com.pos.project.point_of_sale.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;

}
