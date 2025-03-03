package generator.com.xinpo.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_order
 */
@Data
public class TOrder implements Serializable {
    private Integer orderId;

    private String orderName;

    private Integer customerId;

    private static final long serialVersionUID = 1L;
}