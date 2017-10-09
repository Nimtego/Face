package model.behavior.interfaces;

/**
 * Created by myasnikov
 * on 04.10.2017.
 */
public interface ObservableWin {
    void setObserver(ObserverWin observer);
    void removeObserver(ObserverWin observerWin);
    void update();
}
