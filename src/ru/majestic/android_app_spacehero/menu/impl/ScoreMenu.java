package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;

public class ScoreMenu extends GameMenuSkeleton {

   private ButtonSprite    resetButton;
   private ButtonSprite    exitButton;
   
   public ScoreMenu(Camera camera) {
      super(camera);
   }

   @Override
   public void show() {
      camera.setHUD(this);
      
      notifyGameMenuVisibleListenersOnShow();
   }

   @Override
   public void hide() {
      notifyGameMenuVisibleListenersOnHide();
   }

   @Override
   protected void initMenuElements() {
      
   }

}
