package com.scoproject.carmudi.di.component;

import com.scoproject.carmudi.CarmudiApp;
import com.scoproject.carmudi.base.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */

public interface IAppComponent {
    void inject(CarmudiApp app);

    ActivityScreenSwitcher activityScreenSwitcher();
}
