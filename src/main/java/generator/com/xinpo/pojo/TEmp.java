package generator.com.xinpo.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_emp
 */
@Data
public class TEmp implements Serializable {
    private Integer empId;

    private String empName;

    private Double empSalary;

    private static final long serialVersionUID = 1L;
}