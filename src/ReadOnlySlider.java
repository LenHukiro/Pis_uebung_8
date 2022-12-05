import controlP5.CColor;
import controlP5.ControlListener;
import controlP5.Slider;

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
            CColor gray = new CColor().setBackground(255);
            slider.setColor(gray);
            slider.removeListener(this.listener);
        }else {
            slider.removeListener(this.listener);
        }
    }
}
