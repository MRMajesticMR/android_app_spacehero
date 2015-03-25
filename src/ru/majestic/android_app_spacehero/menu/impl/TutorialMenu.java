package ru.majestic.android_app_spacehero.menu.impl;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.android_app_spacehero.menu.GameMenuSkeleton;
import ru.majestic.android_app_spacehero.resources.ResourceManager;

public class TutorialMenu extends GameMenuSkeleton {

   private Rectangle shadowRectangle;
   
   public TutorialMenu(Camera camera) {
      super(camera);
   }   
   
   @Override
   protected void initMenuElements() {
      shadowRectangle = new Rectangle(0, 0, camera.getWidth(), camera.getHeight(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      shadowRectangle.setColor(0.0f, 0.0f, 0.0f);
      shadowRectangle.setAlpha(0.7f);
      
      attachChild(shadowRectangle);
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

}
