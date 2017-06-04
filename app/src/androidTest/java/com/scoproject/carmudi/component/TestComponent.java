package com.scoproject.carmudi.component;

import com.scoproject.carmudi.HomeInstrumentedTest;
import com.scoproject.carmudi.di.component.AppComponent;
import com.scoproject.carmudi.scope.TestScope;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 6/4/17.
 */
@TestScope
@Component(dependencies = {AppComponent.class})
public interface TestComponent {
    void inject(HomeInstrumentedTest homeInstrumentedTest);
}
