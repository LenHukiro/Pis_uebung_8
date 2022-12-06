import controlP5.*;
import controlP5.Button;
import processing.core.PApplet;

import java.awt.*;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class Main extends PApplet {
    ControlP5 p5;
    int sliderVal = 0, btnVal = 0;
    Button btn, disableAllBtn,disableAllSlider;
    Slider slider;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void setup() {
        p5 = new ControlP5(this);
        btn = p5.addButton("TestButton");
        disableAllBtn = p5.addButton("DisableButton");
        disableAllSlider = p5.addButton("DisableSlider");
        slider = p5.addSlider("TestSlider");

        p5.getAll().forEach(element ->element.setColor(new CColor().setBackground(Color.BLUE.getRGB())));

        slider.setValue(sliderVal);
        btn.setLabel(String.valueOf(btnVal));

        ControlListener controlListener = controlEvent -> btn.setValue(sliderVal);
        CallbackListener callbackListener = callbackEvent -> btn.setLabel(String.valueOf(btnVal+=1));;

        ReadOnlyBtn readOnlyBtn = new ReadOnlyBtn(btn, callbackListener);
        ReadOnlySlider readOnlySlider= new ReadOnlySlider(slider, controlListener);

        btn.addListenerFor(ACTION_RELEASE,(callbackListener));
        disableAllBtn.addListenerFor(ACTION_RELEASE, callbackEvent -> readOnlyBtn.setDisabled(!readOnlyBtn.isEnabled()));
        disableAllSlider.addListenerFor(ACTION_RELEASE, callbackEvent -> readOnlySlider.setDisabled(!readOnlySlider.isEnabled()));

    }

    @Override
    public void settings() {
        size(400, 800);
    }

    @Override
    public void draw() {
    }
}