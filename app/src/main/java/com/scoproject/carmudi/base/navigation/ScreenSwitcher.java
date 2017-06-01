package com.scoproject.carmudi.base.navigation;

import android.content.Intent;

public interface ScreenSwitcher {

    void open(Screen screen);

    void goBack();

    void openAndFinish(Screen screen);

    void closeWithResult(int resultCode, Intent result);

    //public void startForResult(Screen screen);
}
