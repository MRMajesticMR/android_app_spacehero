package ru.majestic.android_app_spacehero.andengine;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;

public class GameScene extends Scene {
   
   public GameScene() {
      setBackgroundEnabled(true);
      setBackground(new Background(1.0f, 0.0f, 0.0f));
   }

}
