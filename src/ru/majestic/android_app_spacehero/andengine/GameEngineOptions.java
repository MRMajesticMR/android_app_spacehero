package ru.majestic.android_app_spacehero.andengine;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;

public class GameEngineOptions extends EngineOptions {

   public GameEngineOptions(Camera pCamera) {
      super(true, ScreenOrientation.PORTRAIT_FIXED, new FillResolutionPolicy(), pCamera);
   }

}
