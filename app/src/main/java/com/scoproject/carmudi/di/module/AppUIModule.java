package com.scoproject.carmudi.di.module;

import com.scoproject.carmudi.di.scope.AppScope;
import com.scoproject.carmudi.base.navigation.ActivityScreenSwitcher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

@Module
public class AppUIModule{
    @Provides
    @AppScope
    ActivityScreenSwitcher provideActivityScreenSwitcher() {
        return new ActivityScreenSwitcher();
    }

}
