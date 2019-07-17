package ir.eniac.tech.bimeh.com.sdk.bimeh.service.helper;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */

public class Const
{
    public final static String ClientUniqueCode = "ZWQzNzkwYjctYzBmMy00MTc0LWFmMjYtYTc0NWE0ZTM1OGRh";

    public final static Boolean MOCK = false;

    public static Boolean TEST = false;

    public final static String BASEURL = "http://www.eniacgds.com:1031/MainService.svc/";
//    public final static String BASEURL = "http://192.168.20.242:1031/MainService.svc/";

    public static final int HotelServiceId = 2;

    public final static String AuthenticateLogin = "rest/AuthenticateLogin";
    public final static String FlightSearch = "restFlight/FlightSearch";
    public final static String GetFlightLocations = "rest/GetFlightSearch";
    public final static String Reservation = "restFlight/Reservation";
    public final static String IssueReservation = "restFlight/IssueReservation";
    public final static String Condition = "restFlight/Condition";
    public final static String GetPassengerInfo = "restFlight/GetPassengerInfo";
    public final static String BusSearch = "restBus/BusSearch";
    public final static String CheckSeat = "restBus/CheckSeat";
    public final static String GetAllNationalities = "restHotel/GetAllNationalities";
    public final static String SearchHotel = "restHotel/SearchHotel";
    public final static String GetBusLocations = "restbus/GetBusLocations";
    public final static String LockSeat = "restbus/LockSeat";
    public final static String GetHotelContent = "restHotel/HotelContent";
    public final static String GetCancellationPolicies = "restHotel/GetCancellationPolicies";
    public final static String SetTempReservation = "restHotel/Inquiry";
    public final static String SetConfirmReservation = "restHotel/Confirm";
    public final static String GetBookingInfo = "rest/GetBookingInfo";
    public final static String SaleVerify = "restBus/SaleVerify";
    public final static String GetHotelLocationByTitle = "restHotel/GetHotelLocationByTitle";

}