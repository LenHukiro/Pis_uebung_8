import controlP5.CColor;
import controlP5.ControlListener;
import controlP5.Slider;

import java.awt.*;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class ReadOnlySlider {
    private final ControlListener listener;
    private final Slider slider;

    private boolean readOnly;
    ReadOnlySlider(Slider slider, ControlListener listener){
    this.slider = slider;
    this.listener = listener;
    }

    public boolean isEnabled() {
        return readOnly;
    }

    void setDisabled(boolean state) {
        readOnly = state;
        if (state) {
            slider.setColorBackground(Color.gray.getRGB());
            slider.removeListener(listener);
            slider.setLock(true);
        } else {
            slider.setColorBackground(Color.blue.getRGB());
            slider.addListener(listener);
            slider.setLock(true);
        }
    }
}
