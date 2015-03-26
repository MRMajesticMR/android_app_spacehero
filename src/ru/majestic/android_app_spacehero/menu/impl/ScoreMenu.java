package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.ButtonSprite;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.menu.animation.GameMenuAnimator;

public class ScoreMenu extends GameMenuSkeleton {

   private ButtonSprite    resetButton;
   private ButtonSprite    exitButton;
   
   public ScoreMenu(Camera camera) {
      super(camera);
   }

   @Override
   protected void initMenuElements() {
      
   }
   
   @Override
   protected void initShowElementsModifiers(GameMenuAnimator gameMenuAnimator) {
      // TODO Auto-generated method stub
      
   }

   @Override
   protected void initHideElementsModifiers(GameMenuAnimator gameMenuAnimator) {
      // TODO Auto-generated method stub
      
   }

}
