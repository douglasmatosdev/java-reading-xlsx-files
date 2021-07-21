import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Table {

    private Date intialHour;
    private Date endHour;
    private Date totalHour;
    private String description;
}
