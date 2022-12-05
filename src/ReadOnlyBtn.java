import controlP5.Button;
import controlP5.CColor;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;

import javax.security.auth.callback.Callback;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class ReadOnlyBtn {

    Button btn;
    CallbackListener listener;
    private boolean readOnly;

    ReadOnlyBtn(Button btn, CallbackListener listener) {
        this.btn = btn;
        this.listener = listener;
        readOnly = false;
    }

    public boolean isEnabled() {
        return readOnly;
    }

    void setDisabled(boolean state) {
        readOnly = state;
        if (state) {
            CColor gray = new CColor().setBackground(255);
            btn.setColor(gray);
            btn.removeCallback(this.listener);
        }else {
            btn.addCallback(this.listener);
        }
    }
}
