package model;

import view.ObserverWin;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public interface ObservableWin {
    void setObserver(ObserverWin observer);
    void removeObserver(ObserverWin observerWin);
    void update();
}
