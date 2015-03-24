package ru.majestic.android_app_spacehero.andengine;

import org.andengine.engine.camera.Camera;

public class GameCamera extends Camera {

   private static final int DEFAULT_WIDTH   = 640;
   private static final int DEFAULT_HEIGHT  = 800;   
   
   public GameCamera() {
      super(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
   }

}
