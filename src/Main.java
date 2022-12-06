import controlP5.*;
import processing.core.PApplet;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class Main extends PApplet {
    ControlP5 p5;
    int sliderVal = 0, btnVal = 0;
    Button btn,disableBtn;
    Slider slider;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void setup() {
        p5 = new ControlP5(this);
        btn = p5.addButton("TestButton");
        disableBtn = p5.addButton("DisableBtn");
        slider = p5.addSlider("TestSlider");

        slider.setValue(sliderVal);
        btn.setLabel(String.valueOf(btnVal));

       // ControlListener controlListener = controlEvent -> sliderVal = sliderVal;
        CallbackListener callbackListener = callbackEvent -> btnVal = btnVal + 1;

        ReadOnlyBtn readOnlyBtn = new ReadOnlyBtn(btn, callbackListener);

        btn.addListenerFor(ACTION_RELEASE,(callbackListener));
        disableBtn.addListenerFor(ACTION_RELEASE, callbackEvent -> readOnlyBtn.setDisabled(!readOnlyBtn.isEnabled()));
       // new ReadOnlySlider(slider, controlListener);

    }

    @Override
    public void settings() {
        size(200, 400);
    }

    @Override
    public void draw() {
        btn.setLabel(String.valueOf(btnVal));
    }
}