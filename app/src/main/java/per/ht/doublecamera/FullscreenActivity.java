package per.ht.doublecamera;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_fullscreen);

        if (null == savedInstanceState) {
            // TODO: Switch front camera to external camera.
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.back_cam_container, CameraFragment.newInstance(R.id.cam_texture, CameraCharacteristics.LENS_FACING_BACK))
                    .replace(R.id.usb_cam_container, CameraFragment.newInstance(R.id.cam_texture, CameraCharacteristics.LENS_FACING_FRONT))
                    .commit();
        }
    }
}
