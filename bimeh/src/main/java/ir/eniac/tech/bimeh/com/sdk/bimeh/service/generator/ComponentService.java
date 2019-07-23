package ir.eniac.tech.bimeh.com.sdk.bimeh.service.generator;

import dagger.Component;
import ir.eniac.tech.bimeh.com.sdk.bimeh.di.component.NetComponent;
import ir.eniac.tech.bimeh.com.sdk.bimeh.service.scope.CustomScope;

/**
 * Created by Javad.Abadi on 3/26/2018.
 */
@CustomScope
@Component(dependencies = NetComponent.class)
public interface ComponentService {
    void inject(SingletonService singletonService);
}
