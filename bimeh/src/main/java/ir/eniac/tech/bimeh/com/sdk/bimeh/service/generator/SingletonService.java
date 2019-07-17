package ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator;

import javax.inject.Inject;

import ir.eniac.tech.bimeh.com.sdk.bimeh.EniacApplication;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.NetComponent;
import okhttp3.OkHttpClient;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */
public class SingletonService
{
    private NetComponent netComponent;
    @Inject
    ServiceGenerator serviceGenerator;
    @Inject
    OkHttpClient okHttpClient;
    private EniacApplication serviceApplication;
    private static final SingletonService ourInstance = new SingletonService();

    public static SingletonService getInstance()
    {
        return ourInstance;
    }

    public SingletonService setNetComponent(NetComponent netComponent)
    {
        this.netComponent = netComponent;
        return this;
    }

    public void inject()
    {
        ComponentService componentService = DaggerComponentService.builder().netComponent(netComponent).build();
        componentService.inject(this);
    }

    public OkHttpClient getOkHttpClient()
    {
        return okHttpClient;
    }

    private SingletonService()
    {
    }

    public EniacApplication getContext()
    {
        return serviceApplication;
    }

    public void setContext(EniacApplication context)
    {
        this.serviceApplication = context;
    }

//    public AuthenticateLoginService authenticateLoginService()
//    {
//        return new AuthenticateLoginService(serviceGenerator);
//    }
//
//    public FlightSearchService flightSearchService()
//    {
//        return new FlightSearchService(serviceGenerator);
//    }
//
//    public GetFlightLocationsService flightLocationsService()
//    {
//
//        return new GetFlightLocationsService(serviceGenerator);
//    }
//
//    public ReservationService getReservationService()
//    {
//        return new ReservationService(serviceGenerator);
//    }
//
//    public IssueReservationService getIssueReservationService()
//    {
//        return new IssueReservationService(serviceGenerator);
//    }
//
//    public ConditionService getConditionService()
//    {
//        return new ConditionService(serviceGenerator);
//    }
//
//    public GetPassengerInfoService getPassengerInfoService()
//    {
//        return new GetPassengerInfoService(serviceGenerator);
//    }
//
//    public SearchBusService getSearchBusService()
//    {
//        return new SearchBusService(serviceGenerator);
//    }
//
//    public GetBusLocationsService getBusLocationsService()
//    {
//        return new GetBusLocationsService(serviceGenerator);
//    }
//    public LockSeatService lockSeatService() {
//        return new LockSeatService(serviceGenerator);
//    }
//
//
//    public GetAllNationalities getAllNationalities()
//    {
//        return new GetAllNationalities(serviceGenerator);
//    }
//
//    public HotelSearchService HotelSearchService()
//    {
//        return new HotelSearchService(serviceGenerator);
//    }
//
//    public HotelSearchByIdService HotelSearchByIdService()
//    {
//        return new HotelSearchByIdService(serviceGenerator);
//    }
//
//    public HotelContentService GetHotelContent()
//    {
//        return new HotelContentService(serviceGenerator);
//    }
//
//    public CancellationPoliciesService GetCancellationPolicies()
//    {
//        return new CancellationPoliciesService(serviceGenerator);
//    }
//
//    public TempReservationService TempReservasionService()
//    {
//        return new TempReservationService(serviceGenerator);
//    }
//
//    public ConfirmReservationService ConfirmReservasionService()
//    {
//        return new ConfirmReservationService(serviceGenerator);
//    }
//
//    public GetBookingInfoService GetBookingInfoService()
//    {
//        return new GetBookingInfoService(serviceGenerator);
//    }
//
//    public GetHotelLocationByTitleService getHotelLocationByTitleService()
//    {
//        return new GetHotelLocationByTitleService(serviceGenerator);
//    }
}