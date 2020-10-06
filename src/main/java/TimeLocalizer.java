import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLocalizer {
        public Date localizeTime(String timeString) throws ParseException {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            return formatter.parse(String.valueOf(timeString));
        }
    }

