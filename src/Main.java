import controlP5.*;
import processing.core.PApplet;

public class Main extends PApplet {
    ControlP5 p5;
    int val = 0;
    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void setup() {
        size(   600,800);
        p5 = new ControlP5(this);
        Button button = p5.addButton("TestButton");
        Slider slider = p5.addSlider("TestSlider");
        slider.setValue(val);
        ControlListener controlListener = new ControlListener() {
            @Override
            public void controlEvent(ControlEvent controlEvent) {
                val = (int) slider.getValue();
            }
        };
        slider.addListener(controlListener);
        ReadOnlySlider readOnlySlider = new ReadOnlySlider(slider,controlListener);
    }

    @Override
    public void settings() {
        super.settings();
    }

    @Override
    public void draw() {
        super.draw();
    }
}