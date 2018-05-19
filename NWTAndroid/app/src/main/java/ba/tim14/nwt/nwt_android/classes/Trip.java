package ba.tim14.nwt.nwt_android.classes;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;

import ba.tim14.nwt.nwt_android.utils.Utils;

public class Trip {

    private String[] durationPeriod = new String[4];

    // TODO: 5/17/18 distance in kilometers
    private String distance;

    private Date startDateTime;
    private Date stopDateTime;
    private ArrayList<LatLng> path;

    public Trip(Date startDateTime) {
        this.path = new ArrayList<>();
        this.startDateTime = startDateTime;
    }


    public String[] getDurationPeriod() {        return durationPeriod;    }

    public void setDurationPeriod() {
        long diff = getStopDateTime().getTime() - getStartDateTime().getTime();
        //seconds
        long seconds = diff / 1000;
        durationPeriod[3] = String.valueOf(seconds);

        // minutes
        long minutes = seconds / 60;
        durationPeriod[2] = String.valueOf(minutes);

        // hours
        long hours = minutes / 60;
        durationPeriod[1] = String.valueOf(hours);

        //days
        durationPeriod[0] = String.valueOf(hours / 24);

        this.durationPeriod = durationPeriod;
    }

    public String getDistance() {        return distance;    }

    public void setDistance(String distance) {        this.distance = distance;    }

    private Date getStopDateTime() {        return stopDateTime;    }

    public void setStopDateTime(Date stopDateTime) {        this.stopDateTime = stopDateTime;    }

    private Date getStartDateTime() {        return startDateTime;    }


    /**
     *  Start and stop date
     **/
    private String getStartTripDate() {  return Utils.dateFormat.format(getStartDateTime());    }

    private String getStopTripDate() {   return Utils.dateFormat.format(getStopDateTime());    }

    public String getTripDates(){
        return "Trip started: " + getStartTripDate();
        //+  "\n Trip stopped: " + getStopTripDate();
    }

    public ArrayList<LatLng> getPath() {        return path;    }

    public void setPath(ArrayList<LatLng> path) {        this.path = path;    }
}
